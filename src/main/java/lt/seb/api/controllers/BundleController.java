package lt.seb.api.controllers;

import lombok.AllArgsConstructor;
import lt.seb.api.entities.Bundle;
import lt.seb.api.entities.dto.BundleDTO;
import lt.seb.api.services.BundleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bundles")
@AllArgsConstructor
public class BundleController {
    private final BundleService bundleService;

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BundleDTO getBundle(@PathVariable("customerId") Long customerId){
        return bundleService.createBundle(customerId);
    }
}
