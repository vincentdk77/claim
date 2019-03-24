package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.gyic.claim.bl.facade.BLHerdsettlelistFacade;
import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLNyxsettlelistFacade;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimtgFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensatetgFacade;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagertgDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLcompensatetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimBillManager;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimBillManagertg;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimBillManager的业务对象扩展类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLclaimBillManagertgAction extends BLPrpLclaimBillManagerActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLclaimBillManagerAction.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimBillManagertgAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimBillManagerDto prpLclaimBillManagerDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimBillManagerDto prpLclaimBillManagerDto,String mode)
            throws Exception{
    }

	public PageRecord findByConditonSum(DBManager dbManager,String conditions,String editType,String back,int rowsPerPage,int pageNo) throws Exception {
		 DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbPrpLclaimBillManager.findByConditonSumCount(conditions, editType, back,rowsPerPage,pageNo);
        collection = dbPrpLclaimBillManager.findByConditonSum(conditions,editType,back,rowsPerPage,pageNo);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
	}

	public void update(DBManager dbManager, String registNo, String compensateNo, int serialNo,
			double payAmount, String userCode,String payFlag) throws Exception {
		DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //更新记录
        dbPrpLclaimBillManager.update(registNo,compensateNo,serialNo,payAmount,userCode,payFlag);
		
	}
	
	public void update(DBManager dbManager, String registNo, String compensateNo, int serialNo,
			double payAmount,String payFlag) throws Exception {
		DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //更新记录
        dbPrpLclaimBillManager.update(registNo,compensateNo,serialNo,payAmount,payFlag);
		
	}

	public PageRecord findByConditonBillSum(DBManager dbManager,String conditions,String editType,int rowsPerPage,int pageNo) throws Exception {
		DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbPrpLclaimBillManager.findByConditonBillSumCount(conditions,editType,rowsPerPage,pageNo);
        collection = dbPrpLclaimBillManager.findByConditonBillSum(conditions,editType,rowsPerPage,pageNo);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
	}
	/**
	 * 新农险清单支付审核详细信息查询
	 * @param dbManager
	 * @param conditions
	 * @param editType
	 * @param rowsPerPage
	 * @param pageNo
	 * @param wtFlag
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByConditonBillSumNew(DBManager dbManager,String conditions,String editType,int rowsPerPage,int pageNo,boolean wtFlag) throws Exception {
		DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
		Collection collection = new ArrayList();
		
		if(conditions.trim().length()==0){
			conditions = "1=1";
		}
		int count = 0;
		if(wtFlag){
			count = dbPrpLclaimBillManager.findByConditonBillSumCountNewtg(conditions,editType,rowsPerPage,pageNo);
			collection = dbPrpLclaimBillManager.findByConditonBillSumNewtg(conditions,editType,rowsPerPage,pageNo);
		}else{
			count = dbPrpLclaimBillManager.findByConditonBillSumCountNew(conditions,editType,rowsPerPage,pageNo);
			collection = dbPrpLclaimBillManager.findByConditonBillSumNew(conditions,editType,rowsPerPage,pageNo);
		}
		PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
		return pageRecord;
	}
	public void nyxToclaimBillManager(DBManager dbManager,String compensateNo) throws Exception{
		//add 托管险种  2018年7月16日09:28:42
		BLUtiPlatConfigRuleFacade blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
		String tgywRisk = blUtiPlatConfigRuleFacade.findByPrimaryKey("newagriprpall", "TGYWRISK", 1).getRule();
		boolean tgFlag = false;
		if(tgywRisk.contains(compensateNo.substring(1, 5))){
			tgFlag = true;
		}
		if(tgFlag){
			BLPrpLcompensatetgFacade blPrpLcompensatetgFacade = new BLPrpLcompensatetgFacade();
	    	BLPrpLclaimtgFacade blPrpLclaimtgFacade = new BLPrpLclaimtgFacade() ; 
	    	PrpLcompensatetgDto prpLcompensatetgDto = blPrpLcompensatetgFacade.findByPrimaryKey(compensateNo);
	    	String claimNo = prpLcompensatetgDto.getClaimNo() ; 
	    	PrpLclaimtgDto prpLclaimtgDto = blPrpLclaimtgFacade.findByPrimaryKey(claimNo);
	    	ArrayList prpLclaimBillManagerList = new ArrayList();
	    	if(prpLcompensatetgDto!=null && prpLcompensatetgDto.getSumThisPaid()>0){
	    		BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
	    		if("31".equals(prpLcompensatetgDto.getClassCode())||"3228".equals(prpLcompensatetgDto.getRiskCode())){
	    			BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
	        		SettlemainlistDto settlemainlistDto = blSettlemainlistFacade.findByPrimaryKey(prpLcompensatetgDto.getClaimRelationNo());
	        		String conditions = " settlelistcode = '"+prpLcompensatetgDto.getClaimRelationNo()+"' and nodetype='compe' ";
	        		ArrayList plantingsettlelist = (ArrayList)blPlantingsettlelistFacade.findAccountByConditions(conditions);
	        		PlantingsettlelistDto plantingsettlelistDto = null;
	        		PrpLclaimBillManagertgDto prpLclaimBillManagerDto = null; 
	        		for(int i=0;i<plantingsettlelist.size();i++){
	        			plantingsettlelistDto = (PlantingsettlelistDto)plantingsettlelist.get(i);
	        			prpLclaimBillManagerDto = new PrpLclaimBillManagertgDto();
	        			prpLclaimBillManagerDto.setRegistNo(settlemainlistDto.getReportcode());
	        			prpLclaimBillManagerDto.setPolicyNo(settlemainlistDto.getPolicyno());
	        			prpLclaimBillManagerDto.setCompensateNo(settlemainlistDto.getCompensateno());
	        			prpLclaimBillManagerDto.setSerialNo(i+1);
	        			prpLclaimBillManagerDto.setPayName(plantingsettlelistDto.getFname());
	        			prpLclaimBillManagerDto.setIdentifyNumber(plantingsettlelistDto.getFidcard());
	        			prpLclaimBillManagerDto.setInsuredCode(plantingsettlelistDto.getFcode());
	        			prpLclaimBillManagerDto.setOpenBank(plantingsettlelistDto.getBank());
	        			prpLclaimBillManagerDto.setBankAccount(plantingsettlelistDto.getZhibuka());
	        			prpLclaimBillManagerDto.setSumPaid(Double.parseDouble(plantingsettlelistDto.getSettlesum()));
	        			prpLclaimBillManagerDto.setPayAmount(Double.parseDouble(plantingsettlelistDto.getSettlesum()));
	        			if("0".equals(plantingsettlelistDto.getSettlesum())){
	        				prpLclaimBillManagerDto.setPayFlag("1");
	        			}else{
	        				prpLclaimBillManagerDto.setPayFlag("0");
	        			}
	        			prpLclaimBillManagerDto.setFlag("0000000000") ; 
	        			prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
	        		}
	        		if(prpLclaimBillManagerList != null && prpLclaimBillManagerList.size() > 0 ){
	        		}else{	
		        		/*//大棚蔬菜
		        		BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
		        		ArrayList planting31settlelist = (ArrayList)blPlanting31SettleListFacade.findByConditions(conditions);
		        		Planting31SettleListDto planting31settlelistDto = null;
		        		
		        		for(int i=0;i<planting31settlelist.size();i++){
		
		        			planting31settlelistDto = (Planting31SettleListDto)planting31settlelist.get(i);
		        			prpLclaimBillManagerDto = new PrpLclaimBillManagertgDto();
		        			prpLclaimBillManagerDto.setRegistNo(prpLclaimtgDto.getRegistNo());
		        			prpLclaimBillManagerDto.setPolicyNo(prpLcompensatetgDto.getPolicyNo());
		        			prpLclaimBillManagerDto.setCompensateNo(compensateNo);
		        			prpLclaimBillManagerDto.setSerialNo(i+1);
		        			prpLclaimBillManagerDto.setPayName(planting31settlelistDto.getFname());
		        			prpLclaimBillManagerDto.setIdentifyNumber(planting31settlelistDto.getFidCard());
		        			prpLclaimBillManagerDto.setInsuredCode(planting31settlelistDto.getFcode());
		        			prpLclaimBillManagerDto.setOpenBank(planting31settlelistDto.getBank());
		        			prpLclaimBillManagerDto.setBankAccount(planting31settlelistDto.getZhiBuKa());
		        			prpLclaimBillManagerDto.setSumPaid(planting31settlelistDto.getSettleSum());
		        			prpLclaimBillManagerDto.setPayAmount(planting31settlelistDto.getSettleSum());
		        			if(planting31settlelistDto.getSettleSum()==0){
		        				prpLclaimBillManagerDto.setPayFlag("1");
		        			}else{
		        				prpLclaimBillManagerDto.setPayFlag("0");
		        			}
		        			prpLclaimBillManagerDto.setFlag("0000000000") ; 
		        			prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
		        		}*/
	        		}
	    		}else if("32".equals(prpLcompensatetgDto.getClassCode()) && !"3224".equals(prpLcompensatetgDto.getRiskCode())){
	    			BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
	        		SettlemainlistDto settlemainlistDto = blSettlemainlistFacade.findByPrimaryKey(prpLcompensatetgDto.getCompensateNo());
	        		String conditions = " settlelistcode = '"+prpLcompensatetgDto.getCompensateNo()+"' ";
	        		ArrayList herdsettlelist = (ArrayList)blHerdsettlelistFacade.findAccountByConditions(conditions);
	        		HerdsettlelistDto herdsettlelistDto = null;
	        		PrpLclaimBillManagerDto prpLclaimBillManagerDto = null; 
	        		for(int i=0;i<herdsettlelist.size();i++){
	        			herdsettlelistDto = (HerdsettlelistDto)herdsettlelist.get(i);
	        			prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
	        			prpLclaimBillManagerDto.setRegistNo(settlemainlistDto.getReportcode());
	        			prpLclaimBillManagerDto.setPolicyNo(settlemainlistDto.getPolicyno());
	        			prpLclaimBillManagerDto.setCompensateNo(settlemainlistDto.getCompensateno());
	        			prpLclaimBillManagerDto.setSerialNo(i+1);
	        			prpLclaimBillManagerDto.setPayName(herdsettlelistDto.getFname());
	        			prpLclaimBillManagerDto.setIdentifyNumber(herdsettlelistDto.getFidcard());
	        			prpLclaimBillManagerDto.setInsuredCode(herdsettlelistDto.getFcode());
	        			prpLclaimBillManagerDto.setOpenBank(herdsettlelistDto.getBankname());
	        			prpLclaimBillManagerDto.setBankAccount(herdsettlelistDto.getBankaccount());
	        			prpLclaimBillManagerDto.setSumPaid(herdsettlelistDto.getSettleamount());
	        			prpLclaimBillManagerDto.setPayAmount(herdsettlelistDto.getSettleamount());
	        			if(herdsettlelistDto.getSettleamount()==0){
	        				prpLclaimBillManagerDto.setPayFlag("1");
	        			}else{
	        				prpLclaimBillManagerDto.setPayFlag("0");
	        			}
	        			prpLclaimBillManagerDto.setFlag("0000000000") ; 
	        			prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
	        		}
	        		//yx
	    		//}else if("3224".equals(prpLcompensateDto.getRiskCode()))
	    		  }else if("3224,3201,3204,3232,3215,3219,3221,3226,3229,3230,3231,3222,3102,3105,3124,3125,3127,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196".indexOf(prpLcompensatetgDto.getRiskCode()) > -1)
	    		{
	    			SettlemainlistDto settlemainlistDto = blSettlemainlistFacade.findByPrimaryKey(prpLcompensatetgDto.getClaimRelationNo());
	        		String conditions = " settlelistcode = '"+prpLcompensatetgDto.getClaimRelationNo()+"' and nodetype='compe' ";
	    			BLNyxsettlelistFacade blNyxsettlelistFacade = new BLNyxsettlelistFacade();
	        		ArrayList planting31settlelist = (ArrayList)blNyxsettlelistFacade.findByConditions(conditions);
	        		NyxsettlelistDto planting31settlelistDto = null;
	        		PrpLclaimBillManagertgDto prpLclaimBillManagerDto = null; 
	        		for(int i=0;i<planting31settlelist.size();i++){

	        			planting31settlelistDto = (NyxsettlelistDto)planting31settlelist.get(i);
	        			prpLclaimBillManagerDto = new PrpLclaimBillManagertgDto();
	        			prpLclaimBillManagerDto.setRegistNo(settlemainlistDto.getReportcode());
	        			prpLclaimBillManagerDto.setPolicyNo(settlemainlistDto.getPolicyno());
	        			prpLclaimBillManagerDto.setCompensateNo(settlemainlistDto.getCompensateno());
	        			prpLclaimBillManagerDto.setSerialNo(i+1);
	        			prpLclaimBillManagerDto.setPayName(planting31settlelistDto.getFname());
	        			prpLclaimBillManagerDto.setIdentifyNumber(planting31settlelistDto.getFidcard());
	        			prpLclaimBillManagerDto.setInsuredCode(planting31settlelistDto.getFcode());
	        			prpLclaimBillManagerDto.setOpenBank(planting31settlelistDto.getBank());
	        			prpLclaimBillManagerDto.setBankAccount(planting31settlelistDto.getZhibuka());
	        			prpLclaimBillManagerDto.setSumPaid(planting31settlelistDto.getSettlesum());
	        			prpLclaimBillManagerDto.setPayAmount(planting31settlelistDto.getSettlesum());
	        			if(planting31settlelistDto.getSettlesum()==0){
	        				prpLclaimBillManagerDto.setPayFlag("1");
	        			}else{
	        				prpLclaimBillManagerDto.setPayFlag("0");
	        			}
	        			prpLclaimBillManagerDto.setFlag("0000000000") ; 
	        			prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
	        		}
	    		}
	    		if(prpLclaimBillManagerList != null && prpLclaimBillManagerList.size() > 0 ){
	    		}else{
	    			//String strClaimRelationNo = prpLcompensateDto.getClaimRelationNo() ; 
	            	//if("".equals(strClaimRelationNo)){
	            		String policyNo = prpLcompensatetgDto.getPolicyNo() ; 
	            		BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade() ; 
	            		ArrayList cinsuredList = (ArrayList) blPrpCinsuredFacade.findByConditions( " policyno = '"+policyNo+"' and insuredflag = '2'");
	            		if(cinsuredList != null && cinsuredList.size()> 0){
	            			PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) cinsuredList.get(0) ; 
	            			PrpLclaimBillManagertgDto prpLclaimBillManagerDto = new PrpLclaimBillManagertgDto();
	            			prpLclaimBillManagerDto.setRegistNo(prpLclaimtgDto.getRegistNo());
	            			prpLclaimBillManagerDto.setPolicyNo(policyNo);
	            			prpLclaimBillManagerDto.setCompensateNo(compensateNo);
	            			prpLclaimBillManagerDto.setSerialNo(1);
	            			prpLclaimBillManagerDto.setPayName(prpCinsuredDto.getInsuredName());
	            			prpLclaimBillManagerDto.setIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
	            			prpLclaimBillManagerDto.setInsuredCode(prpCinsuredDto.getInsuredCode());
	            			prpLclaimBillManagerDto.setOpenBank("");
	            			prpLclaimBillManagerDto.setBankAccount("");
	            			prpLclaimBillManagerDto.setSumPaid(prpLcompensatetgDto.getSumDutyPaid());
	            			prpLclaimBillManagerDto.setPayAmount(prpLcompensatetgDto.getSumDutyPaid());
	            			if(prpLcompensatetgDto.getSumPaid()==0){
	            				prpLclaimBillManagerDto.setPayFlag("1");
	            			}else{
	            				prpLclaimBillManagerDto.setPayFlag("0");
	            			}
	            			prpLclaimBillManagerDto.setFlag("0000000000") ; 
	            			prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
	            		}
	            	//}
	    		}
	    	}
	    	if(prpLclaimBillManagerList.size()>0){
	    		DBPrpLclaimBillManagertg dbPrpLclaimBillManagertg = new DBPrpLclaimBillManagertg(dbManager);
	    		dbPrpLclaimBillManagertg.deleteByConditions(" compensateno = '"+compensateNo+"' and substr(flag,0,1) = '0' ");
	    		dbPrpLclaimBillManagertg.insertAll(prpLclaimBillManagerList);
	    	}
		}else{
			BLPrpLcompensateFacade blPrpLcompensateFacade = new BLPrpLcompensateFacade();
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade() ; 
			PrpLcompensateDto prpLcompensateDto = blPrpLcompensateFacade.findByPrimaryKey(compensateNo);
			String claimNo = prpLcompensateDto.getClaimNo() ; 
			PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
			ArrayList prpLclaimBillManagerList = new ArrayList();
			if(prpLcompensateDto!=null && prpLcompensateDto.getSumThisPaid()>0){
				BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
				if("31".equals(prpLcompensateDto.getClassCode())||"3228".equals(prpLcompensateDto.getRiskCode())){
					BLPlantingsettlelistFacade blPlantingsettlelistFacade = new BLPlantingsettlelistFacade();
					SettlemainlistDto settlemainlistDto = blSettlemainlistFacade.findByPrimaryKey(prpLcompensateDto.getClaimRelationNo());
					String conditions = " settlelistcode = '"+prpLcompensateDto.getClaimRelationNo()+"' and nodetype='compe' ";
					ArrayList plantingsettlelist = (ArrayList)blPlantingsettlelistFacade.findAccountByConditions(conditions);
					PlantingsettlelistDto plantingsettlelistDto = null;
					PrpLclaimBillManagerDto prpLclaimBillManagerDto = null; 
					for(int i=0;i<plantingsettlelist.size();i++){
						plantingsettlelistDto = (PlantingsettlelistDto)plantingsettlelist.get(i);
						prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
						prpLclaimBillManagerDto.setRegistNo(settlemainlistDto.getReportcode());
						prpLclaimBillManagerDto.setPolicyNo(settlemainlistDto.getPolicyno());
						prpLclaimBillManagerDto.setCompensateNo(settlemainlistDto.getCompensateno());
						prpLclaimBillManagerDto.setSerialNo(i+1);
						prpLclaimBillManagerDto.setPayName(plantingsettlelistDto.getFname());
						prpLclaimBillManagerDto.setIdentifyNumber(plantingsettlelistDto.getFidcard());
						prpLclaimBillManagerDto.setInsuredCode(plantingsettlelistDto.getFcode());
						prpLclaimBillManagerDto.setOpenBank(plantingsettlelistDto.getBank());
						prpLclaimBillManagerDto.setBankAccount(plantingsettlelistDto.getZhibuka());
						prpLclaimBillManagerDto.setSumPaid(Double.parseDouble(plantingsettlelistDto.getSettlesum()));
						prpLclaimBillManagerDto.setPayAmount(Double.parseDouble(plantingsettlelistDto.getSettlesum()));
						if("0".equals(plantingsettlelistDto.getSettlesum())){
							prpLclaimBillManagerDto.setPayFlag("1");
						}else{
							prpLclaimBillManagerDto.setPayFlag("0");
						}
						prpLclaimBillManagerDto.setFlag("0000000000") ; 
						prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
					}
					if(prpLclaimBillManagerList != null && prpLclaimBillManagerList.size() > 0 ){
					}else{	
						//大棚蔬菜
						/*BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
						ArrayList planting31settlelist = (ArrayList)blPlanting31SettleListFacade.findByConditions(conditions);
						Planting31SettleListDto planting31settlelistDto = null;
						
						for(int i=0;i<planting31settlelist.size();i++){
							
							planting31settlelistDto = (Planting31SettleListDto)planting31settlelist.get(i);
							prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
							prpLclaimBillManagerDto.setRegistNo(prpLclaimDto.getRegistNo());
							prpLclaimBillManagerDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
							prpLclaimBillManagerDto.setCompensateNo(compensateNo);
							prpLclaimBillManagerDto.setSerialNo(i+1);
							prpLclaimBillManagerDto.setPayName(planting31settlelistDto.getFname());
							prpLclaimBillManagerDto.setIdentifyNumber(planting31settlelistDto.getFidCard());
							prpLclaimBillManagerDto.setInsuredCode(planting31settlelistDto.getFcode());
							prpLclaimBillManagerDto.setOpenBank(planting31settlelistDto.getBank());
							prpLclaimBillManagerDto.setBankAccount(planting31settlelistDto.getZhiBuKa());
							prpLclaimBillManagerDto.setSumPaid(planting31settlelistDto.getSettleSum());
							prpLclaimBillManagerDto.setPayAmount(planting31settlelistDto.getSettleSum());
							if(planting31settlelistDto.getSettleSum()==0){
								prpLclaimBillManagerDto.setPayFlag("1");
							}else{
								prpLclaimBillManagerDto.setPayFlag("0");
							}
							prpLclaimBillManagerDto.setFlag("0000000000") ; 
							prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
						}*/
					}
				}else if("32".equals(prpLcompensateDto.getClassCode()) && !"3224".equals(prpLcompensateDto.getRiskCode())){
					BLHerdsettlelistFacade blHerdsettlelistFacade = new BLHerdsettlelistFacade();
					SettlemainlistDto settlemainlistDto = blSettlemainlistFacade.findByPrimaryKey(prpLcompensateDto.getCompensateNo());
					String conditions = " settlelistcode = '"+prpLcompensateDto.getCompensateNo()+"' ";
					ArrayList herdsettlelist = (ArrayList)blHerdsettlelistFacade.findAccountByConditions(conditions);
					HerdsettlelistDto herdsettlelistDto = null;
					PrpLclaimBillManagerDto prpLclaimBillManagerDto = null; 
					for(int i=0;i<herdsettlelist.size();i++){
						herdsettlelistDto = (HerdsettlelistDto)herdsettlelist.get(i);
						prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
						prpLclaimBillManagerDto.setRegistNo(settlemainlistDto.getReportcode());
						prpLclaimBillManagerDto.setPolicyNo(settlemainlistDto.getPolicyno());
						prpLclaimBillManagerDto.setCompensateNo(settlemainlistDto.getCompensateno());
						prpLclaimBillManagerDto.setSerialNo(i+1);
						prpLclaimBillManagerDto.setPayName(herdsettlelistDto.getFname());
						prpLclaimBillManagerDto.setIdentifyNumber(herdsettlelistDto.getFidcard());
						prpLclaimBillManagerDto.setInsuredCode(herdsettlelistDto.getFcode());
						prpLclaimBillManagerDto.setOpenBank(herdsettlelistDto.getBankname());
						prpLclaimBillManagerDto.setBankAccount(herdsettlelistDto.getBankaccount());
						prpLclaimBillManagerDto.setSumPaid(herdsettlelistDto.getSettleamount());
						prpLclaimBillManagerDto.setPayAmount(herdsettlelistDto.getSettleamount());
						if(herdsettlelistDto.getSettleamount()==0){
							prpLclaimBillManagerDto.setPayFlag("1");
						}else{
							prpLclaimBillManagerDto.setPayFlag("0");
						}
						prpLclaimBillManagerDto.setFlag("0000000000") ; 
						prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
					}
					//yx
					//}else if("3224".equals(prpLcompensateDto.getRiskCode()))
				}else if("3224,3201,3204,3232,3215,3219,3221,3226,3229,3230,3231,3222,3102,3105,3124,3125,3127,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196".indexOf(prpLcompensateDto.getRiskCode()) > -1)
				{
					SettlemainlistDto settlemainlistDto = blSettlemainlistFacade.findByPrimaryKey(prpLcompensateDto.getClaimRelationNo());
					String conditions = " settlelistcode = '"+prpLcompensateDto.getClaimRelationNo()+"' and nodetype='compe' ";
					BLNyxsettlelistFacade blNyxsettlelistFacade = new BLNyxsettlelistFacade();
					ArrayList planting31settlelist = (ArrayList)blNyxsettlelistFacade.findByConditions(conditions);
					NyxsettlelistDto planting31settlelistDto = null;
					PrpLclaimBillManagerDto prpLclaimBillManagerDto = null; 
					for(int i=0;i<planting31settlelist.size();i++){
						
						planting31settlelistDto = (NyxsettlelistDto)planting31settlelist.get(i);
						prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
						prpLclaimBillManagerDto.setRegistNo(settlemainlistDto.getReportcode());
						prpLclaimBillManagerDto.setPolicyNo(settlemainlistDto.getPolicyno());
						prpLclaimBillManagerDto.setCompensateNo(settlemainlistDto.getCompensateno());
						prpLclaimBillManagerDto.setSerialNo(i+1);
						prpLclaimBillManagerDto.setPayName(planting31settlelistDto.getFname());
						prpLclaimBillManagerDto.setIdentifyNumber(planting31settlelistDto.getFidcard());
						prpLclaimBillManagerDto.setInsuredCode(planting31settlelistDto.getFcode());
						prpLclaimBillManagerDto.setOpenBank(planting31settlelistDto.getBank());
						prpLclaimBillManagerDto.setBankAccount(planting31settlelistDto.getZhibuka());
						prpLclaimBillManagerDto.setSumPaid(planting31settlelistDto.getSettlesum());
						prpLclaimBillManagerDto.setPayAmount(planting31settlelistDto.getSettlesum());
						if(planting31settlelistDto.getSettlesum()==0){
							prpLclaimBillManagerDto.setPayFlag("1");
						}else{
							prpLclaimBillManagerDto.setPayFlag("0");
						}
						prpLclaimBillManagerDto.setFlag("0000000000") ; 
						prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
					}
				}
				if(prpLclaimBillManagerList != null && prpLclaimBillManagerList.size() > 0 ){
				}else{
					//String strClaimRelationNo = prpLcompensateDto.getClaimRelationNo() ; 
					//if("".equals(strClaimRelationNo)){
					String policyNo = prpLcompensateDto.getPolicyNo() ; 
					BLPrpCinsuredFacade blPrpCinsuredFacade = new BLPrpCinsuredFacade() ; 
					ArrayList cinsuredList = (ArrayList) blPrpCinsuredFacade.findByConditions( " policyno = '"+policyNo+"' and insuredflag = '2'");
					if(cinsuredList != null && cinsuredList.size()> 0){
						PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) cinsuredList.get(0) ; 
						PrpLclaimBillManagerDto prpLclaimBillManagerDto = new PrpLclaimBillManagerDto();
						prpLclaimBillManagerDto.setRegistNo(prpLclaimDto.getRegistNo());
						prpLclaimBillManagerDto.setPolicyNo(policyNo);
						prpLclaimBillManagerDto.setCompensateNo(compensateNo);
						prpLclaimBillManagerDto.setSerialNo(1);
						prpLclaimBillManagerDto.setPayName(prpCinsuredDto.getInsuredName());
						prpLclaimBillManagerDto.setIdentifyNumber(prpCinsuredDto.getIdentifyNumber());
						prpLclaimBillManagerDto.setInsuredCode(prpCinsuredDto.getInsuredCode());
						prpLclaimBillManagerDto.setOpenBank("");
						prpLclaimBillManagerDto.setBankAccount("");
						prpLclaimBillManagerDto.setSumPaid(prpLcompensateDto.getSumDutyPaid());
						prpLclaimBillManagerDto.setPayAmount(prpLcompensateDto.getSumDutyPaid());
						if(prpLcompensateDto.getSumPaid()==0){
							prpLclaimBillManagerDto.setPayFlag("1");
						}else{
							prpLclaimBillManagerDto.setPayFlag("0");
						}
						prpLclaimBillManagerDto.setFlag("0000000000") ; 
						prpLclaimBillManagerList.add(prpLclaimBillManagerDto);
					}
					//}
				}
			}
			if(prpLclaimBillManagerList.size()>0){
				this.deleteByConditions(dbManager, " compensateno = '"+compensateNo+"' and substr(flag,0,1) = '0' ");
				this.insertAll(dbManager, prpLclaimBillManagerList);
			}
		}
    }

	public void insertAll(DBManager dbManager,
			ArrayList prpLclaimBillManagerList) throws Exception {
		DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        //插入记录
        dbPrpLclaimBillManager.insertAll(prpLclaimBillManagerList);
		
	}
	
	public Collection findByPaynameIndetSum(DBManager dbManager, String conditions,String fiscalno) throws Exception{
		DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
        Collection collection = new ArrayList();
        collection = dbPrpLclaimBillManager.findByPaynameIndetSum(conditions,fiscalno);
        return collection;
	}
    public int getMaxSerialNo(DBManager dbManager,String conditions) 
	    throws Exception{
	    DBPrpLclaimBillManager dbPrpLclaimBillManager = new DBPrpLclaimBillManager(dbManager);
	
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	
	    int count = dbPrpLclaimBillManager.getMaxSerialNo(conditions);
	    return count;
	}
}
