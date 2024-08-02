package my.app.object;

import java.util.*;

public class Room {
    private final String uid;
    private final Member admin;
    private final Map<String, Member> members;
    private final Map<String, Card> cards;
    private Ticket ticket;

    Room(Member admin) {
        this.uid = UUID.randomUUID().toString();
        this.members = new HashMap<>();
        this.cards = new HashMap<>();
        this.admin = admin;
        addMember(admin);
    }

    public String getUid() {
        return uid;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<Member> getMembers() {
        return List.copyOf(members.values());
    }

    public void addMember(Member member) {
        members.put(member.getUid(), member);
    }

    public void removeMember(Member m) {
        members.remove(m.getUid());
    }

    public Member getMember(String uid) {
        return members.get(uid);
    }

    public void addCard(Card card) {
        cards.put(card.getUid(), card);
    }

    public void removeCard(Card card) {
        cards.remove(card.getUid());
    }

    public List<Card> getCards() {
        return List.copyOf(cards.values());
    }

    public Card getCard(String uid) {
        return cards.get(uid);
    }
}
