package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.MessageBoard;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.entity.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface NoticeMapper {
    Notice findByIp(@Param("ip") String ip);

    int add(Notice notice);

    int deleteById(Notice notice);

    List<Notice> findBySearchStr(@Param("searchStr") String searchStr);

    Notice findById(@Param("id") String id);

    List<Notice> findByAll();

    List<Notice> selectPage();

    int updateById(Notice notice);

    List<Notice> findByHot();

}
