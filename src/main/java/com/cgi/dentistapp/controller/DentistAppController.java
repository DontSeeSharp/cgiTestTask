package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dao.entity.DentistEntity;
import com.cgi.dentistapp.dao.entity.DentistVisitEntity;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO, Model model) {
        List<DentistEntity> dentsists = dentistVisitService.listDentists();
        model.addAttribute("dentists", dentsists);
        return "form";
    }

    @GetMapping("/visits")
    public String showVisits(DentistVisitDTO dentistVisitDTO, Model model) {
        List<DentistVisitEntity> visits = dentistVisitService.listVisits();
        model.addAttribute("visits", visits);
        return "visits";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<DentistEntity> dentsists = dentistVisitService.listDentists();
            model.addAttribute("dentists", dentsists);
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitService.getDentistById(dentistVisitDTO.getDentistId())
                , dentistVisitDTO.getVisitDate());
        return "redirect:/results";
    }

}
