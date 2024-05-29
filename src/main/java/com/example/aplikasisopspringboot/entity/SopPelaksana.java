package com.example.aplikasisopspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(schema = "public", name = "sop_pelaksana")
@DynamicUpdate
@Data
public class SopPelaksana {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nama_pelaksana", columnDefinition = "text")
    private String namaPelaksana;

    @ManyToOne
    @JoinColumn(name = "id_sop")
    private Sop sop;

}
