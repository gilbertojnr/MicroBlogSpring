package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 * Created by gilbertakpan on 12/20/16.
 */
@Controller
public class MicroBlogSpringController {
    ArrayList<Message> messages = new ArrayList<>();

    @RequestMapping(path ="/", method = RequestMethod.GET)
        public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("newUserName"));
        model.addAttribute("messages", messages);
        return "home";

    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String newUserName){
        session.setAttribute("newUserName", newUserName);
        return "redirect:/";
    }

    @RequestMapping(path ="/add-message", method = RequestMethod.POST)
    public String message(String newMessage){
        Message m = new Message (newMessage, messages.size() + 1);
        messages.add(m);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(int id){
        messages.remove(id - 1);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}

