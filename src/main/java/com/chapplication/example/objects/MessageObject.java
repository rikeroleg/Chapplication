package com.chapplication.example.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class MessageObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer messageId;
    private String message;
    private Date messageTimeStamp;
    private Integer userId;

    public MessageObject(){ }

    public MessageObject(Integer messageId, String message, Date messageTimeStamp, Integer userId) {
        this.message = message;
        this.messageTimeStamp = messageTimeStamp;
        this.userId = userId;
        this.messageId = messageId;
    }

    
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(Date messageTimeStamp) {
        this.messageTimeStamp = messageTimeStamp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "MessageObject{" +
                "messageId=" + messageId +
                ", message='" + message + '\'' +
                ", messageTimeStamp=" + messageTimeStamp +
                ", userId=" + userId +
                '}';
    }
}


