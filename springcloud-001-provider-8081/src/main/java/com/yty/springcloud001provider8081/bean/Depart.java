package com.yty.springcloud001provider8081.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Getter
@Setter
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID自动递增
    private Integer id;
    private String name;
}
