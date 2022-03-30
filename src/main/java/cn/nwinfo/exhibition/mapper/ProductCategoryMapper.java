package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface ProductCategoryMapper {
    int add(ProductCategory productCategory);
    int deleteById(ProductCategory productCategory);
    List<ProductCategory> findBySearchStr(@Param("searchStr") String searchStr);
    ProductCategory findById(@Param("id") String id);
    List<ProductCategory> findByAll();
    List<ProductCategory> selectPage();
    int updateById(ProductCategory productCategory);

}
