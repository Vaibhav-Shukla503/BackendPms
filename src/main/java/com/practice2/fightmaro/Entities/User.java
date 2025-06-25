package com.practice2.fightmaro.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="UsersData")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Property> properties=new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns =@JoinColumn(name="user",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
    private Set<Role> roles=new HashSet<>();
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority( role.getRoleName())) // or role.getName()
                .collect(Collectors.toList());

    }
    public String getPassword(){
        return password;

    }
    public String getUsername(){
        return email;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    public  boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    public  boolean isEnabled() {
        return true;
    }

}
