package com.homework3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework3.data.CompanyInfo;

/**
 * Servlet implementation class PurchasedStockList
 */
@WebServlet("/purchasedStockList")
public class PurchasedStockList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchasedStockList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CompanyInfo> companies = (List<CompanyInfo>) request.getAttribute("companies");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title>Stock exchange </title>");
		printWriter.println("</head>");
		printWriter.println("<body>");
		printWriter.println("<h1>Stock exchange!</h1>");
		int nbr = 0;
		if(companies != null && !companies.isEmpty()){
			String tickerSymbole1 = request.getParameter("tickerSymbole1");
			String nbrShare1 = request.getParameter("nbrShare1");
			CompanyInfo companyInfo = getCompanyInfo(tickerSymbole1, companies);
			printWriter.println("<table>");
			//table header
			printWriter.println("<tr>");
			printWriter.println("<td>");
			printWriter.println("name");
			printWriter.println("</td>");
			printWriter.println("<td>");
			printWriter.println("price");
			printWriter.println("</td>");
			printWriter.println("<td>");
			printWriter.println("addedOn");
			printWriter.println("</td>");
			printWriter.println("<td>");
			printWriter.println("exchange");
			printWriter.println("</td>");
			printWriter.println("<td>");
			printWriter.println("symbol");
			printWriter.println("</td>");
			printWriter.println("<td>");
			printWriter.println("industry");
			printWriter.println("</td>");
			printWriter.println("<td>");
			printWriter.println("Total cost");
			printWriter.println("</td>");
			printWriter.println("</tr>");
			//table header
			if(companyInfo != null){
				nbr = Integer.parseInt(nbrShare1);
				printWriter.println("<tr>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getName());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getAddedOn());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getExchange());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getSymbol());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getIndustry());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice() * nbr);
				printWriter.println("</td>");
				printWriter.println("</tr>");
			}
			String tickerSymbole2 = request.getParameter("tickerSymbole2");
			String nbrShare2 = request.getParameter("nbrShare2");
			companyInfo = getCompanyInfo(tickerSymbole2, companies);
			if(companyInfo != null){
				nbr = Integer.parseInt(nbrShare2);
				printWriter.println("<tr>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getName());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getAddedOn());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getExchange());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getSymbol());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getIndustry());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice() * nbr);
				printWriter.println("</td>");
				printWriter.println("</tr>");
			}
			String tickerSymbole3 = request.getParameter("tickerSymbole3");
			String nbrShare3 = request.getParameter("nbrShare3");
			companyInfo = getCompanyInfo(tickerSymbole3, companies);
			if(companyInfo != null){
				nbr = Integer.parseInt(nbrShare3);
				printWriter.println("<tr>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getName());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getAddedOn());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getExchange());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getSymbol());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getIndustry());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice() * nbr);
				printWriter.println("</td>");
				printWriter.println("</tr>");
			}
			String tickerSymbole4 = request.getParameter("tickerSymbole4");
			String nbrShare4 = request.getParameter("nbrShare4");
			companyInfo = getCompanyInfo(tickerSymbole4, companies);
			if(companyInfo != null){
				nbr = Integer.parseInt(nbrShare4);
				printWriter.println("<tr>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getName());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getAddedOn());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getExchange());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getSymbol());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getIndustry());
				printWriter.println("</td>");
				printWriter.println("<td>");
				printWriter.println(companyInfo.getPrice() * nbr);
				printWriter.println("</td>");
				printWriter.println("</tr>");
			}
			printWriter.println("</table>");
		}
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

	private CompanyInfo getCompanyInfo(String tickerSymbole, List<CompanyInfo> companies) {
		if(companies != null  && !companies.isEmpty()){
			for(CompanyInfo companyInfo: companies){
				if(companyInfo.getSymbol().equalsIgnoreCase(tickerSymbole)){
					return companyInfo;
				}
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
