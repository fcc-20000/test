package cn.bdqn.warehousemanager.mapper.user;


import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.entity.UserVO;
import cn.bdqn.warehousemanager.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User loadUserByUserName(String userName);

    List<Role> getUserRolesByUid(Integer id);

    Integer addUser(UserVO user);

    List<UserVO> getUserAll(UserVO userVO);


}
