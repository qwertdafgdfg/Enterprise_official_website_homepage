package cn.nwinfo.exhibition.mapper;

import cn.nwinfo.exhibition.entity.Company;
import cn.nwinfo.exhibition.entity.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author
 * @date 2020-01-23 20:44
 */
public interface CompanyMapper {
    Company findByIp(@Param("ip") String ip);

    int add(Company link);

    int deleteById(Company link);

    List<Company> findBySearchStr(@Param("searchStr") String searchStr);

    Company findById(@Param("id") String id);

    List<Company> findByAll();

    List<Company> selectPage();

    int updateById(Company link);

    List<Company> findByHot();

}
