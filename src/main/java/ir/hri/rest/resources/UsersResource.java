package ir.hri.rest.resources;

import ir.hri.core.entities.User;

import java.util.List;

public class UsersResource {
    List<User> users;

    public UsersResource() {
    }

    public UsersResource(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
