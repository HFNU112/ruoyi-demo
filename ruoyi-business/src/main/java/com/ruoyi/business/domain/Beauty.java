package com.ruoyi.business.domain;

import com.ruoyi.business.service.IVideoService;

/**
 * 美颜
 * @Author Husp
 * @Date 2023/10/19 14:43
 */
public class Beauty extends VedioDecorator{

    public Beauty(IVideoService videoService) {
        super(videoService);
    }

    public void decorator(){
        System.out.println(" 装饰美颜 ");
    }

    @Override
    public void playVideo() {
        super.playVideo();
        this.decorator();
    }
}
