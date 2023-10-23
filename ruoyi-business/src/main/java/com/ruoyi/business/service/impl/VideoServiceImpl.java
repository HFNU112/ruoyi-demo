package com.ruoyi.business.service.impl;

import com.ruoyi.business.service.IVideoService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.stereotype.Service;

/**
 * @Author Husp
 * @Date 2023/10/19 14:35
 */
@Service
public class VideoServiceImpl implements IVideoService {

    @Override
    public void playVideo() {
        System.out.println(" 视频播放 ");
    }

}
