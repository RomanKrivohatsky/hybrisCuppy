package de.hybris.platform.cuppy.daos;

import de.hybris.platform.cuppy.model.ChatRoomModel;

import java.util.List;

public interface ChatRoomDAO {

    List<ChatRoomModel> findChatRooms();
}
