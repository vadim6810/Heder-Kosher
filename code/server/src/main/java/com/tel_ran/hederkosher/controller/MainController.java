/**
 * Created by Ruslan on 16.08.2016.
 */

package com.tel_ran.hederkosher.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.impl.Log4JLogger;
import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.PersonService1;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Handles and retrieves person request
 */
@RequestMapping("/main")
public class MainController {

    //protected static Logger logger = Logger.getLogger("controller");

    @Resource(name="personService")
    private PersonService1 personService;

    /**
     * Handles and retrieves all persons and show it in a JSP page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String getPersons(Model model) {

        //logger.debug("Received request to show all persons");

        // Retrieve all persons by delegating the call to PersonService1
        List<Person> persons = personService.listPerson();

        // Attach persons to the Model
        model.addAttribute("persons", persons);

        // This will resolve to /WEB-INF/jsp/personspage.jsp
        return "personspage";
    }

    /**
     * Retrieves the add page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
       // logger.debug("Received request to show add page");

        // Create new Person and add to model
        // This is the formBackingOBject
        model.addAttribute("personAttribute", new Person());

        // This will resolve to /WEB-INF/jsp/addpage.jsp
        return "addpage";
    }

    /**
     * Adds a new person by delegating the processing to PersonService1.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("personAttribute") Person person) {
        //logger.debug("Received request to add new person");

        // The "personAttribute" model has been passed to the controller from the JSP
        // We use the name "personAttribute" because the JSP uses that name

        // Call PersonService1 to do the actual adding
        personService.addPerson(person);

        // This will resolve to /WEB-INF/jsp/addedpage.jsp
        return "addedpage";
    }

    /**
     * Deletes an existing person by delegating the processing to PersonService1.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Integer id,
                         Model model) {

       // logger.debug("Received request to delete existing person");

        // Call PersonService1 to do the actual deleting
        personService.removePerson(id);

        // Add id reference to Model
        model.addAttribute("id", id);

        // This will resolve to /WEB-INF/jsp/deletedpage.jsp
        return "deletedpage";
    }

    /**
     * Retrieves the edit page
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/persons/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Integer id,
                          Model model) {
       // logger.debug("Received request to show edit page");

        // Retrieve existing Person and add to model
        // This is the formBackingOBject
//        model.addAttribute("personAttribute", personService.get(id));

        // This will resolve to /WEB-INF/jsp/editpage.jsp
        return "editpage";
    }

    /**
     * Edits an existing person by delegating the processing to PersonService1.
     * Displays a confirmation JSP page
     *
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/persons/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person,
                           @RequestParam(value="id", required=true) Integer id,
                           Model model) {
      //  logger.debug("Received request to update person");

        // The "personAttribute" model has been passed to the controller from the JSP
        // We use the name "personAttribute" because the JSP uses that name

        // We manually assign the id because we disabled it in the JSP page
        // When a field is disabled it will not be included in the ModelAttribute
        person.setIdPerson(id);

        // Delegate to PersonService1 for editing
  //      personService.edit(person);

        // Add id reference to Model
        model.addAttribute("id", id);

        // This will resolve to /WEB-INF/jsp/editedpage.jsp
        return "editedpage";
    }

}