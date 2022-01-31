package com.iconos.demo.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IconDto {

    private Long id;
    private String imagen;
    private String denominacion;
    private LocalDate fechaCreacion;
    private Long altura;
    private String historia;
    private List<PaisDto> paises;
}
