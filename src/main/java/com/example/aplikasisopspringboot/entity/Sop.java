package com.example.aplikasisopspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(schema = "public", name = "sop")
@DynamicUpdate
@Data
public class Sop {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nomor_sop", columnDefinition = "text")
    private String nomorSop;

    @Column(name = "nama_sop", columnDefinition = "text")
    private String namaSop;

}
