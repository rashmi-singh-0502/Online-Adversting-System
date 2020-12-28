package com.cg.oas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oas.dto.Category;
import com.cg.oas.entity.CategoryEntity;
import com.cg.oas.exception.CategoryNotFoundException;
import com.cg.oas.exception.RecordNotFoundException;
import com.cg.oas.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import io.swagger.annotations.ApiResponses;

/*
 * ---------------URL FOR OAS-----------------------------
 */
//http://localhost:8080/cgoas/category
@RestController
@RequestMapping("/cgoas")
@Api(value="Category Related Rest APIS")

public class CategoryController
{
	@Autowired
	public CategoryService categoryService;
	
	/*
	 *------------ ADD A NEW CATEGORY--------------------------
	 */
	@ApiOperation(value="Add category type")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="New Category added"),
			@ApiResponse(code=404,message="No category added")
	})
	
	@PostMapping(value="/category", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryEntity> createNewCategory(@Valid @RequestBody Category category)
	{
		return new ResponseEntity<CategoryEntity>(categoryService.createCategory(category), HttpStatus.OK);
	}
	
	/*
	 * ------------------RETURNS SPECIFIC CATEGORY BY ID FROM THE DATABASE----------------------
	 */
    @ApiOperation(value="Get category by id")
    @ApiResponses(value= {
            @ApiResponse(code=201, message="Found the category"),
            @ApiResponse(code=404, message = "No category found")
    })
    @GetMapping(value="/category/search/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Category getCategoryById(@PathVariable("id") int category_id) throws CategoryNotFoundException
    {
        return categoryService.getCategoryById(category_id);
    }
	
    
	/*
	 * -------------DELETE A CATEGORY BY NAME------------------------
	 */
	@ApiOperation(value="Delete category by name")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="CATEGORY DELETED"),
			@ApiResponse(code=404,message="No SUCH NAME EXISTS")
	})
	@DeleteMapping(value="/category/{name}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> deleteCategory(@PathVariable( "name") String name) throws CategoryNotFoundException
	{
		return categoryService.deleteCategory(name);
	}
	/*
	 *----------------- VIEW ALL THE CATEGORIES PRESENT---------------
	 */
	
	@ApiOperation(value="View Category List")
	@ApiResponses(value=
    {
			@ApiResponse(code=201,message="ALL CATEGORY DISPLAYED"),
			@ApiResponse(code=404,message="NO  CATGEORY EXISTS")
	})
	@GetMapping(value="/category/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getAllCategory() throws RecordNotFoundException
	{
		return categoryService.getAllCategory();
	}
	/*
	 *----------------------FIND A CATEGORY NBY NAME------------------------
	 */
	@ApiOperation(value="Get category by Name")
	@ApiResponses(value= {
			@ApiResponse(code=201,message="CATGEORY DISPLAYED"),
			@ApiResponse(code=404,message="NO SUCH NAME EXISTS")
	})
	@GetMapping(value="/category/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Category> getCategoryByName(@PathVariable("name") String name) 
			throws CategoryNotFoundException {
		return categoryService.getCategoryByName(name);
	}
	
}
