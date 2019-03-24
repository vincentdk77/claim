package com.sinosoft.claim.ui.control.facade;
    
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.jdom.Element;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.ui.control.action.UICertifyImgAction;
import com.sinosoft.claim.util.OperXML;
import com.sinosoft.sysframework.common.datatype.DateTime;
public class UICeriftyServerFacade1 extends HttpServlet {
 
	String iBody = ""; //������������
	public static String insert = "insert";      
	public static String insertAll = "insertAll";      
	public static String delete = "delete";      
	public static String update = "update";    
	public static String findByPrimaryKey = "findByPrimaryKey";    
	public static String findByConditions = "findByConditions";    
	public void init() throws ServletException
	{
	} 
  
	/**
	 * Process the HTTP Get request�����п��Ʒ������������XML������������д���ݷ�����
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws
			ServletException, IOException
	{   
		String strReturn = "";
		DataInputStream input = null;
		BufferedOutputStream output = null;
		try
		{ 
			//��־
			String flag="false";
			input = new DataInputStream(request.getInputStream());        //������
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream(); //����д�붫������			
			byte[] data = null;   //����	
			byte[] b = new byte[1024];		//temp
			int read = 0;			//temp
			//ת��������
			while ( (read = input.read(b)) > 0)
			{
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
			//�������
			input.close();
			//���ܵ�����ת�����ַ���
			String strData = new String(data);
			//�������ݲ���Ӧ��Ӧ�ķ���
			flag = this.doDealData(response, strData);
			//����ɹ���ʶ
			output = new BufferedOutputStream(response.getOutputStream());
			strReturn =flag+"" ;
			output.write(strReturn.getBytes());
			output.close();
		}
		catch (Exception e)
		{
			output = new BufferedOutputStream(response.getOutputStream());
			strReturn = "false";
			output.write(strReturn.getBytes());
			output.close();
		}
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
	  OperXML operXML = new OperXML();
	  PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();
	  //����ͼƬר�õ�dto
	  UICertifyImgAction uiCertifyImgAction= new UICertifyImgAction();
       try {
        operXML.parserFromXMLString(iData);
        Element eType = operXML.getElement("Interface"); 
        iBody = eType.getValue();
        
        List KeyList = operXML.getChildrenElement(iData, iBody);
        Element item = null; 
	     if (KeyList.size() < 1)
	     {
	        throw new Exception("�������Ͳ�ƥ�䣡");
         }
	      
	     List certifyImgList = new ArrayList(); 
	     for(int i = 0;i<KeyList.size();i++){ 
           item = (Element) KeyList.get(i); 
           PrpLcertifyImgDto prpLcertifyImgDtoTemp = new PrpLcertifyImgDto();
           prpLcertifyImgDtoTemp.setBusinessNo(operXML.getKeyValue(item, "businessNo"));
           prpLcertifyImgDtoTemp.setLossItemCode(operXML.getKeyValue(item, "lossItemCode"));
           prpLcertifyImgDtoTemp.setLossItemName(operXML.getKeyValue(item, "lossItemName"));
           prpLcertifyImgDtoTemp.setTypeCode(operXML.getKeyValue(item, "typeCode"));
           //lixiang add
           
           prpLcertifyImgDtoTemp.setPicName(operXML.getKeyValue(item, "picName"));
           prpLcertifyImgDtoTemp.setSignInDate(new DateTime(operXML.getKeyValue(item, "signInDate"),DateTime.YEAR_TO_DAY));
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
             
           certifyImgList.add(prpLcertifyImgDtoTemp);
	       PropertyUtils.copyProperties(prpLcertifyImgDto,prpLcertifyImgDtoTemp);
	     }  
	     
	     prpLcertifyImgDto.setCertifyImgList(certifyImgList);
        //�жϺ������͵ĵ���
        
        if (iBody.equals(insert)) {
          //return uiWorkFlowUWInterFaceFacade.addInformationOnVeric(LflowID,lLogNo,businessNo,notionInfo,handlerCode) ;
          uiCertifyImgAction.save(prpLcertifyImgDto);
        }else if (iBody.equals(delete)) {
          uiCertifyImgAction.delete(prpLcertifyImgDto);
        }else if (iBody.equals(update)) {
          uiCertifyImgAction.update(prpLcertifyImgDto); 
        }else if (iBody.equals(findByPrimaryKey)) { 
            PrpLcertifyImgDto PrpLcertifyImg5=   (PrpLcertifyImgDto)uiCertifyImgAction.findByPrimaryKey(prpLcertifyImgDto);
            //ƴ�����ַ���
            strRe = "<?xml version=\"1.0\" encoding=\"gb2312\" standalone=\"yes\" ?>";
            strRe += "<ClaimData>";
            //��֯����    
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
    <Interface>����</Interface>
    <����>
        <businessNo>����ҵ�����</businessNo>
        <serialNo>�������</serialNo>
        <lossItemCode>���Ա�Ĵ���</lossItemCode>
        <lossItemName>���Ա������</lossItemName>
        <typeCode>����</typeCode>
        <picName>����</picName> 
        <signInDate>����</signInDate>
        <thirdPartyCode>����</thirdPartyCode>
        <uploadFileName>����</uploadFileName>
        <imgFileName>����</imgFileName>
        <picPath>����</picPath>
        <collectorName>����</collectorName>
        <receiveStatus>����</receiveStatus>
        <flag>����</flag>
        <imgSize>����</imgSize> 
        <uploadNodeFlag>����</uploadNodeFlag>   
        <displayName>����</displayName>
        <policyNo>����</policyNo> 
    </����>
    
    <����>
        <businessNo>����ҵ�����</businessNo>
        <serialNo>�������</serialNo>
        <lossItemCode>���Ա�Ĵ���</lossItemCode>
        <lossItemName>���Ա������</lossItemName>
        <typeCode>����</typeCode>
        <picName>����</picName> 
        <signInDate>����</signInDate>
        <thirdPartyCode>����</thirdPartyCode>
        <uploadFileName>����</uploadFileName>
        <imgFileName>����</imgFileName>
        <picPath>����</picPath>
        <collectorName>����</collectorName>
        <receiveStatus>����</receiveStatus>
        <flag>����</flag>
        <imgSize>����</imgSize> 
        <uploadNodeFlag>����</uploadNodeFlag>   
        <displayName>����</displayName>
        <policyNo>����</policyNo> 
    </����> 
</CertifyData>  
*/