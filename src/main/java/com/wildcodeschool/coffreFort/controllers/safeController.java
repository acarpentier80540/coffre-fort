package com.wildcodeschool.coffreFort.controllers;

import com.wildcodeschool.coffreFort.entity.Safe;
//quand on est connecté
import com.wildcodeschool.coffreFort.repository.SafeRepository;
import com.wildcodeschool.coffreFort.repository.UserRepository;
import com.wildcodeschool.coffreFort.entity.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SafeController {

  @Autowired
  private SafeRepository SafeRepository;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/safes")
  public List<Safe> getSafes() {
    List<Safe> safes = SafeRepository.findAll();
    return safes;
  }

@GetMapping("/test")


  @PostMapping("/safe/{userId}")
  public Safe create(@RequestBody Safe safe, @PathVariable Long userId) {
    User user = userRepository.findById(userId).get();
    safe.setUser(user);
    return SafeRepository.save(safe);
  }

}
