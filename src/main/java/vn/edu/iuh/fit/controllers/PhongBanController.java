package vn.edu.iuh.fit.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.dtos.PhongBan;
import vn.edu.iuh.fit.models.PhongBanModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongBan", value = "/phongban/*")
public class PhongBanController extends HttpServlet {

    @Inject
    private PhongBanModel model;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String action = req.getParameter("action");

            if ("add".equals(action)) {
                String tenPhongBan = req.getParameter("tenPhongBan");
                if (tenPhongBan != null && !tenPhongBan.isEmpty()) {
                    model.addPhongBan(tenPhongBan);
                }
            } else if ("update".equals(action)) {
                long id = Long.parseLong(req.getParameter("id"));
                String tenPhongBan = req.getParameter("tenPhongBan");
                model.updatePhongBan(id, tenPhongBan);
            } else if ("delete".equals(action)) {
                long id = Long.parseLong(req.getParameter("id"));
                model.deletePhongBan(id);
            }

            // Gọi lại doGet để lấy dữ liệu mới
            doGet(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("Error occurred: " + e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<PhongBan> listPhongBan = model.listPhongBan();
            HttpSession session = req.getSession(true);
            session.setAttribute("phongbans", listPhongBan);
            resp.sendRedirect("views/phongban.jsp");
        } catch (Exception e) {
            resp.getWriter().write("Error occurred: " + e.getMessage());
        }
    }


}