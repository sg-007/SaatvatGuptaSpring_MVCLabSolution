package com.greatlearning.debate.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.debate.event.entity.Student;
import com.greatlearning.debate.event.service.StudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/show-form")
	public String showFormToUser() {
		return "welcome";
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/new-student")
	public String addStudentDetails(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {
		
		Student student = new Student(id, name, department, country);
		studentService.addStudent(student);
		return "redirect:show-students";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/show-students")
	public ModelAndView getStudentDetails(ModelAndView mav) {
		
		List<Student> students = studentService.getAllStudents();
		mav.setViewName("student-info");
		mav.addObject("studentInfo", students);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/delete-student")
	public String deleteStudentDetails(@RequestParam("id") Integer id) {
		
		if(studentService.deleteStudent(id))
			System.out.println("Student deleted");
		else {
			System.out.println("Student not deleted");
		}
		return "redirect:show-students";
	}
	   
	@RequestMapping("/update-student")    
    public String Update(@RequestParam("id") Integer id, Model model){    
        Student student = studentService.getStudent(id);    
        model.addAttribute("command", student);  
        return "update-form";    
    }    
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	 public String updateStudent(@RequestParam("id") Integer id) {
		Student student = studentService.getStudent(id);
		student.setName(student.getName());
		student.setDepartment(student.getCountry());
		student.setCountry(student.getCountry());
	    studentService.updateStudent(student);
	    return "redirect:show-students";
	}
}