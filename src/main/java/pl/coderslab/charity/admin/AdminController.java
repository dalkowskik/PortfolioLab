package pl.coderslab.charity.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.AppUser;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepo;
import pl.coderslab.charity.users.CurrentUser;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private InstitutionRepo institutionRepo;

    public AdminController(InstitutionRepo institutionRepo) {
        this.institutionRepo = institutionRepo;
    }

    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
    public String dashboard(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user", entityUser);
        return "logged/adminDashboard";
    }

    @GetMapping(value = "/instytutions")
    public String instytucions(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user", entityUser);
        List<Institution> all = institutionRepo.findAll();
        model.addAttribute("institutions", all);

        return "logged/instytucions";
    }


    @GetMapping(value = "/deleteInstytution/{id}")
    public String deleteInstytution(Model model, @PathVariable String id) {

        institutionRepo.deleteById(Long.parseLong(id));

        return "redirect:/admin/instytutions";
    }


    @GetMapping(value = "/addInstytution")
    public String addInstytution(Model model) {
        model.addAttribute("instytution", new Institution());
        return "/logged/addInstytution";
    }

    @PostMapping(value = "/addInstytution")
    public String addInstytution2(@Valid Institution institution, BindingResult result) {

        if(result.hasErrors()){
            return "redirect:/admin/addInstytution";
        }else{
            institutionRepo.save(institution);
        }

        return "redirect:/admin/instytutions";
    }

    @GetMapping(value = "/editInstytution/{id}")
    public String editInstytution(Model model,@PathVariable long id) {
        Institution institution = new Institution();
        institution.setId(id);
        model.addAttribute("institution", institution);
        return "/logged/editInstytution";
    }

    @PostMapping(value = "/editInstytution")
    public String editInstytution2(@Valid Institution institution, BindingResult result) {

        if(result.hasErrors()){
            return "redirect:/admin/addInstytution";
        }else{
            institutionRepo.save(institution);
        }

        return "redirect:/admin/instytutions";
    }






}
