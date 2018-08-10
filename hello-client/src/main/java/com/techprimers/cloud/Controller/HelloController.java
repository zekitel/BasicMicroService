package com.techprimers.cloud.Controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Qualifier("eurekaClient")
    @Autowired
    EurekaClient eurekaClient;



    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String hello(){

        String serviceUrl = this.getServiceUrl("hello-server");
        System.out.println(serviceUrl);
        RestTemplate restTemplate = new RestTemplate();
        String temp = restTemplate.getForObject(serviceUrl+"hello/get",String.class);
        return temp;

    }
    public String getServiceUrl(String serviceName) {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka(serviceName, false);
        return instance.getHomePageUrl();
    }
}
