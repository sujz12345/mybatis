package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by sujinzhou on 17-10-22.
 */
public interface UserMapper {
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    List<SysRole> selectRolesById(Long id);
    List<SysRole> selectRolesById2(Long id);
    int insert(SysUser user);
    int insert2(SysUser user);
    int insert3(SysUser user);
    int updateById(SysUser user);
    int deleteById(Long id);
    int deleteById(SysUser user);
    List<SysRole> selectRolesByUserIdAndRoleEnabled(
            @Param("userId") Long userId,
            @Param("enabled") Integer enabled);
    List<SysUser> selectByUser(SysUser user);
    int updateByIdSelective(SysUser user);

    SysUser selectByIdOrUserName(SysUser user);

    List<SysUser> selectByIdList(List<Long> idList);
    int updateByMap(Map<String,Object> map);
}
