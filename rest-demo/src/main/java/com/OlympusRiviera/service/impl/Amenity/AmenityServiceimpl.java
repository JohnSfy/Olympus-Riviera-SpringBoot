package com.OlympusRiviera.service.impl.Amenity;

import com.OlympusRiviera.model.Amenity.Amenity;
import com.OlympusRiviera.repository.Amenity.AmenityRepository;
import com.OlympusRiviera.service.Amenity.AmenityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityServiceimpl implements AmenityService {

    AmenityRepository amenityRepository;

    public AmenityServiceimpl(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    public String createAmenity(Amenity amenity) {
        amenityRepository.save(amenity);
        return "Success";
    }

    public String updateAmenity(Amenity amenity) {
        amenityRepository.save(amenity);
        return "Update Success";
    }

    public String deleteAmenity(String amenity_id) {
        amenityRepository.deleteById(amenity_id);
        return "Deleted Success";
    }

    public Amenity getAmenity(String amenity_id) {

        return amenityRepository.findById(amenity_id).get();
    }

    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }
}
