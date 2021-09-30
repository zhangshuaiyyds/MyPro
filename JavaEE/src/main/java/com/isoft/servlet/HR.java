
package com.isoft.servlet;


import com.google.gson.Gson;
import com.isoft.servlet.dao.EmpDao;
import com.isoft.servlet.daoImpl.EmpDaoImpl;
import com.isoft.servlet.entity.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/HR")
public class HR extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String act = req.getParameter("action");

        /*String username = req.getParameter("username");
        String pwd = req.getParameter("password");

        UserDaoImpl dao = new UserDaoImpl();
        User login = dao.login(username, pwd);

        if (login != null){
            System.out.println("登录成功");
            resp.sendRedirect("r/s.html");
        }else {
            System.out.println("登录失败");
        }*/

        if (act.equals("findAll")) {
            EmpDao dao1 = new EmpDaoImpl();
            List<Emp> emps = dao1.selectAll();

            String json = gson.toJson(emps);

            PrintWriter wr = resp.getWriter();
            wr.write(json);

            wr.flush();
            wr.close();
        }else if (act.equals("deleteUser")){
            String myId = req.getParameter("id");
            int id = 0;
            if (myId != "" && myId != null){
                id = Integer.parseInt(myId);
            }
            EmpDao dao = new EmpDaoImpl();
            int i = dao.deleteEmp(id);
            if (i>0){
                System.out.println("删除用户成功");
            }
            resp.sendRedirect("emp.html");
        }
       /* String eid = req.getParameter("eid");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String address = req.getParameter("address");
        String postal = req.getParameter("postal");
        String country = req.getParameter("country");
        String rpr = req.getParameter("rpr");
        String birthday = req.getParameter("birthday");
        String num = req.getParameter("num");
        String nation = req.getParameter("nation");

        Emp emp = new Emp();
        emp.setEid(eid);
        emp.setName(name);
        emp.setSex(sex);
        emp.setMail(email);
        emp.setPhone(phone);
        emp.setQq(qq);
        emp.setAddress(address);
        emp.setPostal(postal);
        emp.setCountry(country);
        emp.setRpr(rpr);
        emp.setBirthday(birthday);
        emp.setNum(num);
        emp.setNational(nation);

        EmpDao dao2 = new EmpDaoImpl();
        int i = dao2.addEmp(emp);
        if (i>0){
            resp.sendRedirect("ss.html");
            System.out.println(emp);
        }else {
            System.out.println("添加失败");
        }*/
    }
}
