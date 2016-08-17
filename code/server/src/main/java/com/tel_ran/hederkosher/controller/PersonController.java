/**
 * Created by user on 17.08.2016.
 */

package com.tel_ran.hederkosher.controller;

import java.util.Map;
import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.PersonService1;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class PersonController {
    @Autowired
    private PersonService1 personService;

//    @Resource(name="personService")

    @RequestMapping("/index")
    public String listPersons(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("personList", personService.listPerson());

        return "person";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person,
                             BindingResult result) {

        personService.addPerson(person);

        return "redirect:/index";
    }

    @RequestMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId);

        return "redirect:/index";
    }
}
