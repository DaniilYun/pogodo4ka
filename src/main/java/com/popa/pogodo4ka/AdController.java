package com.popa.pogodo4ka;

import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.model.City;
import com.popa.pogodo4ka.model.Pogoda;
import com.popa.pogodo4ka.service.AdService;
import com.popa.pogodo4ka.service.ValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/ads"})
public class AdController {

    @Autowired
    AdService adService;

    @Autowired
    ValidService validService;


    @PostMapping(value = "/")
    public @ResponseBody Pogoda findByCityAndData(@RequestBody Ad ad) {
        City city = ad.getCity();
        String date = ad.getDate();
        return adService.findByCityAndData(city,date);

    }

    @PostMapping(value = "/add")
    public @ResponseBody String addAd (@RequestBody Ad currentAd) {
        return validService.isValid(currentAd);
    }


}