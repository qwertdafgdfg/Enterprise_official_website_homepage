package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Advantage;
import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findById(@Param("Id") String Id);
    int add(User user);
    int updateById(User user);
    int deleteById(User user);
    List<User> selectPage();
    List<User> findBySearchStr(@Param("searchStr") String searchStr);

}
