package my.app.controllers;

import my.app.domain.Profession;
import my.app.service.ProfessionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProfessionController {
    public static final String ALL_PROFESSIONS_PAGE = "AllProfessions";
    public static final String ADD_PROFESSION_PAGE = "AddProfession";
   // public static final String HOME_PAGE_PROFESSION = "HomePageProfession";//

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        return HOME_PAGE_PROFESSION;
    }*/

    @RequestMapping(value = "/add/profession", method = RequestMethod.GET)
    public String showPageAddProfession(ModelMap model) {
        model.addAttribute("professionForm", new ProfessionForm());
        return ADD_PROFESSION_PAGE;
    }

    @RequestMapping(value = "/all/professions", method = RequestMethod.GET)
    public String showPageAllProfessions(ModelMap model) {
        model.addAttribute("professions", new ProfessionServiceImpl().getAll());

        return ALL_PROFESSIONS_PAGE;
    }

    @RequestMapping(value = "/save/profession", method = RequestMethod.POST)
    public String saveProfession(@Validated ProfessionForm professionForm, BindingResult bindingResult) {
        if (isIdEmpty(professionForm.getId())) {
            Profession profession = new Profession(professionForm.getName());
            new ProfessionServiceImpl().insert(profession);
        } else {
            Profession profession = new Profession(Long.parseLong(professionForm.getId()), professionForm.getName());
            new ProfessionServiceImpl().update(profession);
        }
        return "redirect:/all/professions";

    }

    private boolean isIdEmpty(String str) {
        return str == null || "".equals(str);
    }

    @RequestMapping(value = "/delete/profession/{id}", method = RequestMethod.GET)
    public String deleteProfession(@PathVariable(value = "id") Long id) {
        new ProfessionServiceImpl().deleteById(id);
        return "redirect:/all/professions";
    }

    @RequestMapping(value = "/save/profession/{id}", method = RequestMethod.GET)
    public String editProfession(@PathVariable(value = "id") Long id, ModelMap model) {
        if (new ProfessionServiceImpl().getById(id) == null) {
            return ALL_PROFESSIONS_PAGE;
        }
        model.addAttribute("professionForm", new ProfessionServiceImpl().getById(id));
        return ADD_PROFESSION_PAGE;
    }
}
