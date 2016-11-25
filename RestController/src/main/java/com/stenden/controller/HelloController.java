package com.stenden.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ron on 24/11/2016.
 */


@RestController
@RequestMapping(value = "/rest")
public class HelloController {


    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String Hello() {
        return "hello Stenden";
    }
}
