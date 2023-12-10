package com.ruoyi.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author Husp
 * @Date 2023/12/9 20:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private String name;

    private LocalDateTime orderTime;

    private Double price;

}
