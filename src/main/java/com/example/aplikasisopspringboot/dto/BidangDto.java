package com.example.aplikasisopspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidangDto {
    private String id;
    private String nama;
    private String deskripsi;
    private String keterangan;
    private String kodeBidang;
    private String bidang;
}
