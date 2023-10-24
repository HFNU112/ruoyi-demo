package com.ruoyi.business.designpattern.TemplateMethod;

/**
 * 制作豆浆抽象类
 * @author: shunpeng.hu
 * @date: 2023/10/24
 */
public abstract class SoymilkAbstractClass {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 制作过程：final类型模板方法
     */
    public final void make(){
        System.out.println(" 豆浆制作开始 ");
        selectMaterial();
        addIngredients();
        soak();
        breakSoyMilk();
        System.out.println(" 豆浆制作结束 ");
    }

    public void selectMaterial(){
        System.out.println(" step1:选用上好的黄豆~ ");
    }

    public abstract void addIngredients();

    public void soak(){
        System.out.println(" step3:对黄豆和配料进行水洗浸泡~");
    }

    public void breakSoyMilk(){
        System.out.println(" step4:将充分浸泡过的黄豆和配料放入豆浆机中，开始打豆浆~ ");
    }

}
