package com.web; /**
 * @description :
 * @author :珠代
 * @create :2022-03-16 23:00:00
 */

import com.pojo.Brand;
import com.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受id
        String id = request.getParameter("id");
        //调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        //存储到request中
        request.setAttribute("brand", brand);
        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
