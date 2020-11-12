/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.serviceImpl;

/**
 *
 * @author Administrator
 */
import com.admin.constant.StatusConstants;
import com.admin.dao.AdminDao;
import com.admin.dao.StatusDao;
import com.admin.dto.BookCategoryDto;
import com.admin.mapper.BookCategoryMapper;
import com.payrollSystem.entity.common.BookCategory;
import java.util.Date;
import com.admin.dto.CollegeDto;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import com.admin.dao.BookCategoryDao;
import com.admin.service.BookCategoryService;

@Stateless
public class BookCategoryServiceImpl implements BookCategoryService {
    @EJB
    private AdminDao adminDao;
    @EJB
    private StatusDao statusDao;
    @EJB
    private BookCategoryDao bookDao;
    @Override
    public boolean save(BookCategoryDto bookDto) {
        return bookDao.save(convertToBookCategory(bookDto));
    }

    private BookCategory convertToBookCategory(BookCategoryDto bookDto) {
        BookCategory bookCategory = new BookCategory();
        bookCategory.setCreatedByAdmin(adminDao.getById(bookDto.getCreatedByAdminDto().getId()));
        bookCategory.setCreatedDate(new Date());
        bookCategory.setName(bookDto.getName());
        bookCategory.setDescription(bookDto.getDescription());
        
        bookCategory.setStatus(statusDao.getByDesc(StatusConstants.CREATE_APPROVE.getName()));
        return bookCategory;
    }

    private void setCreateEditCommonParameters(BookCategory bookCategory, BookCategoryDto bookDto) {
        bookCategory.setDescription(bookDto.getDescription());
        bookCategory.setName(bookDto.getName());
       
    }

    @Override
    public boolean delete(BookCategoryDto bookDto) {
        BookCategory bookCategory = bookDao.getById(bookDto.getId());
        bookCategory.setDeletedDate(new Date());
        bookCategory.setDeletedReason(bookDto.getDeletedReason());
        bookCategory.setDeletedByAdmin(adminDao.getById(bookDto.getDeletedByAdminDto().getId()));
        bookCategory.setStatus(statusDao.getByDesc(StatusConstants.DELETED_APPROVE.getName()));
        return bookDao.modify(bookCategory);
    }

    @Override
    public boolean update(BookCategoryDto bookDto) {
        BookCategory bookCategory = bookDao.getById(bookDto.getId());
        bookCategory.setLastUpdatedDate(new Date());
        bookCategory.setUpdatedByAdmin(adminDao.getById(bookDto.getUpdatedByAdminDto().getId()));
        bookCategory.setStatus(statusDao.getByDesc(StatusConstants.EDIT_APPROVE.getName()));
        setCreateEditCommonParameters(bookCategory, bookDto);
        return bookDao.modify(bookCategory);
    }

    @Override
    public boolean checkIfBookCategoryNameAlreadyExists(BookCategoryDto bookDto) {
        return bookDao.checkIfBookCategoryNameAlreadyExists(bookDto);
    }

    @Override
    public boolean checkIfBookCategoryDescriptionAlreadyExists(BookCategoryDto bookDto) {
        return bookDao.checkIfBookCategoryDescriptionAlreadyExists(bookDto);
    }

    @Override
    public List<BookCategoryDto> findByCollegeId(CollegeDto collegeDto) {
        return BookCategoryMapper.convertToDtos(bookDao.findAllByCollegeId(collegeDto));
    }
    
    @Override
    public List<BookCategoryDto> findByCollegeIdForDropDown(CollegeDto collegeDto) {
        return BookCategoryMapper.convertToDtosForDropDown(bookDao.findAllByCollegeId(collegeDto));
    }
}

