package l.backenddemo.controller;

import l.backenddemo.entity.User;
import l.backenddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path= "/demo")
public class MainController {
    private final UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(path= "/add")
    public @ResponseBody String AddNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @RequestMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUser(){
        return userRepository.findAll();
    }
}
