package de.hybris.platform.cuppy.web.components;

import de.hybris.platform.cuppy.web.data.ChatMessageData;
import de.hybris.platform.cuppy.web.facades.PlayerFacade;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CuppyChatClientController implements ChatController {

	private final LinkedList<ChatMessageData> messages = new LinkedList<>();
	private Date firstFetch = null;
	private int maxMessageSize = 100;

	@Autowired
	private PlayerFacade playerFacade;

	public void addMessage(final String message)
	{
		if (StringUtils.isNotBlank(message))
		{
			playerFacade.addMessage(message);
		}
	}

	public List<ChatMessageData> fetchNewMessages()
	{
		final List<ChatMessageData> newMessages =  playerFacade.findMessagesFromDate(getLastLocalMessageDate());
		messages.addAll(newMessages);
		removeOldMessage();
		return newMessages;
	}

	public List<ChatMessageData> fetchNewMessagesByDate(Date from)
	{
		final List<ChatMessageData> newMessages = playerFacade.findMessagesFromDate(from);
		messages.clear();
		messages.addAll(newMessages);
		removeOldMessage();
		return newMessages;
	}

	private Date getLastLocalMessageDate()
	{
		return messages.isEmpty() ? (firstFetch == null ? firstFetch = new Date() : firstFetch) : messages.getLast()
				.getCreationTime();
	}

	public int getNewMessageCount()
	{
		return playerFacade.findMessagesFromDate(getLastLocalMessageDate()).size();
	}

	public List<ChatMessageData> getAllMessages()
	{
		return Collections.unmodifiableList(messages);
	}

	public List<ChatMessageData> getAllMessagesFromDate(Date from)
	{
		fetchNewMessagesByDate(from);

		return Collections.unmodifiableList(messages);
	}

	private void removeOldMessage () {
		while (messages.size() > maxMessageSize)
		{
			messages.removeFirst();
		}
	}

}
