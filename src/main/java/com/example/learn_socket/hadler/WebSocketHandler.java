package com.example.learn_socket.hadler;

import com.example.learn_socket.entity.ChattingRoomDto;
import com.example.learn_socket.dto.MessageDto;
import com.example.learn_socket.repository.ChattingRoomRepository;
import com.example.learn_socket.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final MessageService messageService;

    private final ChattingRoomRepository repository;

    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        String payload = message.getPayload();
        log.info(String.format("payload : %s ", payload));

        MessageDto msg = objectMapper.readValue(payload, MessageDto.class);
        ChattingRoomDto room = repository.findById(msg.getRoomId());
//        room.handleAction(session, msg, messageService);
    }
}
