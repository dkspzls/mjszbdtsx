package com.gok.smartpark.sys.device.view;

//见<摄像头接口文档.pdf>，映射上行接口数据
public class CameraResponseView {
    private String vehicleLaneKey ;
    private String ipaddr ;
    private String license ;
    private String colorType  ;
    private String type ;
    private String confidence ;
    private String scanTime ;
    private String imageFile ;
    private String imageFragmentFile ;
    private String triggerType ;

    public String getVehicleLaneKey() {
        return vehicleLaneKey;
    }

    public void setVehicleLaneKey(String vehicleLaneKey) {
        this.vehicleLaneKey = vehicleLaneKey;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageFragmentFile() {
        return imageFragmentFile;
    }

    public void setImageFragmentFile(String imageFragmentFile) {
        this.imageFragmentFile = imageFragmentFile;
    }

    public String getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CameraResponseView{");
        sb.append("vehicleLaneKey='").append(vehicleLaneKey).append('\'');
        sb.append(", ipaddr='").append(ipaddr).append('\'');
        sb.append(", license='").append(license).append('\'');
        sb.append(", colorType='").append(colorType).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", confidence='").append(confidence).append('\'');
        sb.append(", scanTime='").append(scanTime).append('\'');
        sb.append(", imageFile='").append(imageFile).append('\'');
        sb.append(", imageFragmentFile='").append(imageFragmentFile).append('\'');
        sb.append(", triggerType='").append(triggerType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
