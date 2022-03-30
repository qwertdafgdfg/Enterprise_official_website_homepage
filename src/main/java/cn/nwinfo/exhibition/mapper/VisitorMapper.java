package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface VisitorMapper {
    Visitor findByIp(@Param("ip") String ip);

    int add(Visitor visitor);

    int deleteById(Visitor visitor);

    List<Visitor> findBySearchStr(@Param("searchStr") String searchStr);

    Visitor findById(@Param("id") String id);

    List<Visitor> findByAll();

    List<Visitor> selectPage();

    int updateById(Visitor visitor);

    List<Visitor> findByHot();

}
