package com.wallet.Wallet.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping
    @PreAuthorize("hasRole('wallet_user')")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('wallet_admin')")
    public String hello2(){
        return "Hello Admin";
    }
}