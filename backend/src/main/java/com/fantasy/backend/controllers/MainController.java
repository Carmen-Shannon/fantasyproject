package com.fantasy.backend.controllers;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fantasy.backend.models.Athlete;
import com.fantasy.backend.models.Team;
import com.fantasy.backend.services.AthleteService;
import com.fantasy.backend.services.Converter;
import com.fantasy.backend.services.TeamService;

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

	@RequestMapping(value = { "/" })
	public String index() {
		return "error";
	}

	@GetMapping("/error")
	public String errorMap() {
		return "redirect:/";
	}
	
	
	// KEEP THIS POST CLOSED UNLESS YOU NEED TO ADD OR UPDATE PLAYER/TEAM INFORMATION
//	@PostMapping("/add_athletes")
//	public String addAthletes() {
//		System.out.println("TEST TEST TEST");
//		ArrayList<Team> teams = converter.getTeams();
//		ts.create(teams);
//		 converter.setFileName("playerlist");
//		 ArrayList<Athlete> athletes = converter.convertPlayerData();
//		 as.create(athletes);
//		return "redirect:/";
//	}
};