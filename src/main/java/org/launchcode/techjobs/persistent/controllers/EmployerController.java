package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

//Add a private field of EmployerRepository type called employerRepository to EmployerController. Give this field an @Autowired annotation.
    @Autowired
    private EmployerRepository employerRepository;
    //findAll, save, findById

//Add an index method that responds at /employers with a list of all employers in the database
        @GetMapping
        public String displayAllEmployers(Model model){
            model.addAttribute("title","All Employers");
            model.addAttribute("employers",employerRepository.findAll() );
            return "employers/index";
        }

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }
        //Controllers 3.Code to save a valid object. Use employerRepository and the appropriate method to do so.
       model.addAttribute("employer",employerRepository.save(newEmployer)) ;
        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
