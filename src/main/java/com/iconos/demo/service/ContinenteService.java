package com.iconos.demo.service;

import com.iconos.demo.dto.ContinenteDto;
import java.util.List;

public interface ContinenteService {
    
    public ContinenteDto save(ContinenteDto dto);
    
    public List<ContinenteDto> getAllContinentes();
    
    public void delete(Long id);
            
}
