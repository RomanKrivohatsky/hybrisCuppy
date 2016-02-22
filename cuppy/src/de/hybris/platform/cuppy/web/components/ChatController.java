package de.hybris.platform.cuppy.web.components;

import de.hybris.platform.cuppy.web.data.ChatMessageData;

import java.util.Date;
import java.util.List;

public interface ChatController {

    void addMessage(final String message);

    List<ChatMessageData> fetchNewMessages();

    List<ChatMessageData> fetchNewMessagesByDate(Date from);

    List<ChatMessageData> getAllMessages();

    List<ChatMessageData> getAllMessagesFromDate(Date from);

    }
