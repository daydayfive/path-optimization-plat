package com.cqu.api;

import com.cqu.pojo.Result;
import com.cqu.pojo.TaskInfo;

public interface TaskOrderService {

    /**
     *   任务匹配接口
     * @param task
     * @return
     */
    Result matchTask(TaskInfo task);

}
