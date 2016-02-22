package de.hybris.platform.cuppy.daos;

import de.hybris.platform.cuppy.model.ChatMessageModel;
import de.hybris.platform.cuppy.model.PlayerModel;

import java.util.Date;
import java.util.List;

public interface ChatMessageDao  {

    List<ChatMessageModel>
    findMessagesByPlayer (PlayerModel playerModel) ;

    List<ChatMessageModel> findMessagesByDate (Date from, Date to) ;

    List<ChatMessageModel> findMessagesFromDate (Date from) ;

    List<ChatMessageModel> findMessages() ;
}
