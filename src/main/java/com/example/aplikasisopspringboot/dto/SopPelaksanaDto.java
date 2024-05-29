package com.example.aplikasisopspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SopPelaksanaDto {
    private String id;
    private String namaPelaksana;
    private String sop;
}
