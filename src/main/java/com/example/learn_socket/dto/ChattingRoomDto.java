package com.example.learn_socket.dto;

import com.example.learn_socket.service.MessageService;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
public class ChattingRoomDto {

    private String roomId;
    private Set<WebSocketSession> sessions = new HashSet<>();

    public ChattingRoomDto(String roomId) {
        this.roomId = roomId;
    }

    public void handleAction(WebSocketSession session, MessageDto message, MessageService messageService) {
        if(message.getMessageType().equals(MessageDto.MessageType.ENTER)) {
            sessions.add(session);
            message.updateMessage(MessageDto.MessageType.COMM);
        }
    }

    public <T> void sendMessage(T message, MessageService messageService) {
        sessions.parallelStream().forEach(session -> messageService.sendMessage(session, message));
    }
}