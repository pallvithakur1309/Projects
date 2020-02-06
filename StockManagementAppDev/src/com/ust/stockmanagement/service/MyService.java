package com.ust.stockmanagement.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.stockmanagement.model.OrderDTO;
import com.ust.stockmanagement.model.ProductDTO;
import com.ust.stockmanagement.model.UserDTO;

public interface MyService {
	
       public boolean register(UserDTO dto);
	   public UserDTO login(UserDTO dto);
	   public boolean addData(ProductDTO dto);
	   public List<ProductDTO> view();
       public ProductDTO edit(int id);
       public List<ProductDTO> search(HttpServletRequest req);
       public List<ProductDTO> addtocart(int id);
       public List<OrderDTO> mycart();
       public boolean updatedata(ProductDTO dto);
}
