package my.app.object;

import java.util.*;

public class Ticket {
    private final Map<Member, Card> memberChoose;
    private double result;
    private boolean closed;

    public Ticket() {
        this.memberChoose = new HashMap<>();
    }

    public void choose(Member member, Card card) {
        if (!closed) {
            memberChoose.put(member, card);
        }
    }

    public Map<Member, Card> getMemberChooses() {
        return Collections.unmodifiableMap(memberChoose);
    }

    public boolean isClosed() {
        return closed;
    }

    public double getResult() {
        return result;
    }

    public void setClosed() {
        this.closed = true;
        OptionalDouble average = memberChoose.values().stream().mapToDouble(Card::getCost).average();
        result = average.orElse(0);
    }
}
