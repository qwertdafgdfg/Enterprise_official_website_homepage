package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Example;
import cn.nwinfo.exhibition.mapper.ArticleMapper;
import cn.nwinfo.exhibition.mapper.ExampleMapper;
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
@Service("ExampleService")
public class ExampleService {
    @Autowired
    ExampleMapper exampleMapper;

    public boolean add(Example example) {

        return exampleMapper.add(example) > 0;
    }

    public boolean deleteById(Example example) {

        return exampleMapper.deleteById(example) > 0;
    }

    public List<Example> findBySearchStr(String searchStr) {
        return exampleMapper.findBySearchStr(searchStr);
    }

    public List<Example> findByAll() {
        return exampleMapper.findByAll();
    }


    public Example findById(String id) {

        return exampleMapper.findById(id);
    }

    public boolean updateById(Example example) {

        return exampleMapper.updateById(example) > 0;
    }

    public PageResult findPage(Example example,PageRequest pageRequest) {

        return PageUtils.getPageResult(pageRequest, getPageInfo(example,pageRequest));
    }

    public List<Example>  findByHot() {

        return exampleMapper.findByHot();
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Example> getPageInfo(Example example,PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "time" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Example> sysMenus = exampleMapper.selectPage(example);
        return new PageInfo<Example>(sysMenus);
    }
}



