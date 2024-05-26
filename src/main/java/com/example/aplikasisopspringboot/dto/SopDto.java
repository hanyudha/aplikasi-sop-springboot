package com.example.aplikasisopspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SopDto {
    private String id;
    private String nomorSop;
    private String namaSop;
}
