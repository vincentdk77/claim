package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CaseNoQueryDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是prplregist报案信息表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLregist extends DBPrpLregistBase{
    private static Log log = LogFactory.getLog(DBPrpLregist.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLregist(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       
    	String statement = "";
    	conditions = conditions.replaceAll("prplregist","a");
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
    	statement = "Select DISTINCT a.RegistNo," +
        "a.PolicyNo, " +
       "a.ReceiverName, " +
        "b.Status, "+
       "b.OperateDate, "+
        "b.RiskCode, "+
        "a.LicenseNo, " +
        "a.InsuredName,a.canceldate From  PrpLClaimStatus b Right JOIN prpLregist a  ON a.RegistNo = b.BusinessNo , prplregistrpolicy c " +
        "where  (c.registno=a.registno) and b.nodetype='regis' and "+conditions;
		//add by zhouliu end at 2006-6-9
        log.debug(statement);
        Collection collection = new ArrayList(); 
        PrpLregistDto prpLregistDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,3));
            prpLregistDto.setStatus(dbManager.getString(resultSet,4));
            prpLregistDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
			//add by zhouliu start at 2006-6-9
			//reason:强三查询
            prpLregistDto.setRelatepolicyNo(new TreeSet());
			//add by zhouliu end at 2006-6-9
            collection.add(prpLregistDto);
        }
        resultSet.close();
			//add by zhouliu start at 2006-6-9
			//reason:强三查询        
        for (Iterator it=collection.iterator(); it.hasNext();)
        {
        	prpLregistDto=(PrpLregistDto)it.next();
        	statement="select PolicyNo from prplregistrpolicy where RegistNo='"+prpLregistDto.getRegistNo()+"'";
        	resultSet = dbManager.executeQuery(statement);
        	while (resultSet.next())
        	{
        		prpLregistDto.getRelatepolicyNo().add(resultSet.getString("policyno"));
        	}
        	resultSet.close();
        }
			//add by zhouliu end at 2006-6-9
        log.info("DBPrpLregist.findByConditions() success!");
        return collection;
    }

    /**
     * 查询出险次数界面的数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     */
    public Collection findSamePolicyRegist(String conditions,int pageNo,int rowsPerPage) throws Exception{
    /*
       String statement = "Select DISTINCT a.RegistNo," +
                           "a.PolicyNo, "+
                           "a.ReceiverName, "+
                           "b.Status, "+
                           "b.OperateDate, "+
                           "b.RiskCode, "+
                           "a.LicenseNo From (Select * from PrpLClaimStatus where nodetype='regis') b LEFT JOIN prpLregist a  ON a.RegistNo = b.BusinessNo where"+conditions ;
      */
      /*
      String statement = "Select Prplregist.damageStartDate,"+
                          "Prplregist.linkerName,Prplregist.operatorCode,Prplregist.operatorCode,"+
                          "Prplregist.Registno,Prplregist.Damageaddress,"+
                          "Prplthirdcarloss.CompName,Prplregist.Phonenumber,Prplclaimstatus.status "+
                          "From (Prplregist Left Join (Select * From Prplclaimstatus Where Nodetype='regis') M "+
                          "Prplclaimstatus On Prplregist.Registno = Prplclaimstatus.Businessno) T "+
                          "Left Join Prplthirdcarloss On (Prplregist.Registno = Prplthirdcarloss.Registno "+
                          "and Prplthirdcarloss.LicenseNo=Prplregist.LicenseNo)  where "+conditions;
        */                  
        String statement =" Select Prplregist.registNo," +
        				"Prplregist.DamageStartDate," +
        				"Prplregist.reportDate," +
        				"Prplregist.cancelDate," +
        				"t.persondeathb," +
        				"t.personinjureb," +
        				"t.persondeathd1," +
        				"t.personinjured1, "+
        				"Prplregist.riskcode" +
                        " From Prplregist Prplregist ,prplext t where t.certino(+)=Prplregist.registno and "+conditions;
                         
                          
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLregistDto prpLregistDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
           prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
           prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
           prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
           prpLregistDto.setPersonDeathB(dbManager.getLong(resultSet,5));
           prpLregistDto.setPersonInjureB(dbManager.getLong(resultSet,6));
           prpLregistDto.setPersonDeathD1(dbManager.getLong(resultSet,7));
           prpLregistDto.setPersonInjureD1(dbManager.getLong(resultSet,8));
           prpLregistDto.setRiskCode(dbManager.getString(resultSet, 9));
            /*
            prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,2));
            prpLregistDto.setOperatorCode(dbManager.getString(resultSet,3));
            prpLregistDto.setOperatorName(dbManager.getString(resultSet,4));
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLregistDto.setDamageAddress(dbManager.getString(resultSet,6));
            prpLregistDto.setBrandName(dbManager.getString(resultSet,7));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,8));
            prpLregistDto.setStatus(dbManager.getString(resultSet,9));
            */
            collection.add(prpLregistDto);
        }
        resultSet.close();
        log.info("DBPrpLregist.findSamePolicyRegist() success!");
        return collection;
    }

    /**
     * 按条件从prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     */
    public Collection getWorkFlowList(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT a.RegistNo," +
                           "a.PolicyNo, "+
                           "a.ReceiverName, "+
                           "a.RiskCode, "+
                           "a.ReportDate, "+
                           "a.LicenseNo, "+
                           "b.FlowID,b.HandlerName From prpLregist a Right JOIN (Select * from swflog where nodetype='regis') b ON a.RegistNo = b.BusinessNo where"+conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLregistDto prpLregistDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){ 
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,3));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLregistDto.setLicenseNo(dbManager.getString(resultSet,6));
            prpLregistDto.setFlowID(dbManager.getString(resultSet,7));
            prpLregistDto.setHandlerName(dbManager.getString(resultSet,8));
            collection.add(prpLregistDto);
        }
        resultSet.close();
        log.info("DBPrpLregist.findByConditions() success!");
        return collection;
    }
    
    
    //add by zhaolu 20060801 start
    //查询满足模糊查询条件的记录数
    public int getCount1(String conditions) throws Exception
    {
    	int count = -1;
        String statement = "Select count(DISTINCT a.RegistNo) from PrpLClaimStatus b Right JOIN prpLregist a  ON a.RegistNo = b.BusinessNo , prplregistrpolicy c " +
        "where  (c.registno=a.registno) and b.nodetype='regis' and "+conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1); 
        resultSet.close();
        log.info("DBPrpLregist.getCount1() success!");
        return count;
		
    	
    }
    //add by zhaolu 20060801 end
    
    /**
     * 按条件更新数据  add by liyannjie 2005-12-07 for:双代标志更新
     * @param String condition 
     * @throws Exception
     */
    public void updateByCondition(String condition) 
        throws Exception
	{
        
    	String statement = " Update PrpLregist Set " + condition;
    	log.debug(statement);
		dbManager.prepareStatement(statement);
		dbManager.executePreparedUpdate();
		log.info("DBPrpLregist.updateByCondition() success!");
    }
    

    /**
     * 按条件从prplclaim表,prplregist表和compensateno表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By 
     */
    public Collection findByQueryConditionsForPolicyno(String conditions,int pageNo,int rowsPerPage) throws Exception{
    	  String statement = "SELECT  "
              + " PrpLregist.registNo," 
              + " PrpLregist.lFlag," 
              + " PrpLregist.ClassCode," 
              + " PrpLregist.RiskCode," 
              + " PrpLregist.PolicyNo," 
              + " PrpLregist.Language," 
              + " PrpLregist.InsuredCode," 
              + " PrpLregist.InsuredName," 
              + " PrpLregist.InsuredAddress," 
              + " PrpLregist.ClauseType," 
              + " PrpLregist.LicenseNo," 
              + " PrpLregist.LicenseColorCode," 
              + " PrpLregist.CarKindCode," 
              + " PrpLregist.ModelCode," 
              + " PrpLregist.BrandName," 
              + " PrpLregist.EngineNo," 
              + " PrpLregist.FrameNo," 
              + " PrpLregist.RunDistance," 
              + " PrpLregist.UseYears," 
              + " PrpLregist.ReportDate," 
              + " PrpLregist.ReportHour," 
              + " PrpLregist.ReportAddress," 
              + " PrpLregist.ReportorName," 
              + " PrpLregist.ReportType," 
              + " PrpLregist.PhoneNumber," 
              + " PrpLregist.LinkerName," 
              + " PrpLregist.DamageStartDate," 
              + " PrpLregist.DamageStartHour," 
              + " PrpLregist.DamageEndDate," 
              + " PrpLregist.DamageEndHour," 
              + " PrpLregist.DamageCode," 
              + " PrpLregist.DamageName," 
              + " PrpLregist.DamageTypeCode," 
              + " PrpLregist.DamageTypeName," 
              + " PrpLregist.FirstSiteFlag," 
              + " PrpLregist.DamageAreaCode," 
              + " PrpLregist.DamageAreaName," 
              + " PrpLregist.DamageAddressType," 
              + " PrpLregist.AddressCode," 
              + " PrpLregist.DamageAddress," 
              + " PrpLregist.DamageAreaPostCode," 
              + " PrpLregist.HandleUnit," 
              + " PrpLregist.LossName," 
              + " PrpLregist.LossQuantity," 
              + " PrpLregist.Unit," 
              + " PrpLregist.EstiCurrency," 
              + " PrpLregist.EstimateLoss," 
              + " PrpLregist.ReceiverName," 
              + " PrpLregist.HandlerCode," 
              + " PrpLregist.Handler1Code," 
              + " PrpLregist.ComCode," 
              + " PrpLregist.InputDate," 
              + " PrpLregist.AcceptFlag," 
              + " PrpLregist.RepeatInsureFlag," 
              + " PrpLregist.ClaimType," 
              + " PrpLregist.CancelDate," 
              + " PrpLregist.DealerCode," 
              + " PrpLregist.Remark," 
              + " PrpLregist.OperatorCode," 
              + " PrpLregist.MakeCom," 
              + " PrpLregist.Flag," 
              + " PrpLregist.ReportorPhoneNumber," 
              + " PrpLregist.LinkerPostCode," 
              + " PrpLregist.LinkerAddress," 
              + " PrpLregist.EstimateFee," 
              + " PrpLregist.CatastropheCode1," 
              + " PrpLregist.CatastropheName1," 
              + " PrpLregist.CatastropheCode2," 
              + " PrpLregist.CatastropheName2," 
              + " PrpLregist.ReportFlag," 
              + " PrpLregist.LossesNumber," 
              + " PrpLregist.LossesUnitCode," 
              + " PrpLregist.Businesstype," 
              + " PrpLregist.Businesstype1," 
              + " PrpLregist.IndemnityDuty, " 
              + " PrpLregist.BusinessFlag, " 
              + " PrpLregist.OtherFlag " 
              + " from prplregist PrpLregist, prplclaim prplclaim, prplcompensate prplcompensate "
              + " where PrpLregist.registno = prplclaim.registno(+)       "           
              + " and prplclaim.claimno = prplcompensate.claimno(+)      "  
              + " and prplcompensate.compensateno  is null      "   
              + " and PrpLregist.policyno = '"+ conditions +"'";
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLregistDto prpLregistDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0; 
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                } 
            }
            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregistDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregistDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregistDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregistDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregistDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregistDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregistDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregistDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregistDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregistDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregistDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregistDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregistDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregistDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregistDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregistDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregistDto.setReportType(dbManager.getString(resultSet,24));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregistDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregistDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregistDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregistDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregistDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregistDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregistDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregistDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregistDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregistDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregistDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregistDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregistDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregistDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregistDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregistDto.setLossName(dbManager.getString(resultSet,43));
            prpLregistDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregistDto.setUnit(dbManager.getString(resultSet,45));
            prpLregistDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregistDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregistDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregistDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregistDto.setComCode(dbManager.getString(resultSet,51));
            prpLregistDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,52));
            prpLregistDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregistDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregistDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregistDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregistDto.setRemark(dbManager.getString(resultSet,58));
            prpLregistDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregistDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregistDto.setFlag(dbManager.getString(resultSet,61));
            prpLregistDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregistDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregistDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregistDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregistDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregistDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregistDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregistDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregistDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregistDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregistDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregistDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregistDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregistDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregistDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregistDto.setOtherFlag(dbManager.getString(resultSet,77));
            collection.add(prpLregistDto);
        }
        resultSet.close();
        log.info("prpLregistDto.findByConditions() success!");
        return collection;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsNew1(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append(" select  c.registno ");
        buffer.append("  from swflog a ");
        buffer.append("  Left Join PrpLscheduleMainWF b ");
        buffer.append(" Left Join PrpLscheduleMainWF b ");
        buffer.append(" on a.registno = b.registno ");
        buffer.append(" Left Join prplregist c ");
        buffer.append(" on c.registno = a.registno ");
        buffer.append("  where a.nodetype = 'sched' ");
        buffer.append(" and a.dataflag is null ");
        buffer.append(" and a.nodestatus = '4' ");
        
        System.err.println(buffer);        
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLregistDto prpLregistDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            collection.add(prpLregistDto);
        }
        resultSet.close();
       
        return collection;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsNew(String conditions)
            throws Exception{
        return findByConditionsNew(conditions,0,0);
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsNew(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("distinct ");
        buffer.append("c.registNo,");
        buffer.append("c.lFlag,");
        buffer.append("c.ClassCode,");
        buffer.append("c.RiskCode,");
        buffer.append("c.PolicyNo,");
        buffer.append("c.Language,");
        buffer.append("c.InsuredCode,");
        buffer.append("c.InsuredName,");
        buffer.append("c.InsuredAddress,");
        buffer.append("c.ClauseType,");
        buffer.append("c.LicenseNo,");
        buffer.append("c.LicenseColorCode,");
        buffer.append("c.CarKindCode,");
        buffer.append("c.ModelCode,");
        buffer.append("c.BrandName,");
        buffer.append("c.EngineNo,");
        buffer.append("c.FrameNo,");
        buffer.append("c.RunDistance,");
        buffer.append("c.UseYears,");
        buffer.append("c.ReportDate,");
        buffer.append("c.ReportHour,");
        buffer.append("c.ReportAddress,");
        buffer.append("c.ReportorName,");
        buffer.append("c.ReportType,");
        buffer.append("c.PhoneNumber,");
        buffer.append("c.LinkerName,");
        buffer.append("c.DamageStartDate,");
        buffer.append("c.DamageStartHour,");
        buffer.append("c.DamageEndDate,");
        buffer.append("c.DamageEndHour,");
        buffer.append("c.DamageCode,");
        buffer.append("c.DamageName,");
        buffer.append("c.DamageTypeCode,");
        buffer.append("c.DamageTypeName,");
        buffer.append("c.FirstSiteFlag,");
        buffer.append("c.DamageAreaCode,");
        buffer.append("c.DamageAreaName,");
        buffer.append("c.DamageAddressType,");
        buffer.append("c.AddressCode,");
        buffer.append("c.DamageAddress,");
        buffer.append("c.DamageAreaPostCode,");
        buffer.append("c.HandleUnit,");
        buffer.append("c.LossName,");
        buffer.append("c.LossQuantity,");
        buffer.append("c.Unit,");
        buffer.append("c.EstiCurrency,");
        buffer.append("c.EstimateLoss,");
        buffer.append("c.ReceiverName,");
        buffer.append("c.HandlerCode,");
        buffer.append("c.Handler1Code,");
        buffer.append("c.ComCode,");
        buffer.append("c.InputDate,");
        buffer.append("c.AcceptFlag,");
        buffer.append("c.RepeatInsureFlag,");
        buffer.append("c.ClaimType,");
        buffer.append("c.CancelDate,");
        buffer.append("c.DealerCode,");
        buffer.append("c.Remark,");
        buffer.append("c.OperatorCode,");
        buffer.append("c.MakeCom,");
        buffer.append("c.Flag,");
        buffer.append("c.ReportorPhoneNumber,");
        buffer.append("c.LinkerPostCode,");
        buffer.append("c.LinkerAddress,");
        buffer.append("c.EstimateFee,");
        buffer.append("c.CatastropheCode1,");
        buffer.append("c.CatastropheName1,");
        buffer.append("c.CatastropheCode2,");
        buffer.append("c.CatastropheName2,");
        buffer.append("c.ReportFlag,");
        buffer.append("c.LossesNumber,");
        buffer.append("c.LossesUnitCode,");
        buffer.append("c.BusinessType,");
        buffer.append("c.BusinessType1,");
        buffer.append("c.IndemnityDuty, ");
        buffer.append("c.BusinessFlag, ");
        buffer.append("c.OtherFlag ");
        buffer.append("  from swflogstore a ");
        buffer.append("  Left Join PrpLscheduleMainWF b ");
        buffer.append(" on a.registno = b.registno ");
        buffer.append(" Left Join prplregist c ");
        buffer.append(" on c.registno = a.registno ");
        buffer.append("  where a.nodetype = 'endca' ");
        /*
         * a.nodetype = 'endca'结案
         * 		sched 调度
         */
        buffer.append(" and a.dataflag is null ");
        buffer.append(" and a.nodestatus = '4' ");
        buffer.append("and TO_DATE (a.flowintime ,'yyyy-mm-dd hh24:mi:ss') >= TO_DATE('2013-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') ");
        buffer.append("and TO_DATE (a.flowintime ,'yyyy-mm-dd hh24:mi:ss') <= TO_DATE('2013-12-31 23:59:59','yyyy-mm-dd hh24:mi:ss') ");
        	 
        //-----
        boolean supportPaging = false;//数据库是否支持分页
		if (pageNo > 0) {
			//对Oracle优化
			if (dbManager.getConnection().getMetaData()
					.getDatabaseProductName().equalsIgnoreCase("Oracle")) {
				buffer.insert(0,
						"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
				buffer.append(") row_ WHERE rownum <= " + rowsPerPage
						* pageNo + ") WHERE rownum_ > " + rowsPerPage
						* (pageNo - 1));
				supportPaging = true;
			}

		}
		System.err.println("buffer:"+buffer);
        //--------
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(!supportPaging && pageNo > 1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLregistDto prpLregistDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }
            prpLregistDto = new PrpLregistDto();
            prpLregistDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistDto.setLFlag(dbManager.getString(resultSet,2));
            prpLregistDto.setClassCode(dbManager.getString(resultSet,3));
            prpLregistDto.setRiskCode(dbManager.getString(resultSet,4));
            prpLregistDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLregistDto.setLanguage(dbManager.getString(resultSet,6));
            prpLregistDto.setInsuredCode(dbManager.getString(resultSet,7));
            prpLregistDto.setInsuredName(dbManager.getString(resultSet,8));
            prpLregistDto.setInsuredAddress(dbManager.getString(resultSet,9));
            prpLregistDto.setClauseType(dbManager.getString(resultSet,10));
            prpLregistDto.setLicenseNo(dbManager.getString(resultSet,11));
            prpLregistDto.setLicenseColorCode(dbManager.getString(resultSet,12));
            prpLregistDto.setCarKindCode(dbManager.getString(resultSet,13));
            prpLregistDto.setModelCode(dbManager.getString(resultSet,14));
            prpLregistDto.setBrandName(dbManager.getString(resultSet,15));
            prpLregistDto.setEngineNo(dbManager.getString(resultSet,16));
            prpLregistDto.setFrameNo(dbManager.getString(resultSet,17));
            prpLregistDto.setRunDistance(dbManager.getDouble(resultSet,18));
            prpLregistDto.setUseYears(dbManager.getInt(resultSet,19));
            prpLregistDto.setReportDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpLregistDto.setReportHour(dbManager.getString(resultSet,21));
            prpLregistDto.setReportAddress(dbManager.getString(resultSet,22));
            prpLregistDto.setReportorName(dbManager.getString(resultSet,23));
            prpLregistDto.setReportType(dbManager.getString(resultSet,24));
            prpLregistDto.setPhoneNumber(dbManager.getString(resultSet,25));
            prpLregistDto.setLinkerName(dbManager.getString(resultSet,26));
            prpLregistDto.setDamageStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpLregistDto.setDamageStartHour(dbManager.getString(resultSet,28));
            prpLregistDto.setDamageEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,29));
            prpLregistDto.setDamageEndHour(dbManager.getString(resultSet,30));
            prpLregistDto.setDamageCode(dbManager.getString(resultSet,31));
            prpLregistDto.setDamageName(dbManager.getString(resultSet,32));
            prpLregistDto.setDamageTypeCode(dbManager.getString(resultSet,33));
            prpLregistDto.setDamageTypeName(dbManager.getString(resultSet,34));
            prpLregistDto.setFirstSiteFlag(dbManager.getString(resultSet,35));
            prpLregistDto.setDamageAreaCode(dbManager.getString(resultSet,36));
            prpLregistDto.setDamageAreaName(dbManager.getString(resultSet,37));
            prpLregistDto.setDamageAddressType(dbManager.getString(resultSet,38));
            prpLregistDto.setAddressCode(dbManager.getString(resultSet,39));
            prpLregistDto.setDamageAddress(dbManager.getString(resultSet,40));
            prpLregistDto.setDamageAreaPostCode(dbManager.getString(resultSet,41));
            prpLregistDto.setHandleUnit(dbManager.getString(resultSet,42));
            prpLregistDto.setLossName(dbManager.getString(resultSet,43));
            prpLregistDto.setLossQuantity(dbManager.getDouble(resultSet,44));
            prpLregistDto.setUnit(dbManager.getString(resultSet,45));
            prpLregistDto.setEstiCurrency(dbManager.getString(resultSet,46));
            prpLregistDto.setEstimateLoss(dbManager.getDouble(resultSet,47));
            prpLregistDto.setReceiverName(dbManager.getString(resultSet,48));
            prpLregistDto.setHandlerCode(dbManager.getString(resultSet,49));
            prpLregistDto.setHandler1Code(dbManager.getString(resultSet,50));
            prpLregistDto.setComCode(dbManager.getString(resultSet,51));
            prpLregistDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,52));
            prpLregistDto.setAcceptFlag(dbManager.getString(resultSet,53));
            prpLregistDto.setRepeatInsureFlag(dbManager.getString(resultSet,54));
            prpLregistDto.setClaimType(dbManager.getString(resultSet,55));
            prpLregistDto.setCancelDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,56));
            prpLregistDto.setDealerCode(dbManager.getString(resultSet,57));
            prpLregistDto.setRemark(dbManager.getString(resultSet,58));
            prpLregistDto.setOperatorCode(dbManager.getString(resultSet,59));
            prpLregistDto.setMakeCom(dbManager.getString(resultSet,60));
            prpLregistDto.setFlag(dbManager.getString(resultSet,61));
            prpLregistDto.setReportorPhoneNumber(dbManager.getString(resultSet,62));
            prpLregistDto.setLinkerPostCode(dbManager.getString(resultSet,63));
            prpLregistDto.setLinkerAddress(dbManager.getString(resultSet,64));
            prpLregistDto.setEstimateFee(dbManager.getDouble(resultSet,65));
            prpLregistDto.setCatastropheCode1(dbManager.getString(resultSet,66));
            prpLregistDto.setCatastropheName1(dbManager.getString(resultSet,67));
            prpLregistDto.setCatastropheCode2(dbManager.getString(resultSet,68));
            prpLregistDto.setCatastropheName2(dbManager.getString(resultSet,69));
            prpLregistDto.setReportFlag(dbManager.getString(resultSet,70));
            prpLregistDto.setLossesNumber(dbManager.getDouble(resultSet,71));
            prpLregistDto.setLossesUnitCode(dbManager.getString(resultSet,72));
            prpLregistDto.setBusinessType(dbManager.getString(resultSet,73));
            prpLregistDto.setBusinessType1(dbManager.getString(resultSet,74));
            prpLregistDto.setIndemnityDuty(dbManager.getString(resultSet,75));
            prpLregistDto.setBusinessFlag(dbManager.getString(resultSet,76));
            prpLregistDto.setOtherFlag(dbManager.getString(resultSet,77));
            collection.add(prpLregistDto);
        }
        resultSet.close();
       
        return collection;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCountNew(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
       String  statement ;
          statement = "SELECT count( distinct c.registNO ) "+
  " from swflogstore a "+
  " Left Join PrpLscheduleMainWF b "+
  " on a.registno = b.registno "+
  " Left Join prplregist c "+
  "  on c.registno = a.registno "+
  " where a.nodetype = 'endca' "+
  " and a.dataflag is null "+
  " and a.nodestatus = '4'  "+
  " and TO_DATE (a.flowintime ,'yyyy-mm-dd hh24:mi:ss') >= TO_DATE('2013-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss') "+
  " and TO_DATE (a.flowintime ,'yyyy-mm-dd hh24:mi:ss') <= TO_DATE('2013-12-31 23:59:59','yyyy-mm-dd hh24:mi:ss') ";
;
           statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    
   /**
    * 案件互查，查询记录数
    * @param condition
    * @return
    * @throws Exception
    */
	public int getCaseNoCount(StringBuffer condition) throws Exception {
		int totalCount = 0;
		ResultSet rs = null;
    	StringBuffer buffer = new StringBuffer(1000);
    	buffer.append("select count(1) a from(  ");
    	buffer.append(condition.toString());
    	buffer.append(") ");
    	System.out.println(buffer.toString());
    	rs = dbManager.executeQuery(buffer.toString());
    	if(rs!=null&&rs.next()){
    		totalCount = rs.getInt("A");
    	}
    	
		return totalCount;
	}
	/**
	 * 案件互查插叙详细信息
	 * @param condition
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<CaseNoQueryDto> getCaseNo(StringBuffer condition,int pageNo,int recordPerPage) throws Exception {
		ArrayList<CaseNoQueryDto> list = new ArrayList<CaseNoQueryDto>();
    	ResultSet rs = null;
    	StringBuffer buffer = new StringBuffer(1000);
    	
    	buffer.append("select * from (  ");
    	buffer.append("select distinct policyno,registno,claimno,compensateno,caseno,flowid1,flowid2,rownum rn from (  ");
    	buffer.append(condition);
    	buffer.append(")  ");
    	buffer.append("where rownum<="+(pageNo*recordPerPage)+"  )");
    	buffer.append("where rn>"+ ((pageNo-1)*recordPerPage)+" ");
    	buffer.append(" order by policyno,registno ");
    	System.out.println(buffer.toString());
    	rs = dbManager.executeQuery(buffer.toString());
    	if(rs!=null){
    		while(rs.next()){
    			CaseNoQueryDto caseNoQueryDto = new CaseNoQueryDto();
    			caseNoQueryDto.setPolicyno(rs.getString("policyno"));
    			caseNoQueryDto.setRegistno(rs.getString("registno"));
    			caseNoQueryDto.setClaimno(rs.getString("claimno"));
    			caseNoQueryDto.setCompensateno(rs.getString("compensateno"));
    			caseNoQueryDto.setCaseno(rs.getString("caseno"));
    			String flowid1 = rs.getString("flowid1");
    			String flowid2 = rs.getString("flowid2");
    			if(flowid1!=null&&!"".equals(flowid1)){
    				caseNoQueryDto.setFlowid(flowid1);
    			}else if(flowid2!=null&&!"".equals(flowid1)){
    				caseNoQueryDto.setFlowid(flowid2);
    			}else{
    				caseNoQueryDto.setFlowid("");
    			}
    				
    			
    			
    			list.add(caseNoQueryDto);
    		}
    	}
    	return list;
	}
    
}
