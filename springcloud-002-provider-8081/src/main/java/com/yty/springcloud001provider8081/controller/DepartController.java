package com.yty.springcloud001provider8081.controller;

import com.yty.springcloud001provider8081.bean.Depart;
import com.yty.springcloud001provider8081.service.DepartService;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@RequestMapping("/provider/depart")
@RestController
public class DepartController {
    @Resource
    private DepartService service;
    @Resource
    private DiscoveryClient client;
    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart){
        return service.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean deleteHandle(@PathVariable("id") Integer id){
        return service.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandle( @RequestBody Depart depart){
        return service.modifyDepartById(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") Integer id){
        return service.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> getHandle(){
        return service.getAllDeparts();
    }


    @GetMapping("/discovery")
    public List<String> discoveryHandle(){
        // get all service names
        List<String> services = client.getServices();
        for (String serviceName : services) {
            List<ServiceInstance> instances = client.getInstances(serviceName);
            for (ServiceInstance instance : instances) {
                Map<String, Object> map = new HashMap<>();
                map.put("serviceName", serviceName);
                map.put("serviceId", instance.getServiceId());
                map.put("serviceHost", instance.getHost());
                map.put("servicePort", instance.getPort());
                map.put("serviceUri", instance.getUri());
                System.out.println(map);

            }
        }
        return services;
    }
}
