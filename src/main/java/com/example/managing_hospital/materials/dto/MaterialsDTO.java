package com.example.managing_hospital.materials.dto;

import com.example.managing_hospital.materials.entity.Materials;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class MaterialsDTO { //자재 이름, 구매 일자, 재고량
    private String name;
    private Date purchase_date;
    private int stock;

    public Materials toEntity() {
        Materials materials = new Materials();
        materials.setName(name);
        materials.setPurchaseDate(purchase_date);
        materials.setStock(stock);

        return materials;
    }
}
