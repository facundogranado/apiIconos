
package com.iconos.demo.controller;

import com.iconos.demo.dto.PaisDetailsDto;
import com.iconos.demo.dto.PaisDto;
import com.iconos.demo.service.PaisService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paises")
public class PaisController {

    @Autowired
    private PaisService paisService;
    
    @PostMapping
    public ResponseEntity<PaisDto> save(@RequestBody PaisDto dto){
        
        PaisDto result = paisService.save(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<PaisDto>> getAllPaises(){
        List<PaisDto> paises = paisService.getAllPaises();
        return ResponseEntity.ok(paises);
    }
    
    @GetMapping("/detalles")
    public ResponseEntity<List<PaisDetailsDto>> getAllPaisesDetails(){
        List<PaisDetailsDto> paises = paisService.getAllPaisesDetails();
        return ResponseEntity.ok(paises);
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        paisService.delete(id);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    
    }
    
    @GetMapping
    public ResponseEntity<List<PaisDto>> getPaisFilters(@RequestParam(name="name",required = false) String name){
        List<PaisDto> dtos = paisService.getPaisFilers(name);
        return ResponseEntity.ok(dtos);
    }
    
    @GetMapping("/continente")
    public ResponseEntity<List<PaisDto>> getPaisFiltersContinente(@RequestParam(name = "idContinente",required = false) Long id){
        List<PaisDto> dtos = paisService.getPaisFilers(id);
        return ResponseEntity.ok(dtos);
    }
}
