package com.sujan.webclientexample.controller;

import com.sujan.webclientexample.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("/get")
    public ResponseEntity<StudentDto> getStudent()
    {
        System.out.println("Api Executed");

//        return new ResponseEntity<>(new StudentDto(1,"sujan","bachloer"),HttpStatus.OK);
        return new ResponseEntity(List.of(new StudentDto(1,"sujan","bachloer"),new StudentDto(2,"sajan","10")) , HttpStatus.OK);
    }


    @PostMapping("/post")
    public ResponseEntity<StudentDto> postStudent(@RequestBody StudentDto studentDto)
    {
        System.out.println("Post api called");
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @PostMapping("/postList")
    public ResponseEntity<StudentDto> postStudent(@RequestBody List<StudentDto> studentDto)
    {
        System.out.println("Post collection api called");
        studentDto.forEach(studentDto1 -> System.out.println(studentDto));
        return new ResponseEntity(studentDto, HttpStatus.OK);
    }


}
