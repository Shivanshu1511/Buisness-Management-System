/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.admin;

import com.connection.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author azads
 */
@WebServlet("/AdminAddOrder")
public class AdminAddOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs=request.getSession();   
        try{
            int customerId=Integer.parseInt(request.getParameter("ddl_customer"));
            int productId=Integer.parseInt(request.getParameter("ddl_product"));
            int quantity= Integer.parseInt(request.getParameter("quantity"));
            ResultSet rsCustomer=DatabaseConnection.getResultFromSqlQuery("select * from tblcustomer where id="+customerId);
            ResultSet rsProduct=DatabaseConnection.getResultFromSqlQuery("select * from tblproduct where id="+productId);
            if(rsCustomer.next() && rsProduct.next())
            {
            
		int id = 0;
		int order_no = 1000;
		int orderProducts = 0;
		int paymentId=new Random().nextInt(1000);
		String customerName = rsCustomer.getString("name");
		String mobile_number = rsCustomer.getString("phone");
		String email_id = rsCustomer.getString("email");
		String address = rsCustomer.getString("address");
		String address_type = "Home";
		String pincode = rsCustomer.getString("pin_code");
		String product_name = null;
//		int quantity = 0;
		String product_price = null;
		String product_selling_price = null;
		String product_total_price = null;
		String order_status = null;
		String payment_mode = "Cash";
		
		hs.setAttribute("paymentId", paymentId);
		int productAvailable=rsProduct.getInt("quantity");
                
                if(quantity<productAvailable)
                {
                try {
			ResultSet rsMaxOrderNo = DatabaseConnection.getResultFromSqlQuery("select max(order_no) from tblorders");
			if (rsMaxOrderNo.next()) {
				order_no = rsMaxOrderNo.getInt(1);
				order_no=1000+order_no;
			}
		
			
				order_no++;
				System.out.println("Order No  " + order_no);
				String image_name=rsProduct.getString("image_name");
				product_name = rsProduct.getString("name");
				
				product_price = rsProduct.getString("price");
				product_selling_price = rsProduct.getString("mrp_price");
				product_total_price = String.valueOf(Integer.parseInt(product_selling_price)*quantity);
				order_status = "Pending";
				orderProducts = DatabaseConnection.insertUpdateFromSqlQuery(
						"insert into tblorders(id,order_no,customer_name,mobile_number,email_id,address,address_type,pincode,image,product_name,quantity,product_price,product_selling_price,product_total_price,order_status,payment_mode,payment_id) values('"
								+ id + "','" + order_no + "','" + customerName + "','" + mobile_number + "','"
								+ email_id + "','" + address + "','" + address_type + "','" + pincode + "','"+image_name+"','"
								+ product_name + "','" + quantity + "','" + product_price + "','"
								+ product_selling_price + "','" + product_total_price + "','" + order_status + "','"
								+ payment_mode + "','"+paymentId+"')");
			
			if (orderProducts > 0) {
                                int updatedQuantity=productAvailable-quantity;
                                int up=DatabaseConnection.insertUpdateFromSqlQuery("update tblproduct set quantity="+updatedQuantity+" where id="+productId);
                                
				String message="Order Placed Successfully";
				hs.setAttribute("message", message);
				response.sendRedirect("admin-add-order.jsp");
			} else {
				String message="Order Failed";
				hs.setAttribute("message", message);
				response.sendRedirect("admin-add-order.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
                         String message="Exception Occurred";
				hs.setAttribute("message", message);
				response.sendRedirect("admin-add-order.jsp");
		}

            }
                else
                {
                                String message="Product Not Available in Stock, Please Check in Stock";
				hs.setAttribute("message", message);
				response.sendRedirect("admin-add-order.jsp");
                }
           
                }
		
              } 
           catch(Exception e)
           {
            String message="Exception Occured ";
				hs.setAttribute("message", message);
				response.sendRedirect("admin-add-order.jsp");
           }
    }

  
}
