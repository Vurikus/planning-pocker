package my.app.rest;

import my.app.object.Room;
import my.app.object.Rooms;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RoomController {

//    @GetMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }


    @GetMapping("/room/{roomId}")
    public Room get(@PathVariable("roomId") String roomId) {
        return Rooms.getRoom(roomId);
    }

    @PostMapping("/room")
    public Room createRoom(@RequestParam(value = "admin", required = false, defaultValue = "admin") String adminName) {
        return Rooms.newRoom(adminName);
    }
}
