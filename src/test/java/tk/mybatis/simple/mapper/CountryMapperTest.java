package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.Country;

import java.util.List;

/**
 * Created by sujinzhou on 2017/10/17.
 */
public class CountryMapperTest extends BaseMapperTest{


    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();
        List<Country> list = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
        System.out.println(list);
    }
}
