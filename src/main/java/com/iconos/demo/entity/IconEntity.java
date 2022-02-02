
package com.iconos.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "iconos")
@Getter
@Setter
@SQLDelete(sql = "UPDATE iconos SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class IconEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String imagen;
    
    private String denominacion;
    
    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;
    
    private Long altura;
    
    private String historia;
    
    private boolean deleted = Boolean.FALSE;
    
    @ManyToMany(mappedBy = "icons",cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();
}
