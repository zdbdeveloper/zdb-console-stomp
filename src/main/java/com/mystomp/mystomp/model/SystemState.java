package com.mystomp.mystomp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SystemState {
  private String name;
  private int cpuRate;
  private int memoryRate;
}
