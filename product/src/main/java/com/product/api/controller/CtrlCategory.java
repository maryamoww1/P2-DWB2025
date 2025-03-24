<<<<<<< HEAD
package com.customer.api.controller;
=======
package com.product.api.controller;
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.entity.Category;
import com.customer.api.service.SvcCategory;

@RestController
@RequestMapping("/category")
public class CtrlCategory {
	
=======
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.service.SvcCategory;
import com.product.common.ApiResponse;
import com.product.exception.ApiException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")

/**
 * Controlador REST para la gestion de categorías.
 * Proporciona endpoints para realizar operaciones CRUD y gestion de estados
 * de las categorias en el sistema.
 */
public class CtrlCategory {

>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705
	@Autowired
	SvcCategory svc;

	@GetMapping
<<<<<<< HEAD
	public List<Category> getCategories(){
=======
	public ResponseEntity<List<Category>> getCategories() {
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705
		return svc.getCategories();
	}

	@GetMapping("/active")
<<<<<<< HEAD
	public List<Category> getActiveCategories(){
		return svc.getActiveCategories();
	}

	@GetMapping("/{category_id}")
	public Category getCategory(@PathVariable Integer category_id){
		return svc.getCategory(category_id);
	}
}
=======
	public ResponseEntity<List<Category>> getActiveCategories() {
		return svc.getActiveCategories();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
		return svc.getCategory(id);
	}

	@PostMapping
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody DtoCategoryIn in, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

		return svc.createCategory(in);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable Integer id, @Valid @RequestBody DtoCategoryIn in,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			throw new ApiException(HttpStatus.BAD_REQUEST, bindingResult.getFieldError().getDefaultMessage());

		return svc.updateCategory(id, in);
	}

	@PatchMapping("/{id}/enable")
	public ResponseEntity<ApiResponse> enableCategory(@PathVariable Integer id) {
		return svc.enableCategory(id);
	}

	@PatchMapping("/{id}/disable")
	public ResponseEntity<ApiResponse> disableCategory(@PathVariable Integer id) {
		return svc.disableCategory(id);
	}
	
	

}
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705
