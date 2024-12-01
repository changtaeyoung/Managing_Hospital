package com.example.managing_hospital.account.dto;

import com.example.managing_hospital.account.entity.Nurse;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NurseLoginDTO {
    private String email;
    private String password;

    @Builder
    public NurseLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Nurse toEntity() {
        Nurse nurse = new Nurse();
        nurse.setEmail(email);
        nurse.setPassword(password);

        return nurse;
    }
}
