package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdeductCondDto;
import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDdeductCond;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDdeductCond 免赔条件表的业务对象扩展类<br>
 * 创建于 2005-01-20 09:47:10.609<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDdeductCondAction extends BLPrpDdeductCondActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDdeductCondAction.class);
    private static final BLPrpDdeductCondAction blPrpDdeductCondAction = new BLPrpDdeductCondAction();
    public static BLPrpDdeductCondAction getInstance(){
    	return blPrpDdeductCondAction;
    }

    /**
     * 构造函数
     */
    public BLPrpDdeductCondAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDdeductCondDto prpDdeductCondDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDdeductCondDto prpDdeductCondDto,String mode) throws Exception{
    }
    
    public double findDeductibleRateOfAbsolute(DBManager dbManager,String clauseType, String kindCode, ArrayList deductConditionList, 
			String riskCode, String validDate)
    throws Exception{//查找绝对免赔率
    	DBPrpDdeductCond dbPrpDdeductCond = new DBPrpDdeductCond(dbManager);
    	double dblDeductibleRate = 0d;
    	
    	String conditions = " kindCode = '" + kindCode +"'";
        //conditions = conditions + StringConvert.convertDate("validDate",validDate,"<=");
    	conditions = conditions +  " and  validDate <= SINOSOFT_to_date('"+validDate+"','YYYY-MM-DD') " ;
       	                             
    	
        conditions = conditions + " order by DEDUCTPERIOD desc ";
        
		List prpDDeductCondDtoList = (ArrayList)dbPrpDdeductCond.findByConditions(conditions);
		
		Map deductMap = new HashMap();
		Map commonDeductMap = new HashMap();		
		for(int i=0;i<prpDDeductCondDtoList.size();i++){
			PrpDdeductCondDto prpDdeductCondDto = new PrpDdeductCondDto();
			prpDdeductCondDto = (PrpDdeductCondDto)prpDDeductCondDtoList.get(i);
			if(prpDdeductCondDto.getRiskCode().equals(riskCode)){
				deductMap.put(prpDdeductCondDto.getDeductCondCode(), prpDdeductCondDto);
			}else if("0000".equals(prpDdeductCondDto.getRiskCode())){
				commonDeductMap.put(prpDdeductCondDto.getDeductCondCode(), prpDdeductCondDto);
			}
		}
		
		Map deductTempMap = new HashMap();
		if(deductMap.size()>0){
			deductTempMap = deductMap;
			
		}else if(commonDeductMap.size()>0){
			deductTempMap = commonDeductMap;
		}
		if(deductTempMap.size()>0){
			PrpDdeductCondDto prpDdeductCondDtoTemp = (PrpDdeductCondDto)deductTempMap.get("000");
			if(prpDdeductCondDtoTemp != null){
				dblDeductibleRate = prpDdeductCondDtoTemp.getDeductRate();
			}
			for (Iterator iter = deductConditionList.iterator(); iter.hasNext();) {
	    		PrpLdeductCondDto prpLdeductCondDto = (PrpLdeductCondDto) iter.next();
	    		String deductCode = prpLdeductCondDto.getDeductCondCode();
	    		String times = String.valueOf(prpLdeductCondDto.getTimes());
				int baseTimes = 1;
				PrpDdeductCondDto prpDdeductCondDto = (PrpDdeductCondDto)deductTempMap.get(deductCode);
				if(prpDdeductCondDto != null){
					dblDeductibleRate += prpDdeductCondDto.getDeductRate()*(Integer.parseInt(times)-baseTimes+1.00);
			
				}
			}
		}
		return dblDeductibleRate;
	}
}
