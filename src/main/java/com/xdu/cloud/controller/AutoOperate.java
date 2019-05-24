package com.xdu.cloud.controller;

import com.xdu.cloud.service.HBaseService;
import com.xdu.cloud.service.Impl.HBaseServiceImpl;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Map;

@Controller
@EnableScheduling
public class AutoOperate {

    @Scheduled(cron = "*/30 * * * * ?")
    public void operate(){
        System.err.println("执行中。。。");
        if (hBaseService!=null)
            System.err.println("注入成功");
        hBaseService.creatTable("test_base", Arrays.asList("f", "back"));
    }
    @Value("${HBase.nodes}")
    private String nodes;
    @Value("${HBase.maxsize}")
    private String maxsize;

    @Autowired
    HBaseService hBaseService;

   /* public void config(){
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",nodes );
        conf.set("hbase.client.keyvalue.maxsize",maxsize);
        hbaseAPI = new HBaseServiceImpl();
        hbaseAPI.getConnection(conf);

        hbaseAPI.putData("test_base", "66804_000001", "f", new String[] {
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time" }, new String[] { "40866", "mob_3", "0.9416",
                "0.0000", "12.2293", "null" });
        hbaseAPI.putData("test_base", "66804_000002", "f", new String[] {
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time" }, new String[] { "40866", "idno_prov", "0.9317",
                "0.0000", "9.8679", "null" });
        hbaseAPI.putData("test_base", "66804_000003", "f", new String[] {
                "project_id", "varName", "coefs", "pvalues", "tvalues",
                "create_time" }, new String[] { "40866", "education", "0.8984",
                "0.0000", "25.5649", "null" });

        // 查询数据
        // 1. 根据rowKey查询
        Map<String, String> result1 = hbaseAPI.getRowData("test_base",
                "66804_000001");
        System.out.println("+++++++++++根据rowKey查询+++++++++++");
        result1.forEach((k, value) -> {
            System.out.println(k + "---" + value);
        });
        System.out.println();
    }

    // 创建表


    // 插入三条数据
*/

}
