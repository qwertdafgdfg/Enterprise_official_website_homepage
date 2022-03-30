package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.MessageBoard;
import cn.nwinfo.exhibition.entity.Visitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface MessageBoardMapper {
    Visitor findByIp(@Param("ip") String ip);

    int add(MessageBoard messageBoard);

    int deleteById(MessageBoard messageBoard);

    List<MessageBoard> findBySearchStr(@Param("searchStr") String searchStr);

    MessageBoard findById(@Param("id") String id);

    List<MessageBoard> findByAll();

    List<MessageBoard> selectPage();

    int updateById(MessageBoard messageBoard);

    List<MessageBoard> findByHot();

}
