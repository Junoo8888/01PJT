package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class UpdatePurchaseAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int tranNo = Integer.parseInt(request.getParameter("tranNo"));
		
		System.out.println("equest.getParameter(\"receiverName\")" + request.getParameter("receiverName"));
		
		//구매자 이름, 연락처, 주소, 요청사항만 수정하도록 진행 
		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.setTranNo(tranNo); 
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setDivyDate(request.getParameter("divyDate"));
		
		PurchaseService purchaseService = new PurchaseServiceImpl();
		purchaseService.updatePurchase(purchaseVO);
		
		System.out.println(purchaseVO);
		
		purchaseVO = purchaseService.getPurcharse(tranNo);
		request.setAttribute("purchaseVO", purchaseVO);
		
		
		return "forward:/purchase/getPurchase.jsp";
	}

}
