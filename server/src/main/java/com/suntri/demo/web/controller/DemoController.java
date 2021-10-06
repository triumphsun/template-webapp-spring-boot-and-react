package com.suntri.demo.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @ResponseBody
    @RequestMapping(value = {"/api/echo"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public static Map<String, String> echo(
            @RequestParam(name="name", required = true) String name) {
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return result;
    }
}
