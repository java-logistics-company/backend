package com.cscb025.logistic.company.controller;

import com.cscb025.logistic.company.controller.request.admin.CompanyRequestDTO;
import com.cscb025.logistic.company.controller.request.admin.OfficeRequestDTO;
import com.cscb025.logistic.company.controller.response.admin.CompanyResponseDTO;
import com.cscb025.logistic.company.controller.response.admin.OfficeResponseDTO;
import com.cscb025.logistic.company.service.CompanyService;
import com.cscb025.logistic.company.service.OfficeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin(origins = "*")
public class AdminController {

    private final CompanyService companyService;
    private final OfficeService officeService;

    public AdminController(CompanyService companyService, OfficeService officeService) {
        this.companyService = companyService;
        this.officeService = officeService;
    }

    @PostMapping("/company")
    public ResponseEntity<CompanyResponseDTO> registerCompany(@RequestBody @NotBlank String name) {
        return ResponseEntity.ok(companyService.register(name.trim()));
    }

    @PutMapping("/company")
    public ResponseEntity<CompanyResponseDTO> updateCompany(@RequestBody @Valid CompanyRequestDTO companyRequest) {
        return ResponseEntity.ok(companyService.edit(companyRequest));
    }

    @GetMapping("/company")
    public ResponseEntity<CompanyResponseDTO> getCompany(@RequestBody @NotBlank String companyId) {
        return ResponseEntity.ok(companyService.view(companyId));
    }

    @GetMapping("/office")
    public ResponseEntity<OfficeResponseDTO> getOffice(@RequestBody @NotBlank String officeId) {
        return ResponseEntity.ok(officeService.view(officeId));
    }

    @PostMapping("/office")
    public ResponseEntity<OfficeResponseDTO> registerOffice(@RequestBody @Valid OfficeRequestDTO officeRequest) {
        return ResponseEntity.ok(officeService.register(officeRequest));
    }

}
