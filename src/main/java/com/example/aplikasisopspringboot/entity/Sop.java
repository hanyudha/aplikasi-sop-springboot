package com.example.aplikasisopspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @ManyToOne
    @JoinColumn(name = "id_bidang")
    private Bidang bidang;

    @Column(name = "nomor_sop", columnDefinition = "text")
    private String nomorSop;

    @CreatedDate
    @Column(name = "created_at", length = 30, updatable = false)
    private LocalDate tglPembuatan;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate tglRevisi;


    @Column(name = "efektif_at")
    private LocalDate tglEfektif;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String disahkanOleh;

    @Column(name = "nama_sop", columnDefinition = "text")
    private String namaSop;

}
