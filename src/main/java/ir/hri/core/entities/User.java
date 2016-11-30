package ir.hri.core.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @NotEmpty(message = "لطفا نام کاربری را وارد نمایید")
    @Length(min = 6, max = 30, message = "نام کاربری باید بین شش تا سی کاراکتر باشد")
    @Column(name = "USERNAME")
    private String username;

    @NotEmpty(message = "لطفا نام را وارد نمایید")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstName;

    @NotEmpty(message = "لطفا نام خانوادگی را وارد نمایید")
    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @NotEmpty(message = "لطفا کلمه عبور را وارد نمایید")
    @Column(name = "PASSWORD", length = 30, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "CITY_ID", updatable = false)
    private City city;

    public User() {
    }

    public User(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return !(city != null ? !city.equals(user.city) : user.city != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
