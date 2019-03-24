package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.DBManager;
 
/**
 * 这是prplregist报案信息表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBManageReport {
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBManageReport.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBManageReport(DBManager dbManager){
        this.dbManager = dbManager;
    }

  public AnaResultDto findByDto(AnaRepCommonDto anaRepCommonDto,int intPageNo,int intRowsPerPage) throws SQLException,UserException,Exception
  {


    DBCommon dbCommon =  new DBCommon();
    AnaResultDto anaResultDto = new AnaResultDto();

    Vector vecConfigs = (Vector)anaRepCommonDto.getConfigs();
    ArrayList arrConfigsSum = (ArrayList)vecConfigs.get(1);
    ArrayList arrayParameter = (ArrayList)anaRepCommonDto.getArrParameter();
    String strSelect = "";
    String strFrom = "";
    String strWhere = "";
    String strGroupBy = "";
    String strOrderBy = "";
    String strCondition = "";
    String strReportType="";

    strReportType=anaRepCommonDto.getReportType();
	
    strSelect = dbCommon.genSelect(anaRepCommonDto,arrConfigsSum);
    strFrom = dbCommon.genFrom(anaRepCommonDto,arrConfigsSum);
    strWhere = dbCommon.genWhere(arrayParameter);
    strGroupBy = dbCommon.genGroupBy(anaRepCommonDto,arrConfigsSum);



	   if (strReportType.equals("report_certip")||
	   	strReportType.equals("report_certi"))
		strGroupBy =strGroupBy +" , nodetype having nodetype='certi' ";
	   if (strReportType.equals("report_compp")||
	   	strReportType.equals("report_comppp"))
		strGroupBy =strGroupBy +" , nodetype having nodetype='compp' ";
	   if (strReportType.equals("report_veric")||
	   	strReportType.equals("report_vericp"))
		strGroupBy =strGroupBy +" , nodetype having nodetype='veric' ";
	   if (strReportType.equals("report_bvisit")||
			strReportType.equals("report_bvisitp")||
			strReportType.equals("report_bvisitlist"))
		strGroupBy =strGroupBy +", PrpLbackVisitQue.QuestionCode,PrpLbackVisitQue.BackVisitType,PrpLbackVisitQue.QuestionResult ";


   
    strOrderBy = dbCommon.genOrderBy(anaRepCommonDto,arrConfigsSum);
    strCondition = strSelect+strFrom+strWhere+strGroupBy+strOrderBy;





    anaResultDto = getResult(strCondition,arrConfigsSum,"1",intPageNo,intRowsPerPage,strReportType);
    return anaResultDto;
  }

  public AnaResultDto findByDto(AnaRepCommonDto anaRepCommonDto) throws Exception
  {
    return findByDto(anaRepCommonDto,0,0);
  }

  public AnaResultDto getResult(String strCondition,ArrayList arrConfigsSum,String strPageFlag,int intPageNo,int intRowsPerPage,String strReportType) throws SQLException,UserException,Exception
  {
//strCondition="select HandlerCode, count(flowid) from swflog where comcode = '31000000' and NodeStatus='4' and nodetype='regis' and (submittime between '2005-02-01 12:20:30' and '2005-04-01 12:20:30') group by HandlerCode";
   // logger.debug(strCondition);

    DBCommon dbCommon =  new DBCommon();
    AnaResultDto anaResultDto = null;
    MidResultConfigDto midResultConfigDto = null;

    Collection collection = new ArrayList();
    Collection collectiontmp = new ArrayList();	

    int intRowsCount = 0;
    int intCounter=0;

    ResultSet resultSet = dbManager.executeQuery(strCondition);

    if(strPageFlag.equals("1")) //是否分页显示的标志
    {
      if(resultSet!=null)
      {
        resultSet.last();
        intRowsCount = resultSet.getRow();
      }
    }

    anaResultDto = new AnaResultDto();
    anaResultDto.setRowsCount(intRowsCount);
    resultSet.beforeFirst();

    if(intPageNo>1)
      dbManager.locate(resultSet,intRowsPerPage*(intPageNo-1));

    while(resultSet.next())
    {
      if(strPageFlag.equals("1"))
      {
        intCounter++;
        if(intPageNo>0)
        {
          if(intCounter>intRowsPerPage)
            break;
        }
      }
	   if (strReportType.equals("report_bvisit")||
			strReportType.equals("report_bvisitp")||
			strReportType.equals("report_bvisitlist")){
      collection.add(dbCommon.genHashResultsOther(dbManager,resultSet,arrConfigsSum,strReportType));	
	   	}else{
      //调用公共函数，生成结果集的HashMap
      collection.add(dbCommon.genHashResults(dbManager,resultSet,arrConfigsSum));
	   		}
    }

//ljy test
/*
for(int i=0;i<collection.size();i++)
  {
	System.out.println(((ArrayList)(collection)).get(i));
	}
*/
    anaResultDto.setCollection(collection);
    resultSet.close();
    //logger.info("DBManageReport.getResults() success!");
    return anaResultDto;
  }
}

