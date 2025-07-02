package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Config.CustomUserDetails;
import com.practice2.fightmaro.Config.JwtTokenHelper;
import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Payloads.LoginRequest;
import com.practice2.fightmaro.Payloads.LoginResponse;
import com.practice2.fightmaro.Payloads.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class Logincontroller {

    @Autowired
    private ModelMapper  modelMapper;
        @Autowired
        private JwtTokenHelper jwtUtils;

    @Autowired
        private AuthenticationManager authenticationManager;

        @PostMapping("/signin")
        public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
            Authentication authentication;
            try {
                authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsername(), loginRequest.getPassword()
                        )
                );
            } catch (AuthenticationException exception) {
                Map<String, Object> map = new HashMap<>();
                map.put("message", "Bad credentials");
                map.put("status", false);
                return new ResponseEntity<>(map, HttpStatus.UNAUTHORIZED);
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);


            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            User user = userDetails.getUser();

            UserDto userDto = modelMapper.map(user, UserDto.class);
            String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

            LoginResponse response = new LoginResponse(userDto, jwtToken);
            return ResponseEntity.ok(response);
        }
    }


