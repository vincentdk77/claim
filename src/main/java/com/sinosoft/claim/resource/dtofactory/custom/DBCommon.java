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
 * 用于生成SQL
 */
public class DBCommon
{
  private static Log logger = LogFactory.getLog(DBCommon.class);

  public DBCommon()
  {
  }

  /**
   * 获得SQL语句的SELECT部分
   * @param ArrayList arrConfigs（放置配置项的集合）
   * @return String
   * @throws Exception
   */
  public String genSelect(ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strSelect = " SELECT "; //拼接SQL语句时前空格
    String strColumnType = ""; //在SQL中SELECT部分出现的形式
    String strItemColumn = "";
    String strItemTable = "";

    //拼接SELECT部分
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
        else if(strColumnType.equals("N")) //该字段与表中得字段并不对应，该字段用来放计算值
          strSelect += "'' AS "+strItemColumn+",";
      }

      //去掉SELECT尾的“,”
      strSelect = strSelect.substring(0,strSelect.length()-1);
    }

    return strSelect;
  }

  /**
   * 获得SQL语句的SELECT部分
   * @param AnaRepCommonDto anaRepCommonDto（暂时没有用到该参数，不同的应用对应的参数类型不同，如UwReportDto）
   * @param ArrayList arrConfigs（放置配置项的集合）
   * @return String
   * @throws Exception
   */
  public String genSelect(AnaRepCommonDto anaRepCommonDto,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    String strSelect = " SELECT "; //拼接SQL语句时前空格
    String strColumnType = ""; //在SQL中SELECT部分出现的形式
    String strItemColumn = "";
    String strItemTable = "";

System.out.println(arrConfigs.size());

    //拼接SELECT部分
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
        else if(strColumnType.equals("N")) //该字段与表中得字段并不对应，该字段用来放计算值
          strSelect += "'' AS "+strItemColumn+",";
      }

      //去掉SELECT尾的“,”
      strSelect = strSelect.substring(0,strSelect.length()-1);
    }

    return strSelect;
  }

  /**
   * 获得SQL语句的from部分
   * @param ArrayList arrConfigs（放置配置项的集合）
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
   * 获得SQL语句的from部分
   * @param AnaRepCommonDto anaRepCommonDto（需要anaRepCommonDto.getOtherTable()）
   * @param ArrayList arrConfigs（放置配置项的集合）
   * @return String
   * @throws Exception
   */
  public String genFrom(AnaRepCommonDto anaRepCommonDto,ArrayList arrConfigs) throws Exception
  {
    MidResultConfigDto midResultConfigDto = null;

    HashMap hashItemTable = new HashMap(24); //键值从0开始

    String strFrom = " FROM ";
    String strItemTable = "";
    String strOtherTable = "";
    String[] arrOtherTable = {};

    int intCounter = 0;
    int i = 0;

    //处理在MidResultConfig中配置字段的表
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

    //处理没有在MidResultConfig中配置字段、但仍需要查询的表
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

    //将表名拼成字符串
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
   * 获得SQL语句的WHERE部分
   * @param ArrayList arrParameters（ParameterDto的集合）
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
    String[] arrParameterValue = {}; //是否应该放在各自的险种下处理，因为不同情况运算符不同，不过放在这里也能处理

    for(int i=0;i<arrParameter.size();i++)
    {
      parameterDto = new ParameterDto();
      parameterDto = (ParameterDto)arrParameter.get(i);

      strLinkSign = parameterDto.getLinkSign();
      strLeftFlag1 = parameterDto.getLeftFlag1();
      strItemColumn = parameterDto.getItemColumn(); //可能是复合的字符串，如SELECT CertiNo FROM PrpJpayRec
      strParameterSign = parameterDto.getParameterSign();
      strLeftFlag2 = parameterDto.getLeftFlag2();
      strParameterValue = parameterDto.getParameterValue();
      strRightFlag2 = parameterDto.getRightFlag2();
      strRightFlag1 = parameterDto.getRightFlag1();
      if(strParameterValue!=null&&strParameterValue.length()!=0)
      {
        //这一段主要是为了ComCode来处理的，但ComCode另有方法了，所以注释掉
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

        //拼接空格
        //连接运算符：前后都拼接一个空格
        strLinkSign = strSpace1+strLinkSign+strSpace1;
        //参数运算符“其他”情况时前后都拼接一个空格
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
   * 获得有关ComCode的条件：拼接查询条件，查询所属子公司（包括自己），是否包括自己的处理在调用该方法的方法内实现
   * @param String strComCode 部门代码
   * @param int intFlag 是否按机构分级查询（0 不按机构分级查询/非0 按机构分级查询）
   * @return String
   * @throws Exception
   */
  public String genWhereCompany(String strComCode,int intFlag) throws Exception
  {
    String strWhereCompany = " 1=1"; //注意调用的函数拼接返回的字符串时，返回后的字符串后拼空格

    if(strComCode.length()==0)
    {
      return strWhereCompany;
    }
    else
    {
      if(strComCode.indexOf("*")>0) //由用户输入，只能进行模糊查询
      {
        strWhereCompany += " AND ComCode MATCHES ('"+strComCode+"')";
      }
      else
      {
        if(intFlag!=0) //按机构分级查询
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
        else //不按机构分级查询
        {
          strWhereCompany += " AND ComCode='"+strComCode+"'";
        }
      }
    }

    return strWhereCompany;
  }

  /**
   * 获得SQL语句的GROUP BY部分
   * @param ArrayList arrConfigs（放置配置项的集合）
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
           strColumnType.equals("D")) //ColumnType为S/D/N时，不GROUP BY
          strGroupByTmp += strItemTable+"."+strItemColumn+",";
      }

      //去掉GROUP BY尾的“,”
      if(strGroupByTmp.length()!=0)
        strGroupBy = strGroupBy+strGroupByTmp.substring(0,strGroupByTmp.length()-1);
      else
        strGroupBy = "";
    }

    return strGroupBy;
  }

  /**
   * 获得SQL语句的GROUP BY部分
   * @param AnaRepCommonDto anaRepCommonDto（暂时没有用到该参数，不同的应用对应的参数类型不同，如UwReportDto）
   * @param ArrayList arrConfigs（放置配置项的集合）
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
        if(strGroupFlag.equals("1")) //ColumnType为S/D/N时，不GROUP BY
          strGroupBy += strItemTable+"."+strItemColumn+",";
      }
      //去掉GROUP BY尾的“,”
      if(strGroupBy.length()!=0)
        strGroupByTmp= strGroupByTmp+strGroupBy.substring(0,strGroupBy.length()-1);
      else
        strGroupByTmp= "";
    }

    return strGroupByTmp;
  }

  /**
   * 获得SQL语句的ORDER BY部分
   * @param ArrayList arrConfigs（放置配置项的集合）
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
           strColumnType.equals("D")) //ColumnType为S/D/N时，不ORDER BY
          strOrderByTmp += strItemTable+"."+strItemColumn+" ASC,";
        else if(strOrderType.equals("D"))
          strOrderByTmp += strItemColumn +" DESC,";
      }

      //去掉ORDER BY尾的“,”
      if(strOrderByTmp.length()!=0)
        strOrderBy = strOrderBy+strOrderByTmp.substring(0,strOrderByTmp.length()-1);
      else
        strOrderBy = "";
    }

    return strOrderBy;
  }

  /**
   * 获得SQL语句的ORDER BY部分
   * @param AnaRepCommonDto anaRepCommonDto（暂时没有用到该参数，不同的应用对应的参数类型不同，如UwReportDto）
   * @param ArrayList arrConfigs（放置配置项的集合）
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
           strColumnType.equals("D")) //ColumnType为S/D/N时，不ORDER BY
          strOrderByTmp += strItemTable+"."+strItemColumn+" ASC,";
        else if(strOrderType.equals("D"))
          strOrderByTmp += strItemColumn +" DESC,";
      }

      //去掉ORDER BY尾的“,”
      if(strOrderByTmp.length()!=0)
        strOrderBy = strOrderBy+strOrderByTmp.substring(0,strOrderByTmp.length()-1);
      else
        strOrderBy = "";
    }

    return strOrderBy;
  }

  /**
   * @将*转换匹配字符%
   * @strOrin 原始字符串
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
   * 按条件查询
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
    HashMap hashCompany = (HashMap)dbCommon.changeCodeToName("ComCode"); //获得PrpDcompany表中的所有数据，放入HashMap中


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
    String strCompanyFlag = anaRepCommonDto.getCompanyFlag(); //是否需要按机构分级查询（0 不考虑查询所属的子公司/1 需要查询所属的子公司（包括自己）/2需要查询子公司（不包括自己））
    String strTranslateType = anaRepCommonDto.getTranslateType(); //代码翻译的类型（"" 不需要代码翻译/ComCode 需要翻译ComCode/HandlerCode 需要翻译HandlerCode/...）
    String[] arrCompany = StringUtils.split(strComCode,"|");

    int intQueryStyle = anaRepCommonDto.getQueryStyle();
    int intPageFlag = intQueryStyle; //是否分页的标志，原由intQueryStyle决定
    int i = 0;
    int j = 0;

    //获得SELECT部分
    strSelect = dbCommon.genSelect(anaRepCommonDto,arrConfigsSum);
    //获得FROM
    strFrom = dbCommon.genFrom(anaRepCommonDto,arrConfigsSum);
    //获得WHEREPART
    strWhere = dbCommon.genWhere(arrParameter);
    //获得GROUPBY
    strGroupBy = dbCommon.genGroupBy(anaRepCommonDto,arrConfigsSum);
    //获得ORDERBY
    strOrderBy = dbCommon.genOrderBy(anaRepCommonDto,arrConfigsSum);

    if(arrCompany.length>0) //查询条件中需要按机构查询，如果页面上没有输入ComCode，但仍想按机构分级查询，则在ViewHelper中，将ComCode置为AppConfig.get("sysconst.TOP_COMPANY")
    {
      for(i=0;i<arrCompany.length;i++)
      {
        if(arrCompany[i].indexOf("*")>0) //如果是模糊查询，不管strCompanyFlag为何值都只进行模糊查询
        {
          strWhereCompany = genWhereCompany(arrCompany[i],0);
          strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
          anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
          arrResults.addAll(anaResultDtoTmp.getCollection());
        }
        else
        {
          if(strCompanyFlag.equals("1")) //需要按机构分级查询（包括自己）
          {
            strWhereCompany = genWhereCompany(arrCompany[i],1);
            strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
            anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
            arrResults.addAll(anaResultDtoTmp.getCollection());
          }
          else if(strCompanyFlag.equals("2")) //需要按机构分级查询（不包括自己）
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
          else //不需要按机构分级查询
          {
            strWhereCompany = genWhereCompany(arrCompany[i],0);
            strCondition = strSelect+strFrom+strWhere+strWhereCompany+strGroupBy+strOrderBy;
            anaResultDtoTmp = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,strTranslateType);
            arrResults.addAll(anaResultDtoTmp.getCollection());
          }
        }
      }
    }
    else //查询条件中不需要按机构查询
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
   * 获得结果：AnaResultDto，由findByDto调用，按参数strTranslateType分别调用不同的getResult
   * @param DBManager dbManager
   * @param String strCondition
   * @param ArrayList arrConfigsSum
   * @param int intPageFlag 查询结果是否需要分页显示
   * @param int intPageNo
   * @param int intRowsPerPage
   * @param String strTranslateType 代码翻译类型
   * @return Collection
   * @throws Exception

  public AnaResultDto getResult(DBManager dbManager,String strCondition,ArrayList arrConfigsSum,int intPageFlag,int intPageNo,int intRowsPerPage,String strTranslateType) throws SQLException,UserException,Exception
  {
    AnaResultDto anaResultDto = null;

    ArrayList arrHashTranslateCode = new ArrayList();
    HashMap hashTranslateCode = null;

    String[] arrTranslateType = StringUtils.split(strTranslateType,"|"); //如果页面上同时有HandlerCode、OperatorCode需要翻译，则统一置TranslateType为UserCode，避免重复放入

    if(arrTranslateType.length>0) //结果页面需要进行代码翻译
    {
      for(int i=0;i<arrTranslateType.length;i++)
      {
        hashTranslateCode = (HashMap)changeCodeToName(arrTranslateType[i]);
        arrHashTranslateCode.add(hashTranslateCode);
      }

      anaResultDto = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage,arrTranslateType,arrHashTranslateCode);
    }
    else //结果页面不需要代码翻译
    {
      anaResultDto = getResult(dbManager,strCondition,arrConfigsSum,intPageFlag,intPageNo,intRowsPerPage);
    }

    return anaResultDto;
  }
   */
  /**
   * 获得结果：AnaResultDto，不需要代码翻译，由带strTranslateType参数的getResult调用
   * @param DBManager dbManager
   * @param String strCondition
   * @param ArrayList arrConfigsSum
   * @param int intPageFlag 查询结果是否需要分页显示
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

    if(intPageFlag!=1&&intPageFlag!=3) //分页
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
      if(intPageFlag!=1&&intPageFlag!=3) //分页
      {
        intCount++;
        if(intPageNo>0)
        {
          if(intCount>intRowsPerPage)
            break;
        }
      }

      //调用公共函数，生成结果集的HashMap
      collection.add(dbCommon.genHashResults(dbManager,resultSet,arrConfigsSum));
    }

    anaResultDto.setCollection(collection);
    resultSet.close();
    return anaResultDto;
  }

  /**
   * 获得结果：AnaResultDto，需要代码翻译，由带strTranslateType参数的getResult调用
   * @param DBManager dbManager
   * @param String strCondition
   * @param ArrayList arrConfigsSum
   * @param int intPageFlag 查询结果是否需要分页显示
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

    if(intPageFlag!=1&&intPageFlag!=3) //分页
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

      //调用公共函数，生成结果集的HashMap
      collection.add(dbCommon.genHashResults(dbManager,resultSet,arrConfigsSum,arrTranslateType,arrHashTranslateCode));
    }

    anaResultDto.setCollection(collection);
    resultSet.close();
    return anaResultDto;
  }

  /**
   * 获得结果集：HashMap，不需要代码翻译，由不带strTranslateType参数的getResult调用
   * @param DBManager dbManager
   * @param ResultSet resultSet 结果集
   * @param ArrayList arrConfigs（放置配置项的集合）
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
   * 获得结果集：HashMap，需要代码翻译，由带strTranslateType参数的getResult调用
   * @param DBManager dbManager
   * @param ResultSet resultSet 结果集
   * @param ArrayList arrConfigs（放置配置项的集合）
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
      //注意放入arrTranslateType时，要保证放入不同的
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
   * 代码翻译：获得Code/Name的结果集
   * @return HashMap Code/Name的结果集
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
   * 获得结果集：HashMap，不需要代码翻译，由不带strTranslateType参数的getResult调用
   * @param DBManager dbManager
   * @param ResultSet resultSet 结果集
   * @param ArrayList arrConfigs（放置配置项的集合）
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




