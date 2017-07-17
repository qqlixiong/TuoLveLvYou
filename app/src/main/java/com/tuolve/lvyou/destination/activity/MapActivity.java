package com.tuolve.lvyou.destination.activity;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.tuolve.lvyou.R;
import com.tuolve.lvyou.base.BaseActivity;
import com.tuolve.lvyou.common.LogUtil;

import butterknife.Bind;

public class MapActivity extends BaseActivity {
    private String cityName;

    @Override
    public int getLayoutId() {
        return R.layout.activity_map;
    }

    @Bind(R.id.map_view)
    public MapView mMapView;
    public BaiduMap mBaiMap;
    public LocationClient client;

    public MyLocationConfiguration.LocationMode locationMode;
    private MyBDLocationListener listener = new MyBDLocationListener();

    @Override
    public void initData() {
        super.initData();
        cityName = getIntent().getExtras().getString("cityName");
        mBaiMap = mMapView.getMap();
        mBaiMap.setTrafficEnabled(true);
        mBaiMap.setBaiduHeatMapEnabled(true);
        mBaiMap.setMyLocationEnabled(true);
        locationMode = MyLocationConfiguration.LocationMode.FOLLOWING;
        mBaiMap.setMyLocationConfigeration(new MyLocationConfiguration(locationMode, true, null));

        client = new LocationClient(getApplicationContext());
        LogUtil.i("百度地图的client被初始化了");
        client.registerLocationListener(listener);
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setCoorType("bd0911");
        option.setScanSpan(1000);
        client.setLocOption(option);
        client.start();
    }

    private class MyBDLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            LogUtil.i("百度地图的location："+bdLocation);
            if (bdLocation == null || mMapView == null) {
                return;
            }
//            MyLocationData data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(bdLocation.getLatitude()).longitude(bdLocation.getLongitude()).build();
            MyLocationData data = null;
            //latitude代表纬度     longitude代表经度
            switch (cityName){
                case "巴厘岛":
                     data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(-8.723151523802366).longitude(115.19113540649414).build();
                    break;

                case "普吉岛":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(7.883333333).longitude(98.333333333).build();
                    break;

                case "好望角":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(34.35).longitude(18.5).build();
                    break;

                case "马尔代夫":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(4.033333333).longitude(73.083333333).build();
                    break;

                case "泰国":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(13.75).longitude(100.516666667).build();
                    break;

                case "马来西亚":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(3.6777777777).longitude(101.516666667).build();
                    break;

                case "香港":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(22.25).longitude(114.25).build();
                    break;

                case "澳门":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(22.189923).longitude(113.53802).build();
                    break;

                case "台湾":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(23.434444444444).longitude(121.34555555555).build();
                    break;

                case "日本":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(38).longitude(130).build();
                    break;

                case "韩国":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(36).longitude(128).build();
                    break;

                case "朝鲜":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(39).longitude(125.5).build();
                    break;

                case "新加坡":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(103.48).longitude(122).build();
                    break;

                case "菲律宾":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(12.879721).longitude(121.774017).build();
                    break;

                case "文莱":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(4.9333333333).longitude(114.96666667).build();
                    break;

                case "东帝汶":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(8.583333333).longitude(125.5833333333).build();
                    break;

                case "印尼":
                    data = new MyLocationData.Builder().accuracy(bdLocation.getRadius()).direction(100).latitude(3).longitude(113).build();
                    break;
            }
            mBaiMap.setMyLocationData(data);
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    @Override
    public void onDestroy() {
        client.unRegisterLocationListener(listener);
        client.stop();
        mBaiMap.setMyLocationEnabled(false);
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        if(mMapView != null)mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        if(mMapView != null)mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        if(mMapView != null)mMapView.onPause();
    }
}
