package com.example.aplikasisopspringboot.controller;

import com.example.aplikasisopspringboot.dao.SopDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("full")
public class FullSopController {
    @Autowired
    private SopDao sopDao;
}
