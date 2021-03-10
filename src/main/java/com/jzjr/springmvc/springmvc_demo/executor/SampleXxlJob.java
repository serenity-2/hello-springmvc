package com.jzjr.springmvc.springmvc_demo.executor;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleXxlJob {
    /**
     * 1、任务示例（Bean模式）
     */
    @XxlJob("ImportantJobHandler")
    public void ImportantJobHandler() throws Exception {
        log.info("探索生命起源，认知世间真相");
    }
}
