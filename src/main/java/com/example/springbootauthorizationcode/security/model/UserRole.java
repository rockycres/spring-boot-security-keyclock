package com.example.springbootauthorizationcode.security.model;


public enum UserRole {

   CEO("CEO"), USER("USER");

   final String value;

    UserRole(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "value='" + value + '\'' +
                '}';
    }
}