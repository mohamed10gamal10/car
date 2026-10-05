package com.Carrental.car.Exaption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorREsponse
{
    private String masage;
    private LocalDateTime localDateTime;
    private int  statues;

}
