
package com.iconos.demo.controller;

import com.iconos.demo.dto.ContinenteDto;
import com.iconos.demo.service.ContinenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;
    
    @PostMapping
    public ResponseEntity<ContinenteDto> save(@RequestBody ContinenteDto continente){
        
        ContinenteDto continenteGuardado = continenteService.save(continente);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }
    
    @GetMapping
    public ResponseEntity<List<ContinenteDto>> getAll(){
        List<ContinenteDto> continentes = continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        continenteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
