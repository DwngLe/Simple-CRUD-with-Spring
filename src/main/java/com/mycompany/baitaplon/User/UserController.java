package com.mycompany.baitaplon.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.ListResourceBundle;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/users")
    public List<User> showUserList(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return listUsers;
    }

    @GetMapping("/users/addUser")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

//    @PostMapping("/users/save")
//    public String saveUser(@Param("user") User user, RedirectAttributes ra) {
//        service.save(user);
//        ra.addFlashAttribute("message", "Thêm khách hàng thành công");
//        return "redirect:/users";
//    }

    @PostMapping("/users/save")
    public String saveUser(@RequestBody User user) {
        service.save(user);
        return  "Saved.....";
    }


//
//    @GetMapping("/users/delete")
//    public String deleteUser(Integer id){
//        service.delete(id);
//        return "redirect:/users";
//    }

    @GetMapping("/user/delete")
    public void deleteUser(Integer id){
        service.delete(id);
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            return "user_edit_form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "Thay đổi thông tin khách hàng thành công");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
            service.delete(id);
            ra.addFlashAttribute("message", "The user ID:" + id +"has been deleted");
            return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) throws UserNotFoundException {
        User user = service.get(id);
        return ResponseEntity.ok(user);
    }

}
