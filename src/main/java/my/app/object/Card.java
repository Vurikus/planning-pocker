package my.app.object;

import java.util.UUID;

public class Card {
    private final String uid;
    private final double cost;

    public Card(double cost) {
        this.uid = UUID.randomUUID().toString();
        this.cost = cost;
    }

    public String getUid() {
        return uid;
    }

    public double getCost() {
        return cost;
    }
}
