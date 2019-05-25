# XDUCloud
车辆信息处理平台

# 接口说明
## 车辆信息查询模块：
### /searchByEID
根据电子车牌查询接口 
#### 接口方法
GET  
#### 接口说明
根据传入的的电子车牌（eid）查询车辆信息（出现时间、出现地点ID、出现地点名称、经纬度）  
#### 参数说明
参数 | 说明 |  备注  
-|-|-
eid | 电子车牌 | required |
#### 返回结果
``` 
{
  "data": {
      "address": "string",
      "eid": "string",
      "latitude": "string",
      "longitude": "string",
      "placeID": "string",
      "time": "2019-05-24T13:31:44.199Z"
  },
  "msg": "string",
  "ok": "string",
  "status": 0
}
```
### /searchByPlaceIDOrAddress
根据采集地点ID查询接口
#### 接口方法
GET  
#### 接口说明
待定
根据传入的的地点ID（placeId）或地点名称（address）以及时间段（timeStart、timeEnd）查询车辆信息（EID、出现时间、出现地点ID、出现地点名称、经纬度）  
#### 参数说明
参数 | 说明 |  备注  
-|-|-
idaddress | 地点ID或名称 | required |
timeStart | 开始时间 | required |
timeEnd | 结束时间 | required |
method | 方法选择 | required；boolean类型数据，true为按地点ID查询，false为按地点名称查询 |
#### 返回结果
``` 
{
  "data": {
      "placeID": "string",
      "address": "string",
      "eid": "string",
      "startTime": "2019-05-24T13:31:44.199Z",
      "endTime": "2019-05-24T13:32:44.199Z",
      "carNum": "string",
  },
  "msg": "string",
  "ok": "string",
  "status": 0
}
```
### /searchMeet
查询车辆相遇情况接口
#### 接口方法
GET  
#### 接口说明
根据传入的的电子车牌（eid）查询车辆相遇信息 
#### 参数说明
参数 | 说明 |  备注  
-|-|-
eid | 电子车牌 | required |
#### 返回结果
``` 
{
  "data": {
      "address": "string",
      "eid": "string",
      "placeID": "string",
      "startTime": "2019-05-24T13:31:44.199Z",
      "endTime": "2019-05-24T13:32:44.199Z",
      "meetEid": "string",
      "times": "string",
  },
  "msg": "string",
  "ok": "string",
  "status": 0
}
```

### /searchIllegalInfo
超范围车辆信息查询接口
#### 接口方法
GET  
#### 接口说明
直接将所有超范围非法数据展示处理（就是被Kafka过滤掉的数据）
#### 参数说明
无参数
#### 返回结果
``` 
{
  "data": {
      "address": "string",
      "eid": "string",
      "latitude": "string",
      "longitude": "string",
      "placeID": "string",
      "time": "2019-05-24T13:31:44.199Z"
  },
  "msg": "string",
  "ok": "string",
  "status": 0
}
```

## 警报模块：
我没看见这个需求啊？？？

## 轨迹重现模块：（最后搞）
### /trace
轨迹重现接口
#### 接口方法
GET  
#### 接口说明
给定电子车牌（eid）以及时间段（timeStart、timeEnd），调用百度地图实现车辆轨迹重现
#### 参数说明
参数 | 说明 |  备注  
-|-|-
eid | 电子车牌 | required |
timeStart | 开始时间 | required |
timeEnd | 结束时间 | required |
#### 返回结果
``` 
待定
```
