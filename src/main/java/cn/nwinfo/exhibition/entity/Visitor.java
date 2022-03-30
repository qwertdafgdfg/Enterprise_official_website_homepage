package cn.nwinfo.exhibition.entity;

/**
 * 访客
 */
public class Visitor {
    String id;

    String ip;
    String address;
    String country;
    String area;
    String region;
    String city;
    String county;
    String time;
    String clicks;
    String eevice;
    String isp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public String getEevice() {
        return eevice;
    }

    public void setEevice(String eevice) {
        this.eevice = eevice;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id='" + id + '\'' +
                ", ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", area='" + area + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", time='" + time + '\'' +
                ", clicks='" + clicks + '\'' +
                ", eevice='" + eevice + '\'' +
                ", isp='" + isp + '\'' +
                '}';
    }
}