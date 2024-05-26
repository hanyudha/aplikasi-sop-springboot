package com.example.aplikasisopspringboot.service;

import com.example.aplikasisopspringboot.dao.SopDao;
import com.example.aplikasisopspringboot.entity.Sop;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
public class SopService {
    @Autowired
    private SopDao sopDao;

    public Page<Sop> getByNameAndPage(String search, Pageable page) {
        return sopDao.findAllByNamaSopContainingIgnoreCase(search, page);
    }

    public Page<Sop> getAllSopListPaging(Pageable page) {
        return sopDao.findAll(page);
    }
}
