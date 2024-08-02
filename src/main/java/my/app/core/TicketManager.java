package my.app.core;

import my.app.object.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketManager {

    public Ticket newTicket(String roomUid) {
        Room room = Rooms.getRoom(roomUid);
        if (room == null) {
            throw new IllegalArgumentException("Room not found with id = " + roomUid);
        }
        Ticket t = new Ticket();
        room.setTicket(t);
        return t;
    }

    public Ticket closeTicket(String roomUid) {
        Room room = Rooms.getRoom(roomUid);
        if (room == null) {
            throw new IllegalArgumentException("Room not found with id = " + roomUid);
        }
        Ticket ticket = room.getTicket();
        if (ticket != null) {
            ticket.setClosed();
        }
        return ticket;
    }

    public void bid(String roomUid, String memberUid, String cardUid) {
        Room room = Rooms.getRoom(roomUid);
        if (room == null) {
            throw new IllegalArgumentException("Room not found with id = " + roomUid);
        }
        Member member = room.getMember(memberUid);
        if (member == null) {
            throw new IllegalArgumentException("Member not found with id = " + memberUid);
        }
        Card card = room.getCard(cardUid);

        Ticket ticket = room.getTicket();
        if (ticket != null) {
            ticket.choose(member, card);
        }
    }

}
