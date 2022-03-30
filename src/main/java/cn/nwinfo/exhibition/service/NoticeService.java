package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.MessageBoard;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.mapper.MessageBoardMapper;
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
@Service("NoticeService")
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    public List<Notice> findBySearchStr(String searchStr) {
        return noticeMapper.findBySearchStr(searchStr);
    }

    public Notice findById(String userId) {

        return noticeMapper.findById(userId);
    }

    public boolean add(Notice messageBoard) {

        return noticeMapper.add(messageBoard) > 0;
    }

    public boolean updateById(Notice messageBoard) {

        return noticeMapper.updateById(messageBoard) > 0;
    }

    public boolean deleteById(Notice messageBoard) {

        return noticeMapper.deleteById(messageBoard) > 0;
    }

    public List<Notice> findByAll() {

        return noticeMapper.findByAll();
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
    private PageInfo<Notice> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<Notice> sysMenus = noticeMapper.selectPage();
        return new PageInfo<Notice>(sysMenus);
    }
}
