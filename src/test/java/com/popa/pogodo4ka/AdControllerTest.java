package com.popa.pogodo4ka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.model.City;
import com.popa.pogodo4ka.model.Pogoda;
import com.popa.pogodo4ka.model.User;
import com.popa.pogodo4ka.service.AdService;
import com.popa.pogodo4ka.service.ValidService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdController.class)
public class AdControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ValidService validService;

    @MockBean
    AdService adService;


    @Test
    public void controllerShouldReturnMessageFromService() throws Exception {
        Pogoda pogoda = new Pogoda(37,"облачно с прояснениями ",6);
        City city = new City("Moscow");
        String date = "04.10";
        Ad ad = new Ad(new User("oleg", "pppp"),city,date);
        ObjectMapper mapper = new ObjectMapper();
        given(adService.findByCityAndData(city,date)).willReturn(pogoda);
        this.mockMvc.perform(post("http://localhost:8080/ads/").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(new Ad(new User("oleg", "pppp"),city,date))))
                .andExpect(status().isOk());
    }
    @Test
    public void controllerShouldReturnMessageFromServicea() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Pogoda pogoda = new Pogoda(37,"облачно с прояснениями ",6);
        City city = new City("Moscow");
        String date = "04.10";
        when(this.validService.isValid(new Ad(new User("oleg", "pppp"),city,date,pogoda))).thenReturn("success");
        this.mockMvc.perform(post("http://localhost:8080/ads/add").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(new Ad(new User("oleg", "pppp"),city,date,pogoda))))
                .andExpect(status().isOk());
    }

}