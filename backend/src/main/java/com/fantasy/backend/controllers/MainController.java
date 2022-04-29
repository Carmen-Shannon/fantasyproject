package com.fantasy.backend.controllers;

import java.util.ArrayList;

import com.fantasy.backend.models.Athlete;
import com.fantasy.backend.models.Team;
import com.fantasy.backend.services.AthleteService;
import com.fantasy.backend.services.Converter;
import com.fantasy.backend.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController implements ErrorController {

    @Autowired
    private AthleteService as;

    @Autowired
    private TeamService ts;

    private Converter converter = new Converter("teams");

    public MainController(AthleteService as, TeamService ts) {
        this.as = as;
        this.ts = ts;
    }

    @GetMapping(value = { "/" })
    public String index() {
        return "forward:/index.html";
    }

    @GetMapping("/error")
    public String errorMap() {
        return "redirect:/";
    }

    @PostMapping("/add_athletes")
    public String addAthletes() {
    System.out.println("TEST TEST TEST");
    // ArrayList<Team> teams = converter.getTeams();
    // ts.create(teams);
    converter.setFileName("playerlist");
    ArrayList<Athlete> athletes = converter.convertPlayerData();
    as.create(athletes);
    return "redirect:/";
    }

}
