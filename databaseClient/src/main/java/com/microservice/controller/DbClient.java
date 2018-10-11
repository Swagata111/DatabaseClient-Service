package com.microservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@RestController
public class DbClient 
{
	
	
    @Autowired
    private LoadBalancerClient loadBalancer;
    //private DiscoveryClient discoveryClient;
    @RequestMapping("/home")
    public Object getOdi() throws RestClientException,IOException
    {
    	ServiceInstance serviceInstance=loadBalancer.choose("DB-PRODUCER");
    	//String baseUrl=serviceInstance.getUri().toString();
    	
       // ServiceInstance serviceInstance=(ServiceInstance) instances.get(0);
        String baseUrl=serviceInstance.getUri().toString()+"/";
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response=null;
        try
        {
            response=restTemplate.exchange(baseUrl,HttpMethod.GET, getHeaders(), String.class);                                                
        }
        catch (Exception ex)
        {
        	System.out.println(response.getBody());            
        }
        
        return  response.getBody();
    }
    public HttpEntity<?> getHeaders()
    {
        HttpHeaders headers=new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);              
    }
}

