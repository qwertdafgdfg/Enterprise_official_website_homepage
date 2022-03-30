package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.mapper.LinkMapper;
import cn.nwinfo.exhibition.mapper.NoticeMapper;
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
@Service("LinkService")
public class LinkService {
    @Autowired
    LinkMapper linkMapper;

    public List<Link> findBySearchStr(String searchStr) {
        return linkMapper.findBySearchStr(searchStr);
    }

    public Link findById(String userId) {

        return linkMapper.findById(userId);
    }

    public boolean add(Link link) {

        return linkMapper.add(link) > 0;
    }

    public boolean updateById(Link link) {

        return linkMapper.updateById(link) > 0;
    }

    public boolean deleteById(Link link) {

        return linkMapper.deleteById(link) > 0;
    }

    public List<Link> findByAll() {

        return linkMapper.findByAll();
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
    private PageInfo<Link> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Link> sysMenus = linkMapper.selectPage();
        return new PageInfo<Link>(sysMenus);
    }
}
