package com.yty.springcloud001provider8081.controller;

import com.yty.springcloud001provider8081.bean.Depart;
import com.yty.springcloud001provider8081.service.DepartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
