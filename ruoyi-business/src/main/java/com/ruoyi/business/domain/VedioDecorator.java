package com.ruoyi.business.domain;

import com.ruoyi.business.service.IVideoService;

/**
 * @Author Husp
 * @Date 2023/10/19 14:39
 */
public abstract class VedioDecorator implements IVideoService{

    private IVideoService videoService;

    public VedioDecorator(IVideoService videoService) {
        this.videoService = videoService;
    }

    @Override
    public void playVideo() {
        this.videoService.playVideo();
    }

}
