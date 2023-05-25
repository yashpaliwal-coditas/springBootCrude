package com.example.demo.controller;

import java.util.List;

public class ApiResponse<Employee>{
    private boolean error;
    private Employee data;
    public ApiResponse(boolean error, Employee data) {
        this.error = error;
        this.data = data;
    }
    public boolean isError() {
        return error;
    }
    public Employee getData() {
        return data;
    }
}
