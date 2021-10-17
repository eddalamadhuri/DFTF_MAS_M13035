package com.hcl.cs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.cs.model.Login;
import com.hcl.cs.model.MyPets;
import com.hcl.cs.model.Pet;
import com.hcl.cs.model.User;
import com.hcl.cs.service.PetService;
import com.hcl.cs.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;

	@Autowired
	private PetService petService;

	String username1;

	@RequestMapping(value = "/")
	public String userRegistrationForm(ModelMap map) {
		User user = new User();
		map.addAttribute("userForm", user);
		return "registrationPage";

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@Validated @ModelAttribute("userForm") User user, BindingResult result, ModelMap map) {
		String responce = "";
		if (result.hasErrors()) {
			responce = "registrationPage";
		}
		else {
			if (user.getPassword().equals(user.getConfirmpassword())) {
				boolean userExist = userService.checkUserName(user.getUserName());
				if (userExist == true) {
					map.addAttribute("message", user.getUserName() + " Already exist please enter new UserName");
					responce = "RegistrationErrorPage";
				} else {

					userService.saveUser(user);
					Login login = new Login();
					map.addAttribute("loginForm", login);
					responce = "successfullRegistration";
				}
			} else {
				map.addAttribute("message", "password and confirmpassword should match");
				responce = "RegistrationErrorPage";
			}
		}
		
		return responce;

	}

	@RequestMapping(value="/authenticateUser",method = RequestMethod.POST)
	public ModelAndView validateuser(@Validated @ModelAttribute("loginForm") Login userAuth, BindingResult result,ModelMap map) {
     if(result.hasErrors()){
    	 return new ModelAndView("loginPage");
     }else {
 		 boolean isValidUser = userService.checkLogin(userAuth.getUserName(), userAuth.getPassword());

    	 if (isValidUser == true) {
 			List<Pet> petlist = petService.fetchAllPet();
 			map.addAttribute("petList", petlist);
 			fetchUsername(userAuth.getUserName());
 			return new ModelAndView("home", "username", userAuth.getUserName());
 		} else {
 			return new ModelAndView("LoginErrorPage", "message", "Invalid userName or Password");
 		}

 	} 
    }
		

	@RequestMapping(value = "/loginpage") // to goto login page
	public ModelAndView gotoLoginPage(@ModelAttribute("loginForm") User userAuth) {
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPage");
		return model;
	}

	@RequestMapping(value = "/homepage") // go to home page
	public ModelAndView gotoHomePage(ModelMap map) {
		ModelAndView model = new ModelAndView();
		List<Pet> pet = petService.fetchAllPet();
		map.addAttribute("petList", pet);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/mypets") // goto AddNewPet page
	public String gotomyPetsPage(ModelMap map) {
		List<MyPets> mypets = petService.fetchAllMyPets(username1);
		map.addAttribute("mypets", mypets);
		return "myPetsPage";
	}

	@RequestMapping(value = "/buypet/{petId}")
	public String buyPet(@PathVariable("petId") Integer petId, @ModelAttribute("userForm") User user, ModelMap map) {
		petService.buyPet(username1, petId);
		petService.deletePet(petId);
		List<Pet> pet = petService.fetchAllPet();
		map.addAttribute("petList", pet);
		return "home";
	}

	public void fetchUsername(String userName) {
		username1 = userName;
	}

	@RequestMapping(value = "/savepet")
	public String savePet(@Validated @ModelAttribute("petForm") Pet savepet, ModelMap map, BindingResult result) {
		if (result.hasErrors()) {
			return "addPetPage";
		}
		else {
			petService.savePet(savepet);
			List<Pet> pet = petService.fetchAllPet();
			map.addAttribute("petList", pet);
			return "home";
			
		}

		
	}

	@RequestMapping(value = "/addpet")
	public String addPet(ModelMap map) {
		Pet pet = new Pet();
		map.addAttribute("petForm", pet);
		return "addPetPage";
	}

}
