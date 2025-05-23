package net.hwyz.iov.cloud.tsp.ccp.service.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao.VehicleCcpDao;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao.VehicleCcpLogDao;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.VehicleCcpLogPo;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.VehicleCcpPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆中央计算平台相关应用服务类
 *
 * @author hwyz_leo
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleCcpAppService {

    private final VehicleCcpDao vehicleCcpDao;
    private final VehicleCcpLogDao vehicleCcpLogDao;

    /**
     * 根据车架号或序列号获取车辆中央计算平台
     *
     * @param sn 序列号
     * @return 车辆中央计算平台
     */
    public VehicleCcpPo get(String vin, String sn) {
        List<VehicleCcpPo> vehicleCcpPoList = vehicleCcpDao.selectPoByExample(VehicleCcpPo.builder().vin(vin).sn(sn).build());
        return vehicleCcpPoList.isEmpty() ? null : vehicleCcpPoList.get(0);
    }

    /**
     * 记录车辆中央计算平台变更日志
     *
     * @param vehicleCcpPo 车辆中央计算平台对象
     * @param remark       变更备注
     */
    private void recordLog(VehicleCcpPo vehicleCcpPo, String remark) {
        vehicleCcpLogDao.insertPo(VehicleCcpLogPo.builder()
                .vin(vehicleCcpPo.getVin())
                .sn(vehicleCcpPo.getSn())
                .description(remark)
                .build());
    }

}
