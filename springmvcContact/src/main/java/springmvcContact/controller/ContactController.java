package springmvcContact.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvcContact.model.User;
import springmvcContact.service.UserService;

@Controller
public class ContactController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping()
	public String index()
	{
		return "index";
	}
	
		@ModelAttribute
		public void commonData(Model m) {
		m.addAttribute("Header","Learn with me");
		m.addAttribute("desc","Get Ready to Fight");
	}
	
	@RequestMapping(path = "/sub")
	public String showForm()
	{
		
		return "contact";
	}
	
	@RequestMapping(path="/processform" , method =RequestMethod.POST)
	public String handleForm(@ModelAttribute User user,Model model)
	{
		System.out.println(user);
		
		if(user.getName().isBlank())
		{
			return "redirect:/contact";
		}
		
		if(user.getEmail().isBlank())
		{
			return "redirect:/contact";
		}
		
		if(user.getPassword().isBlank())
		{
			return "redirect:/contact";
		}
		int createdUser=this.userService.createUser(user);
		model.addAttribute("msg","User created with id"+ createdUser);
		
		return "success";
	}

}





/*
@RequestMapping(path="/processform" , method =RequestMethod.POST)
public String handleForm(
		@RequestParam("email")String userEmail,
		@RequestParam("userName")String userName,
		@RequestParam("password")String userPassword,
		Model model)
{
	System.out.println("email is:"+userEmail);
	System.out.println("Name is:"+userName);
	System.out.println("Password is:"+userPassword);
	
	model.addAttribute("name",userName);
	model.addAttribute("email",userEmail);
	model.addAttribute("password",userPassword);
	return "success";
}*/
