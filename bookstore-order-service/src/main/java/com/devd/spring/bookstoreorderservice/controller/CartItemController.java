package com.devd.spring.bookstoreorderservice.controller;

import com.devd.spring.bookstoreorderservice.service.CartItemService;
import com.devd.spring.bookstoreorderservice.web.CartItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Devaraj Reddy,
 * Date : 2019-06-17
 */
@RestController
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @GetMapping("/test/cart-item")
    public ResponseEntity<String> testUserRoleController() {
        return ResponseEntity.ok("Hey, I am CartItemController");
    }
    
    @PostMapping("/cart/cartItem")
    @ResponseStatus(value = HttpStatus.OK)
    public void addCartItem(@RequestBody CartItemRequest cartItemRequest) {
        cartItemService.addCartItem(cartItemRequest);
    }
    
    @DeleteMapping("/cart/cartItem/{cartItemId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCartItem(@PathVariable(value = "cartItemId") String cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }
    
    @DeleteMapping("/cart/cartItem")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeAllCartItems(@PathVariable(value = "cartId") String cartId) {
        cartItemService.removeAllCartItems(cartId);
    }
    
}