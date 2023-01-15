package lt.seb.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lt.seb.api.entities.Bundle;
import lt.seb.api.entities.dto.BundleDTO;
import lt.seb.api.services.BundleService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bundles")
@AllArgsConstructor
public class BundleController {
    private final BundleService bundleService;
    @Operation(description = "Endpoint for getting bundle for customer")
    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BundleDTO getBundleForCustomer(@PathVariable("customerId") Long customerId){
        return bundleService.showBundle(customerId);
    }

    @Operation(description = "Endpoint for getting all bundles")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bundle> getListOfAllBundles() {
        return bundleService.getBundles();
    }
}
