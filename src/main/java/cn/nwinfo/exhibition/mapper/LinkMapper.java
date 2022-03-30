package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface LinkMapper {
    Link findByIp(@Param("ip") String ip);

    int add(Link link);

    int deleteById(Link link);

    List<Link> findBySearchStr(@Param("searchStr") String searchStr);

    Link findById(@Param("id") String id);

    List<Link> findByAll();

    List<Link> selectPage();

    int updateById(Link link);

    List<Link> findByHot();

}
