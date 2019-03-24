package com.sinosoft.claim.ui.control.facade;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.Action;

import com.sinosoft.claim.dto.custom.AbstractDto;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.ParameterDto;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;

public class UICommonFacade extends Action
{
  /**
   * @Des ������EXCEL��QueryStyleΪ1��Ϊ3��
   * @Parameter ArrayList arrHashResult��arrHashResult��hashResult�ļ��ϣ�hashResult��Key MidResultConfig.ItemColumn��Value ��Ӧ���Dto��Ӧ�ֶε�ֵ��
   * @Parameter ArrayList arrConfigs��ҳ��������ϣ�
   * @Parameter int intExcelFlag
   * @Parameter HttpServletResponse httpServletResponse
   * @author zhangshengli
   * @Date 2005-03-10
   */
  public void exportExcel(ArrayList arrHashResult,ArrayList arrConfigs,int intExcelFlag,HttpServletResponse httpServletResponse) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); //�����µ�HSSFWorkbook����
    HSSFSheet hssfSheet = hssfWorkbook.createSheet("Receivable"); //�����µ�HSSFSheet����
    HSSFRow hssfRow = null;
    HSSFCell hssfCell = null;
    HashMap hashResult = null;

    String strItemColumn = "";
    String strDataType = "";

    int i = 0;
    int j = 0;

    //����EXCEL
    if(intExcelFlag==1) //����EXCEL
      httpServletResponse.setContentType("application/msexcel");
    else if(intExcelFlag==3) //����EXCEL
      httpServletResponse.setContentType("application/vnd.ms-excel");

    //����
    hssfRow = hssfSheet.createRow((short)0);//�������У��кŴ�0��ʼ
    for(i=0;i<arrConfigs.size();i++)
    {
      midResultConfigDto = new MidResultConfigDto();
      midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);
      hssfCell = hssfRow.createCell((short)i);
      hssfCell.setEncoding(HSSFCell.ENCODING_UTF_16);
      hssfCell.setCellValue(midResultConfigDto.getItemColumnName());
    }

    //����
    midResultConfigDto = null;
    for(i=0;i<arrHashResult.size();i++)
    {
      hashResult = new HashMap();
      hashResult = (HashMap)arrHashResult.get(i);
      hssfRow = hssfSheet.createRow((short)(i+1)); //�������У��кŴ�1��ʼ

      for(j=0;j<arrConfigs.size();j++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(j);
        hssfCell = hssfRow.createCell((short)j);

        strItemColumn = midResultConfigDto.getItemColumn();
        strDataType = midResultConfigDto.getDataType();

        if(strDataType.equals("String"))
        {
          hssfCell.setEncoding(HSSFCell.ENCODING_UTF_16);
          hssfCell.setCellValue(((String)hashResult.get(strItemColumn).toString()));
        }
        else if (strDataType.equals("Double"))
          hssfCell.setCellValue(((Double)hashResult.get(strItemColumn)).doubleValue());
        else if (strDataType.equals("Float"))
          hssfCell.setCellValue(((Float)hashResult.get(strItemColumn)).floatValue());
        else if (strDataType.equals("Integer"))
          hssfCell.setCellValue(((Integer)hashResult.get(strItemColumn)).intValue());
      }
    }

    OutputStream out = httpServletResponse.getOutputStream();
    hssfWorkbook.write(out);
    out.close();
    hssfWorkbook = null;
    hashResult = null;
    arrConfigs = null;
  }

  /**
   * @Des ��html��excel
   * @Parameter ArrayList arrHashResult��arrHashResult��hashResult�ļ��ϣ�hashResult��Key MidResultConfig.ItemColumn��Value ��Ӧ���Dto��Ӧ�ֶε�ֵ��
   * @Parameter ArrayList arrConfigs
   * @Parameter int intExcelFlag
   * @Parameter HttpServletResponse httpServletResponse
   * @author zhangshengli
   * @Date  2005-03-10
   */
  public void openExcel(ArrayList arrHashResult,ArrayList arrConfigs,int intExcelFlag,HttpServletResponse httpServletResponse) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    Vector vecConfigs = new Vector();
    HashMap hashResult = null;
    PrintWriter writer = httpServletResponse.getWriter();
    StringBuffer excel = new StringBuffer();


    String strItemColumn = "";
    String strDataType = "";

    int i = 0;
    int j = 0;

    //����EXCEL
    httpServletResponse.setContentType("application/vnd.ms-excel");

    //excel.append("<html><meta http-equiv='Content-Type' content='text/html; charset=GBK'><head><title></title></head>");
    excel.append("<html><head><title></title></head>");
    excel.append("<body><table border='1' bordercolor='#CCCCCC' cellspacing='0' cellpadding='0'>");

    //����
    excel.append("<tr>");
    for(i=0;i<arrConfigs.size();i++)
    {
      midResultConfigDto = new MidResultConfigDto();
      midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);
      //excel.append("<td>"+new String(midResultConfigDto.getItemColumnName().getBytes("ISO-8859-1"),"GBK")+"</td>");
      excel.append("<td>"+midResultConfigDto.getItemColumnName()+"</td>");
    }
    excel.append("</tr>");

    //����
    for(i=0;i<arrHashResult.size();i++)
    {
      hashResult = new HashMap();
      hashResult = (HashMap)arrHashResult.get(i);

      excel.append("<tr>");
      for(j=0;j<arrConfigs.size();j++)
      {
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(j);
        strItemColumn = midResultConfigDto.getItemColumn();
         //excel.append("<td>"+new String((((String)hashResult.get(strItemColumn)).getBytes("ISO-8859-1"),"GBK"))+"</td>");
        excel.append("<td>"+hashResult.get(strItemColumn)+"</td>");
      }
      excel.append("</tr>");
    }

    excel.append("</table></body></html>");

    writer.print(excel.toString());
    writer.flush();
    writer.close();
  }

  /**
   * @Des ��÷�ҳ��Ϣ
   * @Parameter AnaRepCommonDto anaRepCommonDto
   * @Parameter int intRowsCount ��¼��
   * @author zhangshengli
   * @Date 2005-03-13
   */
  public AbstractDto genPage(AnaRepCommonDto anaRepCommonDto,int intRowsCount) throws Exception
  {
    AbstractDto abstractDto = null;

    int intPageFlag = 0; //��ҳ��־
    int intPageCount = 1; //ҳ��

    abstractDto = anaRepCommonDto.getAbstractDto();
    intPageFlag = anaRepCommonDto.getPageFlag();

    if(intPageFlag!=0)
    {
      if(intRowsCount%abstractDto.getRowsPerPage()==0)
        intPageCount = intRowsCount/abstractDto.getRowsPerPage();
      else
        intPageCount = intRowsCount/abstractDto.getRowsPerPage()+1;
    }
    else
    {
      intPageCount = 1;
    }

    abstractDto.setRowsCount(intRowsCount);
    abstractDto.setPageCount(intPageCount);

    return abstractDto;
  }

  /**
   * �õ���ѯ����Ŀ
   * @param  httpServletRequest
   * @return Vector
   */
  public Vector genConfigs(HttpServletRequest httpServletRequest)
  {
    MidResultConfigDto midResultConfigDto = null;

    HttpSession session = httpServletRequest.getSession();
    ArrayList arrConfigsSum = (ArrayList)session.getAttribute("ConfigsSum"); //ConfigsSum����jspҳ���з���MidResultConfig�еĳ�ʼֵ
    ArrayList arrConfigsDetail = (ArrayList)session.getAttribute("ConfigsDetail"); //ConfigsSum����jspҳ���з���MidResultConfig�еĳ�ʼֵ
    Collection collectionSum = new ArrayList();
    Collection collectionDetail = new ArrayList();
    Vector configs = new Vector();

    String strCheckName = "";
    String strCheckNo = "";
    String strURL = "";
    String strLinkFlag = "";

    int i = 0;
    int j = 0;

    if(arrConfigsSum!=null)
    {
      for(i=0;i<arrConfigsSum.size();i++)
      {
//        strCheckName = "isSum"+i+"Checked";
//        strCheckNo = "Sum"+i+"No";

//        if(httpServletRequest.getParameter(strCheckName)!=null)
//        {
          midResultConfigDto = new MidResultConfigDto();
//          if(httpServletRequest.getParameter(strCheckName).equals("true"))
//          {
//            j = Integer.parseInt(httpServletRequest.getParameter(strCheckNo));
            midResultConfigDto = (MidResultConfigDto)arrConfigsSum.get(i);
            collectionSum.add(midResultConfigDto);
//          }
//        }
      }

      if(collectionSum.size()>0)
      {
        configs.add("Sum");
        configs.add(collectionSum);
      }
    }
/*
    if(arrConfigsDetail!=null)
    {
      for(i=0;i<arrConfigsDetail.size();i++)
      {
        strCheckName = "isDetail"+i+"Checked";
        strCheckNo = "Detail"+i+"No";

        if(httpServletRequest.getParameter(strCheckName)!=null)
        {
          midResultConfigDto = new MidResultConfigDto();
          if(httpServletRequest.getParameter(strCheckName).equals("true"))
          {
            j = Integer.parseInt(httpServletRequest.getParameter(strCheckNo));
            midResultConfigDto = (MidResultConfigDto)arrConfigsDetail.get(j);
            collectionDetail.add(midResultConfigDto);
          }
        }
      }

      if(collectionDetail.size()>0)
      {
        configs.add("Detail");
        configs.add(collectionDetail);
      }
    }
*/
    return configs;
  }

  /**
   * ����viewhelper�и���ҳ����������ParameterDto����֪����viewhelperƵ���ĵ���facade�Ƿ��ʱ��
   * @param ��ӦParameterDto��8��˽������
   * @return ParameterDto
   */
  public ParameterDto genParameterDto(String strLinkSign,String strLeftFlag1,String strItemColumn,String strParameterSign,String strLeftFlag2,String strParameterValue,String strRightFlag2,String strRightFlag1)
  {
    ParameterDto parameterDto = new ParameterDto();

    parameterDto.setLinkSign(strLinkSign);
    parameterDto.setLeftFlag1(strLeftFlag1);
    parameterDto.setItemColumn(strItemColumn);
    parameterDto.setParameterSign(strParameterSign);
    parameterDto.setLeftFlag2(strLeftFlag2);
    parameterDto.setParameterValue(strParameterValue);
    parameterDto.setRightFlag2(strRightFlag2);
    parameterDto.setRightFlag1(strRightFlag1);

    return parameterDto;
  }
}

