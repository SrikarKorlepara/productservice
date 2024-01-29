package com.scaler.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will have multiple methods that will be serving HTTP Request at /hello
// This class will be serving Rest (HTTP) APIS
//localhost:8080/hello
@RestController // this annotation will create a bean
@RequestMapping("/hello")
public class HelloController {
    //GET /hello/

    @GetMapping("/")
    public String sayHello(){
        return "Hello.";
    }
    //GET /hello/say
    @GetMapping("/say")
    public String sayHelloThere(){
        return "Hello There.";
    }
    //GET /hello/say/name
    @GetMapping("/say/{name}")  //something in curly braces becomes a variable
    public String sayMyName(@PathVariable("name") String name){
        return "Hello " +name;
    }
    //GET /hello/say/name/times
    @GetMapping("/say/{name}/{times}")  //something in curly braces becomes a variable
    public String sayMyNameTimes(@PathVariable("name") String name,@PathVariable("times") int times) {
        String answer ="";
        for(int i =0;i<times;i++){
            answer +="Hello "+ name;
            answer +="<br>";
        }
        return answer;
    }
}

