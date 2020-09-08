package 设计模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @date 2020/5/15 16:12
 * @description
 */
public class 策略模式进阶版 {
    public static void main(String[] args) {
        String str = "您好!:)<script>敏感，傻逼";
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new FaceFilter())
                .addFilter(new SensetiveFilter());

        FilterChain filterChain2 = new FilterChain();
        filterChain2.addFilter(new HtmlFilter());
        filterChain.addFilter(filterChain);

        FilterProcess fp = new FilterProcess();
        fp.setFc(filterChain);
        String result = fp.process(str);
        System.out.println(result);
    }
}

class FilterProcess {
    private FilterChain fc;

    public FilterChain getFc() {
        return fc;
    }

    public void setFc(FilterChain fc) {
        this.fc = fc;
    }

    public String process(String str) {
        return fc.doFilter(str);
    }
}

class FilterChain implements Filter {
    private List<Filter> fc = new ArrayList<Filter>();

    public FilterChain addFilter(Filter filter) {
        fc.add(filter);
        return this;
    }

    public String doFilter(String str) {
        String msg = str;
        for (Filter filter : fc) {
            msg = filter.doFilter(msg);
        }
        return msg;
    }
}