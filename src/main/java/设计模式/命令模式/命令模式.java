package 设计模式.命令模式;

/**
 * 命令模式的角色：
 *  1 调用者
 *  2 命令集
 *  3 小弟
 */
public class 命令模式 {
    public static void main(String[] args) {
        Command readNewsCommand = new 读取新闻命令();
        Invoke invoke = new Invoke(readNewsCommand);
        invoke.action();
    }
}

//调用者
class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void action(){
        command.execute();
    }
}

abstract class Command {
    protected final Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();
}

class 读取新闻命令 extends Command {
    //默认接收者
    public 读取新闻命令() {
        super(new 朗读());
    }

    //设置新的接收者
    public 读取新闻命令(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }
}

class 倒计时命令 extends Command {
    //默认接收者
    public 倒计时命令() {
        super(new 计时());
    }

    //设置新的接收者
    public 倒计时命令(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        super.receiver.doSomething();
    }
}

abstract class Receiver {
    public abstract void doSomething ();
}

class 计时 extends Receiver {

    @Override
    public void doSomething() {
        System.out.println("开始10秒倒计时");
    }
}

class 朗读 extends Receiver {

    @Override
    public void doSomething() {
        System.out.println("开始朗读新闻：今天是2020年12月29日，星期二，我是主持人智慧，今天的主要新闻有。。。");
    }
}