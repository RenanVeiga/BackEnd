package com.Renan.TabelaProdutoLogin.LoginSenha;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



public class ControllerUsuario {
	
	@Autowired
    UserRepositorio userRepository;

	@PostMapping("/users/register")
    public Status registerUser(@Validated @RequestBody Usuario newUser) {
        List<Usuario> users = userRepository.findAll();
			System.out.println("New user: " + newUser.toString());
			for (Usuario user : users) {
			            System.out.println("Registered user: " + newUser.toString());
			if (user.equals(newUser)) {
			                System.out.println("User Already exists!");
			                return Status.USER_ALREADY_EXISTS;
			            }
	        }
	userRepository.save(newUser);
	        return Status.SUCCESS;
	    }
	@PostMapping("/users/login")
	    public Status loginUser(@Validated @RequestBody Usuario user) {
	        List<Usuario> users = userRepository.findAll();
	for (Usuario other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(true);
	                userRepository.save(user);
	                return Status.SUCCESS;
	            }
        }
		return Status.FAILURE;
		    }
		@PostMapping("/users/logout")
		    public Status logUserOut(@Validated @RequestBody Usuario user) {
		        List<Usuario> users = userRepository.findAll();
				for (Usuario other : users) {
				            if (other.equals(user)) {
				                user.setLoggedIn(false);
				                userRepository.save(user);
				                return Status.SUCCESS;
				            }
				        }
				return Status.FAILURE;
				    }
		
		@DeleteMapping("/users/all")
		    public Status deleteUsers() {
		        userRepository.deleteAll();
		        return Status.SUCCESS;
		    }

}
