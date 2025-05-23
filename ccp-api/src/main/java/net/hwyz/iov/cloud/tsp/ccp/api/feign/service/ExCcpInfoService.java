package net.hwyz.iov.cloud.tsp.ccp.api.feign.service;

import net.hwyz.iov.cloud.framework.common.constant.ServiceNameConstants;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.CcpExService;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.request.BatchImportCcpRequest;
import net.hwyz.iov.cloud.tsp.ccp.api.feign.service.factory.ExCcpInfoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 中央计算平台信息相关服务接口
 *
 * @author hwyz_leo
 */
@FeignClient(contextId = "exCcpInfoService", value = ServiceNameConstants.TSP_CCP, path = "/service/ccp", fallbackFactory = ExCcpInfoServiceFallbackFactory.class)
public interface ExCcpInfoService {

    /**
     * 批量导入中央计算平台数据
     *
     * @param request 批量导入中央计算平台请求
     */
    @PostMapping("/batchImport")
    void batchImport(@RequestBody @Validated BatchImportCcpRequest request);

    /**
     * 根据序列号获取中央计算平台信息
     *
     * @param sn 序列号
     * @return 中央计算平台信息
     */
    @GetMapping("/{sn}")
    CcpExService getBySn(@PathVariable String sn);

}
