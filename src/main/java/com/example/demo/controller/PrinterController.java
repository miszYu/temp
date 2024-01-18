package com.example.demo.controller;

import com.example.demo.model.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/print")
public class PrinterController {

    @Autowired
    @Qualifier("canonPrinter")
    private Printer canonPrinter;

    @Autowired
    @Qualifier("hpPrinter")
    private Printer hpPrinter;

    private String msg;

    @RequestMapping("/hpPrinter")
    public String hpPrinter(){
        //http://localhost:8080/print/hpPrinter
        msg = "HpPrinter Say : Hello World!";
        hpPrinter.print(msg);

        return msg;
    }

    @RequestMapping("/canonPrinter")
    public String canonPrinter(){
        //http://localhost:8080/print/canonPrinter
        msg = "CanonPrinter Say : Hello World!";
        canonPrinter.print(msg);

        return msg;
    }

}
