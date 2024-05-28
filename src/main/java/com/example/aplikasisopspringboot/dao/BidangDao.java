package com.example.aplikasisopspringboot.dao;

import com.example.aplikasisopspringboot.entity.Bidang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidangDao extends JpaRepository<Bidang, String> {
    Page<Bidang> findAllByNamaContainingIgnoreCase(String search, Pageable page);
}
