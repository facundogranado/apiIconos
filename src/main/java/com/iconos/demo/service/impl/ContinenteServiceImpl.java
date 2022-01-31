/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.iconos.demo.service.impl;

import com.iconos.demo.dto.ContinenteDto;
import com.iconos.demo.entity.ContinenteEntity;
import com.iconos.demo.mapper.ContinenteMapper;
import com.iconos.demo.repository.ContinenteRepository;
import com.iconos.demo.service.ContinenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService{

    @Autowired
    private ContinenteMapper continenteMapper;
    
    @Autowired
    private ContinenteRepository continenteRepository;
    
    
    @Override
    public ContinenteDto save(ContinenteDto dto){
        ContinenteEntity entity =  continenteMapper.continenteDto2Entity(dto);
        ContinenteEntity entitySv = continenteRepository.save(entity);
        ContinenteDto result = continenteMapper.continenteEntity2Dto(entitySv);
        return result;
    }

    @Override
    public List<ContinenteDto> getAllContinentes() {
        List<ContinenteEntity> entity = continenteRepository.findAll();
        List<ContinenteDto> result = continenteMapper.continenteEntityList2DtoList(entity);
        return result;
    }

    @Override
    public void delete(Long id) {
            continenteRepository.deleteById(id);
    }

}