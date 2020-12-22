package pl.coderslab.charity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.conwerters.CategoryConverter;
import pl.coderslab.charity.conwerters.InstitutionConverter;
import pl.coderslab.charity.entities.AppUser;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Dotation;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.CategoryRepo;
import pl.coderslab.charity.repositories.DotationRepo;
import pl.coderslab.charity.repositories.InstitutionRepo;
import pl.coderslab.charity.users.CurrentUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/logged")
public class DotationController {
    private DotationRepo dotationRepo;
    private InstitutionRepo institutionRepo;
    private CategoryRepo categoryRepo;


    public DotationController(DotationRepo dotationRepo, InstitutionRepo institutionRepo, CategoryRepo categoryRepo) {
        this.dotationRepo = dotationRepo;
        this.institutionRepo = institutionRepo;
        this.categoryRepo = categoryRepo;
    }


    @GetMapping("/dotation")
    public String dotation(Model model, @AuthenticationPrincipal CurrentUser customUser){
        model.addAttribute("dotation", new Dotation());
        List<Institution> all = institutionRepo.findAll();
        List<Category> all1 = categoryRepo.findAll();
        model.addAttribute("instuties",all);
        model.addAttribute("categories",all1);
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user",entityUser);
        return "logged/form";
    }

    @PostMapping("/dotation")
    public String dotation(@Valid Dotation dotation, BindingResult result, Model model, HttpServletRequest request, @AuthenticationPrincipal CurrentUser customUser){

        if(result.hasErrors()){
            return "logged/form";
        }else {
            dotationRepo.save(dotation);
        }
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user",entityUser);
        dotation.setAppUser(entityUser);
        return "logged/formConfim";
    }


}
