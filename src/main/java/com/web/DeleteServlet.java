package com.web; /**
 * @description :
 * @author :珠代
 * @create :2022-03-18 22:23:00
 */

import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private BrandService brandService=new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受id
        String id = request.getParameter("id");
        //调用service删除
        if("1".equals(request.getParameter("status"))) {
            brandService.delete(Integer.parseInt(id));
        }
        //转发到selectAllServlet
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
