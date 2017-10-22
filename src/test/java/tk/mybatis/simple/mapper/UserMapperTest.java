package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.*;

/**
 * Created by sujinzhou on 17-10-22.
 */
public class UserMapperTest extends BaseMapperTest{


    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            Assert.assertNotNull(sysUser);
            Assert.assertEquals("admin",sysUser.getUserName());
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession session = getSqlSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysUser> list = userMapper.selectAll();
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size()>0);
        }finally {
            session.close();
        }
    }

    @Test
    public void testSelectRoleById(){
        SqlSession session = getSqlSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesById(1L);
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size()>0);
            System.out.println(list);
        }finally {
            session.close();
        }
    }

    @Test
    public void testSelectRoleById2(){
        SqlSession session = getSqlSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<SysRole> list = userMapper.selectRolesById2(1L);
            Assert.assertNotNull(list);
            Assert.assertTrue(list.size()>0);
            System.out.println(list);
        }finally {
            session.close();
        }
    }
    @Test
    public void testInsert(){
        SqlSession session = getSqlSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreatedTime(new Date());
            int result = mapper.insert(user);
            Assert.assertEquals(1,result);
            Assert.assertNull(user.getId());
        }finally {
            session.rollback();
            session.close();
        }
    }
    @Test
    public void testInsert2(){
        SqlSession session = getSqlSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test2");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreatedTime(new Date());
            int result = mapper.insert2(user);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(user.getId());
        }finally {
            session.commit();
            session.close();
        }
    }


    @Test
    public void testInsert3(){
        SqlSession session = getSqlSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test2");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1,2,3});
            user.setCreatedTime(new Date());
            int result = mapper.insert3(user);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(user.getId());
            System.out.println(user.getId());
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testUpdate(){
        SqlSession session = getSqlSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = mapper.selectById(1L);
            user.setUserName("ADMIN_TEST");
            int result = mapper.updateById(user);
            Assert.assertEquals(1,result);
            user = mapper.selectById(user.getId());
            Assert.assertEquals("ADMIN_TEST",user.getUserName());
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void testDelete(){
        SqlSession session = getSqlSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = mapper.selectById(1L);
            Assert.assertEquals(1,mapper.deleteById(user.getId()));
            Assert.assertNull(mapper.selectById(1L));

            user = mapper.selectById(1001L);
            Assert.assertEquals(1,mapper.deleteById(user));
            Assert.assertNull(mapper.selectById(1001L));
        }finally {
            session.rollback();
            session.close();
        }
    }

    @Test
    public void selectRolesByUserIdAndRoleEnabled(){
        SqlSession session = getSqlSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<SysRole> userList = mapper.selectRolesByUserIdAndRoleEnabled(1L,1);
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size()>0);
        }finally {
            session.close();
        }
    }

    @Test
    public void testSelectByUser(){
        SqlSession session = getSqlSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("test");
            List<SysUser> list = mapper.selectByUser(user);
            System.out.println(list);
            SysUser user2 = new SysUser();
            user2.setUserEmail("test@mybatis.tk");
            list = mapper.selectByUser(user2);
            System.out.println(list);

        }finally {

        }
    }

    @Test
    public void selectByIdOrUserName(){
        SqlSession session = getSqlSession();
        try{
            UserMapper mapper = session.getMapper(UserMapper.class);
            SysUser query = new SysUser();
            query.setId(1L);
            query.setUserName("test");
            SysUser user = mapper.selectByIdOrUserName(query);
            System.out.println(user);
            Assert.assertNotNull(user);

            query.setId(null);
            user = mapper.selectByIdOrUserName(query);
            System.out.println(user);
            Assert.assertNotNull(user);

            query.setId(1L);
            query.setUserName(null);
            user = mapper.selectByIdOrUserName(query);
            System.out.println(user);
            Assert.assertNotNull(user);

            query.setId(null);
            query.setUserName(null);
            user = mapper.selectByIdOrUserName(query);
            System.out.println(user);
            Assert.assertNull(user);


        }finally {
            session.close();
        }
    }

    @Test
    public void testSelectByIdList(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Long> list = new ArrayList<Long>();
            list.add(1L);
            list.add(1001L);
            List<SysUser> users = mapper.selectByIdList(list);
            Assert.assertEquals(2,users.size());

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByMap(){
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",1L);
            map.put("user_email","sujz12345@163.com");
            mapper.updateByMap(map);
            SysUser user = mapper.selectById(1L);
            Assert.assertEquals("sujz12345@163.com",user.getUserEmail());

        }finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }


}
