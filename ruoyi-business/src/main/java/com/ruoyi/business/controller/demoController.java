package com.ruoyi.business.controller;

import com.ruoyi.business.domain.vo.User;
import com.ruoyi.business.domain.vo.idBandCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Husp
 * @date: 2023/9/24 17:46
 */
@RestController
public class demoController {

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long id){
        List<idBandCard> idBandCardList = new ArrayList<>();

        LocalDate date1 = LocalDate.of(1998, 8, 29);
        idBandCard idBandCard1 = new idBandCard("36220019980000", date1, new BigDecimal("100.50"));
        idBandCardList.add(idBandCard1);

        LocalDate date2 = LocalDate.of(1998, 8, 29);
        idBandCard idBandCard2 = new idBandCard("362200199800001", date2, new BigDecimal("200.50"));
        idBandCardList.add(idBandCard2);

        return new User(1001L, "天聋八步", idBandCardList);
    }
}
