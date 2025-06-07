package com.ruxlsr.demo.controllers;

import com.ruxlsr.demo.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/employes")
public class EmployeController {
    private final EmployeService employeService;


}
