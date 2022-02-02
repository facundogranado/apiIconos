package com.iconos.demo.dto;

import com.iconos.demo.entity.ContinenteEntity;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDetailsDto {
    
    private Long id;
    
    private String imagen;
    
    private String denominacion;
    
    private Long cantidadHabitantes;
    
    private Long superficie;
    
    private Long continenteId;
    
    private ContinenteEntity continente;
    
    private Set<IconDto> icons = new HashSet<>();
    
}
