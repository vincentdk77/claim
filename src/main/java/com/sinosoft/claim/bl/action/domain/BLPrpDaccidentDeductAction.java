package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDaccidentDeduct;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDaccidentDeduct-事故责任免赔率的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpDaccidentDeductAction extends BLPrpDaccidentDeductActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDaccidentDeductAction.class);
    private static final BLPrpDaccidentDeductAction blPrpDaccidentDeductAction = new BLPrpDaccidentDeductAction();
    public static BLPrpDaccidentDeductAction getInstance(){
    	return blPrpDaccidentDeductAction;
    }
    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDaccidentDeductDto prpDaccidentDeductDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDaccidentDeductDto prpDaccidentDeductDto,String mode)
            throws Exception{
    }
    
    public double findAccidentDeductRate(DBManager dbManager,String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String validDate)
    throws Exception{
    	double dblDutyDeductibleRate = 0;
		DBPrpDaccidentDeduct dbPrpDaccidentDeduct = new DBPrpDaccidentDeduct(dbManager);
		String conditions = "1=1";
		conditions = conditions + " and kindCode = '" + kindCode +"'";
		conditions = conditions + " and indemnityDuty = '" + indemnityDuty +"'";
        conditions = conditions + StringConvert.convertDate("validDate",validDate,"<=");
        conditions = conditions + " order by DEDUCTPERIOD desc ";
		//查找事故责任免赔率
		List prpDaccidentDeductDtoList = (ArrayList)dbPrpDaccidentDeduct.findByConditions(conditions);
		for(int i=0;i<prpDaccidentDeductDtoList.size();i++){
			PrpDaccidentDeductDto prpDaccidentDeductDto = new PrpDaccidentDeductDto();
			prpDaccidentDeductDto = (PrpDaccidentDeductDto)prpDaccidentDeductDtoList.get(i);
			if(prpDaccidentDeductDto.getRiskCode().equals(riskCode) && prpDaccidentDeductDto.getKindCode().equals(kindCode)){
				if(prpDaccidentDeductDto.getDangerLevel().equals(dangerLevel)){
					if(prpDaccidentDeductDto.getIndemnityDuty().equals(indemnityDuty)){
						dblDutyDeductibleRate = prpDaccidentDeductDto.getDeductibleRate();
						break;
					}
				}else if("0".equals(prpDaccidentDeductDto.getDangerLevel())){
					dblDutyDeductibleRate = prpDaccidentDeductDto.getDeductibleRate();
					break;
				}
			}else if("0000".equals(riskCode) && prpDaccidentDeductDto.getKindCode().equals(kindCode)){
				if(prpDaccidentDeductDto.getDangerLevel().equals(dangerLevel)){
					if(prpDaccidentDeductDto.getIndemnityDuty().equals(indemnityDuty)){
						dblDutyDeductibleRate = prpDaccidentDeductDto.getDeductibleRate();
						break;
					}
				}else if("0".equals(prpDaccidentDeductDto.getDangerLevel())){
					dblDutyDeductibleRate = prpDaccidentDeductDto.getDeductibleRate();
					break;
				}
			}
		}
		return dblDutyDeductibleRate;
	}
    
   
}
