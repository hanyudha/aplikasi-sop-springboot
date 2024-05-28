package com.example.aplikasisopspringboot.controller;

import com.example.aplikasisopspringboot.dao.BidangDao;
import com.example.aplikasisopspringboot.entity.Bidang;
import com.example.aplikasisopspringboot.service.BidangService;
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

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("bidang")
public class BidangController {
    @Autowired
    private BidangService bidangService;

    @Autowired
    private BidangDao bidangDao;

    @GetMapping(value = {"/", "/list"})
    public String getList(ModelMap mm,
                          @RequestParam(value = "search", required = false) String search,
                          @PageableDefault(size = 10) Pageable page) {
        Page<Bidang> result;
        if (search != null && !search.isEmpty()) {
            result = bidangService.getByNameAndPage(search, page);
            mm.addAttribute("search", search);
        } else {
            result = bidangService.getAllBidangListPaging(page);
        }
        mm.addAttribute("data", result);

        return "bidang/list";
    }

    @GetMapping("/view")
    public String viewData(@RequestParam(value = "id") String id, ModelMap mm) {
        Bidang bidang = new Bidang();
        if (StringUtils.hasText(id)) {
            Optional<Bidang> o = bidangDao.findById(id);
            if (o.isPresent()) {
                bidang = o.get();
            }
        } else {
            return "redirect:/bidang/list";
        }

        mm.addAttribute("bidang", bidang);

        return "bidang/view";
    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam(value = "id", required = false) String id, RedirectAttributes ra) {
        bidangDao.deleteById(id);
        ra.addAttribute("message", "Bidang berhasil di hapus");
        return "redirect:/bidang/list";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) String id, ModelMap mm){
        Bidang bidang = new Bidang();
        if (StringUtils.hasText(id)){
            Optional<Bidang> o = bidangDao.findById(id);
            if (o.isPresent()) {
                bidang = o.get();
            }
        }
        mm.addAttribute("bidang", bidang);
        return "bidang/form";
    }

    @PostMapping("/form")
    public String updateForm(@ModelAttribute @Valid Bidang o, BindingResult errors, ModelMap mm){
        log.info("Bidang:{}", o);
        if (errors.hasErrors()) {
            log.info("error: {}", errors);
            mm.addAttribute("bidang", o);
            return "bidang/form";
        } else {
            bidangDao.save(o);

            return "redirect:/bidang/list";
        }
    }
}
