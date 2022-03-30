package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.OtherImg;
import cn.nwinfo.exhibition.entity.RotationChart;
import cn.nwinfo.exhibition.mapper.OtherImgMapper;
import cn.nwinfo.exhibition.mapper.RotationChartMapper;
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
@Service("OtherImgService")
public class OtherImgService {
    @Autowired
    OtherImgMapper otherImgMapper;

    public List<OtherImg> findBySearchStr(String searchStr) {
        return otherImgMapper.findBySearchStr(searchStr);
    }

    public OtherImg findById(String userId) {

        return otherImgMapper.findById(userId);
    }

    public boolean add(OtherImg link) {

        return otherImgMapper.add(link) > 0;
    }

    public boolean updateById(OtherImg link) {

        return otherImgMapper.updateById(link) > 0;
    }

    public boolean deleteById(OtherImg link) {

        return otherImgMapper.deleteById(link) > 0;
    }

    public List<OtherImg> findByAll() {

        return otherImgMapper.findByAll();
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
    private PageInfo<OtherImg> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<OtherImg> sysMenus = otherImgMapper.selectPage();
        return new PageInfo<OtherImg>(sysMenus);
    }
}
