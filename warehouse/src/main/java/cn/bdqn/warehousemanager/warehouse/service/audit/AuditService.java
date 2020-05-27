package cn.bdqn.warehousemanager.warehouse.service.audit;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Audit;

import java.util.List;

public interface AuditService {
    List<Audit> getAuditAll();
}
