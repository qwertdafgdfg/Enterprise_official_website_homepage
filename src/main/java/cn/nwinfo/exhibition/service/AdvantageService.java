package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Advantage;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.mapper.AdvantageMapper;
import cn.nwinfo.exhibition.mapper.NoticeMapper;
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
@Service("AdvantageService")
public class AdvantageService {
    @Autowired
    AdvantageMapper advantageMapper;

    public List<Advantage> findBySearchStr(String searchStr) {
        return advantageMapper.findBySearchStr(searchStr);
    }

    public Advantage findById(String userId) {

        return advantageMapper.findById(userId);
    }

    public boolean add(Advantage messageBoard) {

        return advantageMapper.add(messageBoard) > 0;
    }

    public boolean updateById(Advantage messageBoard) {

        return advantageMapper.updateById(messageBoard) > 0;
    }

    public boolean deleteById(Advantage messageBoard) {

        return advantageMapper.deleteById(messageBoard) > 0;
    }

    public List<Advantage> findByAll() {

        return advantageMapper.findByAll();
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
    private PageInfo<Advantage> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Advantage> sysMenus = advantageMapper.selectPage();
        return new PageInfo<Advantage>(sysMenus);
    }
}
