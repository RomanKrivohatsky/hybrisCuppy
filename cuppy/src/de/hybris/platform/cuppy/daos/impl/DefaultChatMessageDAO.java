package de.hybris.platform.cuppy.daos.impl;

import de.hybris.platform.cuppy.daos.ChatMessageDao;
import de.hybris.platform.cuppy.model.ChatMessageModel;
import de.hybris.platform.cuppy.model.PlayerModel;
import de.hybris.platform.cuppy.services.SingletonScopedComponent;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SingletonScopedComponent(value = "chatMessageDao")
public class DefaultChatMessageDAO implements ChatMessageDao {

    @Resource
    FlexibleSearchService flexibleSearchService;

    @Override
    public List<ChatMessageModel> findMessagesByPlayer(PlayerModel playerModel) {
        final StringBuilder builder = new StringBuilder();
        builder.append("SELECT {m:").append(ChatMessageModel.PK).append("} ");
        builder.append("FROM {").append(ChatMessageModel._TYPECODE).append(" AS m} ");
        builder.append("WHERE ").append("{m:").append(ChatMessageModel.PLAYER).append("}").append("=?player ")
               .append(" ORDER BY {m:").append(ChatMessageModel.CREATIONTIME).append("} ASC");

        final FlexibleSearchQuery query = new FlexibleSearchQuery(builder.toString());
        query.setNeedTotal(true);
        query.addQueryParameter("player", playerModel.getPk());

        SearchResult<ChatMessageModel> result = flexibleSearchService.search(query);
                return result.getResult();
    }

    @Override
    public List<ChatMessageModel> findMessagesByDate(Date from, Date to) {
        final StringBuilder builder = new StringBuilder();
        builder.append("SELECT {m:").append(ChatMessageModel.PK).append("} ");
        builder.append("FROM {").append(ChatMessageModel._TYPECODE).append(" AS m} ");
        builder.append("WHERE ").append("{m:").append(ChatMessageModel.CREATIONTIME).append("} > ?from ")
               .append(" AND {m:").append(ChatMessageModel.CREATIONTIME).append("} <= ?to")
               .append(" ORDER BY {m:").append(ChatMessageModel.CREATIONTIME).append("} ASC");

        final FlexibleSearchQuery query = new FlexibleSearchQuery(builder.toString());
        query.setNeedTotal(true);
        query.addQueryParameter("from", from);
        query.addQueryParameter("to", to);

        SearchResult<ChatMessageModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }

    @Override
    public List<ChatMessageModel> findMessagesFromDate(Date from) {
        final StringBuilder builder = new StringBuilder();
        builder.append("SELECT {m:").append(ChatMessageModel.PK).append("} ");
        builder.append("FROM {").append(ChatMessageModel._TYPECODE).append(" AS m} ");
        builder.append("WHERE ").append("{m:").append(ChatMessageModel.CREATIONTIME).append("} > ?from ")
               .append(" ORDER BY {m:").append(ChatMessageModel.CREATIONTIME).append("} ASC");

        final FlexibleSearchQuery query = new FlexibleSearchQuery(builder.toString());
        query.setNeedTotal(true);
        query.addQueryParameter("from", from);

        SearchResult<ChatMessageModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }


    @Override
    public List<ChatMessageModel> findMessages() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SELECT {m:").append(ChatMessageModel.PK).append("} ");
        builder.append("FROM {").append(ChatMessageModel._TYPECODE).append(" AS m} ");
        final FlexibleSearchQuery query = new FlexibleSearchQuery(builder.toString());
        query.setNeedTotal(true);

        SearchResult<ChatMessageModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }
}
