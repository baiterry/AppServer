package com.buaa.AppServer.mapper;

import com.buaa.AppServer.entity.Aircraft;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/**
 *
 * @interfaceName: com.buaa.AppServer.mapper.AircraftMapper
 * @description: Mapper for aircrafts
 * @author: baiterry
 * @date: 2020/4/22
 *
 **/
public interface AircraftMapper {

    /**
     * @description: get all aircrafts
     * @param: []
     * @return: java.util.List<com.buaa.AppServer.entity.Aircraft>
     * @date: 2020/4/22
     */
    List<Aircraft> getAll();


    /**
     * @description: get aircrafts by user_id
     * @param: [id: user_id]
     * @return: java.util.List<com.buaa.AppServer.entity.Aircraft>
     * @date: 2020/4/22
     */
    List<Aircraft> findByUserId(Integer id);

    /**
     * @description: get the aircraft by aircraft_id
     * @param: [id: aircraft_id]
     * @return: com.buaa.AppServer.entity.Aircraft
     * @date: 2020/4/22
     */
    Aircraft findById(Integer id);

    /**
     * @description: add a aircraft
     * @param: com.buaa.AppServer.entity.Aircraft
     * @return: int aircraft_id
     * @date: 2020/4/22
     */
    int add(Aircraft aircraft);

    /**
     * @description: delete a aircraft by aircraft_id
     * @param: [id: aircraft_id]
     * @return: [id: aircraft_id]
     * @date: 2020/4/22
     */
    int delete(Integer id);

    /**
     * @description: update a aircraft
     * @param: com.buaa.AppServer.entity.Aircraft
     * @return: int aircraft_id
     * @date: 2020/4/22
     */
    int update(Aircraft aircraft);
}
