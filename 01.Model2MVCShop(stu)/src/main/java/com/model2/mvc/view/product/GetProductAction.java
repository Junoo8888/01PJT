package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class GetProductAction extends Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		String menu = request.getParameter("menu");
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProduct(prodNo);
		
		request.setAttribute("vo", vo);
		
		if(menu != null && menu.equals("manage")) {
			request.setAttribute("menu", menu);
			return "redirect:/updateProductView.do?prodNo="+vo.getProdNo()+"&menu"+menu;
		}else {
			return "forward:/product/getProduct.jsp";
		}
		
	}

}// end of class 
