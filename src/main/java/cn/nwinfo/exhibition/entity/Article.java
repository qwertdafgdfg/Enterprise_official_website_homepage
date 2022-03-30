package cn.nwinfo.exhibition.entity;

/**
 * 文章
 */
public class Article {
    String id;
    String title;
    String keyword;
    String intro;
    String picture;
    String markdown;
    String html;
    String text;
    String time;
    String hot;
    String clicks;
    String c_id;

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", keyword='" + keyword + '\'' +
                ", intro='" + intro + '\'' +
                ", picture='" + picture + '\'' +
                ", markdown='" + markdown + '\'' +
                ", html='" + html + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                ", hot='" + hot + '\'' +
                ", clicks='" + clicks + '\'' +
                ", c_id='" + c_id + '\'' +
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public String getClicks() {
        return clicks;
    }

    public void setClicks(String clicks) {
        this.clicks = clicks;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
}
