package my.app.core;

import my.app.object.Member;
import my.app.object.Room;
import my.app.object.Rooms;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MemberManager {

    public Member newMember(String name, String roomUid) {
        Room room = Rooms.getRoom(roomUid);
        if (room == null) {
            throw new IllegalArgumentException("Room not found with id = " + roomUid);
        }
        Member member = new Member(name);
        room.addMember(member);
        return member;
    }
}
