package com.yongli.demo.dto;

/**
 * @ClassName RoleDto
 * @Author：Mayuan
 * @Date 2023/9/6/0006 20:35
 * @Description TODO
 * @Version 1.0
 **/
import com.yongli.demo.bean.Role;

import java.util.List;

public class RoleDto extends Role {

    private static final long serialVersionUID = 4218495592167610193L;

    private List<Long> permissionIds;

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
