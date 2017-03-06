package com.spring.cloud.openplatform.web.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo controller
 * @author JohnnyJiang
 * @since 2017.03.01
 */
@RestController
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public Object findAll(){
        return Lists.newArrayList(ImmutableMap.of("name","fake"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Object index(){
        return "index";
    }


}