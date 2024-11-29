package com.example.managing_hospital.materials.service;

import com.example.managing_hospital.materials.dto.MaterialsDTO;
import com.example.managing_hospital.materials.entity.Materials;
import com.example.managing_hospital.materials.repository.MaterialsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialsService {
    @Autowired
    private MaterialsRepository materialsRepository;

    @Transactional
    public Materials addMaterials(MaterialsDTO materialsDTO) {
        Optional<Materials> isExistMaterials =  materialsRepository.findByNameAndPurchaseDate(
                materialsDTO.getName(), materialsDTO.getPurchaseDate());

        if (isExistMaterials.isPresent()) {
            Materials materials = isExistMaterials.get();
            int plusStock = materials.getStock() + materialsDTO.getStock();
            materials.setStock(plusStock);
            return materialsRepository.save(materials); //재고 추가 후 업데이트
        }
        else {
            Materials materials = new Materials();
            materials.setName(materialsDTO.getName());
            materials.setPurchaseDate(materialsDTO.getPurchaseDate());
            materials.setStock(materialsDTO.getStock());
            return materialsRepository.save(materials); //이전에 재고가 없었을 경우 추가
        }
    }

    @Transactional
    public Materials useMaterials(MaterialsDTO materialsDTO) { //선입선출 방식 사용을 위해 List화 시킴
        List<Materials> materialsList = materialsRepository.findByName(materialsDTO.getName())
                .stream()
                .sorted(Comparator.comparing(Materials::getPurchaseDate))
                .toList();

        if (materialsList.isEmpty()) {
            return null; //재고 없음
        }

        int usingStock = materialsDTO.getStock();
        for(Materials materials : materialsList) {
            int availableStock = materials.getStock();

            if(availableStock >= usingStock) {
                materials.setStock(availableStock - usingStock);
                return materialsRepository.save(materials);
            }
            else {
                return null; //남은 재고량 보다 더 많이 쓸 순 없음
            }
        }
        return null; //재고 다씀
    }

    public List<Materials> findAllMaterials() { //재고 전체 검색
        return materialsRepository.findAll();
    }
}
