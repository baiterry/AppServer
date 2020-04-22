package com.buaa.AppServer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
/**
 *
 * @className: com.buaa.AppServer.entity.Aircraft
 * @description: DO(entity) for aircraft
 * @author: baiterry
 * @date: 2020/4/22
 *
 **/
public class Aircraft {

    @JsonProperty("aircraft_id")
    private Integer aircraftId;

    @JsonProperty("user_id")
    private Integer userId;

    private String model;

    private String number;

    private String address;

    private String devices;

}
