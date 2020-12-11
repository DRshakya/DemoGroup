/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.service;

import com.admin.dto.BookCategoryDto;
import com.admin.dto.IssueRuleSettingDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface IssueRuleSettingService {
    boolean save(IssueRuleSettingDto issueRuleSettingDto);

    boolean delete(IssueRuleSettingDto issueRuleSettingDto);
    
    boolean update(IssueRuleSettingDto issueRuleSettingDto);
    
    List<BookCategoryDto> fetchBookCategoryForDropDown();
    
    boolean checkIfMemberTypeAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    
    boolean checkIfSemesterAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    
    boolean checkIfBookCategoryAlreadyExists(IssueRuleSettingDto issueRuleSettingDto);
    
    boolean checkAllRules(IssueRuleSettingDto issueRuleSettingDto);
    
    List <IssueRuleSettingDto> getAllIssueRuleSetting();
    
}
