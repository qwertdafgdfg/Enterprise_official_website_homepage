package cn.nwinfo.exhibition.entity;

public class SeoSetup {
    String id;
    String title;
    String keyword;
    String intro;
    String position;
    String time;

    @Override
    public String toString() {
        return "SeoSetup{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", keyword='" + keyword + '\'' +
                ", intro='" + intro + '\'' +
                ", position='" + position + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
