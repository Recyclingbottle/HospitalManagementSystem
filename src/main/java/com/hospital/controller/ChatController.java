package com.hospital.controller;

import com.hospital.dto.ChatMessageDTO;
import com.hospital.service.ChatService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatController {
    private ChatService chatService = new ChatService();
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 메시지 보내기");
            System.out.println("2. 메시지 확인하기");
            System.out.println("3. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    executor.submit(new SendMessageTask(scanner));
                    break;
                case 2:
                    executor.submit(new ReceiveMessageTask());
                    break;
                case 3:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    break;
            }
        }
    }

    private class SendMessageTask implements Runnable {
        private Scanner scanner;

        SendMessageTask(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public void run() {
            System.out.print("보내는 사람: ");
            String sender = scanner.nextLine();
            System.out.print("받는 사람: ");
            String receiver = scanner.nextLine();
            System.out.print("메시지 내용: ");
            String message = scanner.nextLine();

            ChatMessageDTO chatMessage = new ChatMessageDTO(sender, receiver, message);
            chatService.sendMessage(chatMessage);
            System.out.println("메시지가 전송되었습니다.");
        }
    }

    private class ReceiveMessageTask implements Runnable {
        @Override
        public void run() {
            try {
                ChatMessageDTO message = chatService.receiveMessage();
                System.out.println("새 메시지: " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("메시지 수신이 중단되었습니다.");
            }
        }
    }
}
