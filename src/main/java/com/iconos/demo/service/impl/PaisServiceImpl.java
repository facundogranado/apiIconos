
package com.iconos.demo.service.impl;

import com.iconos.demo.dto.PaisDetailsDto;
import com.iconos.demo.dto.PaisDto;
import com.iconos.demo.entity.PaisEntity;
import com.iconos.demo.mapper.PaisMapper;
import com.iconos.demo.repository.PaisRepository;
import com.iconos.demo.service.PaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService{

    @Autowired
    private PaisMapper paisMapper;
    
    
    @Autowired
    private PaisRepository paisRepository;
    
    
    
    @Override
    public PaisDto save(PaisDto dto) {
        PaisEntity entity = paisMapper.paisDto2Entity(dto);
        PaisEntity entitySv = paisRepository.save(entity);
        PaisDto result = paisMapper.paisEntity2Dto(entitySv);
        return result;
                
    }

    @Override
    public List<PaisDto> getAllPaises() {
        
        List<PaisEntity> entitis = paisRepository.findAll();
        List<PaisDto> result = paisMapper.paisEntityList2DtoList(entitis);
        
        return result;
    }

    @Override
    public void delete(Long id) {
        paisRepository.deleteById(id);
    }

    @Override
    public List<PaisDetailsDto> getAllPaisesDetails() {
        List<PaisEntity> entitis = paisRepository.findAll();
        List<PaisDetailsDto> result = paisMapper.paisEntityList2DtoDetailsList(entitis);
        return result;
    }

    @Override
    public List<PaisDto> getPaisFilers(String name) {
            List<PaisEntity> entitis = paisRepository.findAllByDenominacion(name);
            List<PaisDto> dtos = paisMapper.paisEntityList2DtoList(entitis);
        return dtos;
    }

    @Override
    public List<PaisDto> getPaisFilers(Long id) {
            List<PaisEntity> entitis = paisRepository.findAllByContinenteId(id);
            List<PaisDto> dtos = paisMapper.paisEntityList2DtoList(entitis);
        return dtos;
    }



}
