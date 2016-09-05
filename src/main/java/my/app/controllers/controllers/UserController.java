
package my.app.controllers.controllers;

import my.app.controllers.dao.UserDao;
import my.app.controllers.dao.UserDaoJdbcImpl;
import my.app.controllers.domain.User;
//import oracle.jrockit.jfr.NativeEventControl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        model.addAttribute("userForm", new UserForm());
        return ADD_USER_PAGE;
    }


    @RequestMapping(value = "/all/users", method = RequestMethod.GET)
    public String showPageAllUsers(ModelMap model) {
        return ALL_USERS_PAGE;
    }


    @RequestMapping(value = "/save/user", method = RequestMethod.POST)
    public String saveUser(@Validated UserForm userForm, BindingResult bindingResult) {
        list.add(new User(Long.parseLong(userForm.getId()), userForm.getName()));
        //service.insert(new User(Long.parseLong(userForm.getId()), userForm.getName()));
        User e = new User(Long.parseLong(userForm.getId()), userForm.getName());
        new UserServiceImpl().insert(e);

        return showPageAddUser(new ModelMap());

    }


}
 