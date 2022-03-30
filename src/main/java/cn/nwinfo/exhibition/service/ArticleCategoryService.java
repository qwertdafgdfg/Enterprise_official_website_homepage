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
@Service("ArticleCategoryService")
public class ArticleCategoryService {
    @Autowired
    ArticleCategoryMapper articleCategoryMapper;

    public List<ArticleCategory> findBySearchStr(String searchStr) {
        return articleCategoryMapper.findBySearchStr(searchStr);
    }

    public ArticleCategory findById(String userId) {

        return articleCategoryMapper.findById(userId);
    }

    public boolean add(ArticleCategory articleCategory) {

        return articleCategoryMapper.add(articleCategory) > 0;
    }

    public boolean updateById(ArticleCategory articleCategory) {

        return articleCategoryMapper.updateById(articleCategory) > 0;
    }

    public boolean deleteById(ArticleCategory articleCategory) {

        return articleCategoryMapper.deleteById(articleCategory) > 0;
    }

    public List<ArticleCategory> findByAll() {

        return articleCategoryMapper.findByAll();
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
    private PageInfo<ArticleCategory> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<ArticleCategory> sysMenus = articleCategoryMapper.selectPage();
        return new PageInfo<ArticleCategory>(sysMenus);
    }
}
