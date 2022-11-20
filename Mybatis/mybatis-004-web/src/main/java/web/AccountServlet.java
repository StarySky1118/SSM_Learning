package web;

import exception.BalanceNotEnoughException;
import service.AccountService;
import service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 接收页面传来的数据
        String actOut = req.getParameter("act_no_out");
        String actIn = req.getParameter("act_no_in");
        double money = Double.parseDouble(req.getParameter("money"));

        // 调用 Service 中 transfer() 方法完成转账业务
        try {
            accountService.transfer(actOut, actIn, money);

            // 跳转至转账成功界面
            resp.sendRedirect(req.getContextPath() + "/success/transfer_success.html");
        } catch (BalanceNotEnoughException e) {
            // 跳转至余额不足界面
            resp.sendRedirect(req.getContextPath() + "/error/BalanceNotEnough.html");
        } catch (Exception e) {
            // 跳转至未知原因错误界面
            resp.sendRedirect(req.getContextPath() + "/error/UnkownError.html");
        }
    }
}
