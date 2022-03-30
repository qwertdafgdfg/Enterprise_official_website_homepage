package cn.nwinfo.exhibition.service;

import cn.nwinfo.exhibition.entity.Company;
import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.mapper.CompanyMapper;
import cn.nwinfo.exhibition.mapper.LinkMapper;
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
@Service("CompanyService")
public class CompanyService {
    @Autowired
    CompanyMapper companyMapper;

    public List<Company> findBySearchStr(String searchStr) {
        return companyMapper.findBySearchStr(searchStr);
    }

    public Company findById(String userId) {

        return companyMapper.findById(userId);
    }

    public boolean add(Company link) {

        return companyMapper.add(link) > 0;
    }

    public boolean updateById(Company link) {

        return companyMapper.updateById(link) > 0;
    }

    public boolean deleteById(Company link) {

        return companyMapper.deleteById(link) > 0;
    }

    public List<Company> findByAll() {

        return companyMapper.findByAll();
    }

}
