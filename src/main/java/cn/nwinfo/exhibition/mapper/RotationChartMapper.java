package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.RotationChart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface RotationChartMapper {
    Link findByIp(@Param("ip") String ip);

    int add(RotationChart rotationChart);

    int deleteById(RotationChart rotationChart);

    List<RotationChart> findBySearchStr(@Param("searchStr") String searchStr);

    RotationChart findById(@Param("id") String id);

    List<RotationChart> findByAll();

    List<RotationChart> selectPage();

    int updateById(RotationChart rotationChart);

//    List<RotationChart> findByHot();

}
