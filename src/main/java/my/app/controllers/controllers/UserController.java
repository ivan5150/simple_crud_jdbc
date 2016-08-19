package my.app.controllers.controllers;

import my.app.controllers.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@Controller
@RequestMapping(value = "/")
public class UserController {


    public static final String ALL_USERS_PAGE = "allUsers";
    public static final String ADD_USER_PAGE = "addUser";
    ArrayList<User> list = new ArrayList<User>();


    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String showPageAddUser(ModelMap model) {
        // model.addAttribute("inspection", "add");
        return ADD_USER_PAGE;
    }

    @RequestMapping(value = "/all/users", method = RequestMethod.GET)
    public String showPageAllUsers(ModelMap model) {
        //model.addAttribute("users", userService.getAll());
        return ALL_USERS_PAGE;
    }

   /* private synchronized void saveMessage(MessageForm messageForm) {
        list.add(new Message(messageForm.getAuthor(), messageForm.getText()));
    }*/

}
