package com.example.Gauss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate template;

    private int[] bins = new int[10];

    @Scheduled(fixedRate = 1000)
    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        int position = (int) (Math.random() * bins.length);
        bins[position]++;
        template.convertAndSend("/topic/messages", bins);
        System.out.println("Scheduled task executed on thread: " + Thread.currentThread().getName());
    }
}
