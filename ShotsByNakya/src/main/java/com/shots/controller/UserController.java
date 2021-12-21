package com.shots.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shots.entity.Order;
import com.shots.entity.Scheduler;
import com.shots.entity.User;
import com.shots.repository.OrderRepository;
import com.shots.repository.ScheduleRepository;
import com.shots.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserRepository ur;
	@Autowired
	ScheduleRepository sr;
	@Autowired
	OrderRepository or;
	
	@PostMapping("/save")
	public void submitScheduleDetails(@RequestBody Scheduler schedule) {
		sr.save(schedule);
	}
	
	@GetMapping(value="/findUserById", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Optional<User>> findUserByEmail(String 
	email){ 
		 Optional<User> user = ur.findById(email);
		return new ResponseEntity<>(user,HttpStatus.OK); 

		}
	
	@GetMapping(value="/findOrderById", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Optional<Order>> findOrderById(int id){ 
		 Optional<Order> order = or.findById(id);
		return new ResponseEntity<>(order,HttpStatus.OK); 

		}
	@GetMapping(value="/findAllScheduledShoots", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Scheduler>> findAllScheduledShoots(){
		List<Scheduler> shoots = sr.findAll();
		return new ResponseEntity<>(shoots, HttpStatus.OK);
	}
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<User> userLogin(@RequestBody User user) {
		User login = ur.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
			if (login != null){
			return new ResponseEntity<>(login,HttpStatus.OK);
		}
			else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
}
