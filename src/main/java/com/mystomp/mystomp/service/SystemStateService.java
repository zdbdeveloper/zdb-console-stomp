package com.mystomp.mystomp.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mystomp.mystomp.model.SystemState;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unchecked")
public class SystemStateService {
  public List<SystemState> getSystemStates() throws JsonSyntaxException {
    String json = 
      "[" +
        "{ \"name\": \"zdb-managed-dsr-mdb-mongodb-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-managed-dsr-mdb-mongodb-1\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-managed-dsr-mdb-mongodb-arbiter-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-v2-ma-ma1-mariadb-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-v2-ma-ma1-mariadb-1\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-v2-mo-mo3-mongodb-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-v2-mo-mo3-mongodb-1\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }," +
        "{ \"name\": \"zdb-v2-mo-mo3-mongodb-arbiter-0\", \"cpuRate\": " + getRandomRate() + ", \"memoryRate\": " + getRandomRate() + " }" +
      "]";

    //StringReader reader = new StringReader(json);
    return new Gson().fromJson(json, ArrayList.class);
  }

  private int getRandomRate() {
    return new Random().nextInt(100);
  }
}