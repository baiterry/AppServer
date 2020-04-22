package com.buaa.AppServer.service;

import com.buaa.AppServer.entity.Aircraft;
import com.buaa.AppServer.mapper.AircraftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
@Service
/**
 *
 * @className: com.buaa.AppServer.service.AircraftService
 * @description: Service implementation for aircraft
 * @author: baiterry
 * @date: 2020/4/22
 *
 **/
public class AircraftService {

    @Autowired
    private AircraftMapper aircraftMapper;

    /**
     * @description: get all aircrafts
     * @param: []
     * @return: java.util.List<com.buaa.AppServer.entity.Aircraft>
     * @date: 2020/4/22
     */
    public List<Aircraft> getAll() {
        return aircraftMapper.getAll();
    }

    /**
     * @description: get aircrafts by user_id
     * @param: [id: user_id]
     * @return: java.util.List<com.buaa.AppServer.entity.Aircraft>
     * @date: 2020/4/22
     */
    public List<Aircraft> findByUserId(Integer id) {
        return aircraftMapper.findByUserId(id);
    }

    /**
     * @description: get aircrafts by aircraft_id
     * @param: [id: aircraft_id]
     * @return: com.buaa.AppServer.entity.Aircraft
     * @date: 2020/4/22
     */
    public Aircraft findById(Integer id) {
        return aircraftMapper.findById(id);
    }

    /**
     * @description: add a aircraft
     * @param: com.buaa.AppServer.entity.Aircraft
     * @return: int aircraft_id
     * @date: 2020/4/22
     */
    public int add(Aircraft aircraft) {
        return aircraftMapper.add(aircraft);
    }

    /**
     * @description: delete a aircraft by aircraft_id
     * @param: [id: aircraft_id]
     * @return: [id: aircraft_id]
     * @date: 2020/4/22
     */
    public int delete(Integer id) {
        return aircraftMapper.delete(id);
    }

    /**
     * @description: update a aircraft
     * @param: com.buaa.AppServer.entity.Aircraft
     * @return: int aircraft_id
     * @date: 2020/4/22
     */
    public int update(Aircraft aircraft) {
        // get old record
        int id = aircraft.getAircraftId();
        Aircraft originAircraft = findById(id);

        // fill the absent attributes with the old
        for (Field field : Aircraft.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(aircraft) == null)
                    field.set(aircraft, field.get(originAircraft));
            } catch (IllegalAccessException e) {
                log.info("access field of Aircraft.class: " + field + " FAILED!");
            }
        }

        return aircraftMapper.update(aircraft);
    }
}
