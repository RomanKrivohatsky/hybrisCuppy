package de.hybris.platform.cuppy.web.components;

import de.hybris.platform.cuppy.web.data.ChatMessageData;
import de.hybris.platform.cuppy.web.facades.PlayerFacade;
import org.zkoss.spring.SpringUtil;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class CuppyChatWindow extends Window
{
	private final Div outputBox;
	private final Div toolbar;
	private CuppyChatClientController chatClientController;
	private final StatusBarComponent statusbar;
	private final Div chatBtn;
	private final Div chatRooms;
	private Combobox rangeComboBox;
	private HashMap<String, Period> periods = new HashMap<>();

	{
		periods.put("Yesterday", Period.ofDays(1));
		periods.put("7 days", Period.ofDays(7));
		periods.put("10 days", Period.ofDays(10));

	}

	public CuppyChatWindow(final int updateInterval, final StatusBarComponent frontendController, final Div chatBtn)
	{
		super();
		this.statusbar = frontendController;
		this.chatBtn = chatBtn;

		this.setSclass("cuppyChatWindow");
		this.setSizable(true);
		this.setClosable(true);

		toolbar = new Div();
		toolbar.setSclass("chatToolbar");
		this.appendChild(toolbar);

		rangeComboBox = new Combobox();

		periods.forEach( (k,v)-> {
			rangeComboBox.appendItem(k);
		});

		rangeComboBox.addEventListener(Events.ON_CHANGE, new EventListener() {
			@Override
			public void onEvent(Event event) throws Exception {
				reloadOutputByDate(rangeComboBox.getValue());
			}
		});

		toolbar.appendChild(rangeComboBox);

		outputBox = new Div();
		outputBox.setSclass("chatOutput");
		this.appendChild(outputBox);

		chatRooms = new Div();
		chatRooms.setSclass("chatRooms");
		this.appendChild(chatRooms);

		final Textbox inputBox = new Textbox();
		inputBox.setSclass("chatInput");
		this.appendChild(inputBox);

		inputBox.addEventListener(Events.ON_OK, new EventListener()
		{
			@Override
			public void onEvent(final Event event) throws Exception //NOPMD
			{
				getChatClientController().addMessage(inputBox.getText());
				updateOutput();
				inputBox.setText("");
				inputBox.focus();
			}
		});

		final Timer timer = new Timer(updateInterval);
		timer.setRunning(true);
		timer.setRepeats(true);
		this.appendChild(timer);
		timer.addEventListener(Events.ON_TIMER, new EventListener()
		{
			@Override
			public void onEvent(final Event event) throws Exception //NOPMD
			{
				updateOutput();
			}
		});

		this.addEventListener(Events.ON_CREATE, new EventListener()
		{
			@Override
			public void onEvent(final Event event) throws Exception //NOPMD
			{
				inputBox.focus();
			}
		});

		reloadOutput();
	}

	private void updateOutput()
	{
		final List<ChatMessageData> newMessages = getChatClientController().fetchNewMessages();
		for (final ChatMessageData msg : newMessages)
		{
			addToOutput(msg.getUiID(), msg.getContent(), msg.getCreationTime());
		}
		statusbar.refreshChatStatus(chatBtn);
	}

	private void reloadOutput()
	{
		outputBox.getChildren().clear();
		for (final ChatMessageData msg : getChatClientController().getAllMessages())
		{
			addToOutput(msg.getUiID(), msg.getContent(), msg.getCreationTime());
		}
	}

	private void reloadOutputByDate(String period)
	{
		Period per = periods.get(period);
		LocalDateTime localDateTime = LocalDateTime.now().minus(per);

		Date from = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

		outputBox.getChildren().clear();
		for (final ChatMessageData msg : getChatClientController().getAllMessagesFromDate(from))
		{
			addToOutput(msg.getUiID(), msg.getContent(), msg.getCreationTime());
		}
	}


	private void addToOutput(final String playerID, final String message, final Date creationTime)
	{
		final Div outputEntry = new Div();
		outputEntry.setSclass("chatOutputEntry");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");

		final Label label = new Label("[" + sdf.format(creationTime) + "] " + getPlayerFacade().getProfile(playerID).getName() + ": ");
		label.setSclass(getPlayerFacade().getCurrentPlayer().getId().equals(playerID) ? "currentUserChat" : "otherUserChat");
		outputEntry.appendChild(label);
		outputEntry.appendChild(new Label(message));

		this.outputBox.appendChild(outputEntry);
		Clients.scrollIntoView(outputEntry);
	}


	private CuppyChatClientController getChatClientController()
	{
		if (chatClientController == null)
		{
			chatClientController = (CuppyChatClientController) SpringUtil.getBean("chatClientController");
		}
		return chatClientController;
	}

	private PlayerFacade getPlayerFacade()
	{
		return (PlayerFacade) SpringUtil.getBean("playerFacade");
	}
}
