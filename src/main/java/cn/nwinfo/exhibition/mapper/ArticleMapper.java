package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface ArticleMapper {

    int add(Article article);
    int deleteById(Article article);
    List<Article> findBySearchStr(@Param("searchStr") String searchStr);
    Article findById(@Param("id") String id);
    List<Article> findByAll();
    List<Article> selectPage(Article article);
    int updateById(Article article);
    List<Article> findByHot();

}
