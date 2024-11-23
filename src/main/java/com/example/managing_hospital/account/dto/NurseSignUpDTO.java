package com.example.managing_hospital.account.dto;

import com.example.managing_hospital.account.entity.Nurse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NurseSignUpDTO {
    private String email;
    private String password;
    private String name;

    @Builder
    public NurseSignUpDTO(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Nurse toEntity() {
        Nurse nurse = new Nurse();
        nurse.setEmail(email);
        nurse.setPassword(password);
        nurse.setName(name);

        return nurse;
    }
}
