package com.model2.mvc.view.purchase;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

public class AddPurchaseAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("====================================");
		System.out.println("==AddPurchaseAction Test Start....==");
		System.out.println("====================================");
		
		PurchaseVO purchaseVO = new PurchaseVO();
		
		UserVO buyerId = new UserVO();
		UserService userService = new UserServiceImpl();
		buyerId = userService.getUser(request.getParameter("buyerId"));
		
		ProductVO purchaseProd = new ProductVO();
		ProductService prodService = new ProductServiceImpl();
		purchaseProd = prodService.getProduct(Integer.parseInt(request.getParameter("prodNo")));
		
		
		purchaseVO.setBuyer(buyerId);
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDivyDate(request.getParameter("receiverDate"));
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		
		purchaseVO.setPurchaseProd(purchaseProd);
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		
		PurchaseService purchaseService = new PurchaseServiceImpl();
		purchaseService.addPurcharse(purchaseVO);
		
		request.setAttribute("purchaseVO", purchaseVO);
		return "forward:/purchase/addPurchase.jsp";
	}

}
