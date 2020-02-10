package timetable.realtimeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import timetable.Train;


import java.util.*;

@org.springframework.stereotype.Controller
public class realtimeController {
     HazelcastInstance hazelcastInstance;


    @Autowired
    ObjectMapper objectMapper;

    private Set<Train> trainsSet;
    @GetMapping("/timetable")
    public String train() {
        return "timetable";
    }



}
