package com.ac.backend.controller;

import com.ac.backend.dto.UserDto;
import com.ac.backend.entity.User;
import com.ac.backend.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("")
public class HomeController {

    private UserServiceImpl userService;
    private EmailService emailService;

    public HomeController(UserServiceImpl userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }
    @GetMapping(value = "/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "website/login";
    }
    @GetMapping(value = {"/", "/index"})
    public ModelAndView index (ModelAndView modelAndView){
        modelAndView.setViewName("website/home");
        return modelAndView;
    }

    @GetMapping(value = "/login")
    public String login (){
        return "website/login";
    }

    @GetMapping(value = "/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "website/register";
    }

    @PostMapping(value = "/register")
    public ModelAndView saveUser(ModelAndView modelAndView, @Valid @ModelAttribute("userDto") UserDto userDto,
                                 BindingResult bindingResult, HttpServletRequest request, Errors errors){

        User userExists = userService.findByEmail(userDto.getEmail());

        System.out.println("user exist"+userExists);

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("website/register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("website/register");
        } else { // new user so we create user and send confirmation e-mail

            User user = userService.createNewAccount(userDto);
            // Disable user until they click on confirmation link in email

            user.setEnabled(true);


            userService.saveUser(user);

            /*String appUrl = request.getScheme() + "://" + request.getServerName();
            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("Please confirm the registration");
            registrationEmail.setFrom("email@email.com");
            emailService.sendEmail(registrationEmail);*/

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + userDto.getEmail());
            modelAndView.setViewName("website/registered");
        }

        return modelAndView;
    }



}
