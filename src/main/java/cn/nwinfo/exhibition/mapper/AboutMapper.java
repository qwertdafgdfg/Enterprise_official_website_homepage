package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.About;
import cn.nwinfo.exhibition.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface AboutMapper {

    int add(About about);
    int deleteById(About about);
    List<About> findBySearchStr(@Param("searchStr") String searchStr);
    About findById(@Param("id") String id);
    List<About> findByAll();
    List<About> selectPage();
    int updateById(About about);
    List<About> findByHot();

}
