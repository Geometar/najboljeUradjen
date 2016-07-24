package jwd.parcijalni;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.parcijalni.model.Activity;
import jwd.parcijalni.model.User;
import jwd.parcijalni.service.ActivityService;
import jwd.parcijalni.service.UserService;

@Component
public class FillTable {
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;

	
	@PostConstruct
	public void init(){
		activityService.save(new Activity("Swimming","Plivanje je dobro za muskulaturu tela!"));
		activityService.save(new Activity("Running", "Trcanje je dobro za liniju tela"));
		activityService.save(new Activity("Jogging", "Je dobro za zdravlje i srce"));
		activityService.save(new Activity("Coding", "Ajmo rade, ajde ajde ajde Mozemo!!"));
		activityService.save(new Activity("Jumping", "Dobro za balans i ekplizovnost"));
		
		userService.save(new User("Rade", "Spasojevic","crninovembar","radespasoje@gmail.com", new Date(89, 9, 8)));
		userService.save(new User("Ana", "Mitrovic","princeza","ana@gmail.com", new Date(93, 5, 21)));
		userService.save(new User("Cain", "Velasquez","fighter","hello@gmail.com", new Date(72, 9, 8)));
		userService.save(new User("Davide", "Beckam","football","hello2@gmail.com", new Date(76, 9, 8)));
		userService.save(new User("Franchesco", "Totti","acroma","roma@gmail.com", new Date(68, 9, 8)));
	
	
	}

}
