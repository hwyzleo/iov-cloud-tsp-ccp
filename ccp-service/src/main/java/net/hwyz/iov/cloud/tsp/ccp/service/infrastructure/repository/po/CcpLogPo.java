package net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import net.hwyz.iov.cloud.framework.mysql.po.BasePo;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 中央计算平台信息变更日志表 数据对象
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-14
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_ccp_log")
public class CcpLogPo extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 序列号
     */
    @TableField("sn")
    private String sn;

    /**
     * 配置字
     */
    @TableField("config_word")
    private String configWord;

    /**
     * 硬件版本号
     */
    @TableField("hardware_ver")
    private String hardwareVer;

    /**
     * 软件版本号
     */
    @TableField("software_ver")
    private String softwareVer;

    /**
     * 硬件零件号
     */
    @TableField("hardware_no")
    private String hardwareNo;

    /**
     * 软件零件号
     */
    @TableField("software_no")
    private String softwareNo;

    /**
     * 硬件安全模块
     */
    @TableField("hsm")
    private String hsm;
}
