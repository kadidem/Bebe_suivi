package com.bebesuivi.Controller;

import com.bebesuivi.Modele.Grossesse;
import com.bebesuivi.Service.GrossesseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("grossesse")
@AllArgsConstructor

public class GrossesseControleur {
    private final GrossesseService grossesseService;

    @PostMapping("/create")
    public ResponseEntity<Grossesse> createGrossesse(@Valid @RequestBody Grossesse grossesse){
        return new ResponseEntity<>(grossesseService.createGrossesse(grossesse), HttpStatus.OK);

    }
}