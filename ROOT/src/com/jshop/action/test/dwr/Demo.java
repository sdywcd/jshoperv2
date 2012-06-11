package com.jshop.action.test.dwr;

import org.springframework.stereotype.Controller;

@Controller("demo")
public class Demo {
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}