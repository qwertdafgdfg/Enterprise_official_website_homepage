package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Product;
import cn.nwinfo.exhibition.mapper.ArticleMapper;
import cn.nwinfo.exhibition.mapper.ProductMapper;
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
@Service("ProductService")
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public List<Product>  findByHot() {

        return productMapper.findByHot();
    }

    public boolean add(Product product) {

        return productMapper.add(product) > 0;
    }

    public boolean deleteById(Product product) {

        return productMapper.deleteById(product) > 0;
    }

    public List<Product> findBySearchStr(String searchStr) {
        return productMapper.findBySearchStr(searchStr);
    }

    public List<Product> findByAll() {
        return productMapper.findByAll();
    }


    public Product findById(String id) {

        return productMapper.findById(id);
    }

    public boolean updateById(Product product) {

        return productMapper.updateById(product) > 0;
    }

    public Object findPageByCId(String cid,PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo1(cid,pageRequest));
    }
    public PageResult findPage(Product product,PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(product,pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Product> getPageInfo1(String cid,PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "time" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Product> sysMenus = productMapper.findPageByCId(cid);
        return new PageInfo<Product>(sysMenus);
    }
    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Product> getPageInfo(Product product,PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "time" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Product> sysMenus = productMapper.selectPage(product);
        return new PageInfo<Product>(sysMenus);
    }

}



