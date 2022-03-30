package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.ExampleCategory;
import cn.nwinfo.exhibition.entity.ProductCategory;
import cn.nwinfo.exhibition.mapper.ExampleCategoryMapper;
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
@Service("ExampleCategoryService")
public class ExampleCategoryService {
    @Autowired
    ExampleCategoryMapper exampleCategoryMapper;

    public List<ExampleCategory> findBySearchStr(String searchStr) {
        return exampleCategoryMapper.findBySearchStr(searchStr);
    }

    public ExampleCategory findById(String userId) {

        return exampleCategoryMapper.findById(userId);
    }

    public boolean add(ExampleCategory exampleCategory) {

        return exampleCategoryMapper.add(exampleCategory) > 0;
    }

    public boolean updateById(ExampleCategory exampleCategory) {

        return exampleCategoryMapper.updateById(exampleCategory) > 0;
    }

    public boolean deleteById(ExampleCategory exampleCategory) {

        return exampleCategoryMapper.deleteById(exampleCategory) > 0;
    }

    public List<ExampleCategory> findByAll() {

        return exampleCategoryMapper.findByAll();
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
    private PageInfo<ExampleCategory> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<ExampleCategory> sysMenus = exampleCategoryMapper.selectPage();
        return new PageInfo<ExampleCategory>(sysMenus);
    }
}
