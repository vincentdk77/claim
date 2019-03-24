package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.claim.dto.custom.ParameterDto;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������SQL
 */
public class DBCommon
{
  private static Log logger = LogFactory.getLog(DBCommon.class);

  public DBCommon()
  {
  }

  /**
   * ���SQL����SELECT����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genSelect(ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strSelect = " SELECT "; //ƴ��SQL���ʱǰ�ո�
    String strColumnType = ""; //��SQL��SELECT���ֳ��ֵ���ʽ
    String strItemColumn = "";
    String strItemTable = "";

    //ƴ��SELECT����
    if(arrConfigs.size()>=1)
    {
      for(int i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strColumnType = midResultConfigDto.getColumnType();
        strItemColumn = midResultConfigDto.getItemColumn();
        strItemTable = midResultConfigDto.getItemTable();

        if(strColumnType.equals("S"))
          strSelect += "SUM("+strItemTable+"."+strItemColumn+") AS "+strItemColumn+",";
        else if(strColumnType.equals("C"))
          strSelect += "COUNT(*) AS "+strItemColumn+",";
        else if(strColumnType.equals("D"))
          strSelect += strItemTable+"."+strItemColumn+" AS "+strItemColumn+",";
        else if(strColumnType.equals("N")) //���ֶ�����е��ֶβ�����Ӧ�����ֶ������ż���ֵ
          strSelect += "'' AS "+strItemColumn+",";
      }

      //ȥ��SELECTβ�ġ�,��
      strSelect = strSelect.substring(0,strSelect.length()-1);
    }

    return strSelect;
  }

  /**
   * ���SQL����SELECT����
   * @param AnaRepCommonDto anaRepCommonDto����ʱû���õ��ò�������ͬ��Ӧ�ö�Ӧ�Ĳ������Ͳ�ͬ����UwReportDto��
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genSelect(AnaRepCommonDto anaRepCommonDto,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strSelect = " SELECT "; //ƴ��SQL���ʱǰ�ո�
    String strColumnType = ""; //��SQL��SELECT���ֳ��ֵ���ʽ
    String strItemColumn = "";
    String strItemTable = "";

System.out.println(arrConfigs.size());

    //ƴ��SELECT����
    if(arrConfigs.size()>=1)
    {
      for(int i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strColumnType = midResultConfigDto.getColumnType();
        strItemColumn = midResultConfigDto.getItemColumn();
	 strItemTable = midResultConfigDto.getItemTable();	
	if (anaRepCommonDto.getReportType().equals("report_bvisit")||
		anaRepCommonDto.getReportType().equals("report_bvisitp")||
		anaRepCommonDto.getReportType().equals("report_bvisitlist")){
		if (strItemColumn.equals("QuestionResult")){
	          strSelect += strItemTable+"."+strItemColumn+" ";
			break;
			}
	}

	if (anaRepCommonDto.getReportType().equals("report_cerloss")||
		anaRepCommonDto.getReportType().equals("report_check")
	)
		{
		if (strItemColumn.equals("ConsumeTime")){
	          strSelect += "round(sum(to_date(SubmitTime,'yyyy-mm-dd hh24:mi:ss') - SINOSOFT_to_date(FlowInTime,'yyyy-mm-dd hh24:mi:ss'))*24/count(flowid),4)"+" AS "+strItemColumn+",";			
			continue;			  
			}
		}

	if(	anaRepCommonDto.getReportType().equals("report_certi")||
		anaRepCommonDto.getReportType().equals("report_certip")||
		anaRepCommonDto.getReportType().equals("report_compp")||
		anaRepCommonDto.getReportType().equals("report_comppp")||
		anaRepCommonDto.getReportType().equals("report_veric")||
		anaRepCommonDto.getReportType().equals("report_vericp"))
		{
		if (strItemColumn.equals("ConsumeTime")){
	          strSelect += "round(sum(to_date(SubmitTime,'yyyy-mm-dd hh24:mi:ss') - SINOSOFT_to_date(FlowInTime,'yyyy-mm-dd hh24:mi:ss'))*24,4)"+" AS "+strItemColumn+",";			
			continue;			  
			}
		}
	
	if (anaRepCommonDto.getReportType().equals("report_bcheck"))
		{
		if (strItemColumn.equals("ConsumeTime")){
	          strSelect += "round(sum(to_date(SubmitTime,'yyyy-mm-dd hh24:mi:ss') - SINOSOFT_to_date(FlowInTime,'yyyy-mm-dd hh24:mi:ss'))*24/count(flowid),4)"+" AS "+strItemColumn+",";			
			continue;			  
			}
		}	
        if(strColumnType.equals("S"))
          strSelect += "SUM("+strItemTable+"."+strItemColumn+") AS "+strItemColumn+",";
        else if(strColumnType.equals("C"))
          strSelect += "COUNT(*) AS "+strItemColumn+",";
        else if(strColumnType.equals("D"))
          strSelect += strItemTable+"."+strItemColumn+" AS "+strItemColumn+",";
        else if(strColumnType.equals("N")) //���ֶ�����е��ֶβ�����Ӧ�����ֶ������ż���ֵ
          strSelect += "'' AS "+strItemColumn+",";
      }

      //ȥ��SELECTβ�ġ�,��
      strSelect = strSelect.substring(0,strSelect.length()-1);
    }

    return strSelect;
  }

  /**
   * ���SQL����from����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genFrom(ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HashMap hashItemTable = new HashMap(24);

    String strFrom = " FROM ";
    String strItemTable = "";

    int intCounter = 0;
    int i = 0;

    for(i=0;i<arrConfigs.size();i++)
    {
      midResultConfigDto = new MidResultConfigDto();
      midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

      strItemTable = midResultConfigDto.getItemTable();

      if(!hashItemTable.containsValue(strItemTable))
      {
        hashItemTable.put(Integer.toString(intCounter),strItemTable);
        intCounter = intCounter+1;
      }
    }

    if(hashItemTable.size()>0)
    {
      for(i=0;i<hashItemTable.size();i++)
      {
        if(i!=hashItemTable.size()-1)
          strFrom += (String)hashItemTable.get(Integer.toString(i))+",";
        else
          strFrom += (String)hashItemTable.get(Integer.toString(i));
      }
    }

    return strFrom;
  }

  /**
   * ���SQL����from����
   * @param AnaRepCommonDto anaRepCommonDto����ҪanaRepCommonDto.getOtherTable()��
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genFrom(AnaRepCommonDto anaRepCommonDto,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HashMap hashItemTable = new HashMap(24); //��ֵ��0��ʼ

    String strFrom = " FROM ";
    String strItemTable = "";
    String strOtherTable = "";
    String[] arrOtherTable = {};

    int intCounter = 0;
    int i = 0;

    //������MidResultConfig�������ֶεı�
    for(i=0;i<arrConfigs.size();i++)
    {
      midResultConfigDto = new MidResultConfigDto();
      midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

      strItemTable = midResultConfigDto.getItemTable();

      if(!hashItemTable.containsValue(strItemTable))
      {
        hashItemTable.put(Integer.toString(intCounter),strItemTable);
        intCounter = intCounter+1;
      }
    }

    //����û����MidResultConfig�������ֶΡ�������Ҫ��ѯ�ı�
    strOtherTable = anaRepCommonDto.getOtherTable();

    if(strOtherTable.length()>0)
      arrOtherTable = StringUtils.split(strOtherTable,"|");

    for(i=0;i<arrOtherTable.length;i++)
    {
      if(!hashItemTable.containsValue(arrOtherTable[i]))
      {
        hashItemTable.put(Integer.toString(intCounter),arrOtherTable[i]);
        intCounter = intCounter+1;
      }
    }

    //������ƴ���ַ���
    if(hashItemTable.size()>0)
    {
      for(i=0;i<hashItemTable.size();i++)
      {
        if(i!=hashItemTable.size()-1)
          strFrom += (String)hashItemTable.get(Integer.toString(i))+",";
        else
          strFrom += (String)hashItemTable.get(Integer.toString(i));
      }
    }

    return strFrom;
  }

  /**
   * ���SQL����WHERE����
   * @param ArrayList arrParameters��ParameterDto�ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genWhere(ArrayList arrParameter) throws Exception
  {
    ParameterDto parameterDto = null;

    String strWhere = " WHERE 1=1";
    String strLinkSign = "";
    String strLeftFlag1 = "";
    String strItemColumn = "";
    String strParameterSign = "";
    String strLeftFlag2 = "";
    String strParameterValue = "";
    String strRightFlag2 = "";
    String strRightFlag1 = "";
    String strSpace1 = " ";
    String[] arrParameterValue = {}; //�Ƿ�Ӧ�÷��ڸ��Ե������´�����Ϊ��ͬ����������ͬ��������������Ҳ�ܴ���

    for(int i=0;i<arrParameter.size();i++)
    {
      parameterDto = new ParameterDto();
      parameterDto = (ParameterDto)arrParameter.get(i);

      strLinkSign = parameterDto.getLinkSign();
      strLeftFlag1 = parameterDto.getLeftFlag1();
      strItemColumn = parameterDto.getItemColumn(); //�����Ǹ��ϵ��ַ�������SELECT CertiNo FROM PrpJpayRec
      strParameterSign = parameterDto.getParameterSign();
      strLeftFlag2 = parameterDto.getLeftFlag2();
      strParameterValue = parameterDto.getParameterValue();
      strRightFlag2 = parameterDto.getRightFlag2();
      strRightFlag1 = parameterDto.getRightFlag1();
      if(strParameterValue!=null&&strParameterValue.length()!=0)
      {
        //��һ����Ҫ��Ϊ��ComCode������ģ���ComCode���з����ˣ�����ע�͵�
        //arrParameterValue = StringUtils.split(strParameterValue,"|");
        //
        //if(arrParameterValue.length!=1)
        //{
        //  strParameterValue = "";
        //  if(strParameterSign.equals("="))
        //    strParameterSign = "IN";
        //  strLeftFlag2 = strLeftFlag2+"(";
        //  for(int j=0;j<arrParameterValue.length;j++)
        //  {
        //    if(j!=arrParameterValue.length-1)
        //      strParameterValue += "'"+arrParameterValue[j]+"',";
        //    else
        //      strParameterValue += "'"+arrParameterValue[j];
        //  }
        //  strRightFlag2 = ")"+strRightFlag2;
        //}

        //ƴ�ӿո�
        //�����������ǰ��ƴ��һ���ո�
        strLinkSign = strSpace1+strLinkSign+strSpace1;
        //��������������������ʱǰ��ƴ��һ���ո�
        if(strParameterSign.equals("="))
          strParameterSign = "=";
        else if(strParameterSign.equals("*"))
          strParameterSign = strSpace1+"LIKE"+strSpace1;
        else if(strParameterSign.equals("0"))
          strParameterSign = "<>";
        else if(strParameterSign.equals("1"))
          strParameterSign = ">=";
        else if(strParameterSign.equals("2"))
          strParameterSign = ">";
        else if(strParameterSign.equals("-1"))
          strParameterSign = "<=";
        else if(strParameterSign.equals("-2"))
          strParameterSign = "<";
        else if(strParameterSign.equals("|"))
          strParameterSign ="|";
        else
          strParameterSign = strSpace1+strParameterSign+strSpace1;

        if(!strParameterValue.equals("''")){
		if (!strParameterSign.equals("|"))
          		strWhere += strLinkSign+strLeftFlag1+strItemColumn+strParameterSign+strLeftFlag2+strParameterValue+strRightFlag2+strRightFlag1;
		else
			strWhere += strLinkSign+strLeftFlag1+"";
        	}
      }
    }

    return strWhere;
  }

  /**
   * ����й�ComCode��������ƴ�Ӳ�ѯ��������ѯ�����ӹ�˾�������Լ������Ƿ�����Լ��Ĵ����ڵ��ø÷����ķ�����ʵ��
   * @param String strComCode ���Ŵ���
   * @param int intFlag �Ƿ񰴻����ּ���ѯ��0 ���������ּ���ѯ/��0 �������ּ���ѯ��
   * @return String
   * @throws Exception
   */
  public String genWhereCompany(String strComCode,int intFlag) throws Exception
  {
    String strWhereCompany = " 1=1"; //ע����õĺ���ƴ�ӷ��ص��ַ���ʱ�����غ���ַ�����ƴ�ո�

    if(strComCode.length()==0)
    {
      return strWhereCompany;
    }
    else
    {
      if(strComCode.indexOf("*")>0) //���û����룬ֻ�ܽ���ģ����ѯ
      {
        strWhereCompany += " AND ComCode MATCHES ('"+strComCode+"')";
      }
      else
      {
        if(intFlag!=0) //�������ּ���ѯ
        {
          if(!strComCode.substring(2,8).equals("000000"))
          {
            if(strComCode.substring(4,8).equals("0000"))
              strWhereCompany += " AND SUBSTR(ComCode,1,4)='"+strComCode.substring(0,4)+"'";
            else if(strComCode.substring(6,8).equals("00"))
              strWhereCompany += " AND SUBSTR(ComCode,1,6)='"+strComCode.substring(0,6)+"'";
            else
              strWhereCompany += " AND ComCode='"+strComCode+"'";
          }
        }
        else //���������ּ���ѯ
        {
          strWhereCompany += " AND ComCode='"+strComCode+"'";
        }
      }
    }

    return strWhereCompany;
  }

  /**
   * ���SQL����GROUP BY����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genGroupBy(ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strGroupBy = " GROUP BY ";
    String strGroupByTmp = "";
    String strItemTable = "";
    String strItemColumn = "";
    String strColumnType = "";
    String strGroupFlag = "";

    if(arrConfigs.size()>=1)
    {
      for(int i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strItemTable = midResultConfigDto.getItemTable();
        strItemColumn = midResultConfigDto.getItemColumn();
        strColumnType = midResultConfigDto.getColumnType();
        strGroupFlag = midResultConfigDto.getGroupFlag();

        if(strGroupFlag.equals("1")&&
           strColumnType.equals("D")) //ColumnTypeΪS/D/Nʱ����GROUP BY
          strGroupByTmp += strItemTable+"."+strItemColumn+",";
      }

      //ȥ��GROUP BYβ�ġ�,��
      if(strGroupByTmp.length()!=0)
        strGroupBy = strGroupBy+strGroupByTmp.substring(0,strGroupByTmp.length()-1);
      else
        strGroupBy = "";
    }

    return strGroupBy;
  }

  /**
   * ���SQL����GROUP BY����
   * @param AnaRepCommonDto anaRepCommonDto����ʱû���õ��ò�������ͬ��Ӧ�ö�Ӧ�Ĳ������Ͳ�ͬ����UwReportDto��
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genGroupBy(AnaRepCommonDto anaRepCommonDto,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strGroupBy = " GROUP BY ";
    String strGroupByTmp = "";
    String strItemTable = "";
    String strItemColumn = "";
    String strColumnType = "";
    String strGroupFlag = "";

    if(arrConfigs.size()>=1)
    {
      for(int i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strItemTable = midResultConfigDto.getItemTable();
        strItemColumn = midResultConfigDto.getItemColumn();
        strColumnType = midResultConfigDto.getColumnType();
        strGroupFlag = midResultConfigDto.getGroupFlag();
        if(strGroupFlag.equals("1")) //ColumnTypeΪS/D/Nʱ����GROUP BY
          strGroupBy += strItemTable+"."+strItemColumn+",";
      }
      //ȥ��GROUP BYβ�ġ�,��
      if(strGroupBy.length()!=0)
        strGroupByTmp= strGroupByTmp+strGroupBy.substring(0,strGroupBy.length()-1);
      else
        strGroupByTmp= "";
    }

    return strGroupByTmp;
  }

  /**
   * ���SQL����ORDER BY����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genOrderBy(ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strOrderBy = " ORDER BY ";
    String strOrderByTmp = "";
    String strItemTable = "";
    String strItemColumn = "";
    String strColumnType = "";
    String strOrderType = "";

    if(arrConfigs.size()>=1)
    {
      for(int i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strItemTable = midResultConfigDto.getItemTable();
        strItemColumn = midResultConfigDto.getItemColumn();
        strColumnType = midResultConfigDto.getColumnType();
        strOrderType = midResultConfigDto.getOrderType();

        if(strOrderType.equals("A")&&
           strColumnType.equals("D")) //ColumnTypeΪS/D/Nʱ����ORDER BY
          strOrderByTmp += strItemTable+"."+strItemColumn+" ASC,";
        else if(strOrderType.equals("D"))
          strOrderByTmp += strItemColumn +" DESC,";
      }

      //ȥ��ORDER BYβ�ġ�,��
      if(strOrderByTmp.length()!=0)
        strOrderBy = strOrderBy+strOrderByTmp.substring(0,strOrderByTmp.length()-1);
      else
        strOrderBy = "";
    }

    return strOrderBy;
  }

  /**
   * ���SQL����ORDER BY����
   * @param AnaRepCommonDto anaRepCommonDto����ʱû���õ��ò�������ͬ��Ӧ�ö�Ӧ�Ĳ������Ͳ�ͬ����UwReportDto��
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return String
   * @throws Exception
   */
  public String genOrderBy(AnaRepCommonDto anaRepCommonDto,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strOrderBy = " ORDER BY ";
    String strOrderByTmp = "";
    String strItemTable = "";
    String strItemColumn = "";
    String strColumnType = "";
    String strOrderType = "";

    if(arrConfigs.size()>=1)
    {
      for(int i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strItemTable = midResultConfigDto.getItemTable();
        strItemColumn = midResultConfigDto.getItemColumn();
        strColumnType = midResultConfigDto.getColumnType();
        strOrderType = midResultConfigDto.getOrderType();

        if(strOrderType.equals("A")&&
           strColumnType.equals("D")) //ColumnTypeΪS/D/Nʱ����ORDER BY
          strOrderByTmp += strItemTable+"."+strItemColumn+" ASC,";
        else if(strOrderType.equals("D"))
          strOrderByTmp += strItemColumn +" DESC,";
      }

      //ȥ��ORDER BYβ�ġ�,��
      if(strOrderByTmp.length()!=0)
        strOrderBy = strOrderBy+strOrderByTmp.substring(0,strOrderByTmp.length()-1);
      else
        strOrderBy = "";
    }

    return strOrderBy;
  }

  /**
   * @��*ת��ƥ���ַ�%
   * @strOrin ԭʼ�ַ���
   * @author zhangshengli
   * @Date 2005-03-11
   */
  public String getMatchString(String strOrin) throws UserException,Exception
  {
    String strResult = "%";

    if(strOrin!=null&&strOrin.length()!=0)
    {
      for(int i=0;i<strOrin.length();i++)
      {
        if(strOrin.substring(i,i+1).equals("*"))
          strResult += "%";
        else
          strResult += strOrin.substring(i,i+1);
      }
    }

    strResult += "%";

    return strResult;
  }

  /**
   * ��������ѯ
   * @param DBManager dbManager
   * @param AnaRepCommonDto anaRepCommonDto
   * @param int intPageNo
   * @param itn intRowsPerPage
   * @return Collection
   * @throws Exception

  public AnaResultDto findByDto(DBManager dbManager,AnaRepCommonDto anaRepCommonDto,int intPageNo,int intRowsPerPage) throws SQLException,UserException,Exception
  {
    UIPrpDcompanyAction uiPrpDcompanyAction = new UIPrpDcompanyAction();
    DBCommon dbCommon = new DBCommon();
    AnaResultDto anaResultDto = new AnaResultDto();
    AnaResultDto anaResultDtoTmp = new AnaResultDto();
    PrpDcompanyDto prpDcompanyDto = null;

    Vector vecConfigs = (Vector)anaRepCommonDto.getConfigs();
    ArrayList arrConfigsSum = (ArrayList)vecConfigs.get(1);
    ArrayList arrParameter = (ArrayList)anaRepCommonDto.getArrParameter();
    ArrayList arrResults= new ArrayList();
    ArrayList arrPrpDcompanyChild = null;
    HashMap hashCompany = (HashMap)dbCommon.changeCodeToName("ComCode"); //���PrpDcompany���е��������ݣ�����HashMap��


    ArrayList arrHashTranslateCode = new ArrayList();
    HashMap hashTranslateCode = null;

    String strSelect = "";
    String strFrom = "";
    String strWhere = "";
    String strWhereCompany = "";
    String strOrderBy = "";
    String strGroupBy = "";
    String strCondition = "";
    String strConditionTmp = " 1=1";
    String strComCode = anaRepCommonDto.getComCode();
    String strCompanyFlag = anaRepCommonDto.getCompanyFlag(); //�Ƿ���Ҫ�������ּ���ѯ��0 �����ǲ�ѯ�������ӹ�˾/1 ��Ҫ��ѯ�������ӹ�˾�������Լ���/2��Ҫ��ѯ�ӹ�˾���������Լ�����
    String strTranslateType = anaRepCommonDto.getTranslateType(); //���뷭������ͣ�"" ����Ҫ���뷭��/ComCode ��Ҫ����ComCode/HandlerCode ��Ҫ����HandlerCode/...��
    String[] arrCompany = StringUtils.split(strComCode,"|");

    int intQueryStyle = anaRepCommonDto.getQueryStyle();
    int intPageFlag = intQueryStyle; //�Ƿ��ҳ�ı�־��ԭ��intQueryStyle����
    int i = 0;
    int j = 0;

    //���SELECT����
    strSelect = dbCommon.genSelect(anaRepCommonDto,arrConfigsSum);
    //���FROM
    strFrom = dbCommon.genFrom(anaRepCommonDto,arrConfigsSum);
    //���WHEREPART
    strWhere = dbCommon.genWhere(arrParameter);
    //���GROUPBY
    strGroupBy = dbCommon.genGroupBy(anaRepCommonDto,arrConfigsSum);
    //���ORDERBY
    strOrderBy = dbCommon.genOrderBy(anaRepCommonDto,arrConfigsSum);

    if(arrCompany.length>0) //��ѯ��������Ҫ��������ѯ�����ҳ����û������ComCode�������밴�����ּ���ѯ������ViewHelper�У���ComCode��ΪAppConfig.get("sysconst.TOP_COMPANY")
    {
      for(i=0;i<arrCompany.length;i++)
      {
        if(arrCompany[i].indexOf("*")>0) //�����ģ����ѯ������strCompanyFlagΪ��ֵ��ֻ����ģ����ѯ
        {
          strWhereCompany = genWhereCompany(arrCompany[i],0);
          strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
          anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
          arrResults.addAll(anaResultDtoTmp.getCollection());
        }
        else
        {
          if(strCompanyFlag.equals("1")) //��Ҫ�������ּ���ѯ�������Լ���
          {
            strWhereCompany = genWhereCompany(arrCompany[i],1);
            strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
            anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
            arrResults.addAll(anaResultDtoTmp.getCollection());
          }
          else if(strCompanyFlag.equals("2")) //��Ҫ�������ּ���ѯ���������Լ���
          {
            strConditionTmp = " AND UpperComCode='"+arrCompany[i]+"' ORDER BY ComCode";
            arrPrpDcompanyChild = (ArrayList)uiPrpDcompanyAction.findByConditions(strConditionTmp);

            for(j=0;j<arrPrpDcompanyChild.size();j++)
            {
              prpDcompanyDto = new PrpDcompanyDto();
              prpDcompanyDto = (PrpDcompanyDto)arrPrpDcompanyChild.get(j);
              strComCode = prpDcompanyDto.getComCode();
              strWhereCompany = genWhereCompany(strComCode,1);

              strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
              anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
              arrResults.addAll(anaResultDtoTmp.getCollection());
            }
          }
          else //����Ҫ�������ּ���ѯ
          {
            strWhereCompany = genWhereCompany(arrCompany[i],0);
            strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
            anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
            arrResults.addAll(anaResultDtoTmp.getCollection());
          }
        }
      }
    }
    else //��ѯ�����в���Ҫ��������ѯ
    {
      strCondition = strSelect+strFrom+strWhere+strGroupBy+strOrderBy;
      anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
      arrResults.addAll(anaResultDtoTmp.getCollection());
    }

    anaResultDto.setRowsCount(arrResults.size());
    anaResultDto.setCollection(arrResults);

    return anaResultDto;
  }
   */
  /**
   * ��ý����AnaResultDto����findByDto���ã�������strTranslateType�ֱ���ò�ͬ��getResult
   * @param DBManager dbManager
   * @param String strCondition
   * @param ArrayList arrConfigsSum
   * @param int intPageFlag ��ѯ����Ƿ���Ҫ��ҳ��ʾ
   * @param int intPageNo
   * @param int intRowsPerPage
   * @param String strTranslateType ���뷭������
   * @return Collection
   * @throws Exception

  public AnaResultDto getResult(DBManager dbManager,String strCondition,ArrayList arrConfigsSum,int intPageFlag,int intPageNo,int intRowsPerPage,String strTranslateType) throws SQLException,UserException,Exception
  {
    AnaResultDto anaResultDto = null;

    ArrayList arrHashTranslateCode = new ArrayList();
    HashMap hashTranslateCode = null;

    String[] arrTranslateType = StringUtils.split(strTranslateType,"|"); //���ҳ����ͬʱ��HandlerCode��OperatorCode��Ҫ���룬��ͳһ��TranslateTypeΪUserCode�������ظ�����

    if(arrTranslateType.length>0) //���ҳ����Ҫ���д��뷭��
    {
      for(int i=0;i<arrTranslateType.length;i++)
      {
        hashTranslateCode = (HashMap)changeCodeToName(arrTranslateType[i]);
        arrHashTranslateCode.add(hashTranslateCode);
      }

      anaResultDto = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,arrTranslateType,arrHashTranslateCode);
    }
    else //���ҳ�治��Ҫ���뷭��
    {
      anaResultDto = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage);
    }

    return anaResultDto;
  }
   */
  /**
   * ��ý����AnaResultDto������Ҫ���뷭�룬�ɴ�strTranslateType������getResult����
   * @param DBManager dbManager
   * @param String strCondition
   * @param ArrayList arrConfigsSum
   * @param int intPageFlag ��ѯ����Ƿ���Ҫ��ҳ��ʾ
   * @param int intPageNo
   * @param int intRowsPerPage
   * @return Collection
   * @throws Exception
   */
  public AnaResultDto getResult(DBManager dbManager,String strCondition,ArrayList arrConfigsSum,int intPageFlag,int intPageNo,int intRowsPerPage) throws SQLException,UserException,Exception
  {
    logger.debug(strCondition);

    DBCommon dbCommon =  new DBCommon();
    AnaResultDto anaResultDto = null;
    MidResultConfigDto midResultConfigDto = null;

    Collection collection = new ArrayList();

    int intRowsCount = 0;
    int intCount = 0;

    ResultSet resultSet = dbManager.executeQuery(strCondition);

    if(intPageFlag!=1&&intPageFlag!=3) //��ҳ
    {
      if(resultSet!=null)
      {
        resultSet.last();
        intRowsCount = resultSet.getRow();
      }

      resultSet.beforeFirst();
    }

    anaResultDto = new AnaResultDto();
    anaResultDto.setRowsCount(intRowsCount);

    if(intPageNo>1)
      dbManager.locate(resultSet,intRowsPerPage*(intPageNo-1));

    while(resultSet.next())
    {
      if(intPageFlag!=1&&intPageFlag!=3) //��ҳ
      {
        intCount++;
        if(intPageNo>0)
        {
          if(intCount>intRowsPerPage)
            break;
        }
      }

      //���ù������������ɽ������HashMap
      collection.add(dbCommon.genHashResults(dbManager,resultSet,arrConfigsSum));
    }

    anaResultDto.setCollection(collection);
    resultSet.close();
    return anaResultDto;
  }

  /**
   * ��ý����AnaResultDto����Ҫ���뷭�룬�ɴ�strTranslateType������getResult����
   * @param DBManager dbManager
   * @param String strCondition
   * @param ArrayList arrConfigsSum
   * @param int intPageFlag ��ѯ����Ƿ���Ҫ��ҳ��ʾ
   * @param int intPageNo
   * @param int intRowsPerPage
   * @param String[] arrTranslateType
   * @param ArrayList arrHashTranslateCode
   * @return Collection
   * @throws Exception
   */
  public AnaResultDto getResult(DBManager dbManager,String strCondition,ArrayList arrConfigsSum,int intPageFlag,int intPageNo,int intRowsPerPage,String[] arrTranslateType,ArrayList arrHashTranslateCode) throws SQLException,UserException,Exception
  {
    logger.debug(strCondition);

    DBCommon dbCommon = new DBCommon();
    AnaResultDto anaResultDto = null;
    MidResultConfigDto midResultConfigDto = null;

    Collection collection = new ArrayList();
    ResultSet resultSet = dbManager.executeQuery(strCondition);

    int intRowsCount = 0;
    int intCount=0;

    if(intPageFlag!=1&&intPageFlag!=3) //��ҳ
    {
      if(resultSet!=null)
      {
        resultSet.last();
        intRowsCount = resultSet.getRow();
      }

      resultSet.beforeFirst();
    }

    anaResultDto = new AnaResultDto();
    anaResultDto.setRowsCount(intRowsCount);

    if(intPageNo>1)
      dbManager.locate(resultSet,intRowsPerPage*(intPageNo-1));

    while(resultSet.next())
    {
      if(intPageFlag!=1&&intPageFlag!=3)
      {
        intCount++;
        if(intPageNo>0)
        {
          if(intCount>intRowsPerPage)
            break;
        }
      }

      //���ù������������ɽ������HashMap
      collection.add(dbCommon.genHashResults(dbManager,resultSet,arrConfigsSum,arrTranslateType,arrHashTranslateCode));
    }

    anaResultDto.setCollection(collection);
    resultSet.close();
    return anaResultDto;
  }

  /**
   * ��ý������HashMap������Ҫ���뷭�룬�ɲ���strTranslateType������getResult����
   * @param DBManager dbManager
   * @param ResultSet resultSet �����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return HashMap
   * @throws Exception
   */
  public HashMap genHashResults(DBManager dbManager,ResultSet resultSet,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HashMap hashResults = new HashMap(32);

    String strItemColumn = "";
    String strDataType = "";

System.out.println(arrConfigs.size());

   for(int j=0;j<arrConfigs.size();j++)
    {
      midResultConfigDto = new MidResultConfigDto();
      midResultConfigDto = (MidResultConfigDto)arrConfigs.get(j);

      strItemColumn = midResultConfigDto.getItemColumn();
      strDataType = midResultConfigDto.getDataType();
System.out.println(strItemColumn);
System.out.println(strDataType);


      if(dbManager.getString(resultSet,strItemColumn)==null||dbManager.getString(resultSet,strItemColumn).length()==0)
      {
        hashResults.put(strItemColumn,"");
      }
      else
      {
        if(strDataType.equals("String"))
          hashResults.put(strItemColumn,dbManager.getString(resultSet,strItemColumn));
        else if(strDataType.equals("Double"))
          hashResults.put(strItemColumn,new Double(dbManager.getString(resultSet,strItemColumn)));
        else if(strDataType.equals("Float"))
          hashResults.put(strItemColumn,new Float(dbManager.getString(resultSet,strItemColumn)));
        else if(strDataType.equals("Integer"))
          hashResults.put(strItemColumn,new Integer(dbManager.getString(resultSet,strItemColumn)));
      }
    }
System.out.println("98888888888888");            
    return hashResults;
  }

  /**
   * ��ý������HashMap����Ҫ���뷭�룬�ɴ�strTranslateType������getResult����
   * @param DBManager dbManager
   * @param ResultSet resultSet �����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @param String[] arrTranslateType
   * @param ArrayList arrHashTranslateCode
   * @return HashMap
   * @throws Exception
   */
  public HashMap genHashResults(DBManager dbManager,ResultSet resultSet,ArrayList arrConfigs,String[] arrTranslateType,ArrayList arrHashTranslateCode) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HashMap hashCodeTranslateCom = null;
    HashMap hashCodeTranslateUser = null;
    HashMap hashCodeTranslateAgent = null;
    HashMap hashResults = new HashMap(32);

    String strItemColumn = "";
    String strDataType = "";
    String strCodeCode = "";
    String strCodeNameType = "";

    int i = 0;
    int j = 0;

    if(arrTranslateType.length==0)
    {
      hashResults = genHashResults(dbManager,resultSet,arrConfigs);
    }
    else
    {
      //ע�����arrTranslateTypeʱ��Ҫ��֤���벻ͬ��
      for(i=0;i<arrTranslateType.length;i++)
      {
        if(arrTranslateType[i].equals("ComCode"))
          hashCodeTranslateCom = (HashMap)arrHashTranslateCode.get(i);
        else if(arrTranslateType[i].equals("UserCode"))
          hashCodeTranslateUser = (HashMap)arrHashTranslateCode.get(i);
        else if(arrTranslateType[i].equals("AgentCode"))
          hashCodeTranslateAgent = (HashMap)arrHashTranslateCode.get(i);
      }

      for(i=0;i<arrConfigs.size();i++)
      {
        midResultConfigDto = new MidResultConfigDto();
        midResultConfigDto = (MidResultConfigDto)arrConfigs.get(i);

        strItemColumn = midResultConfigDto.getItemColumn();
        strDataType = midResultConfigDto.getDataType();

        if(dbManager.getString(resultSet,strItemColumn)==null||dbManager.getString(resultSet,strItemColumn).length()==0)
        {
          hashResults.put(strItemColumn,"");
        }
        else
        {
          if(strDataType.equals("String"))
            hashResults.put(strItemColumn,dbManager.getString(resultSet,strItemColumn));
          else if(strDataType.equals("Double"))
            hashResults.put(strItemColumn,new Double(dbManager.getString(resultSet,strItemColumn)));
          else if(strDataType.equals("Float"))
            hashResults.put(strItemColumn,new Float(dbManager.getString(resultSet,strItemColumn)));
          else if(strDataType.equals("Integer"))
            hashResults.put(strItemColumn,new Integer(dbManager.getString(resultSet,strItemColumn)));

          for(j=0;j<arrTranslateType.length;j++)
          {
            if(arrTranslateType[i].equals("ComCode"))
            {
              if(strItemColumn.equals("makeCom"))
                strCodeCode = (String)hashResults.get("makeCom");
              else if(strItemColumn.equals("comCode"))
                strCodeCode = (String)hashResults.get("comCode");
              else if(strItemColumn.equals("company"))
                strCodeCode = (String)hashResults.get("company");

              strCodeNameType = strItemColumn+"Name";
              hashResults.put(strCodeNameType,hashCodeTranslateCom.get(strCodeCode));
            }
            else if(arrTranslateType[i].equals("UserCode"))
            {
              if(strItemColumn.equals("handlerCode"))
                strCodeCode = (String)hashResults.get("handlerCode");
              else if(strItemColumn.equals("handler1Code"))
                strCodeCode = (String)hashResults.get("handler1Code");
              else if(strItemColumn.equals("approverCode"))
                strCodeCode = (String)hashResults.get("approverCode");
              else if(strItemColumn.equals("operatorCode"))
                strCodeCode = (String)hashResults.get("operatorCode");

              strCodeNameType = strItemColumn+"Name";
              hashResults.put(strCodeNameType,hashCodeTranslateUser.get(strCodeCode));
            }
            else if(arrTranslateType[i].equals("AgentCode"))
            {
              if(strItemColumn.equals("agentCode"))
                strCodeCode = (String)hashResults.get("agentCode");

              strCodeNameType = strItemColumn+"Name";
              hashResults.put(strCodeNameType,hashCodeTranslateAgent.get(strCodeCode));
            }
          }
        }
      }
    }

    return hashResults;
  }

  /**
   * ���뷭�룺���Code/Name�Ľ����
   * @return HashMap Code/Name�Ľ����
   * @throws Exception

  public HashMap changeCodeToName(String strTranslateType) throws Exception
  {
    HashMap hashResults = new HashMap();

    String strCondition = " 1=1";

    int i = 0;

    if(strTranslateType.equals("ComCode"))
    {
      PrpDcompanyDto prpDcompanyDto = null;
      UIPrpDcompanyAction uiPrpDcompanyAction = new UIPrpDcompanyAction();
      ArrayList arrPrpDcompany = new ArrayList();

      arrPrpDcompany = (ArrayList)uiPrpDcompanyAction.findByConditions(strCondition);
      for(i=0;i<arrPrpDcompany.size();i++)
      {
        prpDcompanyDto = new PrpDcompanyDto();
        prpDcompanyDto = (PrpDcompanyDto)arrPrpDcompany.get(i);
        hashResults.put(prpDcompanyDto.getComCode(),prpDcompanyDto.getComCname());
      }
    }
    else if(strTranslateType.equals("UserCode"))
    {
      PrpDuserDto prpDuserDto = null;
      UIPrpDuserAction uiPrpDuserAction = new UIPrpDuserAction();
      ArrayList arrPrpDuser = new ArrayList();

      arrPrpDuser = (ArrayList)uiPrpDuserAction.findByConditions(strCondition);
      for(i=0;i<arrPrpDuser.size();i++)
      {
        prpDuserDto = new PrpDuserDto();
        prpDuserDto = (PrpDuserDto)arrPrpDuser.get(i);
        hashResults.put(prpDuserDto.getUserCode(),prpDuserDto.getUserName());
      }
    }
    else if(strTranslateType.equals("AgentCode"))
    {
      PrpDagentDto prpDagentDto = null;
      UIPrpDagentAction uiPrpDagentAction = new UIPrpDagentAction();
      ArrayList arrPrpDagent = new ArrayList();

      arrPrpDagent = (ArrayList)uiPrpDagentAction.findByConditions(strCondition);
      for(i=0;i<arrPrpDagent.size();i++)
      {
        prpDagentDto = new PrpDagentDto();
        prpDagentDto = (PrpDagentDto)arrPrpDagent.get(i);
        hashResults.put(prpDagentDto.getAgentCode(),prpDagentDto.getAgentName());
      }
    }

    return hashResults;
  }
   */  

  /**
   * ��ý������HashMap������Ҫ���뷭�룬�ɲ���strTranslateType������getResult����
   * @param DBManager dbManager
   * @param ResultSet resultSet �����
   * @param ArrayList arrConfigs������������ļ��ϣ�
   * @return HashMap
   * @throws Exception
   */
  public HashMap genHashResultsOther(DBManager dbManager,ResultSet resultSet,ArrayList arrConfigs,String strReportType) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HashMap hashResults = new HashMap(32);

    String strItemColumn = "";
    String strDataType = "";
    int      x=4;	

   for(int j=0;j<x;j++)
    {
      midResultConfigDto = new MidResultConfigDto();
      midResultConfigDto = (MidResultConfigDto)arrConfigs.get(j);

      strItemColumn = midResultConfigDto.getItemColumn();
      strDataType = midResultConfigDto.getDataType();
System.out.println(strItemColumn);
System.out.println(strDataType);


      if(dbManager.getString(resultSet,strItemColumn)==null||dbManager.getString(resultSet,strItemColumn).length()==0)
      {
        hashResults.put(strItemColumn,"");
      }
      else
      {
        if(strDataType.equals("String"))
          hashResults.put(strItemColumn,dbManager.getString(resultSet,strItemColumn));
        else if(strDataType.equals("Double"))
          hashResults.put(strItemColumn,new Double(dbManager.getString(resultSet,strItemColumn)));
        else if(strDataType.equals("Float"))
          hashResults.put(strItemColumn,new Float(dbManager.getString(resultSet,strItemColumn)));
        else if(strDataType.equals("Integer"))
          hashResults.put(strItemColumn,new Integer(dbManager.getString(resultSet,strItemColumn)));
      }
    }
System.out.println("98888888888888");            
    return hashResults;
  }




}




