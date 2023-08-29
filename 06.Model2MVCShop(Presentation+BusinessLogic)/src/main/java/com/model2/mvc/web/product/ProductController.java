package com.model2.mvc.web.product;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@Controller
public class ProductController {

	///Field
	private ProductService productService;
	
	///Constructor
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	@RequestMapping("/addProduct.do")
	public String addProduct(@ModelAttribute("product") Product product) throws Exception{
		
		System.out.println("addProduct.do Start ....  ");
		
		productService.addProduct(product);
		
		System.out.println("addProduct.do End ....  ");
		
		return "forward:/product/getProduct.jsp";
	}
	
	@RequestMapping("/getProduct.do")
	public String getProduct(@RequestParam("prodNo") int prodNo, @RequestParam("menu") String menu, Model model)
			throws Exception {

		System.out.println("getProduct.do Strat....");

		Product product = productService.getProduct(prodNo);

		model.addAttribute("product", product);

		System.out.println("getProduct.do Strat....");

		if (menu != null && menu.equals("manage")) {
			model.addAttribute("menu", menu);
			return "redirect:/updateProductView.do?prodNo=" + product.getProdNo() + "&menu" + menu;
		} else {
			return "forward:/product/getProduct.jsp";
		}
	}

	@RequestMapping("/listProduct.do")
	public String listProduct(@ModelAttribute("search") Search search, Model model, HttpServletRequest request)
			throws Exception {
		
		System.out.println("listProduct.do Strat....");

		if (search.getCurrentPage() == 0) {
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
		System.out.println(search);

		Map<String, Object> map = productService.getProductList(search);
		Page resultPage = new Page(search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("search", search);
		
		System.out.println("listProduct.do End....");
		return "forward:/product/listProduct.jsp";
	}
	
	@RequestMapping("/updateProductView.do")
	public String updateProductView(@RequestParam("prodNo") int prodNo,@RequestParam("menu") String menu, Model model) throws Exception{
		
		System.out.println("updateProductView.do Strat....");
		
		Product product = productService.getProduct(prodNo);
		
		model.addAttribute("product", product);
		model.addAttribute("menu",menu);
		
		System.out.println("updateProductView.do End....");
		
		return "forward:/product/updateProductView.jsp";
	}
	
	@RequestMapping("/updateProduct.dp")
	public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("menu") String menu, Model model )throws Exception{
		System.out.println("updateProduct.do Strat....");
		
		productService.updateProduct(product);
		
		
		System.out.println("updateProduct.do End....");
		
		return "redirect:/getProduct.do?prodNo="+product.getProdNo()+"&menu="+menu;
	}
	
}// end of class 
