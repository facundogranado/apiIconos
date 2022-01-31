package com.iconos.demo.service;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import java.util.List;

public interface IconService {

    public IconDto save(IconDto dto);
    
    public List<IconBasicDto> getAllIcon();
//    
//    public void delete(Long id);
//    
}
