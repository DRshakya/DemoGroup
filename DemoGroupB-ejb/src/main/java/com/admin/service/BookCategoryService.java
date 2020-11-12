/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

/**
 *
 * @author Administrator
 * 
 * 
 */

import com.admin.dto.BookCategoryDto;
import com.admin.dto.CollegeDto;


import javax.ejb.Local;
import java.util.List;
@Local
public interface BookCategoryService {
   /* boolean addBook(BookCategoryDto bookDto);
    boolean updateBook(BookCategoryDto bookDto);
    boolean deleteBook(BookCategoryDto bookDto);
    BookCategoryDto getBook(long id);
     List<BookDto> getAllBooks();
*/
     public boolean save(BookCategoryDto bookDto);

    boolean delete(BookCategoryDto bookDto);
    
    boolean checkIfBookCategoryNameAlreadyExists(BookCategoryDto bookDto);

    boolean checkIfBookCategoryDescriptionAlreadyExists(BookCategoryDto bookDto);
    
    boolean update(BookCategoryDto bookDto);
    
    List<BookCategoryDto> findByCollegeId(CollegeDto collegeDto);
    
    List<BookCategoryDto> findByCollegeIdForDropDown(CollegeDto collegeDto);
}

