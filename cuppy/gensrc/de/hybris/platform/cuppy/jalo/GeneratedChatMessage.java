/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Feb 9, 2016 7:02:22 PM                      ---
 * ----------------------------------------------------------------
 *  
 * [y] hybris Platform
 *  
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *  
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *  
 */
package de.hybris.platform.cuppy.jalo;

import de.hybris.platform.cuppy.constants.CuppyConstants;
import de.hybris.platform.cuppy.jalo.ChatRoom;
import de.hybris.platform.cuppy.jalo.Player;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cuppy.jalo.ChatMessage chatMessage}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedChatMessage extends GenericItem
{
	/** Qualifier of the <code>chatMessage.content</code> attribute **/
	public static final String CONTENT = "content";
	/** Qualifier of the <code>chatMessage.chatRoom</code> attribute **/
	public static final String CHATROOM = "chatRoom";
	/** Qualifier of the <code>chatMessage.player</code> attribute **/
	public static final String PLAYER = "player";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n PLAYER's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedChatMessage> PLAYERHANDLER = new BidirectionalOneToManyHandler<GeneratedChatMessage>(
	CuppyConstants.TC.CHATMESSAGE,
	false,
	"player",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CONTENT, AttributeMode.INITIAL);
		tmp.put(CHATROOM, AttributeMode.INITIAL);
		tmp.put(PLAYER, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.chatRoom</code> attribute.
	 * @return the chatRoom
	 */
	public ChatRoom getChatRoom(final SessionContext ctx)
	{
		return (ChatRoom)getProperty( ctx, CHATROOM);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.chatRoom</code> attribute.
	 * @return the chatRoom
	 */
	public ChatRoom getChatRoom()
	{
		return getChatRoom( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.chatRoom</code> attribute. 
	 * @param value the chatRoom
	 */
	public void setChatRoom(final SessionContext ctx, final ChatRoom value)
	{
		setProperty(ctx, CHATROOM,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.chatRoom</code> attribute. 
	 * @param value the chatRoom
	 */
	public void setChatRoom(final ChatRoom value)
	{
		setChatRoom( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.content</code> attribute.
	 * @return the content - The chat message.
	 */
	public String getContent(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedChatMessage.getContent requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, CONTENT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.content</code> attribute.
	 * @return the content - The chat message.
	 */
	public String getContent()
	{
		return getContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.content</code> attribute. 
	 * @return the localized content - The chat message.
	 */
	public Map<Language,String> getAllContent(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,CONTENT,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.content</code> attribute. 
	 * @return the localized content - The chat message.
	 */
	public Map<Language,String> getAllContent()
	{
		return getAllContent( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.content</code> attribute. 
	 * @param value the content - The chat message.
	 */
	public void setContent(final SessionContext ctx, final String value)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedChatMessage.setContent requires a session language", 0 );
		}
		setLocalizedProperty(ctx, CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.content</code> attribute. 
	 * @param value the content - The chat message.
	 */
	public void setContent(final String value)
	{
		setContent( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.content</code> attribute. 
	 * @param value the content - The chat message.
	 */
	public void setAllContent(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,CONTENT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.content</code> attribute. 
	 * @param value the content - The chat message.
	 */
	public void setAllContent(final Map<Language,String> value)
	{
		setAllContent( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		PLAYERHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.player</code> attribute.
	 * @return the player - Players.
	 */
	public Player getPlayer(final SessionContext ctx)
	{
		return (Player)getProperty( ctx, PLAYER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>chatMessage.player</code> attribute.
	 * @return the player - Players.
	 */
	public Player getPlayer()
	{
		return getPlayer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.player</code> attribute. 
	 * @param value the player - Players.
	 */
	public void setPlayer(final SessionContext ctx, final Player value)
	{
		PLAYERHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>chatMessage.player</code> attribute. 
	 * @param value the player - Players.
	 */
	public void setPlayer(final Player value)
	{
		setPlayer( getSession().getSessionContext(), value );
	}
	
}
