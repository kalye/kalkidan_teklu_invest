package com.homework3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework3.data.CompanyInfo;

/**
 * Servlet implementation class StocksServlet
 */
@WebServlet("/stocks.html")
public class StocksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StocksServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Stock exchange </title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>Stock exchange!</h1>");
		printWriter.println("<h1>Please enter  up  to  4 companies  (by  their  ticker  symbols)  and  specify  the  number  of  requested  shares  for  each company.</h1>");
		printWriter.println("<form action=\"processstockpurchase\" method=\"post\">");
		printWriter.println("<table>");
		//table header
		printWriter.println("<tr>");
		printWriter.println("<td>");
		printWriter.println("Company symbole/Ticker symbole");
		printWriter.println("</td>");
		printWriter.println("<td>");
		printWriter.println("Number of shares");
		printWriter.println("</td>");
		printWriter.println("</tr>");
		//table header
		//table body
		printWriter.println("<tr>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"tickerSymbole1\" id=\"tickerSymbole1\">");
		printWriter.println("</td>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"nbrShare1\" id=\"nbrShare1\">");
		printWriter.println("</td>");
		printWriter.println("</tr>");
		printWriter.println("<tr>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"tickerSymbole2\" id=\"tickerSymbole2\">");
		printWriter.println("</td>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"nbrShare2\" id=\"nbrShare2\">");
		printWriter.println("</td>");
		printWriter.println("</tr>");
		printWriter.println("<tr>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"tickerSymbole3\" id=\"tickerSymbole3\">");
		printWriter.println("</td>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"nbrShare3\" id=\"nbrShare3\">");
		printWriter.println("</td>");
		printWriter.println("</tr>");
		printWriter.println("<tr>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"tickerSymbole4\" id=\"tickerSymbole4\">");
		printWriter.println("</td>");
		printWriter.println("<td>");
		printWriter.println("<input type=\"text\" name=\"nbrShare4\" id=\"nbrShare4\">");
		printWriter.println("</td>");
		printWriter.println("</tr>");
		//table body
		printWriter.println("</table>");

		printWriter.println("<input type=\"submit\" value=\"Submit\" id=\"submit\">");
		printWriter.println("</form>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
