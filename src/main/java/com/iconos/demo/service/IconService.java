package com.iconos.demo.service;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import java.time.LocalDate;
import java.util.List;

public interface IconService {

    public IconDto save(IconDto dto);
    
    public List<IconBasicDto> getAllIcon();

    public void delete(Long id);

    public List<IconBasicDto> getIconFilterName(String name);

    public List<IconBasicDto> getIconFilterDate(LocalDate fecha);

    public List<IconBasicDto> getIconFilterAltura(Long alt);
}
