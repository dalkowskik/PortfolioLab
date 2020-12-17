package pl.coderslab.charity.users;

import pl.coderslab.charity.entities.AppUser;

public interface UserService {

    AppUser findByUserName(String name);
    AppUser findByEmail(String email);
    void updateUser(AppUser appUser);


    void saveUser(AppUser appUser);
}
