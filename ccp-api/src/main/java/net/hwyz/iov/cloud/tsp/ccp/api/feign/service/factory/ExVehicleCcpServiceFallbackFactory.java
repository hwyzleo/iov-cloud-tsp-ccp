package net.hwyz.iov.cloud.tsp.ccp.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.VehicleCcpExService;
import net.hwyz.iov.cloud.tsp.ccp.api.feign.service.ExVehicleCcpService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 车辆中央计算平台相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExVehicleCcpServiceFallbackFactory implements FallbackFactory<ExVehicleCcpService> {

    @Override
    public ExVehicleCcpService create(Throwable throwable) {
        return new ExVehicleCcpService() {
            @Override
            public VehicleCcpExService get(String vin, String sn) {
                logger.error("车辆中央计算平台相关服务根据车架号[{}]或序列号[{}]获取车辆中央计算平台调用异常", vin, sn, throwable);
                return null;
            }

            @Override
            public void bind(VehicleCcpExService vehicleCcp) {
                logger.error("车辆中央计算平台相关服务车辆[{}]绑定中央计算平台[{}]调用异常", vehicleCcp.getVin(), vehicleCcp.getSn(), throwable);
            }
        };
    }
}
