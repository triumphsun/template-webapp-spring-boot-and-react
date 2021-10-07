package com.suntri.demo.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Failure")
    })
    @ResponseBody
    @RequestMapping(value = {"/api/echo"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public static ResponseEntity<Map<String, String>> echo(
            @Parameter()  @RequestParam(name="name", required = true) String name) {
        Map<String, String> result = new HashMap<>();
        result.put("name", name);
        result.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
