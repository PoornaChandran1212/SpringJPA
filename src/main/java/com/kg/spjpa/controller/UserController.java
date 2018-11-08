package com.kg.spjpa.controller;

import java.util.List;

import com.kg.spjpa.entity.User;
import com.kg.spjpa.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
class UserController {
    
   @Autowired
   private UserRepository userRepository;

   @RequestMapping(method=RequestMethod.POST)
    public User create(@RequestBody User user)
    {
       user.setId(0);
        return userRepository.saveAndFlush(user);
    }

   @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User updateduser)
    {    
        User user = userRepository.getOne(id);
        user.setFirstName(updateduser.getFirstName());
        return userRepository.saveAndFlush(user);
    }

   @RequestMapping(method=RequestMethod.GET)
   List<User> read() {
       return userRepository.findAll();
   }

   @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
   @ResponseStatus(HttpStatus.NO_CONTENT)
   void delete(@PathVariable("id") Long id) {
       userRepository.deleteById(id);
   }
}