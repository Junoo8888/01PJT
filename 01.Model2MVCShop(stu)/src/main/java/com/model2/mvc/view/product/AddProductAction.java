package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class AddProductAction extends Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

		ProductVO prodVO = new ProductVO();
		String menu = request.getParameter("menu");
		System.out.println(prodVO);
		prodVO.setProdName(request.getParameter("prodName"));
		prodVO.setProdDetail(request.getParameter("prodDetail"));
		prodVO.setManuDate(request.getParameter("manuDate"));
		prodVO.setPrice(Integer.parseInt(request.getParameter("price")));
		prodVO.setFileName(request.getParameter("fileName"));
		
		System.out.println(prodVO);
		
		request.setAttribute("vo", prodVO);
		ProductService service = new ProductServiceImpl();
		service.addProduct(prodVO);
		
		
		
		if(menu != null && menu.equals("ok")) {
			return "forward:/product/getProduct.jsp";
		}else {
			return "forward:/product/addProduct.jsp";
		}
		
	}

}// end of class 
