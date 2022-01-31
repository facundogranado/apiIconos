package com.iconos.demo.repository;

import com.iconos.demo.entity.PaisEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Long>{
    
    public abstract List<PaisEntity> findAllByDenominacion(String name);
    public abstract List<PaisEntity> findAllByContinenteId(Long id);
    
    
}
