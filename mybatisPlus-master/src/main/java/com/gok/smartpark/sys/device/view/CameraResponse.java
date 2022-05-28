package com.gok.smartpark.sys.device.view;

//见<摄像头接口文档.pdf>，映射上行接口数据
public class CameraResponse<T> {
    private String info ;
    private Integer resultCode ;
    private Integer type ;
    private String data ;


    public CameraResponse(String info, Integer resultCode, Integer type, String data) {
        this.info = info;
        this.resultCode = resultCode;
        this.type = type;
        this.data = data;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CameraResponse{");
        sb.append("info='").append(info).append('\'');
        sb.append(", resultCode='").append(resultCode).append('\'');
        sb.append(", data='").append(data).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
