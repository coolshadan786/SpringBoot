package Crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import Crud.dao.ProductDAO;
import Crud.pojo.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/")
	public String home(Model m) {	
		List<Product> products =  productDAO.getProducts();
		m.addAttribute("product", products);		
		return "index";
	}
	
	//Add Product form
	@RequestMapping("/addProduct")
	public String addProduct(Model m) {
		
		m.addAttribute("title","Add Product");
		return "addProduct_Form";
	}
	
	//Handle add product form	
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		
		System.out.println(product);
		productDAO.createProduct(product);
		RedirectView redirectView =  new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	} 
	
	//Update handler
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pid,Model model) {
		
		Product product =this.productDAO.getProduct(pid);
		model.addAttribute("product", product);
		return "update_Form";
	}
	
	//Delete handler
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request) {
		
		productDAO.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

}
 