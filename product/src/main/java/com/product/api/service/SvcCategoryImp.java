<<<<<<< HEAD
package com.customer.api.service;
=======
package com.product.api.service;
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import com.customer.api.repository.RepoCategory;
import com.customer.api.entity.Category;


=======
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.api.dto.DtoCategoryIn;
import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;
import com.product.common.ApiResponse;
import com.product.exception.ApiException;
import com.product.exception.DBAccessException;


/**
 * Implementación del servicio que gestiona las operaciones CRUD para las categorías.
 * Esta clase maneja todas las operaciones relacionadas con categorías, incluyendo
 * consultas, creación, actualización y cambios de estado.
 */
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705
@Service
public class SvcCategoryImp implements SvcCategory {
	
	@Autowired
	RepoCategory repo;

	@Override
<<<<<<< HEAD
	public List<Category> getCategories() {
		return repo.getCategories();
	}

	@Override
	public List<Category> getActiveCategories() {
		return repo.getActiveCategories();
	}

	@Override
	public Category getCategory(Integer id) {
		try {
			Category category = repo.getCategory(id);
			if(category == null) {
				throw new Exception("No existe la categoría");
			}
			return category;
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
}
=======
	public ResponseEntity<List<Category>> getCategories() {
		try {
			return new ResponseEntity<>(repo.getCategories(), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	@Override
	public ResponseEntity<List<Category>> getActiveCategories() {
		try {
			return new ResponseEntity<>(repo.getActiveCategories(), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	@Override
	public ResponseEntity<Category> getCategory(Integer id) {
		try {
			validateCategoryId(id);
			return new ResponseEntity<>(repo.getCategory(id), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> createCategory(DtoCategoryIn in) {
		try {
			repo.createCategory(in.getCategory(), in.getTag());
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido registrada"), HttpStatus.CREATED);
		}catch (DataAccessException e) {
			if (e.getLocalizedMessage().contains("ux_category"))
				throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoría ya está registrado");
			if (e.getLocalizedMessage().contains("ux_tag"))
				throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoría ya está registrado");

			throw new DBAccessException(e);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> updateCategory(Integer id, DtoCategoryIn in) {
		try {
			validateCategoryId(id);
			repo.updateCategory(id, in.getCategory(), in.getTag());
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido actualizada"), HttpStatus.OK);
		}catch (DataAccessException e) {
			if (e.getLocalizedMessage().contains("ux_category"))
				throw new ApiException(HttpStatus.CONFLICT, "El nombre de la categoría ya está registrado");
			if (e.getLocalizedMessage().contains("ux_tag"))
				throw new ApiException(HttpStatus.CONFLICT, "El tag de la categoría ya está registrado");

			throw new DBAccessException(e);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> enableCategory(Integer id) {
		try {
			validateCategoryId(id);
			repo.enableCategory(id);
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido activada"), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}

	@Override
	public ResponseEntity<ApiResponse> disableCategory(Integer id) {
		try {
			validateCategoryId(id);
			repo.disableCategory(id);
			return new ResponseEntity<>(new ApiResponse("La categoría ha sido desactivada"), HttpStatus.OK);
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}
	
	private void validateCategoryId(Integer id) {
		try {
			if(repo.getCategory(id) == null) {
				throw new ApiException(HttpStatus.NOT_FOUND, "El id de la categoría no existe");
			}
		}catch (DataAccessException e) {
			throw new DBAccessException(e);
		}
	}
}
>>>>>>> 490979ca6a75e414f16c9e664f177906a26eb705
