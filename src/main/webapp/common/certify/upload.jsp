<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jspsmart.upload.*" %>
<%
    

    try{   
    Enumeration e = request.getParameterNames();
    while(e.hasMoreElements()){
      String str1 = e.nextElement().toString();
      System.out.println(str1+"%%%%%%%%%%%%%:" +request.getParameter(str1));    
    }
    //ʵ��������bean
    com.jspsmart.upload.SmartUpload mySmartUpload=new com.jspsmart.upload.SmartUpload();
    //��ʼ��
    mySmartUpload.initialize(pageContext); 
    //�������ص����ֵ
    mySmartUpload.setMaxFileSize(1000 * 1024 * 1024); //ÿ���ļ����Ϊһ��
    // 2.�������ϴ����ݵĳ��ȡ�
    mySmartUpload.setTotalMaxFileSize(2000 * 700 * 1024); //ȫ���ļ���������Ϊ20��
    //�����ļ�
    mySmartUpload.upload();  
          /*
      //ѭ��ȡ���������ص��ļ�
      for (int i=0;i<mySmartUpload.getFiles().getCount();i++){
        //ȡ�����ص��ļ�
        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(i);
        if (!myFile.isMissing()){
          //ȡ�����ص��ļ����ļ���
          String myFileName=myFile.getFileName();
          //ȡ�ò�����׺���ļ���
          String  suffix=myFileName.substring(0,myFileName.lastIndexOf('.'));
          //ȡ�ú�׺��
          String  ext= mySmartUpload.getFiles().getFile(0).getFileExt();  
          //ȡ���ļ��Ĵ�С   
          int fileSize=myFile.getSize();
          //����·�� 
          String aa=request.getSession().getServletContext().getRealPath("/")+"\\";
          String trace=aa+myFileName;
          System.out.println(";;;;;;;;;;:::" + trace);   
          //ȡ�ñ�Ĳ���
          String test1 =  (String)mySmartUpload.getRequest().getParameter("test1"); 
          String test2 =  (String)mySmartUpload.getRequest().getParameter("test2");
          String[] test3 = mySmartUpload.getRequest().getParameterValues("test3");
          
          for(int i1=0;i1<test3.length;i1++){
            System.out.println(":::::test3::::" +i1 +":+"+test3[i1]);
          }
    System.out.println("^^^^^^^^^^^" + request.getParameter("test3"));
          System.out.println(":::::test1::::" + test1);
          System.out.println(":::::test2::::" + test2);
          //���ļ������ڷ������� 
          myFile.saveAs(trace,mySmartUpload.SAVE_PHYSICAL);
          
          out.println(("���سɹ�������").toString());
        } else { out.println(("����ʧ�ܣ�����").toString()); } 
      }//��ǰ���if��Ӧ 
      System.out.println("------1---------");
    mySmartUpload.stop();
      System.out.println("------2---------");
    mySmartUpload=null;
      System.out.println("------3---------");
      */
    } catch (SecurityException ex){
System.out.println("***************");    
          out.println(ex.getMessage());
    }  
    /*
    RequestDispatcher rd = request.getRequestDispatcher("http://www.sina.com.cn");
    System.out.println("dfsdffsd::::" + rd.toString());
    rd.forward(request,response);
    */
    //response.sendRedirect("http://www.sina.com.cn");
%>

 