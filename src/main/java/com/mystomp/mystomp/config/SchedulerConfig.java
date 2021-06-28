package com.mystomp.mystomp.config;

import java.util.Collections;

import com.google.gson.JsonSyntaxException;
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
      e.printStackTrace();
      template.convertAndSend("/topic/states", Collections.emptyList());
    }
  }
  
}
