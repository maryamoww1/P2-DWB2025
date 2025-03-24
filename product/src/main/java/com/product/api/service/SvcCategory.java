<<<<<<< HEAD
package com.customer.api.service;
import com.customer.api.entity.Category;

import java.util.List;


public interface SvcCategory {

	public List<Category> getCategories();
	public List<Category> getActiveCategories();
	public Category getCategory(Integer id);
=======
package com.product.api.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.common.ApiResponse;


public interface SvcCategory {

	public ResponseEntity<List<Category>> getCategories();
	public ResponseEntity<List<Category>> getActiveCategories();
	public ResponseEntity<Category> getCategory(Integer id);
	public ResponseEntity<ApiResponse> createCategory(DtoCategoryIn in);
	public ResponseEntity<ApiResponse> updateCategory(Integer id, DtoCategoryIn in);
	public ResponseEntity<ApiResponse> enableCategory(Integer id);
	public ResponseEntity<ApiResponse> disableCategory(Integer id);
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705
}
