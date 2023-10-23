package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Beauty;
import com.ruoyi.business.domain.Filters;
import com.ruoyi.business.service.IVideoService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Husp
 * @Date 2023/10/19 9:44
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @Resource(name = "videoService")
    private IVideoService videoService;

    @Resource(name = "beauty")
    private Beauty beauty;

    @Resource(name = "filters")
    private Filters filters;

    @GetMapping("/play")
    public String playVideo(String decorator){
        if ("1".equals(decorator)){
            beauty.playVideo();
            return "播放视频 + 美颜";
        } else {
            filters.playVideo();
            return "播放视频 + 滤镜";
        }
    }

}
