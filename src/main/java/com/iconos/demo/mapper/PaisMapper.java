
package com.iconos.demo.mapper;

import com.iconos.demo.dto.PaisDetailsDto;
import com.iconos.demo.dto.PaisDto;
import com.iconos.demo.entity.PaisEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {

    @Autowired
   private IconMapper iconMapper;
    
    public PaisEntity paisDto2Entity(PaisDto dto){
        
        PaisEntity entity = new PaisEntity();
        entity.setDenominacion(dto.getDenominacion());
        entity.setImagen(dto.getImagen());
        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
        
        return entity;
    }
    
    public PaisDto paisEntity2Dto(PaisEntity entity){
        
        PaisDto dto = new PaisDto();
        
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setDenominacion(entity.getDenominacion());
        dto.setImagen(entity.getImagen());
        
        return dto;
    }

    
    public List<PaisDto> paisEntityList2DtoList(List<PaisEntity> listEntity){
        
        List<PaisDto> dtos = new ArrayList<>();
        
        for (PaisEntity entity : listEntity) {
            dtos.add(paisEntity2Dto(entity));
        }
        
        return dtos;
    }

    
    public PaisDetailsDto paisEntity2DtoDetailsPais(PaisEntity entity){
        PaisDetailsDto result = new PaisDetailsDto();
        
        result.setId(entity.getId());
        result.setImagen(entity.getImagen());
        result.setDenominacion(entity.getDenominacion());
        result.setCantidadHabitantes(entity.getCantidadHabitantes());
        result.setSuperficie(entity.getSuperficie());
        result.setContinente(entity.getContinente());
        result.setIcons(iconMapper.iconEntityList2DtoList(entity.getIcons()));
    
        return result;
    }
    
    
    public List<PaisDetailsDto> paisEntityList2DtoDetailsList(List<PaisEntity> paises){
        List<PaisDetailsDto> dtos = new ArrayList<>();
        
        for (PaisEntity paise : paises) {
            dtos.add(paisEntity2DtoDetailsPais(paise));
        }
        return dtos;
    }
    
    
}
