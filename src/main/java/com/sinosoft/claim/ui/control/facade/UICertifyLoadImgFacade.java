/*
*
*/

package com.sinosoft.claim.ui.control.facade;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.claim.ui.control.action.UICertifyLoadImgAction;


/**
*
*/
public class UICertifyLoadImgFacade extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
           IOException {
   	   UICertifyLoadImgAction action = new UICertifyLoadImgAction ();
       action.doPost(request, response);

   }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
   }
}
