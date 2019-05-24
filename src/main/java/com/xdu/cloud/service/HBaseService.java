package com.xdu.cloud.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Scan;

import java.util.List;
import java.util.Map;

/**
 * HBase数据库基本操作
 */
public interface HBaseService {

    /**
     * 连接
     */
    void getConnection(Configuration conf);

    /**
     * 创建表
     * create <table>, {NAME => <column family>, VERSIONS => <VERSIONS>}
     * shell command: create ‘user’, ‘cf1’
     */
    boolean creatTable(String tableName, List<String> columnFamily);

    /**
     * 查询库中所有表的表名
     * shell command: list
     */
    List<String> getAllTableNames();

    /**
     * 条件查询
     */
    Map<String, Map<String, String>> queryData(String tableName,
                                               Scan scan);
    /**
     * 遍历查询指定表中的所有数据
     * shell command: scan 'user'
     */
    public Map<String, Map<String, String>> getResultScanner(String tableName);

    /**
     * 根据tableName和rowKey精确查询行数据
     */
    Map<String, String> getRowData(String tableName, String rowKey);

    /**
     * 为表添加 or 更新数据
     */
    void putData(String tableName, String rowKey, String familyName, String[] columns, String[] values);
}
