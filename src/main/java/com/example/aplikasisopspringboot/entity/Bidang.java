package com.example.aplikasisopspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(schema = "public", name = "bidang")
@DynamicUpdate
@Data
public class Bidang {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nama", columnDefinition = "text")
    private String nama;

    @Column(name = "deskripsi", columnDefinition = "text")
    private String deskripsi;

    @Column(name = "keterangan", columnDefinition = "text")
    private String keterangan;

    @Column(name = "kode_bidang", columnDefinition = "text")
    private String kodeBidang;

    @Column(name = "bidang", columnDefinition = "text")
    private String bidang;
}
