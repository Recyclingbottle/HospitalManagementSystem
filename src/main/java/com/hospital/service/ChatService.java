package com.hospital.service;

import com.hospital.dto.ChatDTO;

import java.util.ArrayList;
import java.util.List;

public class ChatService {
    private List<ChatDTO> chatMessages = new ArrayList<>();

    public void addChatMessage(ChatDTO chatMessage) {
        chatMessages.add(chatMessage);
        System.out.println("채팅 메시지가 추가되었습니다: " + chatMessage.getMessage());
    }

    public ChatDTO findChatMessageByUserName(String userName) {
        for (ChatDTO chatMessage : chatMessages) {
            if (chatMessage.getUserName().equalsIgnoreCase(userName)) {
                return chatMessage;
            }
        }
        return null;
    }

    public List<ChatDTO> getAllChatMessages() {
        return chatMessages;
    }
}
