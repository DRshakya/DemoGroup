/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.BookCategoryDto;
import com.payrollSystem.entity.common.BookCategory;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Administrator
 */
public class BookCategoryMapper extends AbstractProfileMapper{
    
    public static BookCategoryDto convertToDto(BookCategory bookCategory) {
        BookCategoryDto bookDto = new BookCategoryDto();
          
        convertCommonParameters(bookDto, bookCategory);
        return bookDto;
    }
     public static List<BookCategoryDto> convertToDtos(List<BookCategory> bookCategorys) {
        List<BookCategoryDto> bookDtos = new ArrayList<>();
        for (BookCategory bookCategory : bookCategorys) {
            bookDtos.add(convertToDto(bookCategory));
        }
        return bookDtos;
    }

    public static BookCategoryDto convertToDtoForDropDown(BookCategory bookCategory) {
        BookCategoryDto bookDto = new BookCategoryDto();
        bookDto.setDescription(bookCategory.getDescription());
        bookDto.setId(bookCategory.getId());
        bookDto.setName(bookCategory.getName());
        return bookDto;
    }
    
    public static List<BookCategoryDto> convertToDtosForDropDown(List<BookCategory> bookCategorys) {
        List<BookCategoryDto> bookDtos = new ArrayList<>();
        for (BookCategory bookCategory : bookCategorys) {
            bookDtos.add(convertToDtoForDropDown(bookCategory));
        }
        return bookDtos;
    }

}


    


    

