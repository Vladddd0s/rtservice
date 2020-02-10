package timetable.realtimeservice;

import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WSession {
    public static int count=0;
    public static List<WebSocketSession> sessions=Collections.synchronizedList(new ArrayList<>());


}
