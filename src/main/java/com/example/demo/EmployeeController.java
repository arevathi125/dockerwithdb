package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	Logger log = Logger.getAnonymousLogger();

	@RequestMapping("/")
	public ModelAndView defaultpage(HttpServletRequest request, HttpServletResponse response) {
		log.info("entered into the / request");
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("index.jsp");
		//mv.setViewName("index");
		log.info("went to index.jsp page ");
		return mv;

	}

	@RequestMapping("/insert")
	public ModelAndView insertOpr(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Employee e = new Employee();
		e.setEmp_Name(request.getParameter("name"));
		e.setEmp_Phone(request.getParameter("phono"));
		log.info("welcome to index page ");
		if (service.insert(e) != null) {
			//mv.setViewName("display");
			 mv.setViewName("display.jsp");
		}
		return mv;
	}

	@RequestMapping("/getAll")
	public ModelAndView getallOpr(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
//Employee e = new Employee();
		List<Employee> list = service.getAll();
		log.info("Display page");
		//mv.setViewName("employeeList");
mv.setViewName("employeeList.jsp");
		mv.addObject("list", list);
		return mv;

	}

	@RequestMapping("/delete")
	public ModelAndView deleteOpr(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		Employee e = new Employee();
		service.deleteById(id);
		// mv.setViewName("getAll");
		List<Employee> list = service.getAll();
		mv.addObject("list", list);
		log.info("Delete page");
		mv.setViewName("employeeList.jsp");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView updateOpr(HttpServletRequest request, HttpServletResponse response, Employee employee) {
		ModelAndView mv = new ModelAndView();
		// Employee employee = new Employee();
//	employee.setEmp_No(Integer.parseInt(request.getParameter("emp_No")));
//	employee.setEmp_Name(request.getParameter("emp_Name"));
//	employee.setPhono(request.getParameter("phono"));
		service.update(employee);
		// mv.setViewName("getAll");
		List<Employee> list = service.getAll();
		mv.addObject("list", list);
		log.info("Update page");
		mv.setViewName("employeeList.jsp");
		return mv;
	}
}
