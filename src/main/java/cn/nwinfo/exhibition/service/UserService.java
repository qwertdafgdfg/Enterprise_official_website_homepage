package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Advantage;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.User;
import cn.nwinfo.exhibition.mapper.UserMapper;
import cn.nwinfo.exhibition.util.PageRequest;
import cn.nwinfo.exhibition.util.PageResult;
import cn.nwinfo.exhibition.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:52
 */
@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> findBySearchStr(String searchStr) {
        return userMapper.findBySearchStr(searchStr);
    }
    public User findByUsername(User user) {
        return userMapper.findByUsername(user.getUsername());
    }

    public User findById(String userId) {

        return userMapper.findById(userId);
    }

    public boolean add(User user) {

        return userMapper.add(user) > 0;
    }


    public boolean delete(User user) {

        return userMapper.deleteById(user) > 0;
    }

    public boolean deleteById(User user) {

        return userMapper.deleteById(user) > 0;
    }


    public boolean updateById(User user) {

        return userMapper.updateById(user) > 0;
    }

    public PageResult findPage(PageRequest pageRequest) {

        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<User> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userMapper.selectPage();
        return new PageInfo<User>(sysMenus);
    }
}
