package net.hwyz.iov.cloud.tsp.ccp.service.application.service;

import cn.hutool.core.util.ObjUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.framework.common.util.StrUtil;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao.CcpDao;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao.CcpLogDao;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.CcpLogPo;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.CcpPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 中央计算平台信息相关应用服务类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CcpInfoAppService {

    private final CcpDao ccpDao;
    private final CcpLogDao ccpLogDao;

    /**
     * 批量导入中央计算平台信息
     *
     * @param batchNum     批次号
     * @param supplierCode 供应商编码
     * @param ccpList      中央计算平台列表
     */
    public void batchImport(String batchNum, String supplierCode, List<CcpPo> ccpList) {
        if (StrUtil.isBlank(supplierCode)) {
            logger.warn("数据批次[{}]中央计算平台信息供应商编码为空", batchNum);
        }
        for (CcpPo ccpPo : ccpList) {
            if (ObjUtil.isNull(ccpDao.selectBySn(ccpPo.getSn()))) {
                ccpPo.setSupplierCode(supplierCode);
                ccpDao.insertPo(ccpPo);
                recordLog(ccpPo, "数据批次[" + batchNum + "]数据导入");
            } else {
                logger.warn("数据批次[{}]中央计算平台信息[{}]已存在", batchNum, ccpPo.getSn());
            }
        }
    }

    /**
     * 记录中央计算平台信息变更日志
     *
     * @param ccpPo  中央计算平台对象
     * @param remark 变更备注
     */
    private void recordLog(CcpPo ccpPo, String remark) {
        ccpLogDao.insertPo(CcpLogPo.builder()
                .sn(ccpPo.getSn())
                .configWord(ccpPo.getConfigWord())
                .hardwareVer(ccpPo.getHardwareVer())
                .softwareVer(ccpPo.getSoftwareVer())
                .hardwareNo(ccpPo.getHardwareNo())
                .softwareNo(ccpPo.getSoftwareNo())
                .hsm(ccpPo.getHsm())
                .description(remark)
                .build());
    }

}
