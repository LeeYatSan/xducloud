package com.xdu.cloud.common;

import com.xdu.cloud.service.HBaseService;
import com.xdu.cloud.service.Impl.HBaseServiceImpl;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HBaseConfig {
    //HBase相关配置
    @Value("${HBase.nodes}")
    private String nodes;
    @Value("${HBase.maxsize}")
    private String maxsize;

    @Bean
    public HBaseService getHbaseService(){
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",nodes );
        conf.set("hbase.client.keyvalue.maxsize",maxsize);
        return new HBaseServiceImpl();
    }
}