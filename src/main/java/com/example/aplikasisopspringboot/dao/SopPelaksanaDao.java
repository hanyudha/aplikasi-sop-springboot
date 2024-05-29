package com.example.aplikasisopspringboot.dao;


import com.example.aplikasisopspringboot.entity.SopPelaksana;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SopPelaksanaDao extends JpaRepository<SopPelaksana, String> {
    Page<SopPelaksana> findAllByNamaPelaksanaContainingIgnoreCase(String search, Pageable page);
}
