package cn.nwinfo.exhibition.entity;

/**
 * 产品分类
 */
public class ProductCategory {
    String id;
    String name;

    @Override
    public String toString() {
        return "ArticleCategory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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
}
