package com.clc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clc.entity.EmployeeBean;
import com.clc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "emps/", method = RequestMethod.GET)
	public String listOfEmployee(Model model) {
		model.addAttribute("empob", new EmployeeBean());
		model.addAttribute("listOfEmployy", this.service.getAllEmps());
		return "empinfo";

	}
	
	@RequestMapping(value= "/addemp/", method = RequestMethod.POST)
	public String saveEmpInfo(@ModelAttribute("empob") EmployeeBean p){
		System.out.println("inside controller...." +p);
		if(p.getId() == 0){
			//new person, add it
			this.service.addEmp(p);
		}else{
			//existing person, call update
			this.service.updateEmp(p);
		}
		
		return "redirect:/emps/";
		
	}
	

	@RequestMapping("/remove/{id}")
    public String removeEmp(@PathVariable("id") int id){
        this.service.deleteEmp(id);
        return "redirect:/emps/";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmp(@PathVariable("id") int id, Model model){
        model.addAttribute("empob", this.service.getEmp(id));
        model.addAttribute("listemps", this.service.getAllEmps());
        return "empinfo";
    }
	
}
