package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;

/*
    AS-IS
    - request.setAttribute("member", member); 데이터를 담아서 view 에서 랜더링하던 방식

    TO-BE
    - Model 객체를 대신 만들어서 request 가 하던 역할을 수행하는 것으로 변경
 */
public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>(); // 뷰를 렌더링할 때 필요한 model 객체 ("member", Member)

    public ModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
