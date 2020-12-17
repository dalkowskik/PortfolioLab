package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.AppUser;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.AppUserRepo;
import pl.coderslab.charity.repositories.CategoryRepo;
import pl.coderslab.charity.repositories.DotationRepo;
import pl.coderslab.charity.repositories.InstitutionRepo;
import pl.coderslab.charity.users.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {
    private DotationRepo dotationRepo;
    private InstitutionRepo institutionRepo;
    private CategoryRepo categoryRepo;
    private AppUserRepo appUserRepo;
    private UserService userService;

    public HomeController(DotationRepo dotationRepo, InstitutionRepo institutionRepo, CategoryRepo categoryRepo, AppUserRepo appUserRepo, UserService userService) {
        this.dotationRepo = dotationRepo;
        this.institutionRepo = institutionRepo;
        this.categoryRepo = categoryRepo;
        this.appUserRepo = appUserRepo;
        this.userService = userService;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> all = institutionRepo.findAll();
        int i = dotationRepo.countId();
        int q = dotationRepo.sumQuantity();
        model.addAttribute("institutions",all);
        model.addAttribute("dotations",i);
        model.addAttribute("bags",q);
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user",new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid AppUser appUser, BindingResult result){

        if(result.hasErrors()){
            return "register";
        }
        else{
            userService.saveUser(appUser);
        }
        return "index";
    }


}
