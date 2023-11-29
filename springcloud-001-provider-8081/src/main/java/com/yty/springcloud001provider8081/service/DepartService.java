package com.yty.springcloud001provider8081.service;

import com.yty.springcloud001provider8081.bean.Depart;

import java.util.List;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
public interface DepartService {
    boolean saveDepart(Depart depart);
    boolean removeDepartById(Integer id);
    boolean modifyDepartById(Depart depart);
    Depart getDepartById(Integer id);
    List<Depart> getAllDeparts();
}
