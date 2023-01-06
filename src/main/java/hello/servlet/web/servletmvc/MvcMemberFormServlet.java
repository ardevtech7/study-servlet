package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 서블릿 : 컨트롤러 역할
 * JSP : 뷰 역할
 * HttpServletRequest : 모델 역할
 */
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // /WEB-INF 안에 jsp 가 있으면 외부에서 직접 호출 불가, 컨트롤러를 통해서 호출
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // RequestDispatcher : controller -> view로 이동할 때 사용하는 것
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 다른 서블릿이나 JSP 로 이동할 수 있는 기능
        dispatcher.forward(request, response);
    }

}
