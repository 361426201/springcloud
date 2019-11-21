package com.ymy.test.entity;


import com.alibaba.excel.annotation.ExcelProperty;

public class User  {

    @ExcelProperty(index = 0)
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
