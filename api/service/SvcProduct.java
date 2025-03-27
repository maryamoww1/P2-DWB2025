package com.customer.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.customer.api.dto.in.DtoProductIn;
import com.customer.api.dto.out.DtoProductListOut;
import com.customer.api.dto.out.DtoProductOut;
import com.customer.common.dto.ApiResponse;

public interface SvcProduct {

	public ResponseEntity<List<DtoProductListOut>> getProducts();
	public ResponseEntity<DtoProductOut> getProduct(Integer id);
	public ResponseEntity<ApiResponse> createProduct(DtoProductIn in);
	public ResponseEntity<ApiResponse> updateProduct(Integer id, DtoProductIn in);
	public ResponseEntity<ApiResponse> enableProduct(Integer id);
	public ResponseEntity<ApiResponse> disableProduct(Integer id);

}
