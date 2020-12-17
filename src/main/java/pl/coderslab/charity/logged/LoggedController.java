package pl.coderslab.charity.logged;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.entities.AppUser;
import pl.coderslab.charity.users.CurrentUser;

import java.util.List;

@Controller
@RequestMapping("/logged")
public class LoggedController {

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user",entityUser);
        return "logged/dashboard";
    }



}
