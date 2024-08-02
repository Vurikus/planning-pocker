package my.app.object;

import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class Member {
    private final String uid;
    private String name;

    public Member() {
        uid = UUID.randomUUID().toString();
    }

    public Member(String name) {
        uid = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
