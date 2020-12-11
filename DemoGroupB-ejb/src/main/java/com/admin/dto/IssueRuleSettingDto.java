/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.dto;

import com.admin.dto.abstracts.AbstractStatusHelperDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@ToString
public class IssueRuleSettingDto extends AbstractStatusHelperDto{
       private BookCategoryDto bookCategoryDto;
        private String memberType;
        private int semester;
        private int noOfBookAllowed;
        private int noOfRenews;
        private int noOfDayForRenew;
        private double finePerExtraDay;     
    public BookCategoryDto getBookCategoryDto() {
        if (bookCategoryDto == null) {
            bookCategoryDto = new BookCategoryDto();
        }
        return bookCategoryDto;
    }
    
}
