/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin.constant;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Administrator
 */
@Getter
@AllArgsConstructor
public enum MemberTypeConstants {
    Student("Student"),
    Staff("Staff");
    
    private final String name;
    
    public static List<String> membersList(){
        return Arrays.asList(Student.getName(),Staff.getName());
    }
    
}
