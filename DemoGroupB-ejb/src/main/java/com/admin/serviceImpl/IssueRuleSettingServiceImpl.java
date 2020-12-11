/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.StatusDao;
import com.admin.dao.BookCategoryDao;
import com.admin.dao.IssueRuleSettingDao;
import com.admin.dto.BookCategoryDto;
import com.admin.dto.IssueRuleSettingDto;
import com.admin.mapper.BookCategoryMapper;
import com.admin.mapper.IssueRuleSettingMapper;
import com.admin.service.IssueRuleSettingService;
import com.payrollSystem.entity.common.IssueRuleSetting;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Administrator
 */
@Stateless
public class IssueRuleSettingServiceImpl implements IssueRuleSettingService{
    @EJB
    private AdminDao adminDao;
    
    @EJB
    private StatusDao statusDao;
    
    @EJB
    private BookCategoryDao bookCategoryDao;
    
    @EJB
    private IssueRuleSettingDao issueRuleSettingDao;
    
    @Override 
    public boolean save(IssueRuleSettingDto issueRuleSettingDto)
     {
         issueRuleSettingDto.setCreatedDate(new Date());
         return issueRuleSettingDao.save(convertToIssueRuleSetting(issueRuleSettingDto));
     }
    
    @Override
     public boolean update(IssueRuleSettingDto issueRuleSettingDto)
     {
        IssueRuleSetting issueRuleSetting = issueRuleSettingDao.getById(issueRuleSettingDto.getId());
        issueRuleSetting.setLastUpdatedDate(new Date());
        issueRuleSetting.setUpdatedByAdmin(adminDao.getById(issueRuleSetting.getUpdatedByAdmin().getId()));
        issueRuleSetting.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));
        setCreateEditCommonParameters(issueRuleSetting, issueRuleSettingDto);
         System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        return issueRuleSettingDao.modify(issueRuleSetting);
     }
     
     @Override
     public boolean delete(IssueRuleSettingDto issueRuleSettingDto)
    {
         IssueRuleSetting issueRuleSetting = issueRuleSettingDao.getById(issueRuleSettingDto.getId());
        issueRuleSetting.setDeletedDate(new Date());
        issueRuleSetting.setDeletedReason(issueRuleSettingDto.getDeletedReason());
        issueRuleSetting.setDeletedByAdmin(adminDao.getById(issueRuleSettingDto.getDeletedByAdminDto().getId()));
        issueRuleSetting.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return issueRuleSettingDao.modify(issueRuleSetting);
    }
     
     @Override
     public boolean checkIfMemberTypeAlreadyExists(IssueRuleSettingDto issueRuleSettingDto)
     {
         return issueRuleSettingDao.checkIfMemberTypeAlreadyExists(issueRuleSettingDto);
     }
    
     @Override
    public boolean checkIfSemesterAlreadyExists(IssueRuleSettingDto issueRuleSettingDto)
    {
        return issueRuleSettingDao.checkIfSemesterAlreadyExists(issueRuleSettingDto);
    }
    
    @Override
    public boolean checkIfBookCategoryAlreadyExists(IssueRuleSettingDto issueRuleSettingDto)
    {
        return issueRuleSettingDao.checkIfBookCategoryAlreadyExists(issueRuleSettingDto);
    }
     
     private IssueRuleSetting convertToIssueRuleSetting(IssueRuleSettingDto issueRuleSettingDto) {
        IssueRuleSetting issueRuleSetting = new IssueRuleSetting();
         setCreateEditCommonParameters(issueRuleSetting, issueRuleSettingDto);
        issueRuleSetting.setCreatedByAdmin(adminDao.getById(issueRuleSettingDto.getCreatedByAdminDto().getId()));
        issueRuleSetting.setCreatedDate(new Date());
        issueRuleSetting.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
                return issueRuleSetting;
    }
     
     private void setCreateEditCommonParameters(IssueRuleSetting issueRuleSetting, IssueRuleSettingDto issueRuleSettingDto) {
        issueRuleSetting.setFinePerExtraDay(issueRuleSettingDto.getFinePerExtraDay());
        issueRuleSetting.setMemberType(issueRuleSettingDto.getMemberType());
        issueRuleSetting.setNoOfBookAllowed(issueRuleSettingDto.getNoOfBookAllowed());
        issueRuleSetting.setNoOfDayForRenew(issueRuleSettingDto.getNoOfDayForRenew());
        issueRuleSetting.setNoOfRenews(issueRuleSettingDto.getNoOfRenews());
        issueRuleSetting.setSemester(issueRuleSettingDto.getSemester());     
         issueRuleSetting.setBookCategory(bookCategoryDao.getById(issueRuleSettingDto.getBookCategoryDto().getId()));
    }

    
    
    
    
    @Override
     public List<BookCategoryDto> fetchBookCategoryForDropDown()
    {
        return BookCategoryMapper.convertToDtosForDropDown(bookCategoryDao.findAll());
    }
    
    
    
    @Override
    public boolean checkAllRules(IssueRuleSettingDto issueRuleSettingDto)
    {
        return checkIfBookCategoryAlreadyExists(issueRuleSettingDto) && checkIfMemberTypeAlreadyExists(issueRuleSettingDto)
                && checkIfSemesterAlreadyExists(issueRuleSettingDto);
                
    }
    
    @Override
    public List<IssueRuleSettingDto> getAllIssueRuleSetting()
    {
        return issueRuleSettingDao.findAll().stream().map(IssueRuleSettingMapper::convertToDto).collect(Collectors.toList());
    }
    
    
    
}
