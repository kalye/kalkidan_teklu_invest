package com.homework3.servlet;

import java.io.IOException;
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
 * Servlet implementation class ProcessPurchase
 */
@WebServlet("/processstockpurchase")
public class ProcessPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	private static final String DB_URL="jdbc:mysql://uml.cs.uga.edu:3306/stocks";
	private static final String SQL = "SELECT c.name, c.addedOn, c.exchange, c.symbol, c.industry, s.price from company c,  stock_price s where c.symbol = s.symbol";
	private static final String USER = "demo";
	private static final String PASS = "demo";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessPurchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean valid = validateEntry(request, response);
		if(!valid){
			request.getRequestDispatcher("/error").forward(request, response);
			return;
		}
		List<CompanyInfo> companies = getCompanies(request);
		valid = validateSymbolExist(request, companies); 
		if(!valid){
			request.getRequestDispatcher("/error").forward(request, response);
			return;
		}
		request.setAttribute("companies", companies);
		request.getRequestDispatcher("/purchasedStockList").forward(request, response);
	}

	private boolean validateSymbolExist(HttpServletRequest request, List<CompanyInfo> companies) {
		if(companies != null  && !companies.isEmpty()){
			String tickerSymbole1 = request.getParameter("tickerSymbole1");
			String tickerSymbole2 = request.getParameter("tickerSymbole2");
			String tickerSymbole3 = request.getParameter("tickerSymbole3");
			String tickerSymbole4 = request.getParameter("tickerSymbole4");
			boolean symbol1 = false, symbol2 = false, symbol3 = false, symbol4 = false;
			for(CompanyInfo companyInfo: companies){
				if(tickerSymbole1.equals(companyInfo.getSymbol())){
					symbol1 = true;
				} else if(tickerSymbole2.equals(companyInfo.getSymbol())){
					symbol2 = true;
				} else if(tickerSymbole3.equals(companyInfo.getSymbol())){
					symbol3 = true;
				} else if(tickerSymbole4.equals(companyInfo.getSymbol())){
					symbol4 = true;
				}
			}
			if(symbol1 && symbol2 && symbol3 && symbol4){
				return true;
			} else if(!symbol1 && !symbol2 && !symbol3 && !symbol4){
				request.setAttribute("error", "Ticker symbol " + tickerSymbole1 + " doesn't");
				request.setAttribute("error", "Ticker symbol " + tickerSymbole2 + " doesn't");
				request.setAttribute("error", "Ticker symbol " + tickerSymbole3 + " doesn't");
				request.setAttribute("error", "Ticker symbol " + tickerSymbole4 + " doesn't");
				return false;
			}else if(!symbol1) {
				request.setAttribute("error", "Ticker symbol " + tickerSymbole1 + " doesn't");
				return false;
			}else if(!symbol2) {
				request.setAttribute("error", "Ticker symbol " + tickerSymbole2 + " doesn't");
				return false;
			}else if(!symbol3) {
				request.setAttribute("error", "Ticker symbol " + tickerSymbole3 + " doesn't");
				return false;
			}else if(!symbol4) {
				request.setAttribute("error", "Ticker symbol " + tickerSymbole4 + " doesn't");
				return false;
			}
			
		}
		return false;
	}

	private List<CompanyInfo> getCompanies(HttpServletRequest request) {
		List<CompanyInfo> companyInfos = new ArrayList<CompanyInfo>();
		Statement stmt = null;
		Connection conn = null;
		try{
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			// Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				String name  = rs.getString("name");
				String exchange = rs.getString("exchange");
				String symbol = rs.getString("symbol");
				String industry = rs.getString("industry");
				double price = rs.getDouble("price");
				Date addedOn = rs.getDate("addedOn");
				CompanyInfo companyInfo = new CompanyInfo(name, exchange, symbol, industry, price, addedOn);
				companyInfos.add(companyInfo);
			}

			// Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			request.setAttribute("error", se.getMessage());
			se.printStackTrace();
		}catch(Exception e){
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				request.setAttribute("error", se2.getMessage());
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				request.setAttribute("error", se.getMessage());
				se.printStackTrace();
			}//end finally try
		} //end try

		return companyInfos;
	}

	private boolean validateEntry(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String tickerSymbole1 = request.getParameter("tickerSymbole1");
		if(tickerSymbole1 == null || "".equals(tickerSymbole1.trim())){
			request.setAttribute("error", "Ticker symbol must be given");
			return false;
		}
		String nbrShare1 = request.getParameter("nbrShare1");
		if(nbrShare1 == null || "".equals(nbrShare1.trim())){
			request.setAttribute("error", "You must give number of share you want to buy for the first company");
			return false;
		}

		String tickerSymbole2 = request.getParameter("tickerSymbole2");
		if(tickerSymbole2 == null || "".equals(tickerSymbole2.trim())){
			request.setAttribute("error", "Ticker symbol must be given");
			return false;
		}
		String nbrShare2 = request.getParameter("nbrShare2");
		if(nbrShare2 == null || "".equals(nbrShare2.trim())){
			request.setAttribute("error", "You must give number of share you want to buy for the second company");
			return false;
		}

		String tickerSymbole3 = request.getParameter("tickerSymbole3");
		if(tickerSymbole3 == null || "".equals(tickerSymbole3.trim())){
			request.setAttribute("error", "Ticker symbol must be given");
			return false;
		}
		String nbrShare3 = request.getParameter("nbrShare3");
		if(nbrShare3 == null || "".equals(nbrShare3.trim())){
			request.setAttribute("error", "You must give number of share you want to buy for the third company");
			return false;
		}
		String tickerSymbole4 = request.getParameter("tickerSymbole4");
		if(tickerSymbole4 == null || "".equals(tickerSymbole4.trim())){
			request.setAttribute("error", "Ticker symbol must be given");
			return false;
		}
		String nbrShare4 = request.getParameter("nbrShare4");
		if(nbrShare4 == null || "".equals(nbrShare4.trim())){
			request.setAttribute("error", "You must give number of share you want to buy for the fourth company");
			return false;
		}
		try{
			int share1 = Integer.parseInt(nbrShare1);
			int share2 = Integer.parseInt(nbrShare2);
			int share3 = Integer.parseInt(nbrShare3);
			int share4 = Integer.parseInt(nbrShare4);
			if(share1 > 0 && share2 > 0 && share3 > 0 && share4 > 0){
				return true;
			} else if(share1 <= 0 ){
				request.setAttribute("error", "Share number " + share1 + " must be given");
				return false;
			}
			else if(share2 <= 0 ){
				request.setAttribute("error", "Share number " + share2 + " must be given");
				return false;
			}else if(share3 <= 0 ){
				request.setAttribute("error", "Share number " + share3 + " must be given");
				return false;
			}else if(share4 <= 0 ){
				request.setAttribute("error", "Share number " + share4 + " must be given");
				return false;
			}
		} catch(Exception e){
			request.setAttribute("error", "You have to give integer number for shares.");
			e.printStackTrace();
			return false;
		}
		return true;

	}


}
