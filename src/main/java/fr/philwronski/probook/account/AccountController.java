package fr.philwronski.probook.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @GetMapping(value = "/account")
    public String findAll() {
        return "all account";
    }

}
