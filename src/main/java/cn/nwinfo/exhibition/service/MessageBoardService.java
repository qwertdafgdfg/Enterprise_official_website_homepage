package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.MessageBoard;
import cn.nwinfo.exhibition.entity.ProductCategory;
import cn.nwinfo.exhibition.mapper.MessageBoardMapper;
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
@Service("MessageBoardService")
public class MessageBoardService {
    @Autowired
    MessageBoardMapper messageBoardMapper;

    public List<MessageBoard> findBySearchStr(String searchStr) {
        return messageBoardMapper.findBySearchStr(searchStr);
    }

    public MessageBoard findById(String userId) {

        return messageBoardMapper.findById(userId);
    }

    public boolean add(MessageBoard messageBoard) {

        return messageBoardMapper.add(messageBoard) > 0;
    }

    public boolean updateById(MessageBoard messageBoard) {

        return messageBoardMapper.updateById(messageBoard) > 0;
    }

    public boolean deleteById(MessageBoard messageBoard) {

        return messageBoardMapper.deleteById(messageBoard) > 0;
    }

    public List<MessageBoard> findByAll() {

        return messageBoardMapper.findByAll();
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
    private PageInfo<MessageBoard> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        String orderBy = "id" + " desc";//按照（数据库）排序字段 倒序 排序

        PageHelper.startPage(pageNum, pageSize, orderBy);
//        PageHelper.startPage(pageNum, pageSize);
        List<MessageBoard> sysMenus = messageBoardMapper.selectPage();
        return new PageInfo<MessageBoard>(sysMenus);
    }
}
