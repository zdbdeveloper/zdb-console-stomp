package com.mystomp.mystomp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mystomp.mystomp.model.SystemState;
import com.mystomp.mystomp.service.SystemStateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {
  @Autowired
  SimpMessagingTemplate template;
  @Autowired
  SystemStateService systemStateService;

  @Scheduled(fixedDelay = 3000)
  public void sendAdhocMessages() throws JsonSyntaxException {
    try {
      template.convertAndSend("/topic/states", systemStateService.getSystemStates());
    } catch(JsonSyntaxException e) {
      System.out.println(e);
      template.convertAndSend("/topic/states", "[]");
    }
  }
  
}
