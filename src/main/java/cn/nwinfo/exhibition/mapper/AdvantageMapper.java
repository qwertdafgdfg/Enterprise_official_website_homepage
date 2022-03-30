package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Advantage;
import cn.nwinfo.exhibition.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface AdvantageMapper {
    Advantage findByIp(@Param("ip") String ip);

    int add(Advantage advantage);

    int deleteById(Advantage advantage);

    List<Advantage> findBySearchStr(@Param("searchStr") String searchStr);

    Advantage findById(@Param("id") String id);

    List<Advantage> findByAll();

    List<Advantage> selectPage();

    int updateById(Advantage advantage);

    List<Advantage> findByHot();

}
