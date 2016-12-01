package ir.hri.rest.controller;


import ir.hri.aspect.annotation.Loggable;
import ir.hri.core.entities.User;
import ir.hri.core.services.UserService;
import ir.hri.rest.resources.UserResource;
import ir.hri.rest.resources.UsersResource;
import ir.hri.rest.resources.asm.UserResourceAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static ir.hri.rest.utils.ApiV1Urls.UserManagementPath.*;

@Controller
@Path(USER_MANAGE)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserManagement {
    @Autowired
    UserService userService;

    @GET
    @Path(PATH_USER_USERNAME)
    @Loggable
    public Response user(@PathParam(PARAM_USERNAME) String username) {
        User user;
        try {
            user = userService.findByUsername(username);
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.ok().entity(user).build();
    }

    @GET
    @Path(PATH_USERS)
    @Loggable(description = "UserManagement.users")
    public Response users() {
        List<User> userList = null;
        try {
            userList = userService.findAll();
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.ok().entity(new UsersResource(userList)).build();
    }

    @POST
    @Path(PATH_INSERT)
    @Loggable
    public Response insert(UserResource userResource) {
        User user = UserResourceAsm.unresource(userResource);
        try {
            userService.insert(user);
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }
}