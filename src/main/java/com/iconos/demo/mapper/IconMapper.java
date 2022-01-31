package com.iconos.demo.mapper;

import com.iconos.demo.dto.IconBasicDto;
import com.iconos.demo.dto.IconDto;
import com.iconos.demo.entity.IconEntity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class IconMapper {

    public IconEntity iconBasicDto2Entity(IconBasicDto dto) {

        IconEntity result = new IconEntity();

        result.setDenominacion(dto.getDenominacion());
        result.setImagen(dto.getImagen());

        return result;
    }

    public IconEntity iconDto2Entity(IconDto dto) {

        IconEntity result = new IconEntity();
        result.setId(dto.getId());
        result.setDenominacion(dto.getDenominacion());
        result.setImagen(dto.getImagen());
        result.setAltura(dto.getAltura());
        result.setFechaCreacion(dto.getFechaCreacion());
        result.setHistoria(dto.getHistoria());

        return result;
    }

    public IconDto inconEntity2Dtoicon(IconEntity entity) {
        IconDto result = new IconDto();
        result.setId(entity.getId());
        result.setDenominacion(entity.getDenominacion());
        result.setImagen(entity.getImagen());
        result.setAltura(entity.getAltura());
        result.setHistoria(entity.getHistoria());
        result.setFechaCreacion(entity.getFechaCreacion());
        
        return result;
    }

    public IconBasicDto iconEntity2Dto(IconEntity entity) {

        IconBasicDto result = new IconBasicDto();

        result.setDenominacion(entity.getDenominacion());
        result.setId(entity.getId());
        result.setImagen(entity.getImagen());

        return result;
    }

    public List<IconBasicDto> iconEntityList2DtoList(List<IconEntity> entitis) {
        List<IconBasicDto> ldto = new ArrayList<>();
        for (IconEntity entiti : entitis) {
            ldto.add(iconEntity2Dto(entiti));
        }
        return ldto;
    }

    public Set<IconBasicDto> iconEntityList2DtoList(Set<IconEntity> entitis) {
        Set<IconBasicDto> ldto = new HashSet<>();

        for (IconEntity entiti : entitis) {
            ldto.add(iconEntity2Dto(entiti));
        }
        return ldto;
    }

    private LocalDate string2LocalDate(String fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(fecha, formatter);
        return date;
    }

    private String localDate2String(LocalDate fecha) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fecha.format(formatter);
        return date;
    }
}
