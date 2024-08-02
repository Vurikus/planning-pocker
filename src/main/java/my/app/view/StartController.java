package my.app.view;

import my.app.object.Member;
import my.app.object.Room;
import my.app.object.Rooms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
public class StartController {

    @GetMapping("/")
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/createRoom", method = RequestMethod.POST)
    public ModelAndView createRoom(ModelMap model) {
        Room room = Rooms.newRoom("admin");
        model.addAttribute("room", room);
        return new ModelAndView("room");
    }
}
