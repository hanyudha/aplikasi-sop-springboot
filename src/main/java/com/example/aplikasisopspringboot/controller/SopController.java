package com.example.aplikasisopspringboot.controller;


import com.example.aplikasisopspringboot.dao.SopDao;
import com.example.aplikasisopspringboot.entity.Sop;
import com.example.aplikasisopspringboot.service.SopService;
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

import jakarta.validation.Valid;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("sop")
public class SopController{
    @Autowired
    private SopService sopService;
    @Autowired
    private SopDao sopDao;

    @GetMapping(value = {"/", "/list"})
    public String getList(ModelMap mm,
                          @RequestParam(value = "search", required = false) String search,
                          @PageableDefault(size = 10)Pageable page) {
        Page<Sop> result;
        if (search != null && !search.isEmpty()) {
            result = sopService.getByNameAndPage(search, page);
            mm.addAttribute("search", search);
        } else {
            result = sopService.getAllSopListPaging(page);
        }
        mm.addAttribute("data", result);

        return "sop/list";
    }

    @GetMapping("/view")
    public String viewData(@RequestParam(value = "id") String id, ModelMap mm) {
        Sop sop = new Sop();
        if (StringUtils.hasText(id)) {
            Optional<Sop> o = sopDao.findById(id);
            if (o.isPresent()) {
                sop = o.get();
            }
        } else {
            return "redirect:/sop/list";
        }

        mm.addAttribute("sop", sop);

        return "sop/view";
    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam(value = "id", required = false) String id, RedirectAttributes ra) {
        sopDao.deleteById(id);
        ra.addAttribute("message", "SOP berhasil di hapus");
        return "redirect:/sop/list";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) String id, ModelMap mm){
        Sop sop = new Sop();
        if (StringUtils.hasText(id)){
            Optional<Sop> o = sopDao.findById(id);
            if (o.isPresent()) {
                sop = o.get();
            }
        }
        mm.addAttribute("sop", sop);
        return "sop/form";
    }

    @PostMapping("/form")
    public String updateForm(@ModelAttribute @Valid Sop o, BindingResult errors, ModelMap mm){
        log.info("Sop:{}", o);
        if (errors.hasErrors()) {
            log.info("error: {}", errors);
            mm.addAttribute("sop", o);
            return "sop/form";
        } else {
            sopDao.save(o);

            return "redirect:/sop/list";
        }
    }
}
