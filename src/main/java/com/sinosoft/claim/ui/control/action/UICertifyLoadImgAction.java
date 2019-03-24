package com.sinosoft.claim.ui.control.action;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UICertifyLoadImgAction extends HttpServlet {
  public UICertifyLoadImgAction() {
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    OutputStream outputStream = null;
    String strFilePath = request.getParameter("FileAddress");
    FileInputStream fileInputStream = null;
    ByteArrayOutputStream byteOut = null;
    
    try {     
      fileInputStream = new FileInputStream(strFilePath);
      byteOut = new ByteArrayOutputStream();

      byte[] data = null;
      byte[] b = new byte[1024];
      int read = 0;
      while ( (read = fileInputStream.read(b)) > 0) {
        byteOut.write(b, 0, read);
      }
      data = byteOut.toByteArray();
      
      outputStream = response.getOutputStream();
      outputStream.write(data);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
    	byteOut.close();
    	fileInputStream.close();
    	outputStream.close();
    }
  }


}

