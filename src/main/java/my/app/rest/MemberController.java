package my.app.rest;

import my.app.core.MemberManager;
import my.app.object.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MemberController {

    private final MemberManager memberManager;

    public MemberController(MemberManager memberManager) {
        this.memberManager = memberManager;
    }

    @PostMapping("/member")
    public Member createMember(@RequestParam(value = "web") String roomId,
                                               @RequestParam(value = "name") String name) {
        return memberManager.newMember(name, roomId);
    }
}
