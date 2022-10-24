package com.example.learn_socket.controller;

import com.example.learn_socket.dto.ChattingRoomDto;
import com.example.learn_socket.service.MessageService;
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
    private final MessageService messageService;

    @PostMapping
    public ChattingRoomDto createRoom(@RequestParam String name) {
        return messageService.createRoom(name);
    }

    @GetMapping
    public List<ChattingRoomDto> findAllRoom() {
        return messageService.findAllRoom();
    }
}
