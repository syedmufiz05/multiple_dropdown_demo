package com.example.controller;

import com.example.dto.ServiceResponse;
import com.example.dto.dropdownDTO.CountryDTO;
import com.example.exception.CountryException;
import com.example.model.User;
import com.example.service.UserService;
import com.example.service.dropDownService.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CountryService countryService;

    //    @GetMapping("/")
//    public String viewHomePage(Model model) {
//        model.addAttribute("listUsers", userService.getAllUsers());
//        return "index";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model)throws CountryException {
        List<CountryDTO> countryList = countryService.getAllCountries();
        if (countryList.isEmpty()) {
            throw new CountryException("Countries are not found");
        }
        model.addAttribute("countries", countryList);
        return "index";
    }

    @PostMapping("/saveNewUser")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.saveUser(user);
        ServiceResponse<User> response = new ServiceResponse<User>("success", user);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/showNewUserForm")
    public String showNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add_new_user";
    }

//    @GetMapping("/showFormForUpdate/{emailId}")
//    public String showUpdateForm(@PathVariable(value = "emailId") String emailId, Model model) {
//        User user = userService.getUser(emailId);
//        if (user != null) {
//            model.addAttribute("user", user);
//        }
//        return "update_employee";
//    }

//    @GetMapping("/showFormForUpdate/{emailId}")
//    public String showUpdateForm(@PathVariable(value = "emailId") String emailId) {
//        User user = userService.getUser(emailId);
//        return "update_employee";
//    }

    @GetMapping("/showFormForUpdate/{emailId}")
    @ResponseBody
    public User showUpdateForm(@PathVariable(value = "emailId") String emailId) {
        User user = userService.getUser(emailId);
        return user;
    }

    @GetMapping("/deleteUser/{email_id}")
    public String deleteUser(@PathVariable(value = "email_id") String emailId) {
        userService.deleteUser(emailId);
        return "redirect:/";
    }
}
