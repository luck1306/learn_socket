package com.example.learn_socket.controller;

import com.example.learn_socket.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class STOMPMessageController {

    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/comm/message")
    public void message(MessageDto message) {
        if(message.getMessageType().equals(MessageDto.MessageType.ENTER)) {
            message.updateMessage(message.getSender() + "님이 입장하였습니다.");
        }
        sendingOperations.convertAndSend("/sub/comm/room" + message.getRoomId(), message);
    }
}
