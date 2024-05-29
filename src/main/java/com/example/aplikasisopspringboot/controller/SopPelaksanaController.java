package com.example.aplikasisopspringboot.controller;

import com.example.aplikasisopspringboot.dao.SopDao;
import com.example.aplikasisopspringboot.dao.SopPelaksanaDao;
import com.example.aplikasisopspringboot.entity.Sop;
import com.example.aplikasisopspringboot.entity.SopPelaksana;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("sop-pelaksana")
public class SopPelaksanaController {
    @Autowired
    private SopPelaksanaDao sopPelaksanaDao;

    @Autowired
    private SopDao sopDao;

    @GetMapping(value = {"/", "/list"})
    public String getList(ModelMap mm,
                          @RequestParam(value = "search", required = false) String search,
                          @PageableDefault(size = 10)Pageable page) {

        Page<SopPelaksana> result;
        if(search != null && !search.isEmpty()) {
            result = sopPelaksanaDao.findAllByNamaPelaksanaContainingIgnoreCase(search, page);
            mm.addAttribute("search", search);
        } else {
            result = sopPelaksanaDao.findAll(page);
        }

        mm.addAttribute("data", result);

        return "sop-pelaksana/list";
    }

    @GetMapping("/view")
    public String viewData(@RequestParam(value = "id") String id, ModelMap mm) {
        SopPelaksana sopPelaksana = new SopPelaksana();

        if(StringUtils.hasText(id)) {
            Optional<SopPelaksana> o =  sopPelaksanaDao.findById(id);
            if(o.isPresent()) {
                sopPelaksana = o.get();
            }
        } else {
            return "redirect:/sop-pelaksana/list";
        }

        mm.addAttribute("sopPelaksana", sopPelaksana);

        return "sop-pelaksana/view";
    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam(value = "id", required = false) String id, RedirectAttributes ra) {
        sopPelaksanaDao.deleteById(id);
        ra.addAttribute("message", "Pelaksana berhasil di hapus");
        return "redirect:/sop-pelaksana/list";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) String id, ModelMap mm) {
        SopPelaksana sopPelaksana = new SopPelaksana();
        List<Sop> sopList = sopDao.findAll();
        if(StringUtils.hasText(id)) {
            Optional<SopPelaksana> o =  sopPelaksanaDao.findById(id);
            if(o.isPresent()) {
                sopPelaksana = o.get();
            }
        }
        
        mm.addAttribute("sopPelaksana", sopPelaksana);
        mm.addAttribute("sopList", sopList);
        
        return "sop-pelaksana/form";
    }

    @PostMapping("/form")
    public String updateForm(@ModelAttribute @Valid SopPelaksana o, BindingResult errors, ModelMap mm) {
        log.info("SopPelaksana:", o);
        if(errors.hasErrors()){
            log.info("errors:{}", errors);
            mm.addAttribute("sopPelaksana", o);
            return "sop-pelaksana/form";
        } else {
            sopPelaksanaDao.save(o);

            return "redirect:/sop-pelaksana/list";
        }
    }
}
