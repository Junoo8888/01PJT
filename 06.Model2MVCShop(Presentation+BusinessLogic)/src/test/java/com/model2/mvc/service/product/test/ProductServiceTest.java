package com.model2.mvc.service.product.test;

import java.util.List; 
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	
	//@Test
	public void addProduct()throws Exception{
		Product product = new Product();
		
		product.setPrice(10000);
		product.setProdName("04리팩토링");
		product.setManuDate("20230909");
		product.setRegDate(null);
		product.setProdDetail("무조건가자");
		product.setFileName(null);
		
		productService.addProduct(product);
		
	}
	
	
	//@Test
	public void getUserTest() throws Exception{
		
		Product product = new Product();
		
		product = productService.getProduct(10021);
		
		System.out.println("product == > " + product);
		
	}
	
	//prod_no 를 임의로 설정해서 넣음 
	//@Test
	public void updateProductTest() throws Exception{
		Product product = new Product();
		
		product.setProdNo(10081);
		product.setProdName("04업데이트완료");
		product.setProdDetail("04업데이트 prodDetail");
		product.setManuDate("04040404");
		product.setPrice(4444444);
		product.setFileName(null);
		
		
		productService.updateProduct(product);
		
	}
	
	@Test
	 public void testGetUserListByUserId() throws Exception{
		 
		 
		 Search search = new Search();
		 
		 search.setCurrentPage(1);
		 search.setPageSize(3);
		 search.setSearchCondition("0");
		 search.setSearchKeyword("");
		 Map<String, Object> map = productService.getProductList(search);
		 
		 List<Object> list = (List<Object>)map.get("list");
		 Assert.assertEquals(3, list.size());
		 
		 int totalCount = (int) map.get("totalCount");
		 System.out.println("totalcount = > " + totalCount);
		 
//		 	Search search = new Search();
//		 	search.setCurrentPage(1);
//		 	search.setPageSize(3);
//		 	search.setSearchCondition("0");
//		 	search.setSearchKeyword("admin");
//		 	Map<String,Object> map = userService.getUserList(search);
//		 	
//		 	List<Object> list = (List<Object>)map.get("list");
//		 	Assert.assertEquals(1, list.size());
//		 	
//			//==> console 확인
//		 	//System.out.println(list);
//		 	
//		 	Integer totalCount = (Integer)map.get("totalCount");
//		 	System.out.println(totalCount);
//		 	
//		 	System.out.println("=======================================");
//		 	
//		 	search.setSearchCondition("0");
//		 	search.setSearchKeyword(""+System.currentTimeMillis());
//		 	map = userService.getUserList(search);
//		 	
//		 	list = (List<Object>)map.get("list");
//		 	Assert.assertEquals(0, list.size());
//		 	
//			//==> console 확인
//		 	//System.out.println(list);
//		 	
//		 	totalCount = (Integer)map.get("totalCount");
//		 	System.out.println(totalCount);
		 }
	
}// end of class 
