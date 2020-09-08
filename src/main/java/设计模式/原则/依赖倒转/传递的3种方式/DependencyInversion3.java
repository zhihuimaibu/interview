package 设计模式.原则.依赖倒转.传递的3种方式;

/**
 * @author wzh
 * @date 2020/8/24 23:08
 * @description
 */
public class DependencyInversion3 {
    public static void main(String[] args) {
        //1 基于接口的传递
        /*OpenOrClose openOrClose = new OpenOrClose();
        openOrClose.open(new PS4());*/
        //2 基于有参构造器的传递
       /* OpenOrClose openOrClose = new OpenOrClose(new PS4());
        openOrClose.open();*/
        //3 基于setter方法的传递
        OpenOrClose openOrClose = new OpenOrClose();
        openOrClose.setTv(new PS4());
        openOrClose.open();
    }
}

/*
//方式1 基于接口的传递
interface IOpenorClose{
    public void open(ITV tv);
}

interface ITV{
    public void play();
}

class PS4 implements ITV{

    @Override
    public void play() {
        System.out.println("paly ps4 ing");
    }
}

class OpenOrClose implements IOpenorClose{

    @Override
    public void open(ITV tv) {
        tv.play();
    }
}*/


//方式2 基于构造器的传递
/*interface IOpenorClose{
    public void open();
}

interface ITV{
    public void play();
}

class PS4 implements ITV{

    @Override
    public void play() {
        System.out.println("paly ps4 ing");
    }
}

class OpenOrClose implements IOpenorClose{
    private ITV tv;

    public OpenOrClose(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void open() {
        this.tv.play();
    }
}*/

//方式3 基于setter方法的传递
interface IOpenorClose{
    public void open();
}

interface ITV{
    public void play();
}

class PS4 implements ITV{

    @Override
    public void play() {
        System.out.println("paly ps4 ing");
    }
}

class OpenOrClose implements IOpenorClose{
    private ITV tv;

    public OpenOrClose() {
    }

    public void setTv(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void open() {
        this.tv.play();
    }
}