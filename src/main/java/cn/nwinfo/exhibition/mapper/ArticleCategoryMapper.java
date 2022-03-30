package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface ArticleCategoryMapper {
    int add(ArticleCategory articleCategory);
    int deleteById(ArticleCategory articleCategory);
    List<ArticleCategory> findBySearchStr(@Param("searchStr") String searchStr);
    ArticleCategory findById(@Param("id") String id);
    List<ArticleCategory> findByAll();
    List<ArticleCategory> selectPage();
    int updateById(ArticleCategory user);

}
