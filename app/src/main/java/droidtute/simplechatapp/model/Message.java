package droidtute.simplechatapp.model;

public class Message {

    private String messageId;

    private String userName;

    private String message;

    private int readCount;

    private String displayPicture;

    private String timeAgo;


    public Message(String userName, String message, int readCount, String displayPicture, String timeAgo) {
        this.userName = userName;
        this.message = message;
        this.readCount = readCount;
        this.displayPicture = displayPicture;
        this.timeAgo = timeAgo;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }
}
