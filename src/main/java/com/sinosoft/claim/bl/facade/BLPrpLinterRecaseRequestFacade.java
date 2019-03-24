package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterAccdentPersonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCertifyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterClaimAppAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeFeeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeInvMainAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompePayFeeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterInjuryPersonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterSchedExtAction;
import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是大病医疗接口重开赔案参数中间表的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterRecaseRequestFacade extends BLPrpLinterRecaseRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLinterRecaseRequestFacade(){
        super();
    }
    
    /**
     * 插入数据,连同prpLinterRecaseRequestDto对象的子对象数组一起插入
     * @param prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void insertAll(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        BLPrpLinterAccdentPersonAction bLPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        BLPrpLinterCertifyAction bLPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
        BLPrpLinterCompeFeeAction bLPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        BLPrpLinterCompeInvMainAction bLPrpLinterCompeInvMainAction = new BLPrpLinterCompeInvMainAction();
        BLPrpLinterCompePayFeeAction bLPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        BLPrpLinterClaimAppAction blPrpLinterClaimAppAction = new BLPrpLinterClaimAppAction();
        BLPrpLinterSchedExtAction bLPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
        BLPrpLinterInjuryPersonAction bLPrpLinterInjuryPersonAction = new BLPrpLinterInjuryPersonAction();

        PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto = prpLinterRecaseRequestDto.getPrpLinterAccdentPersonDto();
        PrpLinterCertifyDto[] prpLinterCertifyDto = prpLinterRecaseRequestDto.getPrpLinterCertifyDto();
        PrpLinterCompeFeeDto[] prpLinterCompeFeeDto = prpLinterRecaseRequestDto.getPrpLinterCompeFeeDto();
        PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto = prpLinterRecaseRequestDto.getPrpLinterCompeInvMainDto();
        PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto = prpLinterRecaseRequestDto.getPrpLinterCompePayFeeDto();
        PrpLinterClaimAppDto[] prpLinterClaimAppDto = prpLinterRecaseRequestDto.getPrpLinterClaimAppDto();
        PrpLinterSchedExtDto[] prpLinterSchedExtDto = prpLinterRecaseRequestDto.getPrpLinterSchedExtDto();
        PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = prpLinterRecaseRequestDto.getPrpLinterInjuryPersonDto();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterRecaseRequestAction.insert(dbManager,prpLinterRecaseRequestDto);
            if(prpLinterAccdentPersonDto != null){
            	bLPrpLinterAccdentPersonAction.insert(dbManager, prpLinterAccdentPersonDto);
            }
            if(prpLinterCertifyDto != null){
            	bLPrpLinterCertifyAction.insert(dbManager, prpLinterCertifyDto);
            }
            if(prpLinterCompeFeeDto != null){
            	bLPrpLinterCompeFeeAction.insert(dbManager, prpLinterCompeFeeDto);
            }
            if(prpLinterCompeInvMainDto != null){
            	bLPrpLinterCompeInvMainAction.insert(dbManager, prpLinterCompeInvMainDto);
            }
            if(prpLinterCompePayFeeDto != null){
            	bLPrpLinterCompePayFeeAction.insert(dbManager, prpLinterCompePayFeeDto);
            }
            if(prpLinterClaimAppDto != null){
            	blPrpLinterClaimAppAction.insert(dbManager, prpLinterClaimAppDto);
            }
            if(prpLinterSchedExtDto != null){
            	bLPrpLinterSchedExtAction.insert(dbManager, prpLinterSchedExtDto);
            }
            if(prpLinterInjuryPersonDto!=null){
            	bLPrpLinterInjuryPersonAction.insert(dbManager, prpLinterInjuryPersonDto);
            }
            dbManager.commitTransaction();;
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 按条件查询多条数据，关联子表
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterRecaseRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditionsWithChild(String conditions)
		    throws Exception{
		DBManager dbManager = new DBManager();
		Collection collection = new ArrayList();
		BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
		try{
		    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		    collection = blPrpLinterRecaseRequestAction.findByConditions(dbManager,conditions);
		    if(collection.size() >0){
		    	BLPrpLinterRecaseDetailAction blPrpLinterRecaseDetailAction = new BLPrpLinterRecaseDetailAction();
		        BLPrpLinterAccdentPersonAction bLPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
		        BLPrpLinterCertifyAction bLPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
		        BLPrpLinterCompeFeeAction bLPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
		        BLPrpLinterCompeInvMainAction bLPrpLinterCompeInvMainAction = new BLPrpLinterCompeInvMainAction();
		        BLPrpLinterCompePayFeeAction bLPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
		        BLPrpLinterClaimAppAction blPrpLinterClaimAppAction = new BLPrpLinterClaimAppAction();
		        BLPrpLinterSchedExtAction bLPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
				BLPrpLinterInjuryPersonAction blPrplinterInjuryPersonAction = new BLPrpLinterInjuryPersonAction();
		        for (Iterator iter = collection.iterator(); iter.hasNext();) {
		        	PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = ((PrpLinterRecaseRequestDto) iter.next());
		        	String queryConditions = " ID='" + prpLinterRecaseRequestDto.getId() + "' ";
		        	/***********子对象赋值开始**************/
		        	ArrayList<PrpLinterAccdentPersonDto> listAccdentPerson = 
		        		(ArrayList<PrpLinterAccdentPersonDto>)bLPrpLinterAccdentPersonAction.findByConditions(dbManager,queryConditions);
		        	if(listAccdentPerson!=null && listAccdentPerson.size()>0){
		        		PrpLinterAccdentPersonDto prpLinterAccdentPersonDtos[] = new PrpLinterAccdentPersonDto[listAccdentPerson.size()];
		            	//遍历赋值
		        		for(int i=0;i<listAccdentPerson.size();i++){
		        			if(listAccdentPerson.get(i) != null){
		        				prpLinterAccdentPersonDtos[i] = listAccdentPerson.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterAccdentPersonDto(prpLinterAccdentPersonDtos);
		        	}
		        	
		        	ArrayList<PrpLinterSchedExtDto> listSchedExt = 
		        		(ArrayList<PrpLinterSchedExtDto>)bLPrpLinterSchedExtAction.findByConditions(dbManager,queryConditions);
		        	if(listSchedExt!=null && listSchedExt.size()>0){
		        		PrpLinterSchedExtDto prpLinterSchedExtDtos[] = new PrpLinterSchedExtDto[listSchedExt.size()];
		            	//遍历赋值
		        		for(int i=0;i<listSchedExt.size();i++){
		        			if(listSchedExt.get(i) != null){
		        				prpLinterSchedExtDtos[i] = listSchedExt.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterSchedExtDto(prpLinterSchedExtDtos);
		        	}
		        	
		        	ArrayList<PrpLinterClaimAppDto> listClaimApp = 
		        		(ArrayList<PrpLinterClaimAppDto>)blPrpLinterClaimAppAction.findByConditions(dbManager,queryConditions);
		        	if(listClaimApp!=null && listClaimApp.size()>0){
		        		PrpLinterClaimAppDto prpLinterClaimAppDtos[] = new PrpLinterClaimAppDto[listClaimApp.size()];
		            	//遍历赋值
		        		for(int i=0;i<listClaimApp.size();i++){
		        			if(listClaimApp.get(i) != null){
		        				prpLinterClaimAppDtos[i] = listClaimApp.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterClaimAppDto(prpLinterClaimAppDtos);
		        	}
		        	
		        	ArrayList<PrpLinterCertifyDto> listCertify = 
		        		(ArrayList<PrpLinterCertifyDto>)bLPrpLinterCertifyAction.findByConditions(dbManager,queryConditions);
		        	if(listCertify!=null && listCertify.size()>0){
		        		PrpLinterCertifyDto prpLinterCertifyDtos[] = new PrpLinterCertifyDto[listCertify.size()];
		            	//遍历赋值
		        		for(int i=0;i<listCertify.size();i++){
		        			if(listCertify.get(i) != null){
		        				prpLinterCertifyDtos[i] = listCertify.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterCertifyDto(prpLinterCertifyDtos);
		        	}
		        	
		        	ArrayList<PrpLinterCompeFeeDto> listCompeFee = 
		        		(ArrayList<PrpLinterCompeFeeDto>)bLPrpLinterCompeFeeAction.findByConditions(dbManager,queryConditions);
		        	if(listCompeFee!=null && listCompeFee.size()>0){
		        		PrpLinterCompeFeeDto prpLinterCompeFeeDtos[] = new PrpLinterCompeFeeDto[listCompeFee.size()];
		            	//遍历赋值
		        		for(int i=0;i<listCompeFee.size();i++){
		        			if(listCompeFee.get(i) != null){
		        				prpLinterCompeFeeDtos[i] = listCompeFee.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterCompeFeeDto(prpLinterCompeFeeDtos);
		        	}
		        	
		        	ArrayList<PrpLinterCompePayFeeDto> listCompePayFee = 
		        		(ArrayList<PrpLinterCompePayFeeDto>)bLPrpLinterCompePayFeeAction.findByConditions(dbManager,queryConditions);
		        	if(listCompePayFee!=null && listCompePayFee.size()>0){
		        		PrpLinterCompePayFeeDto prpLinterCompePayFeeDtos[] = new PrpLinterCompePayFeeDto[listCompePayFee.size()];
		            	//遍历赋值
		        		for(int i=0;i<listCompePayFee.size();i++){
		        			if(listCompePayFee.get(i) != null){
		        				prpLinterCompePayFeeDtos[i] = listCompePayFee.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterCompePayFeeDto(prpLinterCompePayFeeDtos);
		        	}
		        	
		        	ArrayList<PrpLinterCompeInvMainDto> listCompeInvMain = 
		        		(ArrayList<PrpLinterCompeInvMainDto>)bLPrpLinterCompeInvMainAction.findByConditions(dbManager,queryConditions);
		        	if(listCompeInvMain!=null && listCompeInvMain.size()>0){
		        		PrpLinterCompeInvMainDto prpLinterCompeInvMainDtos[] = new PrpLinterCompeInvMainDto[listCompeInvMain.size()];
		            	//遍历赋值
		        		for(int i=0;i<listCompeInvMain.size();i++){
		        			if(listCompeInvMain.get(i) != null){
		        				prpLinterCompeInvMainDtos[i] = listCompeInvMain.get(i);
		        			}
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterCompeInvMainDto(prpLinterCompeInvMainDtos);
		        	}
		        	
		        	ArrayList<PrpLinterRecaseDetailDto> listRecaseDetail = 
		        		(ArrayList<PrpLinterRecaseDetailDto>)blPrpLinterRecaseDetailAction.findByConditions(dbManager,queryConditions);
		        	if(listRecaseDetail!=null && listRecaseDetail.size()>0){
		        		PrpLinterRecaseDetailDto PrpLinterRecaseDetailDto = new PrpLinterRecaseDetailDto();
		        		if(listRecaseDetail.get(0) != null){
		        			PrpLinterRecaseDetailDto = listRecaseDetail.get(0);
		        		}
		        		prpLinterRecaseRequestDto.setPrpLinterRecaseDetailDto(PrpLinterRecaseDetailDto);
		        	}
					//获取中间表的出险人详细信息
					ArrayList<PrpLinterInjuryPersonDto> listInjuryPerson = (ArrayList<PrpLinterInjuryPersonDto>) blPrplinterInjuryPersonAction
							.findByConditions(dbManager, queryConditions);
					if (listInjuryPerson != null && listInjuryPerson.size() > 0) {
						PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArrayDto = new PrpLinterInjuryPersonDto[listInjuryPerson
								.size()];
						for (int i = 0; i < listInjuryPerson.size(); i++) {
							prpLinterInjuryPersonArrayDto[i] = listInjuryPerson
									.get(i);
						}
						prpLinterRecaseRequestDto
								.setPrpLinterInjuryPersonArrayDto(prpLinterInjuryPersonArrayDto);
					}
					
		        	/***********子对象赋值结束**************/
		        }
		        
		    }
		}catch(Exception exception){
		    throw exception;
		}finally{
		    dbManager.close();
		}
		return collection;
}
    
}
