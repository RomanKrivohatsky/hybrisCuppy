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
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.cuppy.jalo.ChatRoom ChatRoom}.
 */
@SuppressWarnings({"deprecation","unused","cast","PMD"})
public abstract class GeneratedChatRoom extends GenericItem
{
	/** Qualifier of the <code>ChatRoom.roomName</code> attribute **/
	public static final String ROOMNAME = "roomName";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ROOMNAME, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChatRoom.roomName</code> attribute.
	 * @return the roomName - Room chat name
	 */
	public String getRoomName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ROOMNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ChatRoom.roomName</code> attribute.
	 * @return the roomName - Room chat name
	 */
	public String getRoomName()
	{
		return getRoomName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ChatRoom.roomName</code> attribute. 
	 * @param value the roomName - Room chat name
	 */
	public void setRoomName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ROOMNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ChatRoom.roomName</code> attribute. 
	 * @param value the roomName - Room chat name
	 */
	public void setRoomName(final String value)
	{
		setRoomName( getSession().getSessionContext(), value );
	}
	
}
