package com.city.path.route.controller;

import com.city.path.route.business.PathFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PathFinder {

  @Autowired
  private PathFinderService pathFinderService;

    @GetMapping("/connected")
    @ResponseBody
    public String checkPathExistsBetweenCities(@RequestParam String origin, @RequestParam String destination){
        return pathFinderService.pathBetweenCities(origin,destination);
    }

}
