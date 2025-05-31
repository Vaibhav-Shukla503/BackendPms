package com.proj.proj.Controller;

import com.proj.proj.Model.Property;
import com.proj.proj.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller/UserPropertyController.java
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserPropertyController {

    private final PropertyService service;

    public UserPropertyController(PropertyService service) {
        this.service = service;
    }

    @GetMapping("/{userId}/properties")
    public List<Property> getUserProperties(@PathVariable Long userId) {
        return service.getAllForUser(userId);
    }

    @PostMapping("/{userId}/properties")
    public Property addProperty(@PathVariable Long userId, @RequestBody Property property) {
        return service.addPropertyToUser(userId, property);
    }

    @DeleteMapping("/{userId}/properties/{propertyId}")
    public void deleteProperty(@PathVariable Long userId, @PathVariable Long propertyId) {
        service.deleteUserProperty(userId, propertyId);
    }
}
