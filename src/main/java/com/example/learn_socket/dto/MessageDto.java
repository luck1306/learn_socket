package com.example.learn_socket.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDto {
    public enum MessageType {
        ENTER, COMM
    }
    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;

    @Builder
    public MessageDto(MessageType messageType, String roomId, String sender, String message) {
        this.messageType = messageType;
        this.roomId = roomId;
        this.sender = sender;
        this.message = message;
    }

    public void updateMessage(MessageType messageType) {
        this.messageType = messageType;
    }
}
