package com.example.aplikasisopspringboot.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(schema = "public", name = "sop_pelaksana")
public class SopPelaksana {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    private String id;

    @Column(name = "nomor_pelaksana", columnDefinition = "text")
    private String nomorPelaksana;

    @Column(name = "nama_pelaksana", columnDefinition = "text")
    private String namaPelaksana;

}
