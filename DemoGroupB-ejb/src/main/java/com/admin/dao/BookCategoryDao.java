/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dao;


import com.admin.dto.BookCategoryDto;

import com.payrollSystem.entity.common.BookCategory;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface BookCategoryDao extends StatusableDao<BookCategory> {
    boolean checkIfBookCategoryNameAlreadyExists(BookCategoryDto bookDto);

    boolean checkIfBookCategoryDescriptionAlreadyExists(BookCategoryDto bookDto);
    
    
    
}
