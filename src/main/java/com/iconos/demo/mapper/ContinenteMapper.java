
package com.iconos.demo.mapper;

import com.iconos.demo.dto.ContinenteDto;
import com.iconos.demo.entity.ContinenteEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ContinenteMapper {

    public ContinenteEntity continenteDto2Entity(ContinenteDto dto){
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());
        return continenteEntity;
    } 
    
    public ContinenteDto continenteEntity2Dto(ContinenteEntity entity){
        ContinenteDto continenteDto = new ContinenteDto();
        continenteDto.setId(entity.getId());
        continenteDto.setImagen(entity.getImagen());
        continenteDto.setDenominacion(entity.getDenominacion());
        return continenteDto;
    }
    
    public List<ContinenteDto> continenteEntityList2DtoList(List<ContinenteEntity> entities){
            List<ContinenteDto> dtos = new ArrayList<>();
            for (ContinenteEntity enti : entities) {
                dtos.add(continenteEntity2Dto(enti));
            }
        return dtos;
    }
}
