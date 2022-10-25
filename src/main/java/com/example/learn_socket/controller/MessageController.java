package com.example.learn_socket.controller;

import com.example.learn_socket.entity.ChattingRoomDto;
import com.example.learn_socket.repository.ChattingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/chat")
@RestController
public class MessageController {
    private final ChattingRoomRepository repository;

    @PostMapping
    public ChattingRoomDto createRoom(@RequestParam String name) {
        return repository.createRoom(name);
    }

    @GetMapping
    public List<ChattingRoomDto> findAllRoom() {
        return repository.findAllRoom();
    }
}
