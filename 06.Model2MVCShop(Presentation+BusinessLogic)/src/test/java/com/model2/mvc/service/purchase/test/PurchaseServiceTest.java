package com.model2.mvc.service.purchase.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {
	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	
	@Test
	public void addProduct()throws Exception{
		Purchase purchase = new Purchase();
		
		Product product = new Product();
		User user = new User();
		
		product = productService.getProduct(10081);
		user = userService.getUser("user02");


		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		
		purchaseService.addPurchase(purchase);
	
	}
}
