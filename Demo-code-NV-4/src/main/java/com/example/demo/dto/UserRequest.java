package com.example.demo.dto;

import com.example.demo.model.Personnel;
import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest  {

	private User user;
	private Personnel personnel;
}
