# XDUCloud
车辆信息处理平台

# 接口说明
## 车辆信息查询模块：
### /searchByEID
根据电子车牌查询接口 
#### 接口方法
GET  
#### 接口说明
根据传入的的电子车牌（eid）查询车辆信息（车牌、车主、出现时间、出现地点ID、出现地点名称、经纬度）  
#### 参数说明
参数 | 说明 |  备注  
-|-|-
eid | 电子车牌 | required |
#### 返回结果
``` 
待定
```
### /searchByPlaceID
根据采集地点ID查询接口
#### 接口方法
GET  
#### 接口说明
待定
根据传入的的地点ID（placeId）以及时间段（timeStart、timeEnd）查询车辆信息（车牌、车主、出现时间、出现地点ID、出现地点名称、经纬度）  
#### 参数说明
参数 | 说明 |  备注  
-|-|-
placeId | 地点ID | required |
timeStart | 开始时间 | required |
timeEnd | 结束时间 | required |
#### 返回结果
``` 
待定
```
### /searchByAddress
根据采集地点名称查询接口
#### 接口方法
GET  
#### 接口说明
根据传入的的地点名称（address）以及时间段（timeStart、timeEnd）查询车辆信息（车牌、车主、出现时间、出现地点ID、出现地点名称、经纬度）  
#### 参数说明
参数 | 说明 |  备注  
-|-|-
address | 地点名称 | required |
timeStart | 开始时间 | required |
timeEnd | 结束时间 | required |
#### 返回结果
``` 
待定
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
待定
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
待定
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
