package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.Repository.PersonnelRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.Personnel;
import com.example.demo.model.User;

@Controller
@RequestMapping("/api")
public class controller {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PersonnelRepository personnelRepository ;
	
	
	@RequestMapping(value = "/user/login1", method = RequestMethod.POST)
	public ResponseEntity<Personnel> login1(@RequestBody User user){
		return new ResponseEntity<Personnel>(personnelRepository.login(user.getUsername(), user.getPasswork()), HttpStatus.CREATED);
	    }
	
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public ApiResponse login(@RequestBody User user)
	{
		Personnel personnel=personnelRepository.login(user.getUsername(), user.getPasswork());
		
		if(user.getUsername()==null || user.getPasswork()==null)
		{
			return new ApiResponse(1,"error login");
		}
		
		if(personnel==null)
		{
			return new ApiResponse(2,"error login");
		}
		
		return new ApiResponse(200, "Login success", personnel);
		//return new ApiResponse(2,"error login");
	}
 
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public Personnel saveContact(@Valid @RequestBody Personnel personnel) {
		return personnelRepository.save(personnel);
	}
	
	@RequestMapping(value="/user/All", method = RequestMethod.GET)
	public ResponseEntity<List<Personnel>> listAll_p(){
		List<Personnel> listContact=(List<Personnel>) personnelRepository.findAll();
		if(listContact.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Personnel>>(listContact, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id_manage_p}", method = RequestMethod.GET)
	 public ResponseEntity<List<Personnel>> find_manage(@PathVariable(value = "id_manage_p") int id_manage_p) {
	        return new ResponseEntity<List<Personnel>>(personnelRepository.find_manage_p(id_manage_p), HttpStatus.OK);
	    }
	 
	@RequestMapping(value = "/user/{id_p}", method = RequestMethod.DELETE)
	 public ResponseEntity<String> delete(@PathVariable(value = "id_p") int id_p) {
		personnelRepository.deleteById(id_p);
        return new ResponseEntity<>("Employee with EmployeeId : " + id_p + " deleted successfully", HttpStatus.OK);
    }
	
	
	
}
