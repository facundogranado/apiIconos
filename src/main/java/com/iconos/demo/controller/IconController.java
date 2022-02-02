package com.iconos.demo.controller;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import com.iconos.demo.service.IconService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public ResponseEntity<List<IconBasicDto>> getAllIcon() {
        List<IconBasicDto> result = iconService.getAllIcon();
        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<IconDto> save(@RequestBody IconDto dto) {
        IconDto result = iconService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/filtername")
    public ResponseEntity<List<IconBasicDto>> getIconFilterName(@RequestParam(name = "name", required = false) String name) {
        List<IconBasicDto> result = iconService.getIconFilterName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filterdate")
    public ResponseEntity<List<IconBasicDto>> getIconFilterDate(@RequestParam(name = "date", required = false) String fecha) {
        LocalDate fecha1 = LocalDate.parse(fecha);
        List<IconBasicDto> result = iconService.getIconFilterDate(fecha1);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filteraltura")
    public ResponseEntity<List<IconBasicDto>> getIconFilterAltura(@RequestParam(name = "altura", required = false) Long alt) {
        List<IconBasicDto> result = iconService.getIconFilterAltura(alt);
        return ResponseEntity.ok(result);
    }
}
