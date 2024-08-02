package my.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.app.object.Room;
import my.app.object.Rooms;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;

public class RoomWebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper om = new ObjectMapper();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        byte[] bytes = message.asBytes();
        String data = message.getPayload();
        Room room = Rooms.getRoom(data);
        try {
            String response = room == null ? om.writeValueAsString(Map.of("error", "Room not found")) : om.writeValueAsString(room);
            session.sendMessage(new TextMessage(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
