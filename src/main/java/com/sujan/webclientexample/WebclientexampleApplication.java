package com.sujan.webclientexample;

import com.sujan.webclientexample.dto.StudentDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@SpringBootApplication
public class WebclientexampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebclientexampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");

        WebClient client = WebClient.create("http://localhost:8080");

//        WebClient client = WebClient.builder()
//                .baseUrl("http://localhost:8080")
//                .defaultCookie("cookieKey", "cookieValue")
//                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
//                .build();


//        StudentDto studentDto= client.get()
//                .uri("/get")
//                .retrieve()
//                .bodyToMono(StudentDto.class)
//                        .block();
//
//        System.out.println(studentDto);

//        Flux<StudentDto> studentDto = client.get()
//                .uri("/get")
//                .retrieve()
//                .bodyToFlux(StudentDto.class);
//
//        studentDto.subscribe(response-> System.out.println(response));


//        StudentDto studentDto=client.post()
//                .uri("/post")
//                .body(Mono.just(new StudentDto(1,"Sagar","masters")),StudentDto.class)
//                .retrieve()
//                .bodyToMono(StudentDto.class)
//                .block();
//
//        System.out.println(studentDto);


        Flux<StudentDto> studentDtoFlux=client.post()
                .uri("/postList")
                .body(Flux.just(new StudentDto(1,"a","a"),new StudentDto(2,"sakar","5")),StudentDto.class)
                .retrieve()
                .bodyToFlux(StudentDto.class);

        studentDtoFlux.subscribe(response-> System.out.println(studentDtoFlux));

    }
}
