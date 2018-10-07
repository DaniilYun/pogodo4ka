package com.popa.pogodo4ka.service;

import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.dao.UserDao;
import com.popa.pogodo4ka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidServiceImpl implements ValidService {
    @Autowired
    UserDao userDao;
    @Autowired
    AdService adService;

    @Override
    public String isValid(Ad ad)  {
        User user = userDao.getUserByKey(ad.getUser().getName());
        if (user!=null) {
            if (user.getPassword().toString().equals(ad.getUser().getPassword())){
                if (user.isRoot()){
                    if (ad.getPogoda()!=null && ad.getPogoda().getTemperature()!=0
                            && ad.getPogoda().getCloudy()!=null && ad.getPogoda().getWind()!=0) {
                        adService.createAd(ad);
                        return "success";
                    }else return "enter all weather conditions";
                }else return "not root";
            } else return "wrong password";
        }else return "wrong username";
    }
}
