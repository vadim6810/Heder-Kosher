/**
 * Created by Ruslan on 17.08.2016.
 */

package com.tel_ran.hederkosher.controller;

import java.util.Map;
import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/index")
    public String listPersons(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("personList", personService.findAllPersons());

        return "person";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person,
                             BindingResult result) {

        personService.savePerson(person);

        return "redirect:/index";
    }

//    @RequestMapping("/delete/{personId}")
//    public String deletePerson(@PathVariable("personId") Integer personId) {
//
//        personService.deletePersonBySsn(personId);
//
//        return "redirect:/index";
//    }

    @RequestMapping("/delete/{person}")
    public String deletePerson(@PathVariable("person") Person person) {

        personService.deletePerson(person);

        return "redirect:/index";
    }
}
