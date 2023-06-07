package com.neu.common.utils;

import java.util.UUID;

public class UUIDUtil {

     /**
      * @descriptions: 获取UUID
      * @author: FEI BO
      * @date: 2023/6/1 21:22
      * @version: 1.0
      */
    public static String getOneUUID() {
        String s = UUID.randomUUID().toString();
        return s.substring(0,8)+s.substring(9,13)+s.substring(19,23)+s.substring(24);
    }
}
