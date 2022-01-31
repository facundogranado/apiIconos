package com.iconos.demo.service;

import com.iconos.demo.dto.PaisDetailsDto;
import com.iconos.demo.dto.PaisDto;
import java.util.List;


public interface PaisService {
    public PaisDto save(PaisDto dto);
    
    public List<PaisDto> getAllPaises();
    
    public void delete(Long id);

    public List<PaisDetailsDto> getAllPaisesDetails();

    public List<PaisDto> getPaisFilers(String name);
    
    public List<PaisDto> getPaisFilers(Long id);
}
