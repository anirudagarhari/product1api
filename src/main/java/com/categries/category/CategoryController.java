package com.categries.category;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller


public class CategoryController {
	@Autowired
	private CategoryRepository repo;
@GetMapping("/categaries")
public String listCategories(Model model) {
 List<Category>listCategories= repo.findAll();
model.addAttribute("listCategories" , listCategories);
return "categaries";
}
@GetMapping("/categaries/new")
public String showCategoryNewForm(Model model)
{
	model.addAttribute("category",new  Category());
	return "category_form";
}

@PostMapping("/categories/save")
public String saveCategory(Category category)
{
repo.save(category);
return "redirect:/categaries";
}


}
