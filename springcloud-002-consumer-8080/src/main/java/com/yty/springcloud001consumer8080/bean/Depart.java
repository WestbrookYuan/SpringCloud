package com.yty.springcloud001consumer8080.bean;

import jdk.jfr.Enabled;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yty
 * @version 1.0
 * @since 1.0
 **/
@Data
@Getter
@Setter
public class Depart {
    private Integer id;
    private String name;
}
