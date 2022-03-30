package cn.nwinfo.exhibition.entity;

/**
 * 留言板
 */
public class MessageBoard {

    String id;
    String name;
    String phone;
    String title;
    String demand;
    String time;
    String isElectrify;

    @Override
    public String toString() {
        return "MessageBoard{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", demand='" + demand + '\'' +
                ", time='" + time + '\'' +
                ", isElectrify='" + isElectrify + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIsElectrify() {
        return isElectrify;
    }

    public void setIsElectrify(String isElectrify) {
        this.isElectrify = isElectrify;
    }
}
