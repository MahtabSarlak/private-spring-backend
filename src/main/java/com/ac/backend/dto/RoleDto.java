package com.ac.backend.dto;

import com.ac.backend.annotaion.ValidRoleName;
import lombok.Data;

@Data
public class RoleDto {
    Long id;
    @ValidRoleName
    String name;
}
