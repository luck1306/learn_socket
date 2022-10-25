package com.example.learn_socket.entity;

import com.example.learn_socket.dto.MessageDto;
import com.example.learn_socket.service.MessageService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChattingRoomDto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roomId;

    public ChattingRoomDto(String roomId) {
        this.roomId = roomId;
    }

//    public void handleAction(WebSocketSession session, MessageDto message, MessageService messageService) {
//        if(message.getMessageType().equals(MessageDto.MessageType.ENTER)) {
//            message.updateMessage(message.getSender() + "님이 입장했습니다.");
//        }
//        messageService.sendMessage(session, message);
//    }
}