package com.example.aplikasisopspringboot.service;

import com.example.aplikasisopspringboot.dao.BidangDao;
import com.example.aplikasisopspringboot.entity.Bidang;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
public class BidangService {
    @Autowired
    private BidangDao bidangDao;

    public Page<Bidang> getByNameAndPage(String search, Pageable page) {
        return bidangDao.findAllByNamaContainingIgnoreCase(search, page);
    }

    public Page<Bidang> getAllBidangListPaging(Pageable page) {
        return bidangDao.findAll(page);
    }
}
