package com.example.kltn.SpringAPILambdaBuy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kltn.SpringAPILambdaBuy.common.request.checkout.CheckoutItemDto;
import com.example.kltn.SpringAPILambdaBuy.common.response.StripeResponse;
import com.example.kltn.SpringAPILambdaBuy.service.OrderService;
import com.example.kltn.SpringAPILambdaBuy.service.ProductService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping("/order/create-checkout-session")
	public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList) throws StripeException {
        Session session = orderService.createSession(checkoutItemDtoList);
        StripeResponse stripeResponse = new StripeResponse(session.getId());
        return new ResponseEntity<StripeResponse>(stripeResponse,HttpStatus.OK);
    }
	
//	@PostMapping("/order/checkout")
//	public String purchase(@ModelAttribute("order") Order order){
//		Collection<ProductEntity> list = cartItemService.getItems();
//		List<OrderDetail> details = new  ArrayList<>();
//		List<ProductEntity> listProduct = productService.findAll();
//		for(ProductEntity product : list) {
//			OrderDetail detail =new OrderDetail();
//			detail.setOrder(order);
//			detail.setProduct(product);
//			detail.setUnitPrice(product.getUnitPrice());
//			detail.setQuantity(product.getInStock());
//			detail.setDiscount(product.getDiscount());
//			details.add(detail);
//			/*
//			 * for(Product updateProduct:listProduct) { Product productUpdate = new
//			 * Product(); productUpdate.setId(product.getId());
//			 * productUpdate.setQuantity(updateProduct.getQuantity()-product.getQuantity());
//			 * pdao.update(productUpdate); }
//			 */
//			
//		}
//		dao.create(order, details);
//		cart.clear();
//		model.addAttribute("message", "Đặt hàng thành công!");
//
//		
//		return "redirect:/order/list";
//
//	}
	
}
