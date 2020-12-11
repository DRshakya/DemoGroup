/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.issueRuleSetting;

import com.admin.dto.BookCategoryDto;
import com.admin.dto.IssueRuleSettingDto;
import com.admin.service.IssueRuleSettingService;
import com.admin.constant.MemberTypeConstants;
import com.admin.constant.SemesterConstants;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
public class IssueRuleSettingDataModel implements Serializable{
    private IssueRuleSettingDto issueRuleSettingDto;
    private boolean initEdit;
    private List<IssueRuleSettingDto> issueRuleSettingDtos;
    private List<BookCategoryDto> bookCategoryDtos;
    private List<String> memberList;
    private List<Integer> semesterList;
    private MemberTypeConstants memberTypeConstants;
    private SemesterConstants semesterConstants;
    @EJB
    private IssueRuleSettingService issueRuleSettingService;
    
    @PostConstruct
    public void init()
    {
        bookCategoryDtos = issueRuleSettingService.fetchBookCategoryForDropDown();
        memberList = memberTypeConstants.membersList();
        semesterList = semesterConstants.semesterList();
        
        
         
    }

    public IssueRuleSettingDto getIssueRuleSettingDto(){
        if (issueRuleSettingDto == null) {
            issueRuleSettingDto = new IssueRuleSettingDto();
        }
        return issueRuleSettingDto;
    }
    
}
