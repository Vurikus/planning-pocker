package my.app.object;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Rooms {
    private static final Map<String, Room> rooms = new HashMap<>();

    public static Room newRoom(String adminName) {
        Member admin = new Member(adminName);
        Room r = new Room(admin);
        for (double i1 = 0.5, i2 = 0.5; i2 < 150; i2 = i1 + i2, i1 = i2) {
            Card c = new Card(i2);
            r.addCard(c);
        }
        rooms.put(r.getUid(), r);
        return r;
    }

    public static Room getRoom(String uid) {
        return rooms.get(uid);
    }
}
