package com.yty.springcloud001consumer8080.controller;

import com.yty.springcloud001consumer8080.bean.Depart;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/

@RequestMapping("/consumer/depart")
@RestController
public class DepartController {

    @Resource
    private RestTemplate template;

    /*
        直连方式
     */
    //  private static final String SERVICE_PROVIDER ="http://localhost:8081/provider/depart";

    /*
        微服务模式
     */
    private static final String SERVICE_PROVIDER = "http://depart-provider/provider/depart";
    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart){
        return Boolean.TRUE.equals(template.postForObject(SERVICE_PROVIDER + "/save", depart, Boolean.class));
    };

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") String id){
        template.delete(SERVICE_PROVIDER + "/del/"+id);
    }

    @PutMapping("/update/")
    public void updateHandle(@RequestBody Depart depart){
        template.put(SERVICE_PROVIDER + "/update/", depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") String id){
        return template.getForObject(SERVICE_PROVIDER + "/get/"+id, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> getHandle(){
        return template.getForObject(SERVICE_PROVIDER + "/list", List.class);
    }
}
