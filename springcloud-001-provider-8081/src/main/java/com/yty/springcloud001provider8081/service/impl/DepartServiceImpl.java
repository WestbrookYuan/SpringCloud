package com.yty.springcloud001provider8081.service.impl;

import com.yty.springcloud001provider8081.bean.Depart;
import com.yty.springcloud001provider8081.repository.DepartRepository;
import com.yty.springcloud001provider8081.service.DepartService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Service
public class DepartServiceImpl implements DepartService {
    @Resource
    private DepartRepository departRepository;
    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        return !Objects.isNull(obj);
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if (departRepository.existsById(id)){
            departRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean modifyDepartById(Depart depart) {
        Depart obj = departRepository.save(depart);
        return !Objects.isNull(obj);
    }

    @Override
    public Depart getDepartById(Integer id) {
        if (departRepository.existsById(id)){
            Depart depart = departRepository.getReferenceById(id);
            return depart;
        }
        Depart depart = new Depart();
        depart.setName("no such depart");
        return depart;
    }

    @Override
    public List<Depart> getAllDeparts() {
        return departRepository.findAll();
    }
}
