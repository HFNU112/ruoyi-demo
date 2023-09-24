package com.ruoyi.business.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Husp
 * @date: 2023/9/23 22:26
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Long id;

    private String name;

    // 1用户：n银行卡
    private List<idBandCard> idBandCards = new ArrayList<>();

}
