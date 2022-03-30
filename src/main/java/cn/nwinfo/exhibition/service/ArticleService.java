package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.*;
import cn.nwinfo.exhibition.mapper.*;
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
@Service("ArticleService")
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public boolean add(Article article) {

        return articleMapper.add(article) > 0;
    }

    public boolean deleteById(Article article) {

        return articleMapper.deleteById(article) > 0;
    }

    public List<Article> findBySearchStr(String searchStr) {
        return articleMapper.findBySearchStr(searchStr);
    }

    public List<Article> findByAll() {
        return articleMapper.findByAll();
    }


    public Article findById(String id) {

        return articleMapper.findById(id);
    }

    public boolean updateById(Article article) {

        return articleMapper.updateById(article) > 0;
    }

    public PageResult findPage(Article article,PageRequest pageRequest) {

        return PageUtils.getPageResult(pageRequest, getPageInfo(article,pageRequest));
    }

    public List<Article>  findByHot() {

        return articleMapper.findByHot();
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Article> getPageInfo(Article article,PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "time" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Article> sysMenus = articleMapper.selectPage(article);
        return new PageInfo<Article>(sysMenus);
    }
}



