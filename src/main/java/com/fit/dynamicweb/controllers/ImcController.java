package com.fit.dynamicweb.controllers;

import java.util.ArrayList;
import java.util.List;

import com.fit.dynamicweb.models.ImcLayer;
import com.fit.dynamicweb.models.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImcController {
  
  protected List<ImcLayer> imcLayers;

  public ImcController() {
    imcLayers = new ArrayList<>();
    this.imcLayers.add(new ImcLayer(0.00, 18.49, "Magreza"));
    this.imcLayers.add(new ImcLayer(18.50, 24.99, "Normal"));
    this.imcLayers.add(new ImcLayer(25.00, 29.99, "Sobrepeso"));
    this.imcLayers.add(new ImcLayer(30.00, 99.99, "Obesidade"));
  }

  @RequestMapping(value="/")
  public String index(Model model) {
    System.out.println("Get !!!");
    model.addAttribute("imcLayers", this.imcLayers);
    model.addAttribute("person", new Person());

    return "index";
  }

  @PostMapping(value="/")
  public String index(Person person, Model model) {
    System.out.println("Post !!!");
    person.calculate();
    System.out.println(person);
    model.addAttribute("imcLayers", this.imcLayers);
    model.addAttribute("person", person);

    return "index";
  }
  
}
