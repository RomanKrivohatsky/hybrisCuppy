package de.hybris.platform.cuppy.web.data;

import java.util.Date;

public class ChatMessageData implements Comparable<ChatMessageData> {

    private String content;
    private String playerName;
    private Date creationDate;
    private String uiID;

    public String getUiID() {
        return uiID;
    }

    public void setUiID(String uiID) {
        this.uiID = uiID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Date getCreationTime() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    @Override
    public int compareTo(ChatMessageData o) {
        ChatMessageData messageData = (ChatMessageData) o;
            return creationDate.compareTo(messageData.getCreationTime());
    }
}
