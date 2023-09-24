package com.ruoyi.business.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: Husp
 * @date: 2023/9/23 22:28
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class idBandCard {

    // 账户
    private String cardNo;

    //开户日期
//    @JSONField(format = "yyyy/MM/dd")
    private LocalDate openDate;

    // 账户余额
    private BigDecimal balance;
}
