package my.app.controllers.controllers;

import my.app.controllers.dao.UserDao;
import my.app.controllers.dao.UserDaoJdbcImpl;
import my.app.controllers.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import my.app.controllers.service.UserService;
import my.app.controllers.service.UserServiceImpl;

import java.util.ArrayList;


@Controller
public class UserController {


    public static final String ALL_USERS_PAGE = "AllUsers";
    public static final String ADD_USER_PAGE = "AddUser";
    ArrayList<User> list = new ArrayList<User>();


    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String showPageAddUser(ModelMap model) {

        return ADD_USER_PAGE;
    }

    @RequestMapping(value = "/all/users", method = RequestMethod.GET)
    public String showPageAllUsers(ModelMap model) {
        //model.addAttribute("users", userService.getAll());

        return ALL_USERS_PAGE;
    }

    @RequestMapping(value = "/all/users", method = RequestMethod.POST)
    public String saveMessage(ModelMap model) {
        model.addAttribute("tbl", UserDaoJdbcImpl.INSERT_USER);

        /*if (binding.hasErrors()) {
            return ALL_USERS;
        }*/

        return showPageAllUsers(model);
    }

    //private synchronized void saveMessage(UserForm userForm) {
    //    list.add(new User(userForm.getId(), userForm.getName()));
    //}

}
