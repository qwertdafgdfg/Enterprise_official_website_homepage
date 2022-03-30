package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface ExampleMapper {

    int add(Example example);
    int deleteById(Example example);
    List<Example> findBySearchStr(@Param("searchStr") String searchStr);
    Example findById(@Param("id") String id);
    List<Example> findByAll();
    List<Example> selectPage(Example example);
    int updateById(Example example);
    List<Example> findByHot();

}
