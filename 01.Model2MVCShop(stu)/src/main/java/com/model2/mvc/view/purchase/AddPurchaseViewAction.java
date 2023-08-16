package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class AddPurchaseViewAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ProdNo을 가져올 수가 있지 ? 
		
		System.out.println("===== AddPurchaseView Start ======= ");
		int prodNo = Integer.parseInt(request.getParameter("prod_no"));
		
		ProductService productService = new ProductServiceImpl();
		ProductVO prodVO = productService.getProduct(prodNo);
		
		HttpSession session = request.getSession();
		request.setAttribute("prodVO", prodVO);
		session.getAttribute("user");
		
		return "forward:/purchase/addPurchaseView.jsp";
	}

}// end of class 
