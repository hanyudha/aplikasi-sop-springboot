package com.example.aplikasisopspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(schema = "public", name = "sop_relasi")
@DynamicUpdate
@Data
public class SopRelasi {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    private String id;

    @Column(name = "port_asal", columnDefinition = "text")
    private String portAsal;

    @Column(name = "port_tujuan", columnDefinition = "text")
    private String portTujuan;

    @Column(name = "label", columnDefinition = "text")
    private String label;
}
