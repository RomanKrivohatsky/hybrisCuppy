package de.hybris.platform.cuppy.services;

import de.hybris.platform.cuppy.model.ChatMessageModel;
import de.hybris.platform.cuppy.web.data.ChatMessageData;

import java.util.Date;
import java.util.List;

public interface ChatService {

    void saveMessage (ChatMessageData messageModel);

    List<ChatMessageModel> findMessages();

    List<ChatMessageModel> findMessagesFromDate(Date from);

    List<ChatMessageModel> findMessagesByDate(Date from, Date to);

}
