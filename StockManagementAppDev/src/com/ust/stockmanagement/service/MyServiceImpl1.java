package com.ust.stockmanagement.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ust.stockmanagement.dao.MyDAO;
import com.ust.stockmanagement.model.OrderDTO;
import com.ust.stockmanagement.model.ProductDTO;
import com.ust.stockmanagement.model.UserDTO;

@Component
public class MyServiceImpl1 implements MyService {
	@Autowired
	MyDAO mdao;

	@Override
	public boolean register(UserDTO dto) {
		System.out.println("inside service");
		boolean b =mdao.register(dto);
		return b;
	}
@Override
	public UserDTO login(UserDTO dto) {
		System.out.println("inside service");
		UserDTO udto=mdao.login(dto);
		return udto;
	}
@Override
	public boolean addData(ProductDTO dto) {
		System.out.println("inside service");
		boolean b =mdao.addData(dto);
		return b;
	}
@Override
	public List<ProductDTO> view() {
		// TODO Auto-generated method stub
				List<ProductDTO> list=mdao.view();
				return list;
	}
@Override
	public ProductDTO edit(int id) {
	ProductDTO obj=mdao.edit(id);
		return obj;
	}
@Override
	public List<ProductDTO> search(HttpServletRequest req) {
		List<ProductDTO> list=mdao.search(req);
		return list;
	}
@Override
	public List<ProductDTO> addtocart(int id) {
		List<ProductDTO> list=mdao.addtocart(id);
		return list;
	}
@Override
	public List<OrderDTO> mycart() {
		List<OrderDTO> list=mdao.mycart();
		return list;
	}
@Override
	public boolean updatedata(ProductDTO dto) {
		// TODO Auto-generated method stub
		return mdao.updatedata(dto);
	}
}
