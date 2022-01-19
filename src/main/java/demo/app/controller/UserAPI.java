package demo.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.app.entities.UserEntity;
import demo.app.repository.UserRepository;
import demo.app.service.UserService;

@CrossOrigin("*")
@RestController
public class UserAPI {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private UserRepository userReponse;

	@GetMapping(value = "/users")
	public List<UserEntity> getUsers() {
		
		return userService.getAll();
	}

	
	@GetMapping(value = "/searchparam2")
	public List<UserEntity> searchUsersByParam2(@RequestParam String name,@RequestParam String phone,@RequestParam String email) {
		return userService.searchA2(name,phone,email);
	}

	@GetMapping(value = "/users/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		UserEntity userEntity = userReponse.findById(id);
		return userEntity;
	}

	@PostMapping(value = "/create_users")
	public List<UserEntity> createUsers(@RequestBody UserEntity model) {
		List<UserEntity> resual = userService.searchA2("",model.getEmail(),"");

		if (resual.isEmpty()){
			userService.mySave(model);
			return userService.getAll();
		}else {
			return userService.getAll();
		}


	}

	@PutMapping(value = "/update_user/{id}")
	public List<UserEntity> updateUser(@RequestBody UserEntity model, @PathVariable Long id) {
		UserEntity oldUser = userReponse.findById(id);
		oldUser.setName(model.getName());
		oldUser.setEmail(model.getEmail());
		oldUser.setPhone(model.getPhone());
		oldUser.setPassword(model.getPassword());
		oldUser.setZone(model.getZone());
		oldUser.setEnrollDate(model.getEnrollDate());
		oldUser.setStatus(model.getStatus());
		oldUser.setImage(model.getStatus());
		userService.mySave(oldUser);
		return userService.getAll();
	}

	@DeleteMapping(value = "delete_user/{id}")
	public List<UserEntity> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return userService.getAll();
	}

}
