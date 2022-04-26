package com.categries.category.prodect;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.categries.category.Category;
import com.categries.category.CategoryRepository;

@Controller

public class productcontroller {
	@Autowired
	private productRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/prodects/new")
	public String showNewProductForm (Model model)
	{
		List<Category> listCategories=categoryRepo.findAll();
		model.addAttribute("product", new product());
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(product product) {
		productRepo.save(product);
		
		return "redirect:/product_list";
		
	}
	@GetMapping("/prodects")
	public String listProducts(Model model)
	{
		List <product>listProducts=productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		return "prodect_list";
		
		
	}
	@GetMapping("products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model  )
	{
		product product=productRepo.findById(id).get();
		model.addAttribute("product", product);
		List<Category> listCategories=categoryRepo.findAll();
		
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
		
	}
	
	
	
	@GetMapping("products/delete/{id}")
	public String showdeleteProductForm (@PathVariable("id") Integer id, Model model )
	{
		productRepo.deleteById(id);
		return "redirect:/prodect_list";
	}
	
	}
	


