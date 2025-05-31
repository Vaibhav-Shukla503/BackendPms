package com.proj.proj.service;

import com.proj.proj.Model.Property;
import com.proj.proj.Model.User;
import com.proj.proj.Repository.PropertyRepository;
import com.proj.proj.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepo;
    private final UserRepository userRepo;

    public PropertyService(PropertyRepository propertyRepo, UserRepository userRepo) {
        this.propertyRepo = propertyRepo;
        this.userRepo = userRepo;
    }

    public List<Property> getAllForUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getProperties();
    }

    public Property addPropertyToUser(Long userId, Property property) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        property.setUser(user);
        return propertyRepo.save(property);
    }

    public void deleteUserProperty(Long userId, Long propertyId) {
        Property property = propertyRepo.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        if (!property.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized delete");
        }

        propertyRepo.delete(property);
    }
}

