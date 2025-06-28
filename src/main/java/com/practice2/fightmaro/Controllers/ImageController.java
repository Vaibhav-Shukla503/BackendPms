package com.practice2.fightmaro.Controllers;

import com.practice2.fightmaro.Entities.User;
import com.practice2.fightmaro.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/userdetail")
public class ImageController {
    @Autowired
    UserRepo  userRepository;
    @PutMapping("/{id}/upload-image")
    public ResponseEntity<?> uploadUserImage(@PathVariable int id, @RequestParam("image") MultipartFile file) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        try {
            user.setImage(file.getBytes());
            userRepository.save(user);
            System.out.println("image changed successfully"+user.getImage());

            // Optional: return image as Base64 for immediate frontend preview
            String base64 = Base64.getEncoder().encodeToString(user.getImage());
            return ResponseEntity.ok(Map.of(
                    "name", user.getName(),
                    "email", user.getEmail(),
                    "photoUrl", "data:image/jpeg;base64," + base64
            ));

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Could not upload image.");
        }
    }

}
