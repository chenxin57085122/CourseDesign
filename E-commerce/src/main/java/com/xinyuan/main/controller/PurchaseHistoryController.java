package com.xinyuan.main.controller;

import com.xinyuan.main.domain.vo.PurchaseInfo;
import com.xinyuan.main.service.PurchaseHistoryService;
import com.xinyuan.main.utils.ServiceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 22:31
 * @Description:
 */
@RestController
@RequestMapping("/purchase")
public class PurchaseHistoryController {

    @Autowired
    private PurchaseHistoryService purchaseHistoryService = null;

    /**
     *
     * 功能描述: 分页查询用户订单信息
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 22:45
     */
    @GetMapping("/userId")
    public ServiceVO selectAllByUserId(@RequestParam("userId") int userId, @RequestParam("size") int size, @RequestParam("page") int page){

        return new ServiceVO(purchaseHistoryService.selectAllByUserId(userId, size, page));
    }


    /**
     *
     * 功能描述: 添加
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/8 0:00
     */
    @PostMapping("/insert")
    public ServiceVO insertInfo(@RequestBody PurchaseInfo purchaseInfo){

        return new ServiceVO.ServiceVOBuilder().code(purchaseHistoryService.insertInfo(purchaseInfo)).builder();
    }

    /**
     *
     * 功能描述: 取消订单
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 23:59
     */
    @GetMapping("/cancel/{id}")
    public ServiceVO update(@PathVariable("id") int id){
        return new ServiceVO.ServiceVOBuilder().code(purchaseHistoryService.cancelOrder(id)).builder();
    }

    /**
     *
     * 功能描述: 订单详情
     *
     * @param:
     * @return:
     * @auther: chenxin
     * @date: 2019/1/7 23:59
     */
    @GetMapping("/read/{id}")
    public ServiceVO read(@PathVariable("id") int id){
        return new ServiceVO(purchaseHistoryService.cancelOrder(id));
    }
}
