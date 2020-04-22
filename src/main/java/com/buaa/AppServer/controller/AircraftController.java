package com.buaa.AppServer.controller;


import com.buaa.AppServer.entity.Aircraft;
import com.buaa.AppServer.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/plan/v1") // This means URL's start with /plan/v1 (after Application path)
/**
 *
 * @className: com.buaa.AppServer.controller.AircraftController
 * @description: Controller for aircraft
 * @author: baiterry
 * @date: 2020/4/22
 *
 **/
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircraft")
    /**
     * @description: GET /aircraft?user_id=***
     * @param: request param
     * @return: a JSON with the aircrafts
     * @date: 2020/4/22
     */
    public Iterable<Aircraft> getAircrafts(@RequestParam(defaultValue = "") Integer user_id) {
        if (user_id == null)        // if absent, return all
            return aircraftService.getAll();
        return aircraftService.findByUserId(user_id);
    }

    @PostMapping("/aircraft")
    /**
     * @description: POST /aircraft
     * @param: request body
     * @return: String of aircraft_id
     * @date: 2020/4/22
     */
    public Integer addAircraft(@RequestBody Aircraft aircraft) {
        aircraftService.add(aircraft);
        return aircraft.getAircraftId();
    }

    @PutMapping("/aircraft")
    /**
     * @description: PUT /aircraft
     * @param: request body
     * @return: String of aircraft_id
     * @date: 2020/4/22
     */
    public Integer updateAircraft(@RequestBody Aircraft aircraft) {
        aircraftService.update(aircraft);
        return aircraft.getAircraftId();
    }

    @DeleteMapping("/aircraft")
    /**
     * @description: DELETE /aircraft?aircraft_id=***
     * @param: request param
     * @return: String of aircraft_id
     * @date: 2020/4/22
     */
    public Integer deleteAircraft(@RequestParam Integer aircraft_id) {
        aircraftService.delete(aircraft_id);
        return aircraft_id;
    }
}
