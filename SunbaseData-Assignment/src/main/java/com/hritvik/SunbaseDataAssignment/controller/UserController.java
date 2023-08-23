package com.hritvik.SunbaseDataAssignment.controller;


import com.hritvik.SunbaseDataAssignment.model.dto.LoginDto;
import com.hritvik.SunbaseDataAssignment.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    final String url="https://qa2.sunbasedata.com/sunbase/portal/api/assignment.jsp";


        @PostMapping("/get_token")
        public ResponseEntity<?> getToken(@RequestBody  LoginDto login) {

            String uri="https://qa2.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
            System.out.print(uri);
            ResponseEntity<String> result = restTemplate.postForEntity(uri, login, String.class);
            return result;

        }

       @GetMapping("/all_list")
        public ResponseEntity<?> getAllCustomer(@RequestHeader("Authorization") String token,
                                                @RequestParam("cmd") String str) {

           RestTemplate restTemplate = new RestTemplate();
           HttpHeaders headers = new HttpHeaders();

           headers.set("Authorization", "Bearer " + token);
           headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
           String requestJson = "{}";
           HttpEntity <String> entity = new HttpEntity <> (requestJson, headers);
           ResponseEntity <String> response = restTemplate.exchange(url+"?cmd="+str, HttpMethod.GET, entity, String.class);


           return response;
        }

        @PostMapping("/delete_customer")
        public ResponseEntity<?> deleteCustomer(@RequestHeader("Authorization") String token,
                                                @RequestParam("cmd") String str,
                                                @RequestParam("uuid") String uuid) {


            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            headers.set("Authorization", "Bearer " + token);
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            String requestJson = "{}";
            HttpEntity <String> entity = new HttpEntity <> (requestJson, headers);
            System.out.println(url+"?cmd="+str+"&uuid="+uuid);
            ResponseEntity <String> response = restTemplate.exchange(url+"?cmd="+str+"&uuid="+uuid, HttpMethod.POST, entity, String.class);
            return response;

        }

 /*
 Post mapping for create user
  */
    @PostMapping("/create_customer")
    public ResponseEntity<?> deleteCustomer(@RequestHeader("Authorization") String token,
                                            @RequestParam("cmd") String str ,
                                             @RequestBody UserDto user ) {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        String requestJson = String.valueOf(user);
        HttpEntity <UserDto> entity = new HttpEntity <> (user, headers);
            System.out.println(url+"?cmd="+str);
        ResponseEntity <String> response = restTemplate.exchange(url+"?cmd="+str, HttpMethod.POST,entity, String.class);
        return response;

    }



    @PostMapping("/update_customer")
    public ResponseEntity<?> deleteCustomer(@RequestHeader("Authorization") String token,
                                            @RequestParam("cmd") String str ,
                                            @RequestParam("uuid") String uuid,
                                            @RequestBody UserDto user ) {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//        String requestJson = String.valueOf(user);
        HttpEntity <UserDto> entity = new HttpEntity <> (user, headers);
        System.out.println(url+"?cmd="+str+"&uuid="+uuid);
        ResponseEntity <String> response = restTemplate.exchange(url+"?cmd="+str+"&uuid="+uuid, HttpMethod.POST,entity, String.class);
        return response;

    }







}
