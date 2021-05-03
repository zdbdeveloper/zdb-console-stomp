package com.mystomp.mystomp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SystemStateController {
  
  @MessageMapping("/states")
  @SendTo("/topic/states")
  public String getSystemStates(String message) {
    return message;
  }
}
