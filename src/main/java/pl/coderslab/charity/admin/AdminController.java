package pl.coderslab.charity.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.AppUser;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.AppUserRepo;
import pl.coderslab.charity.repositories.InstitutionRepo;
import pl.coderslab.charity.repositories.RoleRepository;
import pl.coderslab.charity.users.CurrentUser;
import pl.coderslab.charity.users.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private InstitutionRepo institutionRepo;
    private AppUserRepo appUserRepo;
    private RoleRepository roleRepository;
    private UserService userService;

    public AdminController(InstitutionRepo institutionRepo, AppUserRepo appUserRepo, RoleRepository roleRepository, UserService userService) {
        this.institutionRepo = institutionRepo;
        this.appUserRepo = appUserRepo;
        this.roleRepository = roleRepository;
        this.userService = userService;
    }



    @RequestMapping(value = "/adminDashboard", method = RequestMethod.GET)
    public String dashboard(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user", entityUser);
        return "logged/adminDashboard";
    }




    //============= INTYTUTIONS =================

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

        Optional<Institution> byId = institutionRepo.findById(id);
        Institution institution = byId.get();

        model.addAttribute("institution",institution);
        return "/logged/editInstytution";
    }

    @PostMapping(value = "/editInstytution/{id}")
    public String editInstytution2(@Valid Institution institution, BindingResult result) {

        if(result.hasErrors()){
            return "redirect:/admin/addInstytution";
        }else{
            institutionRepo.save(institution);
        }

        return "redirect:/admin/instytutions";
    }


    //======================== ADMINS ========================

    @GetMapping(value = "/admins")
    public String admins(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user", entityUser);
        List<AppUser> role_admin = appUserRepo.findAllByRoles(roleRepository.findById(2));
        model.addAttribute("admins",role_admin);

        return "logged/admins";
    }


    @GetMapping(value = "/deleteAdmin/{id}")
    public String deleteAdmin(Model model, @PathVariable String id) {

        appUserRepo.deleteById(Long.parseLong(id));

        return "redirect:/admin/admins";
    }


    @GetMapping(value = "/addAdmin")
    public String addAdmin(Model model) {
        model.addAttribute("user", new AppUser());
        return "/logged/addAdmin";
    }

    @PostMapping(value = "/addAdmin")
    public String addAdmin(@Valid AppUser appUser, BindingResult result) {

        if(result.hasErrors()){
            return "redirect:/admin/addAdmin";
        }else{
            appUser.setRoles(roleRepository.findById(2));
            userService.saveAdmin(appUser);
        }

        return "redirect:/admin/admins";
    }

    @GetMapping(value = "/editAdmin/{id}")
    public String editAdmin(Model model,@PathVariable long id) {

        Optional<AppUser> byId = appUserRepo.findById(id);
        AppUser appUser = byId.get();

        model.addAttribute("admin",appUser);
        return "/logged/editAdmin";
    }

    @PostMapping(value = "/editAdmin/{id}")
    public String editAdmin(@Valid AppUser appUser, BindingResult result) {

        if(result.hasErrors()){
            return "redirect:/admin/editAdmin";
        }else{
            userService.updateUser(appUser);
        }

        return "redirect:/admin/admins";
    }



    //====================  USERS  ======================

    @GetMapping(value = "/users")
    public String users(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        AppUser entityUser = customUser.getAppUser();
        model.addAttribute("user", entityUser);
        List<AppUser> role_user = appUserRepo.findAllByRoles(roleRepository.findById(1));
        model.addAttribute("users",role_user);

        return "logged/users";
    }


    @GetMapping(value = "/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable String id) {
        appUserRepo.deleteById(Long.parseLong(id));
        return "redirect:/admin/users";
    }


    @GetMapping(value = "/addUser")
    public String addUser(Model model) {
        model.addAttribute("users", new AppUser());
        return "/logged/addUser";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@Valid AppUser appUser, BindingResult result) {

        if(result.hasErrors()){
            return "redirect:/admin/addUser";
        }else{
            userService.saveUser(appUser);
        }

        return "redirect:/admin/users";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(Model model,@PathVariable long id) {

        Optional<AppUser> byId = appUserRepo.findById(id);
        AppUser appUser = byId.get();

        model.addAttribute("users",appUser);
        return "/logged/editUser";
    }

    @PostMapping(value = "/editUser/{id}")
    public String editUser(@Valid AppUser appUser, BindingResult result,@PathVariable long id) {

        if(result.hasErrors()){
            return "redirect:/admin/editUser";
        }else{
            Optional<AppUser> byId = appUserRepo.findById(id);
            AppUser appUser1 = byId.get();
            appUser.setPassword(appUser1.getPassword());
            appUser.setEnabled(appUser1.getEnabled());
            appUser.setRoles(appUser1.getRoles());
            appUserRepo.save(appUser);
        }

        return "redirect:/admin/users";
    }







}
