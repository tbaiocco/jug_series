package com.sap.jugSession.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class SimpleRestController
{
    @GetMapping("/")
    @ApiOperation("This is the home endpoint...")
    public String home() {
        return "The root URI";
    }

    @GetMapping("/hi")
    @ApiOperation(value = "Say hi to you!", produces = "A String... 'Hi NSC JUG'")
    public String sayHi(@RequestParam(value = "name", defaultValue = "NSC JUG") String name) {
        return String.format("Hi %s!", name);
    }
}
