package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.ProductCategory;
import cn.nwinfo.exhibition.mapper.ArticleCategoryMapper;
import cn.nwinfo.exhibition.mapper.ProductCategoryMapper;
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
@Service("ProductCategoryService")
public class ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    public List<ProductCategory> findBySearchStr(String searchStr) {
        return productCategoryMapper.findBySearchStr(searchStr);
    }

    public ProductCategory findById(String userId) {

        return productCategoryMapper.findById(userId);
    }

    public boolean add(ProductCategory productCategory) {

        return productCategoryMapper.add(productCategory) > 0;
    }

    public boolean updateById(ProductCategory productCategory) {

        return productCategoryMapper.updateById(productCategory) > 0;
    }

    public boolean deleteById(ProductCategory productCategory) {

        return productCategoryMapper.deleteById(productCategory) > 0;
    }

    public List<ProductCategory> findByAll() {

        return productCategoryMapper.findByAll();
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
    private PageInfo<ProductCategory> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<ProductCategory> sysMenus = productCategoryMapper.selectPage();
        return new PageInfo<ProductCategory>(sysMenus);
    }
}
