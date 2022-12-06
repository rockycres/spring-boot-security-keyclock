package com.example.springbootauthorizationcode.adaptors;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole(T(com.example.springbootauthorizationcode.security.model.UserRole)" +
        ".CHIEF_OPERATING_OFFICER.toString())")
public @interface MustBeChiefOperatingOfficer {
}
