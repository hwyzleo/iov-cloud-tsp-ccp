package net.hwyz.iov.cloud.tsp.ccp.api.feign.service;

import net.hwyz.iov.cloud.framework.common.constant.ServiceNameConstants;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.VehicleCcpExService;
import net.hwyz.iov.cloud.tsp.ccp.api.feign.service.factory.ExVehicleCcpServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 车辆中央计算平台相关服务接口
 *
 * @author hwyz_leo
 */
@FeignClient(contextId = "exVehicleCcpService", value = ServiceNameConstants.TSP_CCP, path = "/service/vehicleCcp", fallbackFactory = ExVehicleCcpServiceFallbackFactory.class)
public interface ExVehicleCcpService {

    /**
     * 根据车架号或序列号获取车辆中央计算平台
     *
     * @param vin 车架号
     * @param sn  序列号
     * @return 车辆中央计算平台
     */
    @GetMapping("")
    VehicleCcpExService get(@RequestParam(required = false) String vin, @RequestParam(required = false) String sn);

    /**
     * 车辆绑定中央计算平台
     *
     * @param vehicleCcp 车辆中央计算平台
     */
    @PostMapping("/bind")
    void bind(@RequestBody @Validated VehicleCcpExService vehicleCcp);

}
