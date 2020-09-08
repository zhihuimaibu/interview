package 设计模式.终极版;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wzh
 * @date 2020/5/15 16:44
 * @description 只能满足请求不能反向满足响应 todo:翟翟写
 * 您好!:)[script] ，傻*
 * response--SernsetiveFilter--HtmlFilter
 */
public class 策略模式终极版 {
    public static void main(String[] args) {
        String str = "您好!:)<script>敏感，傻逼";
        Request request = new Request();
        request.setReqStr(str);
        Response response = new Response();
        response.setRespStr("response");

        FilterChain filterChain = new FilterChain()
                .addFilter(new HtmlFilter())
                .addFilter(new SensetiveFilter());

        Processor fp = new Processor();
        fp.setFilter(filterChain);
        fp.process(request, response, filterChain);
        System.out.println(request.getReqStr());
        System.out.println(response.getRespStr());
    }
}

class Processor {

    private Filter filter;

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    void process(Request request, Response response, FilterChain fc) {
        filter.doFilter(request, response, fc);
    }
}

class FilterChain implements Filter {
    List<Filter> fc = new ArrayList<Filter>();
    int index = 0;

    public FilterChain addFilter(Filter filter) {
        fc.add(filter);
        return this;
    }

    public void doFilter(Request req, Response resp, FilterChain f) {
        if (index == fc.size()) {
            return;
        } else {
            fc.get(index).doFilter(req, resp, f);
            index++;
        }
    }
}

class Request {
    private String reqStr;

    public String getReqStr() {
        return reqStr;
    }

    public void setReqStr(String reqStr) {
        this.reqStr = reqStr;
    }
}

class Response {
    private String respStr;

    public String getRespStr() {
        return respStr;
    }

    public void setRespStr(String respStr) {
        this.respStr = respStr;
    }
}

interface Filter {
    void doFilter(Request req, Response resp, FilterChain f);
}


class HtmlFilter implements Filter {

    public void doFilter(Request req, Response resp, FilterChain f) {
        req.setReqStr(req.getReqStr().replace("<", "[").replace(">", "]"));
        resp.setRespStr(resp.getRespStr() + "--HtmlFilter");
    }
}

class SensetiveFilter implements Filter {

    public void doFilter(Request req, Response resp, FilterChain f) {
        req.setReqStr(req.getReqStr().replace("敏感", "").replace("逼", "*"));
        resp.setRespStr(resp.getRespStr() + "--SernsetiveFilter");
    }
}