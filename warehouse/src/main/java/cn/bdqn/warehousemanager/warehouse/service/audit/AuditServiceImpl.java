package cn.bdqn.warehousemanager.warehouse.service.audit;

import cn.bdqn.warehousemanager.communal.entity.warhouse.Audit;
import cn.bdqn.warehousemanager.communal.mapper.warhouse.audit.AuditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {
    @Autowired
    AuditMapper auditMapper;

    @Override
    public List<Audit> getAuditAll() {
        return auditMapper.getAuditAll();
    }
}
