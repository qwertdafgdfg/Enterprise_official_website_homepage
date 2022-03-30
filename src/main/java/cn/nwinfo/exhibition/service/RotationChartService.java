package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.RotationChart;
import cn.nwinfo.exhibition.mapper.LinkMapper;
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
@Service("RotationChartService")
public class RotationChartService {
    @Autowired
    RotationChartMapper rotationChartMapper;

    public List<RotationChart> findBySearchStr(String searchStr) {
        return rotationChartMapper.findBySearchStr(searchStr);
    }

    public RotationChart findById(String userId) {

        return rotationChartMapper.findById(userId);
    }

    public boolean add(RotationChart link) {

        return rotationChartMapper.add(link) > 0;
    }

    public boolean updateById(RotationChart link) {

        return rotationChartMapper.updateById(link) > 0;
    }

    public boolean deleteById(RotationChart link) {

        return rotationChartMapper.deleteById(link) > 0;
    }

    public List<RotationChart> findByAll() {

        return rotationChartMapper.findByAll();
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
    private PageInfo<RotationChart> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<RotationChart> sysMenus = rotationChartMapper.selectPage();
        return new PageInfo<RotationChart>(sysMenus);
    }
}
