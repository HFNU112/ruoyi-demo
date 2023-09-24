package com.ruoyi.business.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.ruoyi.business.domain.vo.User;
import com.ruoyi.business.domain.vo.idBandCard;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Husp
 * @date: 2023/9/23 22:33
 */
public class fastJsonTest {

    private User user;
    private List<User> users = new ArrayList<>();

    private String userStr;
    private String usersStr;

    @Before
    public void initObjectAndList(){
        List<idBandCard> idBandCardList = new ArrayList<>();

        LocalDate date1 = LocalDate.of(1998, 8, 29);
        idBandCard idBandCard1 = new idBandCard("36220019980000", date1, new BigDecimal("100.50"));
        idBandCardList.add(idBandCard1);

        LocalDate date2 = LocalDate.of(1998, 8, 29);
        idBandCard idBandCard2 = new idBandCard("362200199800001", date2, new BigDecimal("200.50"));
        idBandCardList.add(idBandCard2);

        user = new User(1001L, "天聋八步", idBandCardList);

        users.add(user);
        User user2 = new User(1002L, "小徐", null);
        users.add(user2);
    }

    @Before
    public void initString(){
        userStr = "{\"id\":1001,\"idBandCards\":[{\"balance\":100.50,\"cardNo\":\"36220019980000\",\"openDate\":\"1998-08-29\"},{\"balance\":200.50,\"cardNo\":\"362200199800001\",\"openDate\":\"1998-08-29\"}],\"name\":\"天聋八步\"}";
        usersStr = "[{\"id\":1001,\"idBandCards\":[{\"balance\":100.50,\"cardNo\":\"36220019980000\",\"openDate\":\"1998-08-29\"},{\"balance\":200.50,\"cardNo\":\"362200199800001\",\"openDate\":\"1998-08-29\"}],\"name\":\"天聋八步\"},{\"id\":1002,\"name\":\"小徐\"}]";
    }

    /**
     * 序列化API
     *     1.Java对象/Map集合转为Json字符串
     *     2.List集合转为Json字符串
     */
    @Test
    public void test01(){
        String userStr = JSON.toJSONString(user);
        String usersStr = JSON.toJSONString(users);
        System.out.println(userStr);
        System.out.println(usersStr);
    }

    /**
     * 反序列化API
     *      1.Json字符串转为Java对象
     *      2.Json字符串转为List集合
     */
    @Test
    public void test02(){
        User user = JSON.parseObject(userStr, User.class);
        List<User> userList = JSON.parseArray(usersStr, User.class);
        System.out.println(userList);
    }

    /**
     * 第三方服务request请求对象，数据在request的inputstream流中，获取流中的数据
     */
    @Test
    public void test03() throws Exception {
        InputStream is = new ByteArrayInputStream(userStr.getBytes());
        Map map = JSON.parseObject(is, Map.class);
        System.out.println(map);
    }

    @Test
    public void test04(){
        String comStr = "{\n" +
                "\t\"user\":{\n" +
                "\t\t\"id\":\"\",\n" +
                "\t\t\"name\":\"\",\n" +
                "\t\t\"idBandCards\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"cardNo\":\"36220019980000\",\n" +
                "\t\t\t\"openDate\":\"1998-08-29\",\n" +
                "\t\t\t\"balance\":\"100.50\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"cardNo\":\"362200199800001\",\n" +
                "\t\t\t\"openDate\":\"1998-08-29\",\n" +
                "\t\t\t\"balance\":\"200.50\"\n" +
                "\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "}";

        Map<String, User> map = JSON.parseObject(comStr, new TypeReference<Map<String, User>>() {
        });
        System.out.println(map);
        User user = map.get("user");
        Long id = user.getId();
        List<idBandCard> cardList = user.getIdBandCards();
        String cardNo = cardList.get(0).getCardNo();
    }

    /**
     * Json字符串日期格式化
     */
    @Test
    public void test05(){
        SerializeConfig config = new SerializeConfig();
        config.put(Date.class, new SimpleDateFormatSerializer("yyyy/MM/dd HH:mm:ss"));
        String userStr = JSON.toJSONString(user, config);
        System.out.println(userStr);
    }




}
