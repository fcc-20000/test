package cn.bdqn.warehousemanager.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TableHeaderExcelProperty extends BaseRowModel {
    @ExcelProperty(value = "用户编号", index = 0)
    private Integer id;
    @ExcelProperty(value = "用户名", index = 1)
    private String username;
    @ExcelProperty(value = "密码", index = 2)
    private String password;
}
