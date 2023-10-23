package com.ruoyi.business.domain;

import com.ruoyi.business.service.IVideoService;

/**
 * 滤镜
 * @Author Husp
 * @Date 2023/10/19 14:58
 */
public class Filters extends VedioDecorator{

    public Filters(IVideoService videoService) {
        super(videoService);
    }

    public void decorator(){
        System.out.println(" 装饰滤镜 ");
    }

    @Override
    public void playVideo() {
        super.playVideo();
        this.decorator();
    }
}
