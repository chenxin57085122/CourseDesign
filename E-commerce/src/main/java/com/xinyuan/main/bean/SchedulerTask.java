package com.xinyuan.main.bean;

import com.xinyuan.main.dao.PurchaseHistoryMapper;
import com.xinyuan.main.domain.PurchaseHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Auther: chenxin
 * @Date: 2019/1/8 00:08
 * @Description:
 */
@Component
public class SchedulerTask {


    private Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper = null;
    //1min
    @Scheduled(fixedDelay = 6*10000)
    private void process(){
        List<PurchaseHistory> lists = purchaseHistoryMapper.selectAll();
        logger.info("process:");
        for (PurchaseHistory list : lists){
            if (list.getCloseDate().getTime() < new Date().getTime()){
                logger.info("id:"+list.getId());
                list.setOrderStatus("5");
                purchaseHistoryMapper.updateByPrimaryKeySelective(list);
            }
        }
    }
}
