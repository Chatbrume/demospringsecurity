package eu.ensup.demospringsecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@JsonRootName("user")
public class User implements UserDetails
{
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Roles role;

    @JsonIgnore
    public User() {}

    @JsonIgnore
    public User(String username, String password, Roles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @JsonIgnore
    public User(Integer id, String username, String password, Roles role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @JsonProperty("id")
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    @JsonProperty("username")
    @Override
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    @JsonProperty("password")
    @Override
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    @JsonProperty("role")
    public Roles getRole() {return role;}
    public void setRole(Roles role) {this.role = role;}

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role.toString()));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return false;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
