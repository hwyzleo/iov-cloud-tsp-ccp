package net.hwyz.iov.cloud.tsp.ccp.service.facade.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.CcpExService;
import net.hwyz.iov.cloud.tsp.ccp.api.contract.request.BatchImportCcpRequest;
import net.hwyz.iov.cloud.tsp.ccp.service.application.service.CcpInfoAppService;
import net.hwyz.iov.cloud.tsp.ccp.service.facade.assembler.CcpExServiceAssembler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 中央计算平台信息相关服务接口实现类
 *
 * @author hwyz_leo
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/service/ccp")
public class CcpInfoServiceController {

    private final CcpInfoAppService ccpInfoAppService;

    /**
     * 批量导入中央计算平台数据
     *
     * @param request 批量导入中央计算平台请求
     */
    @PostMapping("/batchImport")
    public void batchImport(@RequestBody @Validated BatchImportCcpRequest request) {
        logger.info("批量导入中央计算平台数据[{}]", request.getBatchNum());
        ccpInfoAppService.batchImport(request.getBatchNum(), request.getSupplierCode(),
                CcpExServiceAssembler.INSTANCE.toPoList(request.getCcpList()));
    }

    /**
     * 根据序列号获取中央计算平台信息
     *
     * @param sn 序列号
     * @return 中央计算平台信息
     */
    @GetMapping("/{sn}")
    public CcpExService getBySn(@PathVariable String sn) {
        logger.info("根据序列号[{}]获取中央计算平台信息", sn);
        return CcpExServiceAssembler.INSTANCE.fromPo(ccpInfoAppService.getBySn(sn));
    }

}
