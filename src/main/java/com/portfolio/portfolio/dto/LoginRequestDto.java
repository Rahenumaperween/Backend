package com.portfolio.portfolio.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequestDto {
	 private String email;
	 private String password;

}
