package com.mystomp.mystomp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.springframework.stereotype.Service;

@Service
public class SystemStateService {
  public List<SystemStateService> getSystemStates() throws JsonSyntaxException {
    String json = 
      "[" +
        "{ \"name\": \"zdb-managed-dsr-mdb-mongodb-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," + 
        "{ \"name\": \"zdb-managed-dsr-mdb-mongodb-1\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," + 
        "{ \"name\": \"zdb-managed-dsr-mdb-mongodb-arbiter-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," + 
        "{ \"name\": \"zdb-test-uzin-dsr-five-redis-master-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," + 
        "{ \"name\": \"zdb-test-uzin-dsr-five-redis-slave-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }" + 
      "]";

    return new Gson().fromJson(json, ArrayList.class);
  }

  private int getRandomRate() {
    return new Random().nextInt(100);
  }
}