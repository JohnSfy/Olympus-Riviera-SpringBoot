package com.OlympusRiviera.controller.Amenity;


import com.OlympusRiviera.model.Amenity.Amenity;
import com.OlympusRiviera.service.Amenity.AmenityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/amenity")
public class AmenityControllerGeneral {

    private final AmenityService amenityService;

    public AmenityControllerGeneral(AmenityService amenityService) {
        this.amenityService = amenityService;
    }



    @GetMapping("/get/all")
    public ResponseEntity<List<Amenity>> getAllApprovedAmenities() {
        // Fetch all amenities
        List<Amenity> allAmenities = amenityService.getAllAmenities();

        // Filter the list to include only those with status "APPROVED"
        List<Amenity> approvedAmenities = allAmenities.stream()
                .filter(amenity -> "APPROVED".equalsIgnoreCase(amenity.getStatus()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(approvedAmenities); // Return 200 OK with the filtered list
    }

    // Get details of a specific destination by ID
    @GetMapping("/get/{amenity_id}")
    public ResponseEntity<Amenity> getAmenityDetails(@PathVariable("amenity_id") String amenity_id) {
        Amenity amenityDetails = amenityService.getAmenity(amenity_id);
        if (amenityDetails != null) {
            return ResponseEntity.ok(amenityDetails); // Return 200 OK with the destination
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 Not Found if the destination doesn't exist
        }
    }
}
