package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.OtherImg;
import cn.nwinfo.exhibition.entity.RotationChart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface OtherImgMapper {
    Link findByIp(@Param("ip") String ip);

    int add(OtherImg rotationChart);

    int deleteById(OtherImg rotationChart);

    List<OtherImg> findBySearchStr(@Param("searchStr") String searchStr);

    OtherImg findById(@Param("id") String id);

    List<OtherImg> findByAll();

    List<OtherImg> selectPage();

    int updateById(OtherImg rotationChart);

//    List<RotationChart> findByHot();

}
