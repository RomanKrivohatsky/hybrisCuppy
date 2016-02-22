package de.hybris.platform.cuppy.services.impl;

import de.hybris.platform.cuppy.daos.ChatMessageDao;
import de.hybris.platform.cuppy.model.ChatMessageModel;
import de.hybris.platform.cuppy.services.ChatService;
import de.hybris.platform.cuppy.services.PlayerService;
import de.hybris.platform.cuppy.services.SingletonScopedComponent;
import de.hybris.platform.cuppy.web.data.ChatMessageData;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Locale;

@SingletonScopedComponent(value = "chatService")
public class DefaultChatService implements ChatService {


    @Autowired
    private ChatMessageDao chatMessageDao;

    @Autowired
    private ModelService modelService;

    @Autowired
    private PlayerService playerService;

    @Override
    public void saveMessage(ChatMessageData messageData) {
        ChatMessageModel messageModel = new ChatMessageModel();
        messageModel.setContent(messageData.getContent(), Locale.ENGLISH);
        messageModel.setPlayer(playerService.getCurrentPlayer());

        modelService.save(messageModel);
    }

    @Override
    public List<ChatMessageModel> findMessages() {
        return chatMessageDao.findMessages();
    }

    @Override
    public List<ChatMessageModel> findMessagesFromDate(Date from) {
        return chatMessageDao.findMessagesFromDate(from);
    }

    @Override
    public List<ChatMessageModel> findMessagesByDate(Date from, Date to) {
        return chatMessageDao.findMessagesByDate(from, to);
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

}
