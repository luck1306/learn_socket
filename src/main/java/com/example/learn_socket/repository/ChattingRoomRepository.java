package com.example.learn_socket.repository;

import com.example.learn_socket.entity.ChattingRoomDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChattingRoomRepository {
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
        ChattingRoomDto room = new ChattingRoomDto(name);
        chattingRoomDto.put(name, room);
        return room;
    }
}
