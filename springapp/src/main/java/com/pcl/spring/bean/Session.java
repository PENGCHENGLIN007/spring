package com.pcl.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pengchenglin
 * @create 2020-07-30 10:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Session implements Serializable {
    private Integer id;
    private Integer sessionId;
    private String session;
}
