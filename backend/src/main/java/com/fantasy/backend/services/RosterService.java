package com.fantasy.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RosterService {
	
	@Autowired
	private RosterRepository rosterRepository;
	
//	CREATE ROSTER
	public Roster createRoster(Roster r) {
		return rosterRepository.save(r);
	}
//	RENDER ROSTER
	public Roster showRoster(Long id) {
		Optional<Roster> roster = rosterRepository.findById(id);
		return roster.isPresent()?roster.get():null;
	}
	
//	UPDATE ROSTER
	public Roster updateRoster(Roster r) {
		return rosterRepository.save(r);
	}
}
