package com.example.aplikasisopspringboot.dao;

import com.example.aplikasisopspringboot.entity.Sop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SopDao extends JpaRepository<Sop, String> {
    Page<Sop> findAllByNamaSopContainingIgnoreCase(String search, Pageable page);
}
