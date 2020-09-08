package 设计模式;

import java.util.ArrayList;

/**
 * @author wzh
 * @date 2020/5/8 17:33
 * @description servlet过滤器 问题：过滤顺序不好改变,再加另外一个过滤链
 */
public class 策略模式初始版 {
    public static void main(String[] args) {
        String str = "您好!:)<script>敏感，傻逼";
        msgProcessor msgProcessor = new msgProcessor();
        msgProcessor.setMsg(str);
        String result = msgProcessor.process();
        System.out.println(result);
    }
}

class msgProcessor {
    private String msg;
    Filter[] Filters = {new HtmlFilter(), new SensetiveFilter(), new FaceFilter()};

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String process() {
        String r = msg;

        for (Filter filter : Filters) {
            r = filter.doFilter(r);
        }
        return r;
    }
}

interface Filter {
    String doFilter(String str);
}

class HtmlFilter implements Filter {

    public String doFilter(String str) {
        String s = str.replace("<", "[")
                .replace(">", "]");
        return s;
    }
}

class SensetiveFilter implements Filter {

    public String doFilter(String str) {
        String s = str.replace("敏感", "")
                .replace("逼", "*");
        return s;
    }
}

class FaceFilter implements Filter {

    public String doFilter(String str) {
        String s = str.replace(":)", "666");
        return s;
    }
}