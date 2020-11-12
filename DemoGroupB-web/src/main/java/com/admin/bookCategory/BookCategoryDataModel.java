/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.bookCategory;

import com.admin.dto.BookCategoryDto;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@ManagedBean
@SessionScoped
public class BookCategoryDataModel implements Serializable{
    
    private BookCategoryDto bookDto;
    private boolean createEditPanel;
    private List<BookCategoryDto> bookDtos;

    public BookCategoryDto getBookDto() {
        if (bookDto == null) {
            bookDto = new BookCategoryDto();
        }
        return bookDto;
    }   
    
}
