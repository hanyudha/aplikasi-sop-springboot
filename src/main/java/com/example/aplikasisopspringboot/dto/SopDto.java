package com.example.aplikasisopspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SopDto {
    private String id;
    private String bidang;
    private String nomorSop;
    private LocalDateTime tglPembuatan;
    private LocalDateTime tglRevisi;
    private LocalDateTime tglEfektif;
    private String disahkanOleh;
    private String namaSop;
}
