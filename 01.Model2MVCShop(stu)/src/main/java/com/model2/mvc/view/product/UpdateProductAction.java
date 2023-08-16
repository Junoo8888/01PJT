package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;

public class UpdateProductAction extends Action{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		int prodNo = Integer.parseInt(request.getParameter("prodNo"));
		String menu = "ok";
		
		ProductVO prodVO = new ProductVO();
		prodVO.setProdNo(prodNo);
		prodVO.setProdName(request.getParameter("prodName"));
		prodVO.setFileName(request.getParameter("fileName"));
		prodVO.setProdDetail(request.getParameter("prodDetail"));
		prodVO.setManuDate(request.getParameter("manuDate"));
		prodVO.setPrice(Integer.parseInt(request.getParameter("price")));
		//prodVO.setRegDate(request.getParameter("regDate"));
		
		ProductService service = new ProductServiceImpl();
		service.updateProduct(prodVO);
		
		return "redirect:/getProduct.do?prodNo="+prodNo+"&menu="+menu;
		
	}

}// end of classs
