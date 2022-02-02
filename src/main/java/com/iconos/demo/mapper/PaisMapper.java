
package com.iconos.demo.mapper;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import com.iconos.demo.dto.PaisDetailsDto;
import com.iconos.demo.dto.PaisDto;
import com.iconos.demo.entity.IconEntity;
import com.iconos.demo.entity.PaisEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {

    @Autowired
   private IconMapper iconMapper;
    
//    public PaisEntity paisDto2Entity(PaisDto dto){
//        
//        PaisEntity entity = new PaisEntity();
//        entity.setDenominacion(dto.getDenominacion());
//        entity.setImagen(dto.getImagen());
//        entity.setCantidadHabitantes(dto.getCantidadHabitantes());
//        
//        return entity;
//    }
    
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
    
    

    public PaisEntity paisDetailsDto2Entity(PaisDetailsDto dto) {
                PaisEntity result = new PaisEntity();
        
        result.setImagen(dto.getImagen());
        result.setDenominacion(dto.getDenominacion());
        result.setCantidadHabitantes(dto.getCantidadHabitantes());
        result.setSuperficie(dto.getSuperficie());
        result.setContinenteId(dto.getContinenteId());
        
        Set<IconDto> icons = dto.getIcons();
        Set<IconEntity> entitis = new HashSet<>();
        for (IconDto icon : icons) {
            entitis.add(iconMapper.iconDto2Entity(icon));
        }
        
        result.setIcons(entitis);
        return result;
    }

    public PaisDetailsDto paisEntity2DetailsDto(PaisEntity entity) {
         PaisDetailsDto result = new PaisDetailsDto();
        
        result.setId(entity.getId());
        result.setImagen(entity.getImagen());
        result.setDenominacion(entity.getDenominacion());
        result.setCantidadHabitantes(entity.getCantidadHabitantes());
        result.setSuperficie(entity.getSuperficie());
        result.setContinenteId(entity.getContinenteId());
        result.setContinente(entity.getContinente());
        Set<IconEntity> entitis = entity.getIcons();
        Set<IconDto> icons = new HashSet<>();
        
        for (IconEntity entiti : entitis) {
            icons.add(iconMapper.inconEntity2Dtoicon(entiti));
        }
        result.setIcons(icons);
        return result;
    }
    
    
}
