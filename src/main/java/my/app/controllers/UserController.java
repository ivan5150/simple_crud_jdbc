
package my.app.controllers;

import my.app.domain.User;
//import oracle.jrockit.jfr.NativeEventControl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import my.app.service.UserServiceImpl;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class UserController {

    public static final String ALL_USERS_PAGE = "AllUsers";
    public static final String ADD_USER_PAGE = "AddUser";

    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String showPageAddUser(ModelMap model) {
        model.addAttribute("userForm", new UserForm());
        return ADD_USER_PAGE;
    }

    @RequestMapping(value = "/all/users", method = RequestMethod.GET)
    public String showPageAllUsers(ModelMap model) {
        model.addAttribute("users", new UserServiceImpl().getAll());

        return ALL_USERS_PAGE;
    }

    @RequestMapping(value = "/save/user", method = RequestMethod.POST)
    public RedirectView saveUser(@Validated UserForm userForm, BindingResult bindingResult) {
        User user = new User(Long.parseLong(userForm.getId()), userForm.getName());
        new UserServiceImpl().insert(user);

        //return showPageAddUser(new ModelMap());
        //return showPageAllUsers(new ModelMap()); //users don't receive
        return new RedirectView("/all/users");
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public RedirectView deleteUser(@PathVariable(value = "id") Long id) {
        new UserServiceImpl().deleteById(id);
        return new RedirectView("/all/users");
    }

    @RequestMapping(value = "/save/user/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable(value = "id") Long id, ModelMap model) {
        if ( new UserServiceImpl().getById(id) == null) {
            return ALL_USERS_PAGE;
        }
        model.addAttribute("userForm", new UserServiceImpl().getById(id));
        return ADD_USER_PAGE;
    }


}
 