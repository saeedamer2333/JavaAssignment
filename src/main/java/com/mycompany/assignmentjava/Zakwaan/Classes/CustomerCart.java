/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignmentjava.Zakwaan.Classes;

import com.mycompany.assignmentjava.AbdulRehman.Vendor;
import com.mycompany.assignmentjava.Utilites.ObjectWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zechn
 */
public class CustomerCart {
    private Customer customer;
    private Vendor vendor;
    private List<Product> cartProducts;
    
    public CustomerCart(Customer customer){
        this.customer = customer;
        this.cartProducts = new ArrayList<>();
    }
    
    public void addProductToCart(Product product){
        this.cartProducts.add(product);
        
        //getting vendor without passing it in
        this.vendor = product.getVendor();
    }
    
    public void removeProductFromCart(Product product){
        this.cartProducts.remove(product);
    }
    
    public void clearCart(){
        this.cartProducts.clear();
    }
    
    public Order checkOut(String orderType){
        List<String> productIDList = ObjectWriter.getIDListByProductList(cartProducts);
        Order order = new Order(this.customer.getCustomerID(), this.vendor.getVendorID(), 
                                productIDList, orderType, calculateTotal());
        
        return order;
    }
    
    //Helper functions
    public double calculateTotal(){
        double total = 0;
        for (Product product : cartProducts){
            total += product.getPrice();
        }
        return total;
    }
    
    //getters and setters
    public List<Product> getCartProducts(){
        return this.cartProducts;
    }
}
