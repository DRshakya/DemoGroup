/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.daoImpl;

import com.admin.constant.StatusConstants;
import com.admin.dao.BookGenreDao;
import com.admin.dto.BookGenreDto;
import com.payrollSystem.entity.common.BookGenre;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
public class BookGenreDaoImpl extends StatusableDaoImpl<BookGenre> implements BookGenreDao
{
  public BookGenreDaoImpl()
  {
        super(BookGenre.class);      
  }
@Override
public boolean checkIfBookGenreNameAlreadyExists(BookGenreDto bookGenreDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(bg.id) FROM BookGenre bg WHERE bg.createdByAdmin.college.id=:collegeId AND bg.name=:bookGenreName  AND bg.status.statusDesc NOT IN (:deletedStatusList)");
        if (bookGenreDto.getId() != null) {
            stringBuilder.append("and bg.id<>:bookGenreId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("collegeId", bookGenreDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("bookGenreName", bookGenreDto.getName());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        if (bookGenreDto.getId() != null) {
            query.setParameter("bookGenreId", bookGenreDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }
@Override
    public boolean checkIfBookGenreDescriptionAlreadyExists(BookGenreDto bookGenreDto) {
        StringBuilder stringBuilder = new StringBuilder("SELECT count(bg.id) FROM BookGenre bg WHERE bg.createdByAdmin.college.id=:collegeId AND bg.description=:bookGenreDescription AND bg.status.statusDesc NOT IN (:deletedStatusList)");
        if (bookGenreDto.getId() != null) {
            stringBuilder.append("and bg.id<>:bookGenreId");
        }
        Query query = getEntityManager().createQuery(stringBuilder.toString());
        query.setParameter("collegeId", bookGenreDto.getCreatedByAdminDto().getCollegeDto().getId());
        query.setParameter("deletedStatusList", StatusConstants.deleteStatusList());
        query.setParameter("bookGenreDescription", bookGenreDto.getDescription());
        if (bookGenreDto.getId() != null) {
            query.setParameter("bookGenreId", bookGenreDto.getId());
        }
        return (Long) query.getSingleResult() > 0;
    }
}
