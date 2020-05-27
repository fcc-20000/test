package cn.bdqn.warehousemanager.warehousehome.mapper.user;


import cn.bdqn.warehousemanager.communal.entity.Role;
import cn.bdqn.warehousemanager.communal.entity.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    UserVO loadUserByUserName(String userName);

    List<Role> getUserRolesByUid(Integer id);

    Integer addUser(UserVO user);

    List<UserVO> getUserAll(UserVO userVO);

    Integer getUserAllCount(UserVO userVO);


    Integer deleteUserById(Integer id);

    UserVO getUserById(Integer id);

    Integer updateUserById(UserVO userVO);

    Integer getUserNmaeCount(String name);
}
