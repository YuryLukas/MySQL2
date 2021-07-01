package jl.mysql2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired
    private PersonRepository personRepository;


    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewPerson(@RequestParam String name,
                        @RequestParam String secondName,
                        @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person n = new Person();
        n.setFirstName(name);
        n.setSecondName(secondName);
        n.setEmail(email);
        personRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllUsers() {
        // This returns a JSON or XML with the users
        return personRepository.findAll();
    }


}