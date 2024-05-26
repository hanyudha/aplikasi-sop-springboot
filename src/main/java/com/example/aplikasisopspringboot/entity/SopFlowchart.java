package com.example.aplikasisopspringboot.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(schema = "public", name = "sop_flowchart")
@DynamicUpdate
@Data
public class SopFlowchart {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @UuidGenerator
    @Column(name = "id", length = 36)
    private String id;

    @Column(name = "nomor_flowchart", columnDefinition = "text")
    private String nomorFlowchart;

    @Column(name = "nama_flowchart", columnDefinition = "text")
    private String namaFlowchart;
}
