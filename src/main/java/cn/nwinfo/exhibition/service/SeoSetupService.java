package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.OtherImg;
import cn.nwinfo.exhibition.entity.SeoSetup;
import cn.nwinfo.exhibition.mapper.OtherImgMapper;
import cn.nwinfo.exhibition.mapper.SeoSetupMapper;
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
@Service("SeoSetupService")
public class SeoSetupService {
    @Autowired
    SeoSetupMapper seoSetupMapper;

    public List<SeoSetup> findBySearchStr(String searchStr) {
        return seoSetupMapper.findBySearchStr(searchStr);
    }

    public SeoSetup findById(String userId) {

        return seoSetupMapper.findById(userId);
    }

    public boolean add(SeoSetup link) {

        return seoSetupMapper.add(link) > 0;
    }

    public boolean updateById(SeoSetup link) {

        return seoSetupMapper.updateById(link) > 0;
    }

    public boolean deleteById(SeoSetup link) {

        return seoSetupMapper.deleteById(link) > 0;
    }

    public List<SeoSetup> findByAll() {

        return seoSetupMapper.findByAll();
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
    private PageInfo<SeoSetup> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<SeoSetup> sysMenus = seoSetupMapper.selectPage();
        return new PageInfo<SeoSetup>(sysMenus);
    }
}
