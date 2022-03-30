package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Visitor;
import cn.nwinfo.exhibition.mapper.ArticleMapper;
import cn.nwinfo.exhibition.mapper.VisitorMapper;
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
@Service("VisitorService")
public class VisitorService {
    @Autowired
    VisitorMapper visitorMapper;

    public boolean add(Visitor visitor) {

        return visitorMapper.add(visitor) > 0;
    }

    public boolean deleteById(Visitor visitor) {

        return visitorMapper.deleteById(visitor) > 0;
    }

    public List<Visitor> findBySearchStr(String searchStr) {
        return visitorMapper.findBySearchStr(searchStr);
    }

    public List<Visitor> findByAll() {
        return visitorMapper.findByAll();
    }


    public Visitor findById(String id) {

        return visitorMapper.findById(id);
    }
    public Visitor findByIp(String ip) {

        return visitorMapper.findByIp(ip);
    }

    public boolean updateById(Visitor visitor) {

        return visitorMapper.updateById(visitor) > 0;
    }

    public PageResult findPage(PageRequest pageRequest) {

        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    public List<Visitor>  findByHot() {

        return visitorMapper.findByHot();
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Visitor> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "time" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Visitor> sysMenus = visitorMapper.selectPage();
        return new PageInfo<Visitor>(sysMenus);
    }
}



