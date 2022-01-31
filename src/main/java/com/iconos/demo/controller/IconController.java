
package com.iconos.demo.controller;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import com.iconos.demo.service.IconService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("icons")
public class IconController {
    
    @Autowired
    private IconService iconService;
    
    @GetMapping
    public ResponseEntity<List<IconBasicDto>> getAllIcon(){
            List<IconBasicDto> result = iconService.getAllIcon();
        return ResponseEntity.ok(result);
    
    }
    
    @PostMapping
    public ResponseEntity<IconDto> save(@RequestBody IconDto dto){
            IconDto result = iconService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    
    }
}
