package com.iconos.demo.repository;

import com.iconos.demo.entity.IconEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long>{
    
    public abstract List<IconEntity> findAllByDenominacion(String name);
    public abstract List<IconEntity> findAllByFechaCreacion(LocalDate fecha);
    public abstract List<IconEntity> findAllByAltura(Long altura);
}
