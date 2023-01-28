package com.prac.cmsshoppingcart;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.prac.cmsshoppingcart.models.Cart;
import com.prac.cmsshoppingcart.models.CategoryRepository;
import com.prac.cmsshoppingcart.models.PageRepository;
import com.prac.cmsshoppingcart.models.data.Category;
import com.prac.cmsshoppingcart.models.data.Page;

@ControllerAdvice
@SuppressWarnings("unchecked")
public class Common {

	@Autowired
	private PageRepository pageRepo;

	@Autowired
	private CategoryRepository categoryRepository;

	@ModelAttribute
	public void sharedData(Model model, HttpSession session, Principal principal) {
		
		if(principal!=null) {
			model.addAttribute("principal", principal.getName());
		}

		List<Page> pages = pageRepo.findAllByOrderBySortingAsc();
		List<Category> categories = categoryRepository.findAllByOrderBySortingAsc();

		boolean cartActive = false;

		if (session.getAttribute("cart") != null) {
			HashMap<Integer, Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
			int size = 0;
			double total = 0;

			for (Cart value : cart.values()) {
				size += value.getQuantity();
				total += value.getQuantity() * Double.parseDouble(value.getPrice());
			}
			model.addAttribute("csize", size);
			model.addAttribute("ctotal", total);

			cartActive = true;

		}

		model.addAttribute("cpages", pages);
		model.addAttribute("categories", categories);
		model.addAttribute("cartActive", cartActive);

	}

}
