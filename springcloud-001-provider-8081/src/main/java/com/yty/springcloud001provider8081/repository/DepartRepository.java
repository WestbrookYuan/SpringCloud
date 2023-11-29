package com.yty.springcloud001provider8081.repository;

import com.yty.springcloud001provider8081.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
