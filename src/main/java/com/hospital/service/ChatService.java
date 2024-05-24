package com.hospital.service;

import com.hospital.dto.ChatMessageDTO;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ChatService {
    private BlockingQueue<ChatMessageDTO> messageQueue = new LinkedBlockingQueue<>();

    public void sendMessage(ChatMessageDTO message) {
        messageQueue.offer(message);
    }

    public ChatMessageDTO receiveMessage() throws InterruptedException {
        return messageQueue.take();
    }
}
