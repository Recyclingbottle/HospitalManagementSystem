package com.hospital.controller;

import com.hospital.dto.ChatDTO;
import com.hospital.service.ChatService;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatController {
    private ChatService chatService;
    private ExecutorService executor;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
        this.executor = Executors.newFixedThreadPool(5);
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("1. 채팅 메시지 추가");
            System.out.println("2. 채팅 메시지 보기");
            System.out.println("3. 모든 채팅 메시지 보기");
            System.out.println("4. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            CountDownLatch latch = new CountDownLatch(1);

            switch (choice) {
                case 1:
                    executor.submit(new AddChatMessageTask(scanner, latch));
                    break;
                case 2:
                    executor.submit(new ViewChatMessageTask(scanner, latch));
                    break;
                case 3:
                    executor.submit(new ViewAllChatMessagesTask(latch));
                    break;
                case 4:
                    executor.shutdown();
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
                    latch.countDown();
                    break;
            }

            try {
                latch.await();  // 비동기 작업이 완료될 때까지 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class AddChatMessageTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        AddChatMessageTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("사용자 이름: ");
            String userName = scanner.nextLine();
            System.out.print("메시지 내용: ");
            String message = scanner.nextLine();
            ChatDTO chatMessage = new ChatDTO(userName, message);
            chatService.addChatMessage(chatMessage);
            latch.countDown();
        }
    }

    private class ViewChatMessageTask implements Runnable {
        private Scanner scanner;
        private CountDownLatch latch;

        ViewChatMessageTask(Scanner scanner, CountDownLatch latch) {
            this.scanner = scanner;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.print("사용자 이름: ");
            String userName = scanner.nextLine();
            ChatDTO chatMessage = chatService.findChatMessageByUserName(userName);
            if (chatMessage != null) {
                System.out.println("사용자: " + chatMessage.getUserName());
                System.out.println("메시지: " + chatMessage.getMessage());
            } else {
                System.out.println("해당 사용자의 채팅 메시지가 없습니다.");
            }
            latch.countDown();
        }
    }

    private class ViewAllChatMessagesTask implements Runnable {
        private CountDownLatch latch;

        ViewAllChatMessagesTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (ChatDTO chatMessage : chatService.getAllChatMessages()) {
                System.out.println("사용자: " + chatMessage.getUserName() + ", 메시지: " + chatMessage.getMessage());
            }
            latch.countDown();
        }
    }
}
