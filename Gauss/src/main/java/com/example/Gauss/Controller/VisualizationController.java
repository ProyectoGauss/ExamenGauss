package com.example.Gauss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class VisualizationController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private int[] ballsDistribution = new int[]{10, 20, 30, 40, 50}; // Ejemplo de datos

    @Scheduled(fixedRate = 1000)
    public void sendBallsDistribution() {
        messagingTemplate.convertAndSend("/topic/balls", ballsDistribution);
    }
}
