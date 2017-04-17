package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dao.entity.DentistEntity;
import com.cgi.dentistapp.dao.entity.DentistVisitEntity;
import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.dto.SearchDTO;
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
import java.util.ArrayList;
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
        List<DentistEntity> dentists = dentistVisitService.listDentists();
        model.addAttribute("dentists", dentists);
        return "form";
    }

    @PostMapping("/")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<DentistEntity> dentists = dentistVisitService.listDentists();
            model.addAttribute("dentists", dentists);
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitService.getDentistById(dentistVisitDTO.getDentistId())
                , dentistVisitDTO.getVisitDate());
        return "redirect:/results";
    }

    @GetMapping("/visits")
    public String showVisits(SearchDTO searchDTO, Model model) {
        List<DentistVisitEntity> visits = dentistVisitService.listVisits();
        List<DentistEntity> dentists = dentistVisitService.listDentists();
        model.addAttribute("dentists", dentists);
        model.addAttribute("visits", visits);
        return "visits";
    }

    @PostMapping("/visits")
    public String postSearch(@Valid SearchDTO searchDTO, BindingResult bindingResult, Model model) {
        List<DentistVisitEntity> visits = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            visits = dentistVisitService.listVisits();
        } else if(searchDTO.getEnd() != null && searchDTO.getStart() != null && searchDTO.getDentistId() != null) {
            visits = dentistVisitService.listVisitsByDentistAndDate(
                    dentistVisitService.getDentistById(searchDTO.getDentistId()),
                    searchDTO.getStart(),
                    searchDTO.getEnd());
        } else if(searchDTO.getStart() != null && searchDTO.getDentistId() != null) {
            visits = dentistVisitService.listVisitsByDentistAndDate(
                    dentistVisitService.getDentistById(searchDTO.getDentistId()),
                    searchDTO.getStart());
        } else if (searchDTO.getEnd() != null && searchDTO.getDentistId() != null) {
            //end
            visits = dentistVisitService.listVisitsByDentistAndEnd(
                    dentistVisitService.getDentistById(searchDTO.getDentistId()),
                    searchDTO.getEnd());
        } else if (searchDTO.getDentistId() != null) {
            visits = dentistVisitService.listVisitsByDentist(
                    dentistVisitService.getDentistById(searchDTO.getDentistId()));
        } else if (searchDTO.getEnd() != null) {
            visits = dentistVisitService.listByEnd(searchDTO.getEnd());
        } else if (searchDTO.getStart() != null) {
            visits = dentistVisitService.listByStart(searchDTO.getStart());
        }
        List<DentistEntity> dentists = dentistVisitService.listDentists();
        model.addAttribute("dentists", dentists);
        model.addAttribute("visits", visits);
        return "visits";
    }


}
