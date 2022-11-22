package com.wildcodeschool.coffreFort.controllers;


//quand on est connecté
import com.wildcodeschool.coffreFort.repository.SafeRepository;
import com.wildcodeschool.coffreFort.entity.Safe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class SafeController {

    @Autowired
    private SafeRepository repository;

    @GetMapping("/safes")
    public String getAll(Model model) {
        model.addAttribute("safe", repository.findAll());
        return "safe";
    }

    @GetMapping("/safe")
    public String getSafe(Model model,
                            @RequestParam(required = false) Long id) {
        Safe safe = new Safe();
        if (id != null) {
            Optional<Safe> optionalSafe = repository.findById(id);
            if (optionalSafe.isPresent()) {
                safe = optionalSafe.get();
            }
        }
        model.addAttribute("safe", safe);

        return "safe";
    }

    @PostMapping("/safe")
    public String postSafe(@ModelAttribute Safe safe){
        repository.save(safe);

     return "redirect:/safes";
    }


   @GetMapping("/safe/delete")
    public String deleteSafe(@RequestParam Long id) {
        repository.deleteById(id);

        return "redirect:/safes";
    }
}


