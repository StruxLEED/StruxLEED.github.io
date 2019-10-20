package com.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.senai.dao.SenaiDao;
import com.senai.model.Product;

@Controller
public class AppController {
	
	@Autowired
	private SenaiDao service;

	/*
	@RequestMapping("/")
	public String veiw() {
		return "app-index";
	}
	@RequestMapping("/")
	public String veiwHomePage(Model model) {
		List<Product> listProduct = service.listAll();
		model.addAttribute("listProduct", listProduct);
		return "index";
	}*/
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new";
	}
	@RequestMapping("/")
	public String showNewProductPage2(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "app-index";
	}
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "app-dashboard";
	}
	@RequestMapping("/cadastro")
	public String cadastro(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "app-cadastro";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name="id") long id) {
		ModelAndView mav = new ModelAndView("edit");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav; //redirecionamento automatico para o /
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(Product product) {
		service.save(product);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name="id")long id) {
		service.delete(id);
		return "redirect:/";
	}
	
	
}
