package com.das.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.das.Brand;
import com.das.Product;
import com.das.sales.order.OrderDetail;
import com.das.sales.order.Orders;
import com.das.sales.order.Payment;
import com.das.transactions.Discount;
import com.das.users.Customer;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		SessionFactory factory = new Configuration().configure("com/das/hibernate/config/hibernate.cfg.xml")
				.buildSessionFactory();
		// Session session=factory.openSession();
		Query query = factory.openSession().createQuery("from Orders");
		List<Orders> list = query.list();
		Iterator<Orders> itr = list.iterator();

	    out.append("<html><header><title>Das Hardware Ltd</title>");
		out.append("<body><h2>Order</h2>");
		out.append("<table>");
		out.append("<tr><th>order id</th><th> is paid</th><th>is fulfilled</th> </tr>");
		while(itr.hasNext()){
			Orders odr = itr.next();
			out.append("<tr><td>"+ odr.getOrderId()+"</td><td>"+odr.isPaid()+"</td><td>"+
			 odr.isFulFilled()+"</td></tr>");
		}
		out.append("</table>");
		
		Query query1=factory.openSession().createQuery("from Product");
		List<Product> list1=query1.list();
		Iterator<Product> itr1=list1.iterator();
		
		out.append("<h2> Product</h2>");
		out.append("<table>");
        out.append("<tr><th> product id</th><th> product name</th>"
        		+ "<th> discount</th><th>category</th>"
        		+ "<th> brands available</th></tr>");
		while(itr1.hasNext())
		{
			Product pdt=itr1.next();
			List<Brand> pdtBrand = pdt.getBrand();
			String sBrand = "";
			for(int  i=0;i<pdtBrand.size() ; i++){
				sBrand = sBrand +","+pdtBrand.get(i).getBrandName();		
			}
			List<Discount> pdtDiscounts = pdt.getDiscount();
			String sdiscount = "";
			for(int  j=0;j<pdtDiscounts.size() ; j++){
				sdiscount = sdiscount +","+pdtDiscounts.get(j).getDiscountAmount();		
			}
			out.append("<tr><td>"+ pdt.getProductId()+"</td><td>"+pdt.getProductName()+
					   "</td><td>"+pdt.getDiscount()+"</td><td>"+pdt.getCategory()+"</td>"
					   		+ "<td>"+ sBrand+"</td>" +"</tr>");
		}
		out.append("</table>");
		Query query2=factory.openSession().createQuery("from Customer");
		List<Customer> list2=query2.list();
		Iterator<Customer> itr2=list2.iterator();
		
		out.append("<h2> Customer </h2>");
		out.append("<table>");
		out.append("<tr><th> use id </th><th> First name</th><th> Last Name </th><th> CustomerSince </th></tr>");
		while(itr2.hasNext())
		{
			Customer cst=itr2.next();
out.append("<tr><td>"+ cst.getUserId()+"</td><td>"+ cst.getFirstName()+"</td><td>"
+cst.getLastName()+"</td><td>"+cst.getCustomerSience()+"</td></tr>");
		}
		out.append("</table>");
		Query query3=factory.openSession().createQuery("from OrderDetail");
		List<OrderDetail> list3=query3.list();
		Iterator<OrderDetail> itr3=list3.iterator();
		out.append("<h2> OrderDetail</h2>");
		out.append("<table>");
		out.append("<tr><th> order detail id</th><th> price</th>"
				+ "<th> fulfilled</th><th>total</th>/<tr>");
		while(itr3.hasNext())
		{
			OrderDetail od=itr3.next();
out.append("<tr><td>"+od.getOrderDetailId()+"</td><td>"+od.getPrice()+
	"</td><td>"+od.isFulfilled()+"</td><td>"+od.getTotal()+"</td></tr>");
		}
		out.append("</table>");
		Query query4=factory.openSession().createQuery("from Payment");
		List<Payment> list4=query4.list();
		Iterator<Payment> itr4=list4.iterator();
		out.append("<h2> Payment</h2>");
		out.append("<table>");
		out.append("<tr><th> payment id</th><th> payment amount</th><th>is processed</th>/<tr>");
		while(itr4.hasNext())
		{
			Payment p=itr4.next();
			out.append("<tr><td>"+p.getPaymentId()+"</td><td>"+p.getPaymentAmount()+
					"</td><td>"+p.isProcessed()+"</td></tr>");
		}
		out.append("</table>");
		Query query5=factory.openSession().createQuery("from Brand");
		List<Brand> list5=query5.list();
		Iterator<Brand> itr5=list5.iterator();
		out.append("<h2> Brand </h2>");
		out.append("<table>");
		out.append("<tr><th> brand name </th></tr>");
		while(itr5.hasNext())
		{
			Brand b=itr5.next();
			out.append("<tr><td>"+b.getBrandName() +"</td></tr>");
			
		}
		out.append("</table>");
		out.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		SessionFactory factory = new Configuration().configure
			    ("com/das/hibernate/config/hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		Product product=new Product();
		product.setProductName(request.getParameter("ProductName").trim());
		Query queryProd=session.createQuery("from Product");
		List<Product> listProd=queryProd.list();
		if(listProd.contains(product)){
			product= listProd.get(listProd.indexOf(product));
		}
		else{
			product.setProductDescription(request.getParameter("ProductDescription"));
			product.setRanking(Integer.parseInt(request.getParameter("Ranking")));
			product.setAvailableColors(request.getParameter("AvailableColors"));
			product.setAvailableSize(Integer.parseInt(request.getParameter("AvailableSize")));
		}
		
		Brand prdBrand = new Brand();
		prdBrand.setBrandName(request.getParameter("Brand").trim());
		Query queryBrand=session.createQuery("from Brand");
		List<Brand> listBrand=queryBrand.list();
		if(listBrand.contains(prdBrand)){
			prdBrand= listBrand.get(listBrand.indexOf(prdBrand));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		String dsDate = request.getParameter("DiscountStartDate");
		try {
			product.setDiscountStartDate(sdf.parse(dsDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String deDate=request.getParameter("DiscountEndDate");
		try {
			product.setDiscountEndDate(sdf.parse(deDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		product.setUnitPrice(Float.parseFloat(request.getParameter("UnitPrice")));
		
		if(!product.getBrand().contains(prdBrand)){
			product.getBrand().add(prdBrand);
		}
		session.save(prdBrand);
		session.save(product);
		session.getTransaction().commit();
		session.close();
		doGet(request, response);
	}

}
