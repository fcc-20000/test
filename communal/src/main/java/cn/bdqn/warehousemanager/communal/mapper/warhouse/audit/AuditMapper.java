package cn.bdqn.warehousemanager.communal.mapper.warhouse.audit;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Audit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuditMapper {

    List<Audit> getAuditAll();
}
