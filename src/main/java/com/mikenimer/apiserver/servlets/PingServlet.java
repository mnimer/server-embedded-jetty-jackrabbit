package com.mikenimer.apiserver.servlets;

import org.apache.jackrabbit.servlet.ServletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.jcr.Repository;

/**
 * User: mikenimer
 * Date: 5/10/13
 */
public class PingServlet extends HttpServlet
{
    public final Logger log = LoggerFactory.getLogger(PingServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Repository repository = new ServletRepository(this); // "this" is the containing servlet



        PrintWriter out = resp.getWriter();
        out.println("ping servlet: " +new Date().toGMTString());

        try
        {
            out.println( repository.login().getRootNode().toString() );
        }catch(Exception ex){
            out.println("JCR FAILED");
        }

        out.close();
    }
}
