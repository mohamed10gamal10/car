package com.Carrental.car.EntityDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiMessageResponse {
    private String message;

    @Data
    public static class LoginRequest {

        @NotBlank(message = "البريد الإلكتروني مطلوب")
        @Email(message = "صيغة البريد الإلكتروني غير صحيحة")
        private String email;

        @NotBlank(message = "كلمة المرور مطلوبة")
        private String password;
    }
}
