package com.example.learn_socket.service;

import com.example.learn_socket.dto.ChattingRoomDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageService {
    private final ObjectMapper objectMapper;
    private Map<String, ChattingRoomDto> chattingRoomDto;

    @PostConstruct
    private void init() {
        chattingRoomDto = new LinkedHashMap<>();
    }

    public List<ChattingRoomDto> findAllRoom() {
        return new ArrayList<>(chattingRoomDto.values());
    }

    public ChattingRoomDto findById(String roomId) {
        return chattingRoomDto.get(roomId);
    }

    public ChattingRoomDto createRoom(String name) {
        chattingRoomDto.put(name, new ChattingRoomDto(name));
        return new ChattingRoomDto(name);
    }

    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
