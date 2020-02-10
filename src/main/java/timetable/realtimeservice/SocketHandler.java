package timetable.realtimeservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import timetable.DB;
import timetable.Train;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class SocketHandler extends TextWebSocketHandler {
    @Autowired
    ObjectMapper objectMapper;
    private Set<Train> trainsSet = new HashSet<>(); ;
    @Override
    public void afterConnectionEstablished(WebSocketSession session)
    {

        WSession.sessions.add(session);
        WSession.count++;
        DB.connect();
        trainsSet.clear();
        trainsSet = DB.read();
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(trainsSet)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
    {

     WSession.sessions.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
    {

        DB.connect();
        trainsSet.clear();
        trainsSet = DB.read();
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(trainsSet)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
