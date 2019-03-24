package com.sinosoft.claim.ui.control.facade;
    
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.jdom.Element;

import com.sinosoft.claim.bl.facade.BLCertifyImgFacade;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.ui.control.action.UICertifyImgAction;
import com.sinosoft.claim.util.OperXML;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;




public class UICeriftyServerFacade extends HttpServlet {
	String iBody = ""; //接收数据类型
	public static String insert = "insert";      
	public static String insertAll = "insertAll";      
	public static String delete = "delete";      
	public static String update = "update";    
	public static String findByPrimaryKey = "findByPrimaryKey";    
	public static String findByConditions = "findByConditions";    
	public static final int   STEPTYPE  	=1;   
	public static final int   FIRST		    =1;   
	public static final int   SECOND	    =2;
	public static final int   THIRD			=3;
	public static final int   FOURTH		=4;


	public void init() throws ServletException
	{
	} 
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException
	{ 
		String  flag="false";
	    ObjectInputStream is = new ObjectInputStream(request.getInputStream());
	    
		String strReturn = "";
		BufferedOutputStream output = null;
		// 图片存放的服务器URL
	 	String serverURL=(String)AppConfig.get("sysconst.FILESERVLET") ;
		HttpURLConnection con=URLConnect(serverURL);
		try {
			int identify=((Integer) is.readObject()).intValue();
			if (identify>>FIRST==STEPTYPE){
			    String address= (String) is.readObject();
			    
				ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream());
				out.writeObject("show");	
				out.writeObject(address);
				out.flush();
				out.close();
				ObjectInputStream is1 = new ObjectInputStream(con.getInputStream());
				String errormsg= (String) is1.readObject();					    
				if (errormsg.equals("error_a")){
					is1.close();	
					ObjectOutputStream out1 = new ObjectOutputStream(response.getOutputStream());
					out1.writeObject("error_a");
					out1.flush();	
					out1.close();
				}
				if (errormsg.equals("success")){	
					    byte[] fileData = (byte[]) is1.readObject();
					    is1.close();	
					    ObjectOutputStream out1 = new ObjectOutputStream(response.getOutputStream());
					    out1.writeObject("success");						
					    out1.writeObject(fileData);
					    out1.flush();	
					    out1.close();
				}
				is1.close();
			} else if (identify>>SECOND==STEPTYPE){
					String businessno=(String) is.readObject();         //业务号（一般是报案号）
					String lossItemCode = (String) is.readObject();     //损失标的序号（车>0，非车暂时都为0。）
					String typeCode = (String) is.readObject();   //单证类型编号
					BLCertifyImgFacade blCertifyImgFacade= new BLCertifyImgFacade();
					String condition = " businessno='" + businessno + "' and ValidStatus ='1' and LossItemCode='" + lossItemCode + "'";
					/**
					 * typeCode==0时是非车险和意健险的单证,不区分类型
					 */
					if(!("0".equals(typeCode.trim()))){
						if(typeCode.length()==1){
							typeCode="0"+typeCode;
						}
						condition += " and substr(TYPECODE,1,2)='" + typeCode + "'";
					}
				    ArrayList collection=(ArrayList)blCertifyImgFacade.findByConditions(condition);

				    ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
				    out.writeObject(collection);
					out.flush();					   
		       		out.close();
		  }	else if (identify>>THIRD==STEPTYPE){
					String remoteFile = (String) is.readObject();
					// 处理jar包中生成的文件路径
					remoteFile = this.getRemoteFile(remoteFile);
					
					byte[] fileData = (byte[]) is.readObject();
					byte[] xmlData = (byte[]) is.readObject();
					String dirFile = (String) is.readObject();
					String strData = new String(xmlData, "GB2312");
					ObjectOutputStream out = new ObjectOutputStream(con.getOutputStream());
				    out.writeObject("upload");						
				    out.writeObject(remoteFile);
				    out.writeObject(fileData);
				    out.writeObject(dirFile);					   
					out.close();
					ObjectInputStream is3 = new ObjectInputStream(con.getInputStream());
					String getreturnmsg = (String) is3.readObject();
					if (getreturnmsg.equals("success")){
					   String remoteFileName = (String) is3.readObject();						
					   flag = this.doDealData(response, strData,remoteFile,remoteFileName);
					   output = new BufferedOutputStream(response.getOutputStream());
					   strReturn =flag+"" ;
					   output.write(strReturn.getBytes());
					   output.close();
					   is3.close();
					}else{
						is3.close();
					    throw new Exception("数据类型不匹配！"); 
					}
		  }	else if (identify>>FOURTH==STEPTYPE){
					byte[] xmlData = (byte[]) is.readObject();
					//接受的数据转换成字符串
					String strData = new String(xmlData);
					//解析数据并响应相应的方法
					flag = this.doDealData(response, strData);
					//输出成功标识
					String businessno=flag;
					BLCertifyImgFacade blCertifyImgFacade= new BLCertifyImgFacade();
				    ArrayList collection=(ArrayList)blCertifyImgFacade.findByConditions("businessno='"+businessno+"' and ValidStatus ='1' ");
				    ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
				    out.writeObject(collection);
					out.flush();					   
		       		out.close();
		 }
	} catch (Exception e){
	    System.out.println("图片上传/下载失败！" + new Date());
	    e.printStackTrace();
	}finally {
		is.close();
		con.disconnect();
	}
}


	private String getRemoteFile(String remoteFile) {
		// 取得当前日期字符串
		String strDate = DateTime.current().toString(DateTime.YEAR_TO_DAY);
		strDate = "/" + strDate.replaceAll("-", "") + "/";
		
		// 取得当前月份
		String strMonth = "/" + String.valueOf(Integer.parseInt(DateTime
				.current().toString(DateTime.MONTH_TO_MONTH))) + "/";
		/* 整理remoteFile的文件路径
		 * 1、删除/dubang//;
		 * 2、将月份信息替换为当前系统日期
		 */
		remoteFile = remoteFile.substring(remoteFile.indexOf("//") + 1,remoteFile.length());
		remoteFile = StringUtils.replace(remoteFile, strMonth, strDate);
		return remoteFile;
	}

	/**
	 * parse XML
	 * @param response HttpServletResponse
	 * @param iData String
	 * @throws Exception
	 */
	public String doDealData(HttpServletResponse response, String iData,String remoteFileDir, String remoteFileName) throws SQLException, Exception
	{
	  String strRe = "true"; 
	  OperXML operXML = new OperXML();
	  PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();
	  //处理图片专用的dto
	  UICertifyImgAction uiCertifyImgAction= new UICertifyImgAction();
       try {
        operXML.parserFromXMLString(iData);
        Element eType = operXML.getElement("Interface"); 
        iBody = eType.getValue();

        List KeyList = operXML.getChildrenElement(iData, iBody);
        Element item = null; 
	     if (KeyList.size() < 1)
	     {
	        throw new Exception("数据类型不匹配！");
         }
	      
	     List certifyImgList = new ArrayList(); 
	     for(int i = 0;i<KeyList.size();i++){ 
           item = (Element) KeyList.get(i); 
           PrpLcertifyImgDto prpLcertifyImgDtoTemp = new PrpLcertifyImgDto();
           prpLcertifyImgDtoTemp.setBusinessNo(operXML.getKeyValue(item, "businessNo"));
           prpLcertifyImgDtoTemp.setLossItemCode(operXML.getKeyValue(item, "lossItemCode"));
           prpLcertifyImgDtoTemp.setLossItemName(operXML.getKeyValue(item, "lossItemName"));
           prpLcertifyImgDtoTemp.setTypeCode(operXML.getKeyValue(item, "typeCode"));
           prpLcertifyImgDtoTemp.setPicName(operXML.getKeyValue(item, "picName"));
           prpLcertifyImgDtoTemp.setSignInDate(new DateTime(operXML.getKeyValue(item, "signInDate"),DateTime.YEAR_TO_DAY));
           prpLcertifyImgDtoTemp.setThirdPartyCode(operXML.getKeyValue(item, "thirdPartyCode"));
           prpLcertifyImgDtoTemp.setUploadFileName(operXML.getKeyValue(item, "uploadFileName"));
           prpLcertifyImgDtoTemp.setImgFileName(operXML.getKeyValue(item, "imgFileName"));
           //prpLcertifyImgDtoTemp.setPicPath(operXML.getKeyValue(item, "picPath"));
           prpLcertifyImgDtoTemp.setPicPath(remoteFileDir.substring(0,remoteFileDir.lastIndexOf("/")));
           prpLcertifyImgDtoTemp.setCollectorName(operXML.getKeyValue(item, "collectorName"));
           prpLcertifyImgDtoTemp.setReceiveStatus(operXML.getKeyValue(item, "receiveStatus"));
           prpLcertifyImgDtoTemp.setFlag(operXML.getKeyValue(item, "flag"));
           prpLcertifyImgDtoTemp.setImgSize(Double.parseDouble(operXML.getKeyValue(item, "imgSize")) );
           prpLcertifyImgDtoTemp.setUploadNodeFlag(operXML.getKeyValue(item, "uploadNodeFlag"));
           prpLcertifyImgDtoTemp.setDisplayName(operXML.getKeyValue(item, "displayName"));
           prpLcertifyImgDtoTemp.setPolicyNo(operXML.getKeyValue(item, "policyNo"));
           prpLcertifyImgDtoTemp.setValidStatus("1");
	       prpLcertifyImgDtoTemp.setImgFileName(remoteFileName);		   
           
             
           certifyImgList.add(prpLcertifyImgDtoTemp);

	       PropertyUtils.copyProperties(prpLcertifyImgDto,prpLcertifyImgDtoTemp);
	     }  
	     
	     prpLcertifyImgDto.setCertifyImgList(certifyImgList);
        //判断函数类型的调用
        
        if (iBody.equals(insert)) {
          uiCertifyImgAction.save(prpLcertifyImgDto);
        }else if (iBody.equals(delete)) {
          uiCertifyImgAction.delete(prpLcertifyImgDto);
        }else if (iBody.equals(update)) {
          uiCertifyImgAction.update(prpLcertifyImgDto); 
        }else if (iBody.equals(findByPrimaryKey)) { 
            PrpLcertifyImgDto PrpLcertifyImg5=   (PrpLcertifyImgDto)uiCertifyImgAction.findByPrimaryKey(prpLcertifyImgDto);
            //拼返回字符串
            strRe = "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>";
            strRe += "<ClaimData>";
            //组织数据    
            strRe += "<" + PrpLcertifyImg5.getBusinessNo() + ">";        
            strRe += "<businessNo>" + PrpLcertifyImg5.getBusinessNo() + "</businessNo>";
            strRe += "<lossItemCode>" + PrpLcertifyImg5.getLossItemCode() + "</lossItemCode>";
            strRe += "<lossItemName>" + PrpLcertifyImg5.getLossItemName() + "</lossItemName>";
            strRe += "<typeCode>" + PrpLcertifyImg5.getTypeCode() + "</typeCode>";
            strRe += "<picName>" + PrpLcertifyImg5.getPicName() + "</picName>";
            strRe += "<signInDate>" + PrpLcertifyImg5.getSignInDate() + "</signInDate>";
            strRe += "<thirdPartyCode>" + PrpLcertifyImg5.getThirdPartyCode() + "</thirdPartyCode>"; 
            strRe += "<uploadFileName>" + PrpLcertifyImg5.getUploadFileName() + "</uploadFileName>";
            strRe += "<imgFileName>" + PrpLcertifyImg5.getImgFileName() + "</imgFileName>";
            strRe += "<picPath>" + PrpLcertifyImg5.getPicPath() + "</picPath>";
            strRe += "<collectorName>" + PrpLcertifyImg5.getCollectorName() + "</collectorName>";
            strRe += "<receiveStatus>" + PrpLcertifyImg5.getReceiveStatus() + "</receiveStatus>";
            strRe += "<flag>" + PrpLcertifyImg5.getFlag() + "</flag>"; 
            strRe += "<imgSize>" + PrpLcertifyImg5.getImgSize() + "</imgSize>"; 
            strRe += "<uploadNodeFlag>" + PrpLcertifyImg5.getUploadNodeFlag() + "</uploadNodeFlag>";
            strRe += "<displayName>" + PrpLcertifyImg5.getDisplayName() + "</displayName>";
            strRe += "<policyNo>" + PrpLcertifyImg5.getPolicyNo() + "</policyNo>"; 
            strRe += "</" + PrpLcertifyImg5.getBusinessNo() + ">";
            strRe += "</ClaimData>";
        }
    }
    catch (SQLException ex)
    {
    	ex.printStackTrace();
      return "false";
    }
    catch (Exception ex)
    {
    	ex.printStackTrace();
      return "false";
    }
	  return strRe;
  }


	/**
	 * parse XML
	 * @param response HttpServletResponse
	 * @param iData String
	 * @throws Exception
	 */
	public String doDealData(HttpServletResponse response, String iData) throws SQLException, Exception
	{
	  String strRe = "true"; 
	  String strReno="";
	  OperXML operXML = new OperXML();
	  PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();
	  //处理图片专用的dto
	  UICertifyImgAction uiCertifyImgAction= new UICertifyImgAction();
       try {
        operXML.parserFromXMLString(iData);
        Element eType = operXML.getElement("Interface"); 
        iBody = eType.getValue();        
        List KeyList = operXML.getChildrenElement(iData, iBody);
        Element item = null; 
	     if (KeyList.size() < 1)
	     {
	        throw new Exception("数据类型不匹配！");
         }
	      
	     List certifyImgList = new ArrayList(); 
	     for(int i = 0;i<KeyList.size();i++){ 
           item = (Element) KeyList.get(i); 
           PrpLcertifyImgDto prpLcertifyImgDtoTemp = new PrpLcertifyImgDto();
           prpLcertifyImgDtoTemp.setBusinessNo(operXML.getKeyValue(item, "businessNo"));
           prpLcertifyImgDtoTemp.setLossItemCode(operXML.getKeyValue(item, "lossItemCode"));
           prpLcertifyImgDtoTemp.setLossItemName(operXML.getKeyValue(item, "lossItemName"));
           prpLcertifyImgDtoTemp.setTypeCode(operXML.getKeyValue(item, "typeCode"));
           prpLcertifyImgDtoTemp.setPicName(operXML.getKeyValue(item, "picName"));
        // prpLcertifyImgDtoTemp.setSignInDate(new DateTime(operXML.getKeyValue(item, "signInDate"),DateTime.YEAR_TO_DAY));
           
           //不晓得为什么这个时间保存不对，暂时用这个方式试一下。  2005-12-29
           prpLcertifyImgDtoTemp.setSignInDate(new DateTime((new java.util.Date())));
           
           prpLcertifyImgDtoTemp.setThirdPartyCode(operXML.getKeyValue(item, "thirdPartyCode"));
           prpLcertifyImgDtoTemp.setUploadFileName(operXML.getKeyValue(item, "uploadFileName"));
           prpLcertifyImgDtoTemp.setImgFileName(operXML.getKeyValue(item, "imgFileName"));
           prpLcertifyImgDtoTemp.setPicPath(operXML.getKeyValue(item, "picPath"));
           prpLcertifyImgDtoTemp.setCollectorName(operXML.getKeyValue(item, "collectorName"));
           prpLcertifyImgDtoTemp.setReceiveStatus(operXML.getKeyValue(item, "receiveStatus"));
           prpLcertifyImgDtoTemp.setFlag(operXML.getKeyValue(item, "flag"));
           prpLcertifyImgDtoTemp.setImgSize(Double.parseDouble(operXML.getKeyValue(item, "imgSize")) );
           prpLcertifyImgDtoTemp.setUploadNodeFlag(operXML.getKeyValue(item, "uploadNodeFlag"));
           prpLcertifyImgDtoTemp.setDisplayName(operXML.getKeyValue(item, "displayName"));
           prpLcertifyImgDtoTemp.setPolicyNo(operXML.getKeyValue(item, "policyNo"));
           strReno=  prpLcertifyImgDtoTemp.getBusinessNo();
           certifyImgList.add(prpLcertifyImgDtoTemp);
	       PropertyUtils.copyProperties(prpLcertifyImgDto,prpLcertifyImgDtoTemp);
	     }  
	     
	     prpLcertifyImgDto.setCertifyImgList(certifyImgList);
        //判断函数类型的调用
        
        if (iBody.equals(insert)) {
          //return uiWorkFlowUWInterFaceFacade.addInformationOnVeric(LflowID,lLogNo,businessNo,notionInfo,handlerCode) ;
          uiCertifyImgAction.save(prpLcertifyImgDto);
        }else if (iBody.equals(delete)) {
          uiCertifyImgAction.delete(prpLcertifyImgDto);
        }else if (iBody.equals(update)) {
          uiCertifyImgAction.update(prpLcertifyImgDto); 
        }else if (iBody.equals(findByPrimaryKey)) { 
            PrpLcertifyImgDto PrpLcertifyImg5=   (PrpLcertifyImgDto)uiCertifyImgAction.findByPrimaryKey(prpLcertifyImgDto);
            //拼返回字符串
            strRe = "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>";
            strRe += "<ClaimData>";
            //组织数据    
            strRe += "<" + PrpLcertifyImg5.getBusinessNo() + ">";        
            strRe += "<businessNo>" + PrpLcertifyImg5.getBusinessNo() + "</businessNo>";
            strRe += "<lossItemCode>" + PrpLcertifyImg5.getLossItemCode() + "</lossItemCode>";
            strRe += "<lossItemName>" + PrpLcertifyImg5.getLossItemName() + "</lossItemName>";
            strRe += "<typeCode>" + PrpLcertifyImg5.getTypeCode() + "</typeCode>";
            strRe += "<picName>" + PrpLcertifyImg5.getPicName() + "</picName>";
            strRe += "<signInDate>" + PrpLcertifyImg5.getSignInDate() + "</signInDate>";
            strRe += "<thirdPartyCode>" + PrpLcertifyImg5.getThirdPartyCode() + "</thirdPartyCode>"; 
            strRe += "<uploadFileName>" + PrpLcertifyImg5.getUploadFileName() + "</uploadFileName>";
            strRe += "<imgFileName>" + PrpLcertifyImg5.getImgFileName() + "</imgFileName>";
            strRe += "<picPath>" + PrpLcertifyImg5.getPicPath() + "</picPath>";
            strRe += "<collectorName>" + PrpLcertifyImg5.getCollectorName() + "</collectorName>";
            strRe += "<receiveStatus>" + PrpLcertifyImg5.getReceiveStatus() + "</receiveStatus>";
            strRe += "<flag>" + PrpLcertifyImg5.getFlag() + "</flag>"; 
            strRe += "<imgSize>" + PrpLcertifyImg5.getImgSize() + "</imgSize>"; 
            strRe += "<uploadNodeFlag>" + PrpLcertifyImg5.getUploadNodeFlag() + "</uploadNodeFlag>";
            strRe += "<displayName>" + PrpLcertifyImg5.getDisplayName() + "</displayName>";
            strRe += "<policyNo>" + PrpLcertifyImg5.getPolicyNo() + "</policyNo>"; 
            strRe += "</" + PrpLcertifyImg5.getBusinessNo() + ">";
            strRe += "</ClaimData>";
        }
    }
    catch (SQLException ex)
    {
    	ex.printStackTrace();
      return "false";
    }
    catch (Exception ex)
    {
    	ex.printStackTrace();
      return "false";
    }
	  return strReno;
  }


public HttpURLConnection URLConnect(String serverURL) throws IOException {
			 URL	url = new URL(serverURL);
			 HttpURLConnection con = (HttpURLConnection) url.openConnection();
		       con.setDoOutput(true);
		       con.setDoInput(true);
		       con.setRequestMethod("POST");
		       con.setUseCaches(false);
		       con.setDefaultUseCaches(false);
		       con.setRequestProperty("Content-Type", "application/octet-stream");
		       con.connect();
			return con;
		}



	/**
	 * Process the HTTP Post request
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException
	{ 
		doGet(request, response);
	}


}
/*
<?xml version="1.0" encoding="gb2312" standalone="yes" ?>
<CertifyData>
    <Interface>插入</Interface>
    <插入>
        <businessNo>属性业务号码</businessNo>
        <serialNo>属性序号</serialNo>
        <lossItemCode>属性标的代码</lossItemCode>
        <lossItemName>属性标的名称</lossItemName>
        <typeCode>数据</typeCode>
        <picName>数据</picName> 
        <signInDate>数据</signInDate>
        <thirdPartyCode>数据</thirdPartyCode>
        <uploadFileName>数据</uploadFileName>
        <imgFileName>数据</imgFileName>
        <picPath>数据</picPath>
        <collectorName>数据</collectorName>
        <receiveStatus>数据</receiveStatus>
        <flag>数据</flag>
        <imgSize>数据</imgSize> 
        <uploadNodeFlag>数据</uploadNodeFlag>   
        <displayName>数据</displayName>
        <policyNo>数据</policyNo> 
    </插入>
    
    <插入>
        <businessNo>属性业务号码</businessNo>
        <serialNo>属性序号</serialNo>
        <lossItemCode>属性标的代码</lossItemCode>
        <lossItemName>属性标的名称</lossItemName>
        <typeCode>数据</typeCode>
        <picName>数据</picName> 
        <signInDate>数据</signInDate>
        <thirdPartyCode>数据</thirdPartyCode>
        <uploadFileName>数据</uploadFileName>
        <imgFileName>数据</imgFileName>
        <picPath>数据</picPath>
        <collectorName>数据</collectorName>
        <receiveStatus>数据</receiveStatus>
        <flag>数据</flag>
        <imgSize>数据</imgSize> 
        <uploadNodeFlag>数据</uploadNodeFlag>   
        <displayName>数据</displayName>
        <policyNo>数据</policyNo> 
    </插入> 
</CertifyData>  
*/

