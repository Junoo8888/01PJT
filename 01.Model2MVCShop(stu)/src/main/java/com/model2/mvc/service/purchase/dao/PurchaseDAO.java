package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;

public class PurchaseDAO {

	//Constructor
	public PurchaseDAO() {
	}
	
	//Method
	public PurchaseVO findPurchase(int tranNo) throws Exception{
		
		Connection con = DBUtil.getConnection();
	    String sql = "SELECT * FROM transaction WHERE tran_no = ?";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setInt(1, tranNo);
	    ResultSet rs = pstmt.executeQuery();
	    
	    PurchaseVO purchaseVO = null;
	    
	    if (rs.next()) {
	        purchaseVO = new PurchaseVO();
	        
	        UserVO userVO = new UserVO();
	        userVO.setUserId(rs.getString("BUYER_ID"));
	        
	        ProductVO productVO = new ProductVO();
	        productVO.setProdNo(rs.getInt("PROD_NO"));
	        
	        purchaseVO.setBuyer(userVO);
	        purchaseVO.setPurchaseProd(productVO);
	        purchaseVO.setDivyAddr(rs.getString("DEMAILADDR"));
	        purchaseVO.setDivyRequest(rs.getString("DLVY_REQUEST"));
	        purchaseVO.setOrderDate(rs.getDate("ORDER_DATA"));
	        purchaseVO.setPaymentOption(rs.getString("PAYMENT_OPTION"));
	        purchaseVO.setReceiverName(rs.getString("RECEIVER_NAME"));
	        purchaseVO.setReceiverPhone(rs.getString("RECEIVER_PHONE"));
	        purchaseVO.setTranCode(rs.getString("TRAN_STATUS_CODE"));
	        purchaseVO.setTranNo(rs.getInt("TRAN_NO"));
	    }
	    
	    return purchaseVO;
	}
	
	public HashMap<String, Object> getPurchaseList(SearchVO searchVO, String userId) throws Exception{
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		Connection con = DBUtil.getConnection();
		
		String sql = "SELECT users.*, transaction.* "
				+ "FROM users LEFT JOIN transaction "
				+ "ON users.user_id = transaction.buyer_id "
				+ "WHERE transaction.tran_status_code IS NOT NULL "
				+ "AND users.user_id = '" + userId +"'";
		
		System.out.println("getPurchase sql => " + sql);
		PreparedStatement pstmt = con.prepareStatement(sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = pstmt.executeQuery();
		
		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수 : " + total);

		map.put("count", new Integer(total));
		
		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		
		ArrayList<PurchaseVO> purchaseList = new ArrayList<PurchaseVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				
				UserVO userVO = new UserVO();
				userVO.setUserId(rs.getString("USER_ID"));
				userVO.setUserName(rs.getString("USER_NAME"));
				userVO.setPassword(rs.getString("PASSWORD"));
				userVO.setRole(rs.getString("ROLE"));
				userVO.setSsn(rs.getString("SSN"));
				userVO.setPhone(rs.getString("CELL_PHONE"));
				userVO.setAddr(rs.getString("ADDR"));
				userVO.setEmail(rs.getString("EMAIL"));
				userVO.setRegDate(rs.getDate("REG_DATE"));
				
				ProductVO productVO = new ProductVO();
				productVO.setProdNo(rs.getInt("PROD_NO"));
				
				PurchaseVO purchaseVO = new PurchaseVO();
				purchaseVO.setBuyer(userVO);
				purchaseVO.setPurchaseProd(productVO);
				purchaseVO.setDivyAddr(rs.getString("DEMAILADDR"));
				purchaseVO.setDivyRequest(rs.getString("DLVY_REQUEST"));
				purchaseVO.setOrderDate(rs.getDate("ORDER_DATA"));
				purchaseVO.setPaymentOption(rs.getString("PAYMENT_OPTION"));
				purchaseVO.setReceiverName(rs.getString("RECEIVER_NAME"));
				purchaseVO.setReceiverPhone(rs.getString("RECEIVER_PHONE"));
				purchaseVO.setTranCode(rs.getString("TRAN_STATUS_CODE"));
				purchaseVO.setTranNo(rs.getInt("TRAN_NO"));
				
				purchaseList.add(purchaseVO);
				if (!rs.next())
					break;
			}
		}
		
		System.out.println("list.size() : " + purchaseList.size());
		map.put("list", purchaseList);
		con.close();
		
		
		return map;
	}
	
	
	public HashMap<String, Object> getSaleList(SearchVO searchVO) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql = "SELECT product.*, transaction.tran_status_code "
				+ "FROM product LEFT JOIN transaction "
				+ "ON product.prod_no = transaction.prod_no";
		if (searchVO.getSearchCondition() != null && !searchVO.getSearchKeyword().equals("")) {
			if (searchVO.getSearchCondition().equals("0")) {
				sql += " WHERE product.prod_no=" + searchVO.getSearchKeyword();
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += " WHERE prod_name LIKE '" + searchVO.getSearchKeyword()
						+ "%'";
			}else if (searchVO.getSearchCondition().equals("2")) {
				sql += " WHERE price=" + searchVO.getSearchKeyword();
			}
		}
		sql += " order by product.PROD_NO";

			
		System.out.println(sql);
		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		//System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				ProductVO productVO = new ProductVO();
			//	PurchaseVO purchaseVO = new PurchaseVO();
				
				productVO.setProdNo(rs.getInt("PROD_NO"));
				productVO.setProdName(rs.getString("PROD_NAME"));
				productVO.setProdDetail(rs.getString("PROD_DETAIL"));
				productVO.setManuDate(rs.getString("MANUFACTURE_DAY"));
				productVO.setPrice(rs.getInt("PRICE"));
				productVO.setFileName(rs.getString("IMAGE_FILE"));
				productVO.setRegDate(rs.getDate("REG_DATE"));
				productVO.setProTranCode(rs.getString("tran_status_code"));
				
				list.add(productVO);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}
	
	public void insertPurcharse(PurchaseVO purchaseVO) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		ProductVO prodVO = purchaseVO.getPurchaseProd();
		UserVO userVO = purchaseVO.getBuyer();
		
		String sql = "INSERT INTO transaction VALUES(seq_transaction_tran_no.nextval,?,?,?,?,?,?,?,?,SYSDATE,TO_DATE(?, 'YYYY-MM-DD'))";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, prodVO.getProdNo());
		pstmt.setString(2, userVO.getUserId());
		pstmt.setString(3, purchaseVO.getPaymentOption()); 
		pstmt.setString(4, purchaseVO.getReceiverName());
		pstmt.setString(5, purchaseVO.getReceiverPhone());
		pstmt.setString(6, purchaseVO.getDivyAddr());
		pstmt.setString(7, purchaseVO.getDivyRequest());
		pstmt.setString(8, "1"); // tran_
		pstmt.setString(9, purchaseVO.getDivyDate());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}
	
	public void updatePurcharse(PurchaseVO purchaseVO) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql = "UPDATE transaction "
				+ "SET receiver_name=?, receiver_phone=?, demailaddr=?, dlvy_request=? "
				+ "WHERE tran_no = ?"; 
		
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, purchaseVO.getReceiverName());
		pstmt.setString(2, purchaseVO.getReceiverPhone());
		pstmt.setString(3, purchaseVO.getDivyAddr());
		pstmt.setString(4, purchaseVO.getDivyRequest());
		pstmt.setInt(5, purchaseVO.getTranNo());
		pstmt.executeUpdate();
		
		con.close();
		
	}
	
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql = "UPDATE transaction "
				+ "SET tran_status_code = ? ";
		
		if(purchaseVO.getPurchaseProd() != null) {
			
			System.out.println("여기로 들어오는ㄱ ");

			
			sql += "WHERE prod_no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseVO.getTranCode());
			pstmt.setInt(2, purchaseVO.getPurchaseProd().getProdNo());
			pstmt.executeUpdate();
		}else {
			sql += "WHERE tran_no = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseVO.getTranCode());
			pstmt.setInt(2, purchaseVO.getTranNo());
			pstmt.executeUpdate();
		}
		
		con.close();
		
	}
	
}// end of class 
