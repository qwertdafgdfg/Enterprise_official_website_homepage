package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.OtherImg;
import cn.nwinfo.exhibition.entity.SeoSetup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface SeoSetupMapper {
    SeoSetup findByIp(@Param("ip") String ip);

    int add(SeoSetup rotationChart);

    int deleteById(SeoSetup rotationChart);

    List<SeoSetup> findBySearchStr(@Param("searchStr") String searchStr);

    SeoSetup findById(@Param("id") String id);

    List<SeoSetup> findByAll();

    List<SeoSetup> selectPage();

    int updateById(SeoSetup rotationChart);

//    List<RotationChart> findByHot();

}
