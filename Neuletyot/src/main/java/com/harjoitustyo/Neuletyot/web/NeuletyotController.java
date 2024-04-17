package com.harjoitustyo.Neuletyot.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.harjoitustyo.Neuletyot.model.CategoryRepository;
import com.harjoitustyo.Neuletyot.model.Neuletyot;
import com.harjoitustyo.Neuletyot.model.NeuletyotRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.validation.Valid;

@Controller
public class NeuletyotController {

    @Autowired
    private NeuletyotRepository repository;
    @Autowired
    private CategoryRepository carepository;

    // Show all neuleet
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    // shows all neuletyot by title
    @RequestMapping(value = { "/", "/neulelist" }, method = RequestMethod.GET)
    public String ShowTitles(Model model) {
        model.addAttribute("neuletyot", repository.findAll());
        return "neulelist";
    }

    // Edit selected title
    @RequestMapping(value = "/edit/{neuleId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editNeule(@PathVariable("neuleId") Long neuleId, Model model) {
        model.addAttribute("neuletyot", repository.findById(neuleId));
        model.addAttribute("categories", carepository.findAll());
        return "edit";
    }

    // Restfulservice to get all neuletot
    @RequestMapping(value = "/neuletyot", method = RequestMethod.GET)
    public @ResponseBody List<Neuletyot> neulelistRest() {
        return (List<Neuletyot>) repository.findAll();
    }

    // Restful service to get by id
    @RequestMapping(value = "/neuletyo/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Neuletyot> findBookRest(@PathVariable("neuleId") Long neuleId) {
        return repository.findById(neuleId);
    }

    // Save a new neule
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Neuletyot neuletyot) {
        repository.save(neuletyot);
        return "redirect:neulelist";
    }

    // Add new neule
    @RequestMapping(value = "/addneule", method = RequestMethod.GET)
    public String addNeule(Model model) {
        model.addAttribute("neuletyot", new Neuletyot());
        model.addAttribute("categories", carepository.findAll());
        return "addneule";
    }

    @RequestMapping(value = "/addneule", method = RequestMethod.POST)
    public String save(@Valid Neuletyot neuleTitle, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addneule"; // Palaa takaisin lomakkeeseen näyttämään virheet
        }

        repository.save(neuleTitle);
        return "redirect:neulelist";
    }

    // Delete by book id, admin only TULOSSA MYÖHEMMIN

    @RequestMapping(value = "/delete/{neuleId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("neuleId") Long neuleId, Model model) {
        repository.deleteById(neuleId);
        return "redirect:../neulelist";
    }

    // Look selected title
    @RequestMapping(value = "/neule/{neuleId}", method = RequestMethod.GET)
    public String lookNeule(@PathVariable("neuleId") Long neuleId, Model model) {
        model.addAttribute("neuletyot", repository.findById(neuleId));
        return "neule";
    }

}
