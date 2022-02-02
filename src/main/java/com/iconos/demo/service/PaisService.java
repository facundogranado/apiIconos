package com.iconos.demo.service;

import com.iconos.demo.dto.PaisDetailsDto;
import com.iconos.demo.dto.PaisDto;
import java.util.List;


public interface PaisService {
    public PaisDetailsDto save(PaisDetailsDto dto);
    
    public List<PaisDto> getAllPaises();
    
    public void delete(Long id);

    public List<PaisDto> getPaisFilers(String name);
    
    public List<PaisDto> getPaisFilers(Long id);

    public PaisDetailsDto getPaisDetails(Long id);
}
