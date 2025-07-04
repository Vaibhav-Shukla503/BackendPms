package com.practice2.fightmaro.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;
    private String mobno;
    private String address;
    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @OneToMany(mappedBy = "owner",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Property> properties=new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Roleh role;
   @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
   @JsonBackReference
   private List<Booking>  bookings=new ArrayList<>();

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


    public boolean isAccountNonExpired() {
        return true;
    }


    public  boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }


    public  boolean isEnabled() {
        return true;
    }

}
