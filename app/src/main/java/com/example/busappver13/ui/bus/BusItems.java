package com.example.busappver13.ui.bus;

import android.os.Parcel;
import android.os.Parcelable;

public class BusItems implements Parcelable {
    private String routeNm,nodeNm,nodeId,routeTp,vehicleNo,cityCode,cityName,routeId,routeNo,endNodeNm,startNodeNm,endVehicleTime,startVehicleTime,totalCount;

    public BusItems() {

    }

    public void setRouteNm(String routeNm){
        this.routeNm=routeNm;
    }

    public void setNodeNm(String nodeNm){
        this.nodeNm=nodeNm;
    }

    public void setNodeId(String nodeId){
        this.nodeId=nodeId;
    }

    public void setRouteTp(String routeTp){
        this.routeTp=routeTp;
    }

    public void setVehicleNo(String vehicleNo){
        this.vehicleNo=vehicleNo;
    }

    public void setCityCode(String cityCode){
        this.cityCode=cityCode;
    }

    public void setCityName(String cityName){
        this.cityName=cityName;
    }

    public void setEndNodeNm(String endNodeNm) {
        this.endNodeNm = endNodeNm;
    }

    public void setEndVehicleTime(String endVehicleTime) {
        this.endVehicleTime = endVehicleTime;
    }

    public void setRouteNo(String routeNo) {
        this.routeNo = routeNo;
    }

    public void setStartNodeNm(String startNodeNm) {
        this.startNodeNm = startNodeNm;
    }

    public void setStartVehicleTime(String startVehicleTime) {
        this.startVehicleTime = startVehicleTime;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getRouteNm(){
        return routeNm;
    }

    public String getNodeNm(){
        return nodeNm;
    }

    public String getNodeId(){
        return nodeId;
    }

    public String getRouteTp(){
        return routeTp;
    }

    public String getVehicleNo(){
        return vehicleNo;
    }

    public String getCityCode(){
        return cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getEndNodeNm() {
        return endNodeNm;
    }

    public String getEndVehicleTime() {
        return endVehicleTime;
    }

    public String getRouteNo() {
        return routeNo;
    }

    public String getStartNodeNm() {
        return startNodeNm;
    }

    public String getStartVehicleTime() {
        return startVehicleTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getTotalCount() {
        return totalCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(routeNm);
        dest.writeString(nodeNm);
        dest.writeString(nodeId);
        dest.writeString(routeTp);
        dest.writeString(vehicleNo);
        dest.writeString(cityCode);
        dest.writeString(cityName);
        dest.writeString(routeId);
        dest.writeString(routeNo);
        dest.writeString(endNodeNm);
        dest.writeString(startNodeNm);
        dest.writeString(endVehicleTime);
        dest.writeString(startVehicleTime);
        dest.writeString(totalCount);
    }
    public BusItems(Parcel source){
        routeNm=source.readString();
        nodeNm=source.readString();
        nodeId=source.readString();
        routeTp=source.readString();
        vehicleNo=source.readString();
        cityCode=source.readString();
        cityName=source.readString();
        routeId=source.readString();
        routeNo=source.readString();
        endNodeNm=source.readString();
        startNodeNm=source.readString();
        endVehicleTime=source.readString();
        startVehicleTime=source.readString();
        totalCount=source.readString();
    }
    public static final Parcelable.Creator CREATOR=new Parcelable.Creator(){
        @Override
        public BusItems createFromParcel(Parcel source) {
            return new BusItems(source);
        }

        @Override
        public BusItems[] newArray(int size) {
            return new BusItems[0];
        }
    };
}
