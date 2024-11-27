package com.example.managing_hospital.materials.controller;

import com.example.managing_hospital.materials.dto.MaterialsDTO;
import com.example.managing_hospital.materials.entity.Materials;
import com.example.managing_hospital.materials.service.MaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialsController {
    @Autowired
    private MaterialsService materialsService;

    //재고 추가
    @PostMapping("/add")
    public ResponseEntity<Materials> addMaterials(@RequestBody MaterialsDTO materialsDTO) {
        Materials materials = materialsService.addMaterials(materialsDTO);
        return ResponseEntity.ok().body(materials);
    }

    //사용시 현재 재고량 감소
    @PostMapping("/use")
    public ResponseEntity<Materials> useMaterials(@RequestBody MaterialsDTO materialsDTO) {
        Materials materials = materialsService.useMaterials(materialsDTO);
        if (materials != null) {
            return ResponseEntity.status(HttpStatus.OK).body(materials);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    //재고 전체 확인
    @PostMapping("/findall")
    public ResponseEntity<List<Materials>> findAllMaterials() {
        List<Materials> materials = materialsService.findAllMaterials();
        return ResponseEntity.status(HttpStatus.OK).body(materials);
    }
}
