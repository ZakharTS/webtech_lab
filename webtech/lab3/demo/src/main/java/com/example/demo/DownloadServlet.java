package com.example.demo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "downloadServlet", value = "/download-servlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setHeader("Content-Disposition", "attachment; filename=\"myfile.txt\"");
//        response.setContentType("text/plain");
//        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        try (var writer = response.getWriter()) {
//            writer.write("Servlet, hello from txt file!");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        response.setContentType("image/jpeg");
        File imgFile = new File("d:/sample.jpg");
        BufferedImage img = ImageIO.read(imgFile);
        ImageIO.write(img, "JPG", response.getOutputStream());
    }
}
