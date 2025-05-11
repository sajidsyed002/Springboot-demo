package com.dailycodebuffer.Springboot.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    @NotBlank(message = "Please add name")
    /*@Length(max = 5, min =1)
    @Size(max = 10, min =0)
    @Email
    @PositiveOrZero*/
    private String deptName;
    private String deptAddress;
    private String deptCode;

}
