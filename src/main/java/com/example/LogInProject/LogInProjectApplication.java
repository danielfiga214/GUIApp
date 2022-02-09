package com.example.LogInProject;

import com.example.LogInProject.GUI.*;
import com.example.LogInProject.model.User;
import com.example.LogInProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class LogInProjectApplication  {

	@Autowired
	static
	UserRepository userRepository;

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(LogInProjectApplication.class, args);
		System.setProperty("java.awt.headless", "false");
		userRepository = configurableApplicationContext.getBean(UserRepository.class);

		WelcomePage welcomePage = new WelcomePage();
		//LogIn logIn = new LogIn();
		//SignUp signUp = new SignUp();
		//TicTacToe ticTacToe = new TicTacToe();
		//App app = new App();

	}

	public static void createNewUser(String firstName, String lastName, String login, String password){
		User newUser = new User(firstName, lastName, login, password);
		userRepository.save(newUser);
	}

	public static User findLogin(String login){
		List<User> userLogin = userRepository.findAllByLogin(login);
		User dbUser = null;
		for(int i = 0; i < userLogin.size(); i++){
			dbUser = userLogin.get(i);
		}
		return dbUser;
	}
}
