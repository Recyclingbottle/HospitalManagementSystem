package com.hospital.dto;

public class ChatMessageDTO {
    private String sender;
    private String receiver;
    private String message;

    public ChatMessageDTO(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return sender + " -> " + receiver + ": " + message;
    }
}
