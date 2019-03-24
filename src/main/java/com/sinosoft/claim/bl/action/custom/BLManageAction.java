package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBManageReport;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是prplregist报案信息表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLManageAction {
    private static Log log = LogFactory.getLog(BLManageAction.class.getName());

    /**
     * 构造函数
     */
    public BLManageAction(){
        super();
    }

   public AnaResultDto findByDto(DBManager dbManager,AnaRepCommonDto anaRepCommonDto,int intPageNo,int intRowsPerPage) throws Exception
  {
    ArrayList arrResults = null;
    HashMap hashResults = null;	
    HashMap hashResultsNew = new HashMap(32);	
    String strHandlerCode="";
    int flowid=0,i=0,nodestatus=0;
    double consumetime=0d,allrate=0d;
    Collection collection = new ArrayList();	
    int[] bvisitarray=new int[12];	

    DBManageReport dbManageReport = new DBManageReport(dbManager);
    AnaResultDto anaResultDto = new AnaResultDto();

    anaResultDto = dbManageReport .findByDto(anaRepCommonDto,intPageNo,intRowsPerPage);





if (anaRepCommonDto.getReportType().equals("report_regist")){
    arrResults = (ArrayList)anaResultDto.getCollection();

    if (arrResults.size()>0)
    	{
       hashResults = (HashMap)arrResults.get(0);
	strHandlerCode=(String)hashResults.get("HandlerCode");
    	}
	
    hashResults =null;
    for(i=0;i<arrResults.size();i++)
    {
      hashResults = (HashMap)arrResults.get(i);
      if(((String)hashResults.get("HandlerCode")).equals(strHandlerCode))
      {
        flowid=flowid+((Integer)hashResults.get("Flowid")).intValue();
        if (((String)hashResults.get("NodeStatus")).equals("4")){
		nodestatus=((Integer)hashResults.get("Flowid")).intValue();
        	}	
	if (i==arrResults.size()-1){
       hashResultsNew.put("HandlerCode",strHandlerCode);	
       hashResultsNew.put("Flowid",new Integer(flowid));	
       hashResultsNew.put("NodeStatus",new Integer(nodestatus));
	collection.add(hashResultsNew);
		}
      	}
	  
	else
	{
       hashResultsNew.put("HandlerCode",strHandlerCode);	
       hashResultsNew.put("Flowid",new Integer(flowid));	
       hashResultsNew.put("NodeStatus",new Integer(nodestatus));
	collection.add(hashResultsNew);
	strHandlerCode=(String)hashResults.get("HandlerCode");
       flowid=((Integer)hashResults.get("Flowid")).intValue();
        if (((String)hashResults.get("NodeStatus")).equals("4")){
		nodestatus=((Integer)hashResults.get("Flowid")).intValue();
        	}	
	else{	nodestatus=0;}          	   	
	hashResults=null;
	hashResultsNew = new HashMap(32);	
		}
    }
//ljy test
anaResultDto.setCollection(collection);
    	}



if (anaRepCommonDto.getReportType().equals("report_certi")||
	anaRepCommonDto.getReportType().equals("report_compp")){
    arrResults = (ArrayList)anaResultDto.getCollection();

    if (arrResults.size()>0)
    	{
       hashResults = (HashMap)arrResults.get(0);
	strHandlerCode=(String)hashResults.get("HandlerCode");
    	}
	
    hashResults =null;
    for(i=0;i<arrResults.size();i++)
    {
      hashResults = (HashMap)arrResults.get(i);
      if(((String)hashResults.get("HandlerCode")).equals(strHandlerCode))
      {
        if (((String)hashResults.get("NodeStatus")).equals("4")){
        	flowid=((Integer)hashResults.get("Flowid")).intValue();
	      	consumetime=Double.parseDouble(DataUtils.nullToZero((String)hashResults.get("ConsumeTime")));
        	}
        if (((String)hashResults.get("NodeStatus")).equals("3")){
		nodestatus=((Integer)hashResults.get("Flowid")).intValue();
        	}
	if (i==arrResults.size()-1){
       hashResultsNew.put("HandlerCode",strHandlerCode);	
       hashResultsNew.put("Flowid",new Integer(flowid));
	if (flowid==0){ 
		flowid=0;
	}else{
       allrate=(double)((flowid)-(nodestatus))/flowid;
		}
       hashResultsNew.put("NodeStatus",new Double(allrate));
	if  (Double.parseDouble(DataUtils.nullToZero(anaRepCommonDto.getTimeLimit()))==0)  
	consumetime=0;
	else
	consumetime=consumetime/Double.parseDouble(DataUtils.nullToZero(anaRepCommonDto.getTimeLimit()));
       hashResultsNew.put("ConsumeTime",new Double(consumetime));

	collection.add(hashResultsNew);
		}
      	}
	  
	else
	{
       hashResultsNew.put("HandlerCode",strHandlerCode);	
       hashResultsNew.put("Flowid",new Integer(flowid));
	if (flowid==0){ 
		flowid=0;
	}else{
       allrate=(double)((flowid)-(nodestatus))/flowid;
		}
       hashResultsNew.put("NodeStatus",new Double(allrate));
	if  (Double.parseDouble(DataUtils.nullToZero(anaRepCommonDto.getTimeLimit()))==0)  
	consumetime=0;
	else
	consumetime=consumetime/Double.parseDouble(DataUtils.nullToZero(anaRepCommonDto.getTimeLimit()));
	
       hashResultsNew.put("ConsumeTime",new Double(consumetime));
	collection.add(hashResultsNew);
	strHandlerCode=(String)hashResults.get("HandlerCode");

	flowid=0;
	nodestatus=0;
        if (((String)hashResults.get("NodeStatus")).equals("4")){
        	flowid=((Integer)hashResults.get("Flowid")).intValue();
	      	consumetime=Double.parseDouble(DataUtils.nullToZero((String)hashResults.get("ConsumeTime")));
        	}
        if (((String)hashResults.get("NodeStatus")).equals("3")){
		nodestatus=((Integer)hashResults.get("Flowid")).intValue();
        	}
	
//       flowid=((Integer)hashResults.get("Flowid")).intValue();
//        if (((String)hashResults.get("NodeStatus")).equals("4")){
//		nodestatus=((Integer)hashResults.get("Flowid")).intValue();
//        	}	
//	else{	nodestatus=0;}
         	   	
	hashResults=null;
	hashResultsNew = new HashMap(32);	
		}
    }
//ljy test
anaResultDto.setCollection(collection);
    	}
//======================================================
if (anaRepCommonDto.getReportType().equals("report_bvisitp")||
	anaRepCommonDto.getReportType().equals("report_bvisit")){
    arrResults = (ArrayList)anaResultDto.getCollection();
    if (arrResults.size()>0)
    	{
       hashResults = (HashMap)arrResults.get(0);
	strHandlerCode=(String)hashResults.get("HandlerCode");
    	}
    hashResults =null;

for(i=0;i<arrResults.size();i++)
  {
	}

	
    for(i=0;i<arrResults.size();i++)
    {
      hashResults = (HashMap)arrResults.get(i);
      if(((String)hashResults.get("HandlerCode")).equals(strHandlerCode))
      {
        flowid=flowid+1;	

        if (((String)hashResults.get("QuestionResult")).equals("1")){

		if (((String)hashResults.get("BackVisitType")).equals("01")){
			if (((String)hashResults.get("QuestionCode")).equals("1001"))
				bvisitarray[1]=bvisitarray[1]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1002"))
				bvisitarray[2]=bvisitarray[2]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1003"))
				bvisitarray[3]=bvisitarray[3]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1004"))
				bvisitarray[4]=bvisitarray[4]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1005"))
				bvisitarray[5]=bvisitarray[5]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1006"))
				bvisitarray[6]=bvisitarray[6]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1007"))
				bvisitarray[7]=bvisitarray[7]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1008"))
				bvisitarray[8]=bvisitarray[8]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1009"))
				bvisitarray[9]=bvisitarray[9]+1;
			}
		if( ((String)hashResults.get("BackVisitType")).equals("02")){
			if (((String)hashResults.get("QuestionCode")).equals("1010"))
				bvisitarray[10]=bvisitarray[10]+1;
			if (((String)hashResults.get("QuestionCode")).equals("1011"))
				bvisitarray[11]=bvisitarray[11]+1;
			}

        	}	
      	}
	else
	{
       hashResultsNew.put("HandlerCode",strHandlerCode);	
       hashResultsNew.put("QuestionCode",String.valueOf((double)bvisitarray[1]/flowid));	
       hashResultsNew.put("BackVisitType",String.valueOf((double)bvisitarray[2]/flowid));	
       hashResultsNew.put("QuestionResult",String.valueOf((double)bvisitarray[3]/flowid));	
       hashResultsNew.put("QuestionCode4",String.valueOf((double)bvisitarray[4]/flowid));	
       hashResultsNew.put("QuestionCode5",String.valueOf((double)bvisitarray[5]/flowid));	
       hashResultsNew.put("QuestionCode6",String.valueOf((double)bvisitarray[6]/flowid));	
       hashResultsNew.put("QuestionCode7",String.valueOf((double)bvisitarray[7]/flowid));		   
       hashResultsNew.put("QuestionCode8",String.valueOf((double)bvisitarray[8]/flowid));		   
       hashResultsNew.put("QuestionCode9",String.valueOf((double)bvisitarray[9]/flowid));		   
       hashResultsNew.put("QuestionCode10",String.valueOf((double)bvisitarray[10]/flowid));		   
       hashResultsNew.put("QuestionCode11",String.valueOf((double)bvisitarray[11]/flowid));		   	   
	collection.add(hashResultsNew);
	strHandlerCode=(String)hashResults.get("HandlerCode");
       flowid=1;        	   	
	hashResults=null;
	hashResultsNew = new HashMap(32);	
		}
    }
       hashResultsNew.put("HandlerCode",strHandlerCode);	
       hashResultsNew.put("QuestionCode",String.valueOf((double)bvisitarray[1]/flowid));	
       hashResultsNew.put("BackVisitType",String.valueOf((double)bvisitarray[2]/flowid));	
       hashResultsNew.put("QuestionResult",String.valueOf((double)bvisitarray[3]/flowid));	
       hashResultsNew.put("QuestionCode4",String.valueOf((double)bvisitarray[4]/flowid));	
       hashResultsNew.put("QuestionCode5",String.valueOf((double)bvisitarray[5]/flowid));	
       hashResultsNew.put("QuestionCode6",String.valueOf((double)bvisitarray[6]/flowid));	
       hashResultsNew.put("QuestionCode7",String.valueOf((double)bvisitarray[7]/flowid));		   
       hashResultsNew.put("QuestionCode8",String.valueOf((double)bvisitarray[8]/flowid));		   
       hashResultsNew.put("QuestionCode9",String.valueOf((double)bvisitarray[9]/flowid));		   
       hashResultsNew.put("QuestionCode10",String.valueOf((double)bvisitarray[10]/flowid));		   
       hashResultsNew.put("QuestionCode11",String.valueOf((double)bvisitarray[11]/flowid));		   	   
	collection.add(hashResultsNew);	
//ljy test
anaResultDto.setCollection(collection);
}
	
    return anaResultDto;
  }

  public AnaResultDto findByDto(DBManager dbManager,AnaRepCommonDto anaRepCommonDto) throws Exception
  {
    DBManageReport dbManageReport  = new DBManageReport(dbManager);
    AnaResultDto anaResultDto = new AnaResultDto();

    anaResultDto = dbManageReport .findByDto(anaRepCommonDto);
    return anaResultDto;
  }
 

}

