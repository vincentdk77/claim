package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLcompensatetgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcompensate赔款计算书表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcompensatetg extends DBPrpLcompensatetgBase{
    private static Log log = LogFactory.getLog(DBPrpLcompensatetg.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcompensatetg(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplcompensate表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT a.ClaimNo,"+
                           "a.PolicyNo, "+
                           "a.CompensateNo, "+
                           "a.SumPaid, "+
                           "a.UnderWriteFlag, "+
                           "b.Status, "+
                           "b.RiskCode, "+ 
                           "c.LicenseNo From (select * from PrpLClaimStatustg where NodeType='compe') b LEFT JOIN PrpLcompensatetg a ON a.CompensateNo = b.BusinessNo LEFT JOIN (SELECT PrpLclaimtg.ClaimNo AS ClaimNo,PrpLclaimtg.RegistNo AS RegistNo,PrpLregist.LicenseNo AS LicenseNo,PrpLregist.Insuredname as insuredName from PrpLclaimtg LEFT JOIN PrpLregist on PrpLregist.RegistNo=PrpLclaimtg.RegistNo) c ON a.ClaimNo = c.ClaimNo where"+conditions ; 
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLcompensatetgDto prpLcompensatetgDto = null; 
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
            prpLcompensatetgDto = new PrpLcompensatetgDto();
            prpLcompensatetgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcompensatetgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLcompensatetgDto.setCompensateNo(dbManager.getString(resultSet,3));
            prpLcompensatetgDto.setSumPaid(dbManager.getDouble(resultSet,4));
            prpLcompensatetgDto.setUnderWriteFlag(dbManager.getString(resultSet,5));
            prpLcompensatetgDto.setStatus(dbManager.getString(resultSet,6));
            //prpLcompensatetgDto.setUnderWriteFlag(dbManager.getString(resultSet,7));
            prpLcompensatetgDto.setRiskCode(dbManager.getString(resultSet,7)); 
            collection.add(prpLcompensatetgDto); 
        }
        resultSet.close();
        log.info("DBPrpLcompensatetg.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件从prplcompensate表,prplregist表和prplclaimstatus表中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception 
     * @return Collection
     * Modify By sunhao 2004-09-07 Reason:实赔复核查询条件
     */
    public Collection findByApproveQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select prplcompensatetg.CompensateNo,"+
                           "prplcompensatetg.PolicyNo, "+
                           "prplcompensatetg.ClaimNo, "+
                           "prplcompensatetg.OperatorCode, "+
                           "prplcompensatetg.InputDate,prplcompensatetg.RiskCode from prplcompensatetg where "+conditions ; 
        log.debug(statement);
         
        Collection collection = new ArrayList();
        PrpLcompensatetgDto prpLcompensatetgDto = null;
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
            prpLcompensatetgDto = new PrpLcompensatetgDto();
            prpLcompensatetgDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcompensatetgDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLcompensatetgDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLcompensatetgDto.setOperatorCode(dbManager.getString(resultSet,4));
            prpLcompensatetgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcompensatetgDto.setRiskCode(dbManager.getString(resultSet,6));
            collection.add(prpLcompensatetgDto); 
        }
        resultSet.close();
        log.info("DBPrpLcompensatetg.findByApproveConditions() success!");
        return collection;
    }

    /**
     * 复核实赔
     * @param compensateNo：赔款计算书号码
     * @param userCode：复核员代码
     * @param underWriteFlag：核赔标志
     * @throws Exception
     */
    public void approve(String compensateNo,String userCode,String underWriteFlag) throws Exception{
        String statement = " Update PrpLcompensatetg  set ApproverCode = '"+userCode+"',UnderWriteFlag = '"+underWriteFlag+"' where compensateno = '"+compensateNo+"'";
  

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.executePreparedUpdate();
        log.info("DBPrpLcompensatetgBase.delete() success!");
    }  
    
    
    /**
     * 根据赔案号得到已决赔款
     * @param claimNo 赔案号
     * @author wangli 
     * @return
     * @throws Exception
     */
    public CompensateFeeDto findCompensateFeeByClaimNo(String claimNo)throws Exception{
    	
    	double sumPaid = 0d;
    	CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
    	String statement = "select sum(t.sumpaid)  from prplcompensatetg t  where  t.claimno = '"+claimNo+"' and (t.UnderWriteFlag = '1' or t.UnderWriteFlag ='3')";

    	ResultSet resultSet = dbManager.executeQuery(statement);
    	while(resultSet.next()){
    	String temp = dbManager.getString(resultSet,1); 	
    	
    	if(temp!=null&&temp.length()>0){
    	sumPaid =Double.parseDouble(temp);
    	} 	
    	compensateFeeDto.setSumPaid(sumPaid);
    	}
    	
    	resultSet.close();
    	return compensateFeeDto;    
    }
    
    //add by zhaolu 20060803 start
    public int getCount1(String conditions)
    throws Exception{
    int count = -1;
    String statement = "Select count(1) From (select * from PrpLClaimStatustg where NodeType='compe') b LEFT JOIN PrpLcompensatetg a ON a.CompensateNo = b.BusinessNo LEFT JOIN (SELECT PrpLclaimtg.ClaimNo AS ClaimNo,PrpLclaimtg.RegistNo AS RegistNo,PrpLregist.LicenseNo AS LicenseNo,PrpLregist.Insuredname as insuredName from PrpLclaimtg LEFT JOIN PrpLregist on PrpLregist.RegistNo=PrpLclaimtg.RegistNo) c ON a.ClaimNo = c.ClaimNo where"+conditions ;;
    statement = SqlUtils.getWherePartForGetCount(statement);
    log.debug(statement);
    ResultSet resultSet = dbManager.executeQuery(statement);
    resultSet.next(); 
    count = dbManager.getInt(resultSet,1); 
    resultSet.close();
    log.info("DBPrpLcompensatetg.getCount1() success!");
    return count;
}
    //add by zhaolu 20060803 end
    
    /**
     * 校验计算书是否核赔通过
     * strCompensateNo   ： 理算书号
     * reurn             ：true代表非正在理算处理或核赔退回的单子
     */
    public boolean checkCompensateNo(String strCompensateNo)throws Exception{
    	StringBuffer strBuffer = new StringBuffer();
    	strBuffer.append("select 1                                                  ");                                                         
    	strBuffer.append("  from swflog sw                                          ");                                                         
    	strBuffer.append(" where sw.nodeType = 'compp'                              ");                                                         
    	strBuffer.append("   and sw.NodeStatus in ('2', '3')                        ");                                                         
    	strBuffer.append("   and (sw.flowStatus = '1' or sw.flowStatus = '2')       ");                                                         
    	strBuffer.append("   and sw.businessno = '"+strCompensateNo+"'        "); 
    	boolean flag = true;
    	try{	
    		ResultSet resultSet = dbManager.executeQuery(strBuffer.toString());
    		if(resultSet.next()){
    			flag = false;
    		}
    		resultSet.close();
    	}catch(Exception e){
    		throw e;
    	}finally{
    		
    	}
    	
    	return flag;
    }
    
    /**
     * 按条件查询 理赔清单的数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 集合
     * @throws Exception
     */
    public Collection findByConditionsForNXDA(String conditions,int pageNo,int rowsPerPage) throws Exception{
    	String statement = " SELECT SETTLELISTCODE," +
						" FCODE," +
						" FNAME," +
						" FIDCARD," +
						" ZHIBUKA," +
						" INSUREAREA," +
						" GROWINGSEASON," +
						" LOSSRATE," +
						" SETTLEAREA," +
						" SETTLESUM," +
						" INSURECATEGORY," +
						" VALIDITY FROM  SETTLECLAIMSLIST t where "+ conditions+ " Order By SETTLELISTCODE";

			log.debug(statement);
			Collection collection = new ArrayList();
			
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
				ArrayList arrayList = new ArrayList();
				arrayList.add(dbManager.getString(resultSet, 1));
				arrayList.add(dbManager.getString(resultSet, 2));
				arrayList.add(dbManager.getString(resultSet, 3));
				arrayList.add(dbManager.getString(resultSet, 4));
				arrayList.add(dbManager.getString(resultSet, 5));
				arrayList.add(dbManager.getDouble(resultSet, 6));
				arrayList.add(dbManager.getDouble(resultSet, 7));
				arrayList.add(dbManager.getDouble(resultSet, 8));
				arrayList.add(dbManager.getDouble(resultSet, 9));
				arrayList.add(dbManager.getDouble(resultSet, 10));
				arrayList.add(dbManager.getString(resultSet, 11));
				arrayList.add(dbManager.getString(resultSet, 12));
				
				collection.add(arrayList);
			}
			resultSet.close();
			log.info("DBPrpLcompensatetgBase.findByConditionsForNXDA() success!");
			return collection;
    }
    
    /**
     * 查询满足条件的理赔清单记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的理赔清单记录数
     * @throws Exception 
     */
	public int getCountForNXDA(String conditions) throws Exception {
		int count = -1;
        String statement = " SELECT COUNT(distinct(fcode)) FROM SETTLECLAIMSLIST WHERE " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
       
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next(); 
        count = dbManager.getInt(resultSet,1); 
        resultSet.close();
       
        return count;
	}
	
	/**
     * 查询理赔清单的总亩数
     * @param conditions conditions
     * @return 查询满足条件的理赔清单总亩数
	 * @throws Exception 
     */
	public double getSumSettleAreaForNXDA(String conditions) throws Exception {
		double count = -1;
        String statement = " SELECT SUM(SETTLEAREA) FROM SETTLECLAIMSLIST WHERE " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
       
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next(); 
        count = dbManager.getDouble(resultSet,1); 
        resultSet.close();
       
        return count;
	}
    
	 public PrpLcompensateDto transTGToPrplCompensate(PrpLcompensatetgDto prpLcompensatetgDto){
		  PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		  prpLcompensateDto.setAccount               	(prpLcompensatetgDto.getAccount()              );
		  prpLcompensateDto.setAffectedArea          	(prpLcompensatetgDto.getAffectedArea       ()  );
		  prpLcompensateDto.setAffectedUnit          	(prpLcompensatetgDto.getAffectedUnit       ()  );
		  prpLcompensateDto.setAppliName             	(prpLcompensatetgDto.getAppliName          ()  );
		  prpLcompensateDto.setApproverCode          	(prpLcompensatetgDto.getApproverCode       ()  );
		  prpLcompensateDto.setBank                  	(prpLcompensatetgDto.getBank               ()  );
		  prpLcompensateDto.setBrandName             	(prpLcompensatetgDto.getBrandName          ()  );
		  prpLcompensateDto.setBusinessFlag          	(prpLcompensatetgDto.getBusinessFlag       ()  );
		  prpLcompensateDto.setBusinessNature        	(prpLcompensatetgDto.getBusinessNature     ()  );
		  prpLcompensateDto.setBusinessType          	(prpLcompensatetgDto.getBusinessType       ()  );
		  prpLcompensateDto.setBusinessType1         	(prpLcompensatetgDto.getBusinessType1      ()  );
		  prpLcompensateDto.setCarKind               	(prpLcompensatetgDto.getCarKind            ()  );
		  prpLcompensateDto.setCarKindCode           	(prpLcompensatetgDto.getCarKindCode        ()  );
		  prpLcompensateDto.setCaseNo                	(prpLcompensatetgDto.getCaseNo             ()  );
		  prpLcompensateDto.setCaseType              	(prpLcompensatetgDto.getCaseType           ()  );
		  prpLcompensateDto.setCaseTypeName          	(prpLcompensatetgDto.getCaseTypeName       ()  );
		  prpLcompensateDto.setCheckAgentCode        	(prpLcompensatetgDto.getCheckAgentCode     ()  );
		  prpLcompensateDto.setCheckAgentName        	(prpLcompensatetgDto.getCheckAgentName     ()  );
		  prpLcompensateDto.setChecker1              	(prpLcompensatetgDto.getChecker1           ()  );
		  prpLcompensateDto.setClaimNo               	(prpLcompensatetgDto.getClaimNo            ()  );
		  prpLcompensateDto.setClaimNotification     	(prpLcompensatetgDto.getClaimNotification  ()  );
		  prpLcompensateDto.setClaimRelationNo	 	 	(prpLcompensatetgDto.getClaimRelationNo	 	() );
		  prpLcompensateDto.setClaimType			 	(prpLcompensatetgDto.getClaimType			() );
		  prpLcompensateDto.setClaimTypeName		 	(prpLcompensatetgDto.getClaimTypeName		() );
		  prpLcompensateDto.setClassCode		     	(prpLcompensatetgDto.getClassCode		   () );
		  prpLcompensateDto.setClauseName   		 	(prpLcompensatetgDto.getClauseName   		() );
		  prpLcompensateDto.setClauseType			 	(prpLcompensatetgDto.getClauseType			() );
		  prpLcompensateDto.setClauseTypeCode		 	(prpLcompensatetgDto.getClauseTypeCode		() );
		  prpLcompensateDto.setCoinsFlag			 	(prpLcompensatetgDto.getCoinsFlag			() );
		  prpLcompensateDto.setCoinsOtherPaid		 	(prpLcompensatetgDto.getCoinsOtherPaid		() );
		  prpLcompensateDto.setCoinsPaidLossType	 	(prpLcompensatetgDto.getCoinsPaidLossType	() );
		  prpLcompensateDto.setCoinsSumPaid	 		 	(prpLcompensatetgDto.getCoinsSumPaid	 	() 	);
		  prpLcompensateDto.setComCode				 	(prpLcompensatetgDto.getComCode				() );
		  prpLcompensateDto.setComName				 	(prpLcompensatetgDto.getComName				() );
		  prpLcompensateDto.setCompensateList		 	(prpLcompensatetgDto.getCompensateList		() );
		  prpLcompensateDto.setCompensateNo			 	(prpLcompensatetgDto.getCompensateNo		() 	);
		  prpLcompensateDto.setCounterClaimerName	 	(prpLcompensatetgDto.getCounterClaimerName	() );
		  prpLcompensateDto.setCurrency				 	(prpLcompensatetgDto.getCurrency			() 	);
		  prpLcompensateDto.setCurrencyName			 	(prpLcompensatetgDto.getCurrencyName		() 	);
		  prpLcompensateDto.setDamageAddress		 	(prpLcompensatetgDto.getDamageAddress		() );
		  prpLcompensateDto.setDamageAddressType	 	(prpLcompensatetgDto.getDamageAddressType	() );
		  prpLcompensateDto.setDamageCode			 	(prpLcompensatetgDto.getDamageCode			() );
		  prpLcompensateDto.setDamageInsured		 	(prpLcompensatetgDto.getDamageInsured		() );
		  prpLcompensateDto.setDamageName			 	(prpLcompensatetgDto.getDamageName			() );
		  prpLcompensateDto.setDamageStartDate		 	(prpLcompensatetgDto.getDamageStartDate		() );
		  prpLcompensateDto.setDamageStartHour		 	(prpLcompensatetgDto.getDamageStartHour		() );
		  prpLcompensateDto.setDamageStartMinute	 	(prpLcompensatetgDto.getDamageStartMinute	() );
		  prpLcompensateDto.setDeathQuantity		 	(prpLcompensatetgDto.getDeathQuantity		() );
		  prpLcompensateDto.setDeathUnit			 	(prpLcompensatetgDto.getDeathUnit			() );
		  prpLcompensateDto.setDeductCond			 	(prpLcompensatetgDto.getDeductCond			() );
		  prpLcompensateDto.setDeductibleTerm		 	(prpLcompensatetgDto.getDeductibleTerm		() );
		  prpLcompensateDto.setDisasterArea			 	(prpLcompensatetgDto.getDisasterArea		() 	);
		  prpLcompensateDto.setDisasterUnit			 	(prpLcompensatetgDto.getDisasterUnit		() 	);
		  prpLcompensateDto.setDutyDescription		 	(prpLcompensatetgDto.getDutyDescription		() );
		  prpLcompensateDto.setEditType				 	(prpLcompensatetgDto.getEditType			() 	);
		  prpLcompensateDto.setEndDate				 	(prpLcompensatetgDto.getEndDate				() );
		  prpLcompensateDto.setEndHour				 	(prpLcompensatetgDto.getEndHour				() );
		  prpLcompensateDto.setEngineNo				 	(prpLcompensatetgDto.getEngineNo			() 	);
		  prpLcompensateDto.setEscapeFlag			 	(prpLcompensatetgDto.getEscapeFlag			() );
		  prpLcompensateDto.setFinallyFlag 			 	(prpLcompensatetgDto.getFinallyFlag 		() 	);
		  prpLcompensateDto.setFlag					 	(prpLcompensatetgDto.getFlag				() 	);
		  prpLcompensateDto.setFrameNo				 	(prpLcompensatetgDto.getFrameNo				() );
		  prpLcompensateDto.setHandler1Code			 	(prpLcompensatetgDto.getHandler1Code		() 	);
		  prpLcompensateDto.setHandler1Name			 	(prpLcompensatetgDto.getHandler1Name		() 	);
		  prpLcompensateDto.setHandlerCode			 	(prpLcompensatetgDto.getHandlerCode			() );
		  prpLcompensateDto.setHandlerName			 	(prpLcompensatetgDto.getHandlerName			() );
		  prpLcompensateDto.setIndemnityDuty		 	(prpLcompensatetgDto.getIndemnityDuty		() );
		  prpLcompensateDto.setIndemnityDutyName	 	(prpLcompensatetgDto.getIndemnityDutyName	() );
		  prpLcompensateDto.setIndemnityDutyRate	 	(prpLcompensatetgDto.getIndemnityDutyRate	() );
		  prpLcompensateDto.setInncentTreatment	 	 	(prpLcompensatetgDto.getInncentTreatment	()  	);
		  prpLcompensateDto.setInputDate			 	(prpLcompensatetgDto.getInputDate			() );
		  prpLcompensateDto.setInsuredCode			 	(prpLcompensatetgDto.getInsuredCode			() );
		  prpLcompensateDto.setInsuredName			 	(prpLcompensatetgDto.getInsuredName			() );
		  prpLcompensateDto.setInsuredNameShow		 	(prpLcompensatetgDto.getInsuredNameShow		() );
		  prpLcompensateDto.setKillQuantity			 	(prpLcompensatetgDto.getKillQuantity		() 	);
		  prpLcompensateDto.setKillUnit				 	(prpLcompensatetgDto.getKillUnit			() 	);
		  prpLcompensateDto.setLawsuitFlag			 	(prpLcompensatetgDto.getLawsuitFlag			() );
		  prpLcompensateDto.setLFlag				 	(prpLcompensatetgDto.getLFlag				() );
		  prpLcompensateDto.setLicenseColorCode		 	(prpLcompensatetgDto.getLicenseColorCode	() 	);
		  prpLcompensateDto.setLicenseColor			 	(prpLcompensatetgDto.getLicenseColor		() 	);
		  prpLcompensateDto.setLicenseNo			 	(prpLcompensatetgDto.getLicenseNo			() );
		  prpLcompensateDto.setLossesNumber			 	(prpLcompensatetgDto.getLossesNumber		() 	);
		  prpLcompensateDto.setLossesUnitCode		 	(prpLcompensatetgDto.getLossesUnitCode		() );
		  prpLcompensateDto.setLossSumRealPay		 	(prpLcompensatetgDto.getLossSumRealPay		() );
		  prpLcompensateDto.setMakeCom				 	(prpLcompensatetgDto.getMakeCom				() );
		  prpLcompensateDto.setMedicalType			 	(prpLcompensatetgDto.getMedicalType			() );
		  prpLcompensateDto.setNoProductionArea	 	 	(prpLcompensatetgDto.getNoProductionArea	()  	);
		  prpLcompensateDto.setNoProductionUnit		 	(prpLcompensatetgDto.getNoProductionUnit	() 	);
		  prpLcompensateDto.setOjectCode			 	(prpLcompensatetgDto.getOjectCode			() );
		  prpLcompensateDto.setOjectName			 	(prpLcompensatetgDto.getOjectName			() );
		  prpLcompensateDto.setOjectType			 	(prpLcompensatetgDto.getOjectType			() );
		  prpLcompensateDto.setOperateDate			 	(prpLcompensatetgDto.getOperateDate			() );
		  prpLcompensateDto.setOperatorCode			 	(prpLcompensatetgDto.getOperatorCode		() 	);
		  prpLcompensateDto.setOtherFlag			 	(prpLcompensatetgDto.getOtherFlag			() );
		  prpLcompensateDto.setPalyFlag				 	(prpLcompensatetgDto.getPalyFlag			() 	);
		  prpLcompensateDto.setPayFee				 	(prpLcompensatetgDto.getPayFee				() );
		  prpLcompensateDto.setPayrefDate			 	(prpLcompensatetgDto.getPayrefDate			() );
		  prpLcompensateDto.setPayrefName			 	(prpLcompensatetgDto.getPayrefName			() );
		  prpLcompensateDto.setPerilCount			 	(prpLcompensatetgDto.getPerilCount			() );
		  prpLcompensateDto.setPersonLossSumRealPay	 	(prpLcompensatetgDto.getPersonLossSumRealPay() 	);
		  prpLcompensateDto.setPolicyNo				 	(prpLcompensatetgDto.getPolicyNo			() 	);
		  prpLcompensateDto.setPreserveDate			 	(prpLcompensatetgDto.getPreserveDate		() 	);
		  prpLcompensateDto.setPrpLdeductCondDtoList 	(prpLcompensatetgDto.getPrpLdeductCondtgDtoList() );
		  prpLcompensateDto.setPurchasePrice		 	(prpLcompensatetgDto.getPurchasePrice		() );
		  prpLcompensateDto.setReceiverName			 	(prpLcompensatetgDto.getReceiverName		() 	);
		  prpLcompensateDto.setRegistList			 	(prpLcompensatetgDto.getRegistList			() );
		  prpLcompensateDto.setRegistNo 			 	(prpLcompensatetgDto.getRegistNo 			() );
		  prpLcompensateDto.setRemark				 	(prpLcompensatetgDto.getRemark				() );
		  prpLcompensateDto.setReopenedType			 	(prpLcompensatetgDto.getReopenedType		() 	);
		  prpLcompensateDto.setReplevyFlag				(prpLcompensatetgDto.getReplevyFlag			() );
		  prpLcompensateDto.setResult					(prpLcompensatetgDto.getResult				() );
		  prpLcompensateDto.setRiskCode					(prpLcompensatetgDto.getRiskCode			() 	);
		  prpLcompensateDto.setSeatCount				(prpLcompensatetgDto.getSeatCount			() );
		  prpLcompensateDto.setStartDate				(prpLcompensatetgDto.getStartDate			() );
		  prpLcompensateDto.setStartHour				(prpLcompensatetgDto.getStartHour			() );
		  prpLcompensateDto.setStatisticsYM				(prpLcompensatetgDto.getStatisticsYM		() 	);
		  prpLcompensateDto.setStatus					(prpLcompensatetgDto.getStatus				() );
		  prpLcompensateDto.setSumAmount				(prpLcompensatetgDto.getSumAmount			() );
		  prpLcompensateDto.setSumCheckFee				(prpLcompensatetgDto.getSumCheckFee			() );
		  prpLcompensateDto.setSumClaim					(prpLcompensatetgDto.getSumClaim			() 	);
		  prpLcompensateDto.setSumDutyPaid				(prpLcompensatetgDto.getSumDutyPaid			() );
		  prpLcompensateDto.setSumDutyPaid1				(prpLcompensatetgDto.getSumDutyPaid1		() 	);
		  prpLcompensateDto.setSumInsured				(prpLcompensatetgDto.getSumInsured			() );
		  prpLcompensateDto.setSumLoss					(prpLcompensatetgDto.getSumLoss				() );
		  prpLcompensateDto.setSumNoDutyFee				(prpLcompensatetgDto.getSumNoDutyFee		() 	);
		  prpLcompensateDto.setSumPaid					(prpLcompensatetgDto.getSumPaid				() );
		  prpLcompensateDto.setSumPaidAll				(prpLcompensatetgDto.getSumPaidAll			() );
		  prpLcompensateDto.setSumPreChargeAmount		(prpLcompensatetgDto.getSumPreChargeAmount	() );
		  prpLcompensateDto.setSumPremium				(prpLcompensatetgDto.getSumPremium			() );
		  prpLcompensateDto.setSumPrePaid				(prpLcompensatetgDto.getSumPrePaid			() );
		  prpLcompensateDto.setSumRest					(prpLcompensatetgDto.getSumRest				() );
		  prpLcompensateDto.setSumThisPaid				(prpLcompensatetgDto.getSumThisPaid			() );
		  prpLcompensateDto.setSurveyorName				(prpLcompensatetgDto.getSurveyorName		() 	);
		  prpLcompensateDto.setThridCompanys			(prpLcompensatetgDto.getThridCompanys		() );
		  prpLcompensateDto.setThridLicenseNos			(prpLcompensatetgDto.getThridLicenseNos		() );
		  prpLcompensateDto.setTimes					(prpLcompensatetgDto.getTimes				() );
		  prpLcompensateDto.setTurnPageDto				(prpLcompensatetgDto.getTurnPageDto			() );
		  prpLcompensateDto.setUnderWriteCode			(prpLcompensatetgDto.getUnderWriteCode		() );
		  prpLcompensateDto.setUnderWriteEndDate		(prpLcompensatetgDto.getUnderWriteEndDate	() );
		  prpLcompensateDto.setUnderWriteFlag			(prpLcompensatetgDto.getUnderWriteFlag		() );
		  prpLcompensateDto.setUnderWriteName			(prpLcompensatetgDto.getUnderWriteName		() );
		  prpLcompensateDto.setUploadSerialNo			(prpLcompensatetgDto.getUploadSerialNo		() );
		  prpLcompensateDto.setWoundGrade				(prpLcompensatetgDto.getWoundGrade			() );
		  prpLcompensateDto.setZeroLossCaseType			(prpLcompensatetgDto.getZeroLossCaseType	() 	);
		  prpLcompensateDto.setZeroLossDetailReason		(prpLcompensatetgDto.getZeroLossDetailReason() 	);
		  prpLcompensateDto.setZeroLossType				(prpLcompensatetgDto.getZeroLossType		() 	);
		  return prpLcompensateDto;
	  }
    
}
 