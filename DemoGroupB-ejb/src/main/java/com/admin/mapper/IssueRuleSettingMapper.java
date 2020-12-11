/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.mapper;

import com.admin.dto.IssueRuleSettingDto;
import com.payrollSystem.entity.common.IssueRuleSetting;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class IssueRuleSettingMapper extends AbstractStatusHelperMapper{
    public static IssueRuleSettingDto convertToDto(IssueRuleSetting issueRuleSetting) {
        IssueRuleSettingDto issueRuleSettingDto = new IssueRuleSettingDto();
        convertCommonStatusParameters(issueRuleSettingDto, issueRuleSetting); 
        setCommonParameters(issueRuleSettingDto, issueRuleSetting);
        issueRuleSettingDto.setBookCategoryDto(BookCategoryMapper.convertToDto(issueRuleSetting.getBookCategory()));
        return issueRuleSettingDto;
    }
    
     private static void setCommonParameters(IssueRuleSettingDto issueRuleSettingDto, IssueRuleSetting issueRuleSetting) {
        issueRuleSettingDto.setFinePerExtraDay(issueRuleSetting.getFinePerExtraDay());
        issueRuleSettingDto.setMemberType(issueRuleSetting.getMemberType());
        issueRuleSettingDto.setId(issueRuleSetting.getId());
        issueRuleSettingDto.setNoOfBookAllowed(issueRuleSetting.getNoOfBookAllowed());
        issueRuleSettingDto.setNoOfDayForRenew(issueRuleSetting.getNoOfDayForRenew());
        issueRuleSettingDto.setNoOfRenews(issueRuleSetting.getNoOfRenews());
    }
    
     
}
