package com.ssafy.startcampchat;
// POJO, Java Bean
public class ChatItem {

    private String firebaseKey;
    private String name;
    private String message;
    private Long time;

    public ChatItem() {}

    public ChatItem(String firebaseKey, String name, String message, Long time) {
        this.firebaseKey = firebaseKey;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public String getFirebaseKey() {
        return firebaseKey;
    }

    public void setFirebaseKey(String firebaseKey) {
        this.firebaseKey = firebaseKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
