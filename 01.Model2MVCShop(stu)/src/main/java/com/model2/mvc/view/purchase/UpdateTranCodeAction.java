package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;

public class UpdateTranCodeAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");
		String role="";

		if(userVO != null) {
			role=userVO.getRole();
		}
		
		String tranCode = request.getParameter("tranCode");
		
	//	int prodNo = Integer.parseInt(request.getParameter("prodNo"));
//		int tranNo = Integer.parseInt(request.getParameter("tranNo"));
		
		
		
		PurchaseVO purchaseVO = new PurchaseVO();
		//ProductVO productVO = new ProductVO();
		//productVO.setProdNo(prodNo);
		
		purchaseVO.setTranCode(tranCode);
	//	purchaseVO.setPurchaseProd(productVO);
	//	purchaseVO.setTranNo(tranNo);
		
//		PurchaseService purchaseService = new PurchaseServiceImpl();
//		purchaseService.updateTranCode(purchaseVO);
		
		if(role.equals("user")) {
			
			int tranNo = Integer.parseInt(request.getParameter("tranNo"));
			purchaseVO.setTranNo(tranNo);
			PurchaseService purchaseService = new PurchaseServiceImpl();
			purchaseService.updateTranCode(purchaseVO);
			return "forward:/listPurchase.do";
		}else {
			
			int prodNo = Integer.parseInt(request.getParameter("prodNo"));
			ProductVO productVO = new ProductVO();
			purchaseVO.setPurchaseProd(productVO);
			productVO.setProdNo(prodNo);
			PurchaseService purchaseService = new PurchaseServiceImpl();
			purchaseService.updateTranCode(purchaseVO);
			return "forward:/listSale.do";
		}
		
	}

}// end of class 
