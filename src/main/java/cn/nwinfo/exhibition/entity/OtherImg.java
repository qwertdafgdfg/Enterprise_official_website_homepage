package cn.nwinfo.exhibition.entity;

/**
 * 留言板
 */
public class OtherImg {

    String id;
    String picture;
    String content;
    String title;
    String link;
    String time;

    @Override
    public String toString() {
        return "rotationChart{" +
                "id='" + id + '\'' +
                ", picture='" + picture + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
