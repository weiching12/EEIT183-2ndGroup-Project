package com.market.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

import com.market.bean.MarketOrderBean;
import com.market.bean.PropBean;
import com.market.dao.MarketDao;
import com.market.util.JndiToJdbc;
@WebServlet("/GetSelectedMarketOrders")

public class GetSelectedMarketOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    int selectedGameId = Integer.valueOf((String) session.getAttribute("selectedGameIdForMarket"));
//	    response.getWriter().write(selectedGameId);
	    
			List<MarketOrderBean> selectedMarketOrders = MarketDao.getSelectedMarketOrders(selectedGameId);
			List<PropBean> selectedMarketProps = MarketDao.getSelectedMarketProps(selectedGameId);
			HttpSession SessionOfMarket = request.getSession();
			session.setAttribute("SeletedGameMrketOrders", selectedMarketOrders);
			session.setAttribute("SelectedProps", selectedMarketProps);
			request.getRequestDispatcher("/jsp/getSelectedMarketOrders.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
