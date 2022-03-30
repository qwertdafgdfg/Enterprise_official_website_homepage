package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface ProductMapper {

    int add(Product product);
    int deleteById(Product product);
    List<Product> findBySearchStr(@Param("searchStr") String searchStr);
    Product findById(@Param("id") String id);
    List<Product> findByAll();
    List<Product> selectPage(Product product);
    int updateById(Product product);
    List<Product> findByHot();

    List<Product> findPageByCId(@Param("cid") String cid);
}
