package com.iconos.demo.service.impl;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import com.iconos.demo.entity.IconEntity;
import com.iconos.demo.mapper.IconMapper;
import com.iconos.demo.repository.IconRepository;
import com.iconos.demo.service.IconService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconServiceImpl implements IconService {
    
    @Autowired
    private IconMapper iconMapper;
    
    @Autowired
    private IconRepository iconRepository;
    
    @Override
    public List<IconBasicDto> getAllIcon() {
        List<IconEntity> lsicon = iconRepository.findAll();
        List<IconBasicDto> result = iconMapper.iconEntityList2DtoList(lsicon);
        
        return result;
    }
    
    @Override
    public IconDto save(IconDto dto) {
        IconEntity entity = iconMapper.iconDto2Entity(dto);
        IconEntity entitySv = iconRepository.save(entity);
        IconDto result = iconMapper.inconEntity2Dtoicon(entitySv);
        return result;
    }
    
    @Override
    public void delete(Long id) {
        iconRepository.deleteById(id);
    }
    
    @Override
    public List<IconBasicDto> getIconFilterName(String name) {
        List<IconEntity> entitis = iconRepository.findAllByDenominacion(name);
        List<IconBasicDto> dtos = iconMapper.iconEntityList2DtoList(entitis);
        return dtos;
    }
    
    @Override
    public List<IconBasicDto> getIconFilterDate(LocalDate fecha) {
        List<IconEntity> entitis = iconRepository.findAllByFechaCreacion(fecha);
        List<IconBasicDto> dtos = iconMapper.iconEntityList2DtoList(entitis);
        return dtos;
    }
    
    @Override
    public List<IconBasicDto> getIconFilterAltura(Long alt) {
        List<IconEntity> entitis = iconRepository.findAllByAltura(alt);
        List<IconBasicDto> dtos = iconMapper.iconEntityList2DtoList(entitis);
        return dtos;
    }
    
}
