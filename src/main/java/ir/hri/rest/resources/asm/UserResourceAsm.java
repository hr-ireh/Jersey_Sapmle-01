package ir.hri.rest.resources.asm;

import ir.hri.core.entities.City;
import ir.hri.core.entities.User;
import ir.hri.rest.resources.UserResource;

public class UserResourceAsm {
    public static UserResource toresource(User user) {
        return new UserResource(user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword());
    }

    public static User unresource(UserResource userResource) {
        User user = new User(userResource.getUsername(),
                userResource.getFirstName(),
                userResource.getLastName(),
                userResource.getPassword());
        City city = new City();
        city.setId(userResource.getCityId());
        user.setCity(city);

        return user;
    }
}