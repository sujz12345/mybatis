package tk.mybatis.simple.model;

/**
 * Created by sujinzhou on 2017/10/17.
 */
public class SysRolePrivilege {
    private Long roleId;
    private Long privilegeId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    public String toString() {
        return "SysRolePrivilege{" +
                "roleId=" + roleId +
                ", privilegId=" + privilegeId +
                '}';
    }
}
