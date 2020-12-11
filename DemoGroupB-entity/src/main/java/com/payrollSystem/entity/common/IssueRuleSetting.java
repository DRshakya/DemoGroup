/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.payrollSystem.entity.common;

import com.payrollSystem.entity.abstracts.AbstractStatusHelper;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
@Entity
@Table(name = "ISSUE_RULE_SETTING")
@NamedQueries({
    @NamedQuery(name = "IssueRuleSetting.findAll", query = "SELECT irs FROM IssueRuleSetting irs"),
    @NamedQuery(name = "IssueRuleSetting.findByIssueRuleSettingId", query = "SELECT irs FROM IssueRuleSetting irs WHERE irs.id = :id")})
public class IssueRuleSetting extends AbstractStatusHelper{
    @JoinColumn(name = "BOOK_CATEGORY", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private BookCategory bookCategory;
    
    @Column(name = "MEMBER_TYPE", nullable = false)
    private String memberType;
    
    @Column(name = "SEMESTER", nullable = false)
    private int semester;
    
    @Column(name = "NO_OF_BOOK_ALLOWED", nullable = false)
    private int noOfBookAllowed;
    
    @Column(name = "NO_OF_RENEWS", nullable = false)
    private int noOfRenews;
    
    @Column(name = "NO_OF_DAY_FOR_RENEW", nullable = false)
    private int noOfDayForRenew;
    
    @Column(name = "FINE_PER_EXTRA_DAY", nullable = true)
    private double finePerExtraDay;
}
