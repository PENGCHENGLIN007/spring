package com.pcl.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author pengchenglin
 * @create 2020-07-22 14:44
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSession implements Serializable {
    private int id;
    private int userId;
    private int sessionId;


}
