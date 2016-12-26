package com.das.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.das.Product;
import com.das.sales.order.OrderDetail;
import com.das.sales.order.Orders;
import com.das.sales.order.Payment;
import com.das.users.Customer;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("kirti");
		SessionFactory factory = new Configuration().configure
	    ("com/das/hibernate/config/hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Orders orders=new Orders();
		orders.setErrLoc(request.getParameter("ErrLoc"));
		orders.setErrMsg(request.getParameter("ErrMsg"));
		orders.setTransactionStatus(null);
		orders.setFulFilled(Boolean.parseBoolean(request.getParameter("FulFilled")));
		orders.setPaid(Boolean.parseBoolean(request.getParameter("Paid")));
		String oDate = request.getParameter("OrderDate");
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		try {
			orders.setOrderDate(sdf.parse(oDate));
		} catch (Exception e) {
			//e.printStackTrace();
		}
		orders.getPayment().add((Payment)session.get(Payment.class, 15));
		
		OrderDetail od=new OrderDetail();
		//String price = 
		//System.out.println("price is " + price);
		od.setPrice(Float.parseFloat(request.getParameter("Price").trim()));
		od.setQuantity(Integer.parseInt(request.getParameter("Quantity")));
		od.setTotal(Integer.parseInt(request.getParameter("Total")));
		od.setSize(Integer.parseInt(request.getParameter("Size")));
		od.setColor(request.getParameter("Color"));
		String sDate = request.getParameter("ShipDate");
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-DD");
		//od.setOrders((Orders)session.get(Orders.class, 15));
		try {
			od.setShipDate(sdf1.parse(sDate));
		} catch (ParseException e) {
			
		}
		String bDate = request.getParameter("BillDate");
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-DD");
		try {
			od.setBillDate(sdf2.parse(bDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		od.getProduct().add((Product)session.get(Product.class,15));

		session.save(orders);
		session.save(od);
		session.getTransaction().commit();
		session.close();
		doGet(request, response);
	}
}