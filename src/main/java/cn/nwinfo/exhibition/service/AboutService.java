package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.About;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.mapper.AboutMapper;
import cn.nwinfo.exhibition.mapper.ArticleMapper;
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
@Service("AboutService")
public class AboutService {
    @Autowired
    AboutMapper aboutMapper;

    public boolean add(About article) {

        return aboutMapper.add(article) > 0;
    }

    public boolean deleteById(About article) {

        return aboutMapper.deleteById(article) > 0;
    }

    public List<About> findBySearchStr(String searchStr) {
        return aboutMapper.findBySearchStr(searchStr);
    }

    public List<About> findByAll() {
        return aboutMapper.findByAll();
    }


    public About findById(String id) {

        return aboutMapper.findById(id);
    }

    public boolean updateById(About article) {

        return aboutMapper.updateById(article) > 0;
    }

    public PageResult findPage(PageRequest pageRequest) {

        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    public List<About>  findByHot() {

        return aboutMapper.findByHot();
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<About> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "time" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<About> sysMenus = aboutMapper.selectPage();
        return new PageInfo<About>(sysMenus);
    }
}



