package com.portfolio.portfolio.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequestDto {
    private String name;
    private String email;
    private String password;

}
