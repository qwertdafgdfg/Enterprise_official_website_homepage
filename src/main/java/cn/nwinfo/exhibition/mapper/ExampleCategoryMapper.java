package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.ExampleCategory;
import cn.nwinfo.exhibition.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface ExampleCategoryMapper {
    int add(ExampleCategory exampleCategory);
    int deleteById(ExampleCategory exampleCategory);
    List<ExampleCategory> findBySearchStr(@Param("searchStr") String searchStr);
    ExampleCategory findById(@Param("id") String id);
    List<ExampleCategory> findByAll();
    List<ExampleCategory> selectPage();
    int updateById(ExampleCategory exampleCategory);

}
