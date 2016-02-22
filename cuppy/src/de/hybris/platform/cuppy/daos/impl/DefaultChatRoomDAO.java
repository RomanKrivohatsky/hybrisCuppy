package de.hybris.platform.cuppy.daos.impl;

import de.hybris.platform.cuppy.daos.ChatRoomDAO;
import de.hybris.platform.cuppy.model.ChatRoomModel;
import de.hybris.platform.cuppy.services.SingletonScopedComponent;

import java.util.List;

@SingletonScopedComponent(value = "chatRoomDAO")
public class DefaultChatRoomDAO implements ChatRoomDAO {

    @Override
    public List<ChatRoomModel> findChatRooms() {

        return null;
    }
}
