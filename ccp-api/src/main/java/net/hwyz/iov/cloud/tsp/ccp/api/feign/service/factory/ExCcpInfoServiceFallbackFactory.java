package net.hwyz.iov.cloud.tsp.ccp.api.feign.service.factory;

import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.CcpExService;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.request.BatchImportCcpRequest;
import net.hwyz.iov.cloud.tsp.ccp.api.feign.service.ExCcpInfoService;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 中央计算平台信息相关服务降级处理
 *
 * @author hwyz_leo
 */
@Slf4j
@Component
public class ExCcpInfoServiceFallbackFactory implements FallbackFactory<ExCcpInfoService> {

    @Override
    public ExCcpInfoService create(Throwable throwable) {
        return new ExCcpInfoService() {
            @Override
            public void batchImport(BatchImportCcpRequest request) {
                logger.error("中央计算平台信息相关服务批量导入中央计算平台数据[{}]调用异常", request.getBatchNum(), throwable);
            }

            @Override
            public CcpExService getBySn(String sn) {
                logger.error("中央计算平台信息相关服务根据序列号[{}]获取中央计算平台信息调用异常", sn, throwable);
                return null;
            }
        };
    }
}
