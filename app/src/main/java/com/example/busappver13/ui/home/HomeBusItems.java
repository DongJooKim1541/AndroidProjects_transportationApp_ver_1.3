package com.example.busappver13.ui.home;

public class HomeBusItems {
    private String totalCount,nodeNm,vehicleNo;
    private boolean isSaved;

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public void setNodeNm(String nodeNm) {
        this.nodeNm = nodeNm;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public String getNodeNm() {
        return nodeNm;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public boolean isSaved() {
        return isSaved;
    }
}
