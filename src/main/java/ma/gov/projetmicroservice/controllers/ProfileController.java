package ma.gov.projetmicroservice.controllers;

import lombok.RequiredArgsConstructor;
import ma.gov.projetmicroservice.dtos.ProfileDto;
import ma.gov.projetmicroservice.services.IProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final IProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileDto>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> getProfileById(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProfileDto> createProfile(@RequestBody ProfileDto profileDTO) {
        return ResponseEntity.ok(profileService.create(profileDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDto> updateProfile(@PathVariable Long id, @RequestBody ProfileDto profileDTO) {
        return ResponseEntity.ok(profileService.update(id, profileDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

