package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterAccdentPersonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCertifyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterClaimAppAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterClaimKindAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeFeeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeInvDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompeInvMainAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCompePayFeeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterInjuryPersonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPrepayFeeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterSchedExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterAutoClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplinterrelationAction;
import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是理赔接口交互中间表的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterRequestFacade extends BLPrpLinterRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRequestFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLinterRequestFacade(){
        super();
    }
    
    /**
     * 插入数据,连同prpLinterRequestDto对象的子对象数组一起插入
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void insertAll(PrpLinterRequestDto prpLinterRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRequestAction blPrpLinterRequestAction = new BLPrpLinterRequestAction();
        BLPrpLinterAccdentPersonAction bLPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        BLPrpLinterCertifyAction bLPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
        BLPrpLinterClaimAppAction bLPrpLinterClaimAppAction = new BLPrpLinterClaimAppAction();
        BLPrpLinterClaimKindAction bLPrpLinterClaimKindAction = new BLPrpLinterClaimKindAction();
        BLPrpLinterCompeFeeAction bLPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        BLPrpLinterCompeInvMainAction bLPrpLinterCompeInvMainAction = new BLPrpLinterCompeInvMainAction();
        BLPrpLinterCompePayFeeAction bLPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        BLPrpLinterPrepayFeeAction bLPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        BLPrpLinterSchedExtAction bLPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
		BLPrpLinterInjuryPersonAction blPrpLinterInjuryPersonAction = new BLPrpLinterInjuryPersonAction();

        PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto = prpLinterRequestDto.getPrpLinterAccdentPersonDto();
        PrpLinterCertifyDto[] prpLinterCertifyDto = prpLinterRequestDto.getPrpLinterCertifyDto();
        PrpLinterClaimAppDto[] prpLinterClaimAppDto = prpLinterRequestDto.getPrpLinterClaimAppDto();
        PrpLinterClaimKindDto[] prpLinterClaimKindDto = prpLinterRequestDto.getPrpLinterClaimKindDto();
        PrpLinterCompeFeeDto[] prpLinterCompeFeeDto = prpLinterRequestDto.getPrpLinterCompeFeeDto();
        PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto = prpLinterRequestDto.getPrpLinterCompeInvMainDto();
        PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto = prpLinterRequestDto.getPrpLinterCompePayFeeDto();
        PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto = prpLinterRequestDto.getPrpLinterPrepayFeeDto();
        PrpLinterSchedExtDto[] prpLinterSchedExtDto = prpLinterRequestDto.getPrpLinterSchedExtDto();
        PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = prpLinterRequestDto.getPrpLinterInjuryPersonDto();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            String id = prpLinterRequestDto.getId();
            //插入记录
            blPrpLinterRequestAction.delete(dbManager, id);
            //插入记录
            blPrpLinterRequestAction.insert(dbManager,prpLinterRequestDto);
            if(prpLinterAccdentPersonDto != null){
            	bLPrpLinterAccdentPersonAction.insert(dbManager, prpLinterAccdentPersonDto);
            }
            if(prpLinterCertifyDto != null){
            	bLPrpLinterCertifyAction.insert(dbManager, prpLinterCertifyDto);
            }
            if(prpLinterClaimAppDto != null){
            	bLPrpLinterClaimAppAction.insert(dbManager, prpLinterClaimAppDto);
            }
            if(prpLinterClaimKindDto != null){
            	bLPrpLinterClaimKindAction.insert(dbManager, prpLinterClaimKindDto);
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
            if(prpLinterPrepayFeeDto != null){
            	bLPrpLinterPrepayFeeAction.insert(dbManager, prpLinterPrepayFeeDto);
            }
            if(prpLinterSchedExtDto != null){
            	bLPrpLinterSchedExtAction.insert(dbManager, prpLinterSchedExtDto);
            }
			if (prpLinterInjuryPersonDto != null) {
				blPrpLinterInjuryPersonAction.insert(dbManager,
						prpLinterInjuryPersonDto);
			}
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * 插入数据,连同prpLinterRequestDto对象的子对象数组一起插入
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void insertRegistAll(PrpLinterRequestDto prpLinterRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRequestAction blPrpLinterRequestAction = new BLPrpLinterRequestAction();
        BLPrpLinterAccdentPersonAction bLPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto = prpLinterRequestDto.getPrpLinterAccdentPersonDto();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterRequestAction.insert(dbManager,prpLinterRequestDto);
            if(prpLinterAccdentPersonDto != null){
            	bLPrpLinterAccdentPersonAction.insert(dbManager, prpLinterAccdentPersonDto);
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
     * 插入数据,连同prpLinterRequestDto对象的子对象数组一起插入
     * @param prpLinterRequestDto prpLinterRequestDto
     * @throws Exception
     */
    public void insertCompeAll(PrpLinterRequestDto prpLinterRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRequestAction blPrpLinterRequestAction = new BLPrpLinterRequestAction();
        BLPrpLinterAccdentPersonAction bLPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
        BLPrpLinterCertifyAction bLPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
        BLPrpLinterClaimAppAction bLPrpLinterClaimAppAction = new BLPrpLinterClaimAppAction();
        BLPrpLinterClaimKindAction bLPrpLinterClaimKindAction = new BLPrpLinterClaimKindAction();
        BLPrpLinterCompeFeeAction bLPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
        BLPrpLinterCompeInvMainAction bLPrpLinterCompeInvMainAction = new BLPrpLinterCompeInvMainAction();
        BLPrpLinterCompePayFeeAction bLPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
        BLPrpLinterPrepayFeeAction bLPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
        BLPrpLinterSchedExtAction bLPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();

        PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDto = prpLinterRequestDto.getPrpLinterAccdentPersonDto();
        PrpLinterCertifyDto[] prpLinterCertifyDto = prpLinterRequestDto.getPrpLinterCertifyDto();
        PrpLinterClaimAppDto[] prpLinterClaimAppDto = prpLinterRequestDto.getPrpLinterClaimAppDto();
        PrpLinterClaimKindDto[] prpLinterClaimKindDto = prpLinterRequestDto.getPrpLinterClaimKindDto();
        PrpLinterCompeFeeDto[] prpLinterCompeFeeDto = prpLinterRequestDto.getPrpLinterCompeFeeDto();
        PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto = prpLinterRequestDto.getPrpLinterCompeInvMainDto();
        PrpLinterCompePayFeeDto[] prpLinterCompePayFeeDto = prpLinterRequestDto.getPrpLinterCompePayFeeDto();
        PrpLinterPrepayFeeDto[] prpLinterPrepayFeeDto = prpLinterRequestDto.getPrpLinterPrepayFeeDto();
        PrpLinterSchedExtDto[] prpLinterSchedExtDto = prpLinterRequestDto.getPrpLinterSchedExtDto();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            String id = prpLinterRequestDto.getId();
            //插入记录
            blPrpLinterRequestAction.delete(dbManager, id);
            blPrpLinterRequestAction.insert(dbManager,prpLinterRequestDto);
            if(prpLinterAccdentPersonDto != null){
            	bLPrpLinterAccdentPersonAction.insert(dbManager, prpLinterAccdentPersonDto);
            }
            if(prpLinterClaimAppDto != null){
            	bLPrpLinterClaimAppAction.insert(dbManager, prpLinterClaimAppDto);
            }
            if(prpLinterClaimKindDto != null){
            	bLPrpLinterClaimKindAction.insert(dbManager, prpLinterClaimKindDto);
            }
            if(prpLinterSchedExtDto != null){
            	bLPrpLinterSchedExtAction.insert(dbManager, prpLinterSchedExtDto);
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
     * @return Collection 包含prpLinterRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditionsWithChild(String conditions)
            throws Exception{
    	DBManager dbManager = new DBManager();
        Collection collection = new ArrayList();
        BLPrpLinterRequestAction blPrpLinterRequestAction = new BLPrpLinterRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterRequestAction.findByConditions(dbManager,conditions);
            if(collection.size() >0){
            	BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
            	BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
            	BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
            	BLPrpLinterCertifyAction blPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
            	BLPrpLinterClaimAppAction blPrpLinterClaimAppAction = new BLPrpLinterClaimAppAction();
            	BLPrpLinterClaimKindAction blPrpLinterClaimKindAction = new BLPrpLinterClaimKindAction();
            	BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
            	BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
            	BLPrpLinterCompeInvMainAction blPrpLinterCompeInvMainAction = new BLPrpLinterCompeInvMainAction();
            	BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
            	BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
            	BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
				BLPrpLinterInjuryPersonAction blPrplinterInjuryPersonAction = new BLPrpLinterInjuryPersonAction();
            	
                for (Iterator iter = collection.iterator(); iter.hasNext();) {
                	PrpLinterRequestDto prpLinterRequestDto = ((PrpLinterRequestDto) iter.next());
                	String queryConditions = " ID='" + prpLinterRequestDto.getId() + "' ";
                	/***********子对象赋值开始**************/
                	PrplinterrelationDto prplinterraletion = blPrplinterrelationAction.findByPrimaryKey(dbManager, 
                			prpLinterRequestDto.getId(), prpLinterRequestDto.getOutRigstNo());
                	if(null != prplinterraletion){
                		prpLinterRequestDto.setRelationRegistNo(prplinterraletion.getRelationRegistNo());
                	}                	
                	ArrayList<PrpLinterAccdentPersonDto> listAccdentPerson = 
                		(ArrayList<PrpLinterAccdentPersonDto>)blPrpLinterAccdentPersonAction.findByConditions(dbManager,queryConditions);
                	if(listAccdentPerson!=null && listAccdentPerson.size()>0){
                		PrpLinterAccdentPersonDto prpLinterAccdentPersonDtos[] = new PrpLinterAccdentPersonDto[listAccdentPerson.size()];
                    	//遍历赋值
                		for(int i=0;i<listAccdentPerson.size();i++){
                			if(listAccdentPerson.get(i) != null){
                				prpLinterAccdentPersonDtos[i] = listAccdentPerson.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterAccdentPersonDto(prpLinterAccdentPersonDtos);
                	}
                	
                	ArrayList<PrpLinterSchedExtDto> listSchedExt = 
                		(ArrayList<PrpLinterSchedExtDto>)blPrpLinterSchedExtAction.findByConditions(dbManager,queryConditions);
                	if(listSchedExt!=null && listSchedExt.size()>0){
                		PrpLinterSchedExtDto prpLinterSchedExtDtos[] = new PrpLinterSchedExtDto[listSchedExt.size()];
                    	//遍历赋值
                		for(int i=0;i<listSchedExt.size();i++){
                			if(listSchedExt.get(i) != null){
                				prpLinterSchedExtDtos[i] = listSchedExt.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterSchedExtDto(prpLinterSchedExtDtos);
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
                		prpLinterRequestDto.setPrpLinterClaimAppDto(prpLinterClaimAppDtos);
                	}
                	
                	ArrayList<PrpLinterClaimKindDto> listClaimKind = 
                		(ArrayList<PrpLinterClaimKindDto>)blPrpLinterClaimKindAction.findByConditions(dbManager,queryConditions);
                	if(listClaimKind!=null && listClaimKind.size()>0){
                		PrpLinterClaimKindDto prpLinterClaimKindDtos[] = new PrpLinterClaimKindDto[listClaimKind.size()];
                    	//遍历赋值
                		for(int i=0;i<listClaimKind.size();i++){
                			if(listClaimKind.get(i) != null){
                				prpLinterClaimKindDtos[i] = listClaimKind.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterClaimKindDto(prpLinterClaimKindDtos);
                	}
                	
                	ArrayList<PrpLinterPrepayFeeDto> listPrepayFee = 
                		(ArrayList<PrpLinterPrepayFeeDto>)blPrpLinterPrepayFeeAction.findByConditions(dbManager,queryConditions);
                	if(listPrepayFee!=null && listPrepayFee.size()>0){
                		PrpLinterPrepayFeeDto prpLinterPrepayFeeDtos[] = new PrpLinterPrepayFeeDto[listPrepayFee.size()];
                    	//遍历赋值
                		for(int i=0;i<listPrepayFee.size();i++){
                			if(listPrepayFee.get(i) != null){
                				prpLinterPrepayFeeDtos[i] = listPrepayFee.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterPrepayFeeDto(prpLinterPrepayFeeDtos);
                	}
                	
                	ArrayList<PrpLinterCertifyDto> listCertify = 
                		(ArrayList<PrpLinterCertifyDto>)blPrpLinterCertifyAction.findByConditions(dbManager,queryConditions);
                	if(listCertify!=null && listCertify.size()>0){
                		PrpLinterCertifyDto prpLinterCertifyDtos[] = new PrpLinterCertifyDto[listCertify.size()];
                    	//遍历赋值
                		for(int i=0;i<listCertify.size();i++){
                			if(listCertify.get(i) != null){
                				prpLinterCertifyDtos[i] = listCertify.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCertifyDto(prpLinterCertifyDtos);
                	}
                	
                	ArrayList<PrpLinterCompeFeeDto> listCompeFee = 
                		(ArrayList<PrpLinterCompeFeeDto>)blPrpLinterCompeFeeAction.findByConditions(dbManager,queryConditions);
                	if(listCompeFee!=null && listCompeFee.size()>0){
                		PrpLinterCompeFeeDto prpLinterCompeFeeDtos[] = new PrpLinterCompeFeeDto[listCompeFee.size()];
                    	//遍历赋值
                		for(int i=0;i<listCompeFee.size();i++){
                			if(listCompeFee.get(i) != null){
                				prpLinterCompeFeeDtos[i] = listCompeFee.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCompeFeeDto(prpLinterCompeFeeDtos);
                	}
                	
                	ArrayList<PrpLinterCompePayFeeDto> listCompePayFee = 
                		(ArrayList<PrpLinterCompePayFeeDto>)blPrpLinterCompePayFeeAction.findByConditions(dbManager,queryConditions);
                	if(listCompePayFee!=null && listCompePayFee.size()>0){
                		PrpLinterCompePayFeeDto prpLinterCompePayFeeDtos[] = new PrpLinterCompePayFeeDto[listCompePayFee.size()];
                    	//遍历赋值
                		for(int i=0;i<listCompePayFee.size();i++){
                			if(listCompePayFee.get(i) != null){
                				prpLinterCompePayFeeDtos[i] = listCompePayFee.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCompePayFeeDto(prpLinterCompePayFeeDtos);
                	}
                	
                	ArrayList<PrpLinterCompeInvMainDto> listCompeInvMain = 
                		(ArrayList<PrpLinterCompeInvMainDto>)blPrpLinterCompeInvMainAction.findByConditions(dbManager,queryConditions);
                	if(listCompeInvMain!=null && listCompeInvMain.size()>0){
                		PrpLinterCompeInvMainDto prpLinterCompeInvMainDtos[] = new PrpLinterCompeInvMainDto[listCompeInvMain.size()];
                    	//遍历赋值
                		for(int i=0;i<listCompeInvMain.size();i++){
                			if(listCompeInvMain.get(i) != null){
                				prpLinterCompeInvMainDtos[i] = listCompeInvMain.get(i);
                				ArrayList<PrpLinterCompeInvDetailDto> listCompeInvDetail = 
                            		(ArrayList<PrpLinterCompeInvDetailDto>)blPrpLinterCompeInvDetailAction.findByConditions(dbManager,queryConditions);
                				if(listCompeInvDetail!=null && listCompeInvDetail.size()>0){
                					PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDtos = new PrpLinterCompeInvDetailDto[listCompeInvDetail.size()];
                    				for(int j=0;j<listCompeInvDetail.size();j++){
                    					prpLinterCompeInvDetailDtos[j] = listCompeInvDetail.get(j);
                    				}
                    				prpLinterCompeInvMainDtos[i].setPrpLinterCompeInvDetailDto(prpLinterCompeInvDetailDtos);
                				}
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCompeInvMainDto(prpLinterCompeInvMainDtos);
                	}
                	
                	ArrayList<PrplinterAutoClaimDetailDto> listClaimDetail = 
                		(ArrayList<PrplinterAutoClaimDetailDto>)blPrplinterAutoClaimDetailAction.findByConditions(dbManager,queryConditions);
                	if(listClaimDetail!=null && listClaimDetail.size()>0){
                		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDtos = new PrplinterAutoClaimDetailDto();
                		if(listClaimDetail.get(0) != null){
                			prplinterAutoClaimDetailDtos = listClaimDetail.get(0);
                		}
                		prpLinterRequestDto.setPrplinterAutoClaimDetailDto(prplinterAutoClaimDetailDtos);
                	}
					//获取中间表出险人详细信息
					ArrayList<PrpLinterInjuryPersonDto> listInjuryPerson = (ArrayList<PrpLinterInjuryPersonDto>) blPrplinterInjuryPersonAction
							.findByConditions(dbManager, queryConditions);
					if(listInjuryPerson!=null&&listInjuryPerson.size()>0){
						PrpLinterInjuryPersonDto[] prpLinterInjuryPersonArrayDto = new PrpLinterInjuryPersonDto[listInjuryPerson.size()];
						for(int i=0;i<listInjuryPerson.size();i++){
							prpLinterInjuryPersonArrayDto[i]=listInjuryPerson.get(i);
						}
						prpLinterRequestDto.setPrpLinterInjuryPersonArrayDto(prpLinterInjuryPersonArrayDto);
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
    
    
    /**
     * 按条件查询多条数据，关联子表
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditionsWithRegistChild(String conditions)
            throws Exception{
    	DBManager dbManager = new DBManager();
        Collection collection = new ArrayList();
        BLPrpLinterRequestAction blPrpLinterRequestAction = new BLPrpLinterRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterRequestAction.findByConditions(dbManager,conditions);
            if(collection.size() >0){
            	BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
            	BLPrpLinterSchedExtAction blPrpLinterSchedExtAction = new BLPrpLinterSchedExtAction();
            	BLPrplinterAutoClaimDetailAction blPrplinterAutoClaimDetailAction = new BLPrplinterAutoClaimDetailAction();
            	BLPrpLinterCertifyAction blPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
            	BLPrpLinterClaimAppAction blPrpLinterClaimAppAction = new BLPrpLinterClaimAppAction();
            	BLPrpLinterClaimKindAction blPrpLinterClaimKindAction = new BLPrpLinterClaimKindAction();
            	BLPrpLinterCompeFeeAction blPrpLinterCompeFeeAction = new BLPrpLinterCompeFeeAction();
            	BLPrpLinterCompeInvDetailAction blPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();
            	BLPrpLinterCompeInvMainAction blPrpLinterCompeInvMainAction = new BLPrpLinterCompeInvMainAction();
            	BLPrpLinterCompePayFeeAction blPrpLinterCompePayFeeAction = new BLPrpLinterCompePayFeeAction();
            	BLPrpLinterPrepayFeeAction blPrpLinterPrepayFeeAction = new BLPrpLinterPrepayFeeAction();
            	BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
            	
                for (Iterator iter = collection.iterator(); iter.hasNext();) {
                	PrpLinterRequestDto prpLinterRequestDto = ((PrpLinterRequestDto) iter.next());
                	String queryConditions = " ID='" + prpLinterRequestDto.getId() + "' ";
                	/***********子对象赋值开始**************/
                	PrplinterrelationDto prplinterraletion = blPrplinterrelationAction.findByPrimaryKey(dbManager, 
                			prpLinterRequestDto.getId(), prpLinterRequestDto.getOutId());
                	if(null != prplinterraletion){
                		prpLinterRequestDto.setRelationRegistNo(prplinterraletion.getRelationRegistNo());
                	}                	
                	ArrayList<PrpLinterAccdentPersonDto> listAccdentPerson = 
                		(ArrayList<PrpLinterAccdentPersonDto>)blPrpLinterAccdentPersonAction.findByConditions(dbManager,queryConditions);
                	if(listAccdentPerson!=null && listAccdentPerson.size()>0){
                		PrpLinterAccdentPersonDto prpLinterAccdentPersonDtos[] = new PrpLinterAccdentPersonDto[listAccdentPerson.size()];
                    	//遍历赋值
                		for(int i=0;i<listAccdentPerson.size();i++){
                			if(listAccdentPerson.get(i) != null){
                				prpLinterAccdentPersonDtos[i] = listAccdentPerson.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterAccdentPersonDto(prpLinterAccdentPersonDtos);
                	}
                	
                	ArrayList<PrpLinterSchedExtDto> listSchedExt = 
                		(ArrayList<PrpLinterSchedExtDto>)blPrpLinterSchedExtAction.findByConditions(dbManager,queryConditions);
                	if(listSchedExt!=null && listSchedExt.size()>0){
                		PrpLinterSchedExtDto prpLinterSchedExtDtos[] = new PrpLinterSchedExtDto[listSchedExt.size()];
                    	//遍历赋值
                		for(int i=0;i<listSchedExt.size();i++){
                			if(listSchedExt.get(i) != null){
                				prpLinterSchedExtDtos[i] = listSchedExt.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterSchedExtDto(prpLinterSchedExtDtos);
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
                		prpLinterRequestDto.setPrpLinterClaimAppDto(prpLinterClaimAppDtos);
                	}
                	
                	ArrayList<PrpLinterClaimKindDto> listClaimKind = 
                		(ArrayList<PrpLinterClaimKindDto>)blPrpLinterClaimKindAction.findByConditions(dbManager,queryConditions);
                	if(listClaimKind!=null && listClaimKind.size()>0){
                		PrpLinterClaimKindDto prpLinterClaimKindDtos[] = new PrpLinterClaimKindDto[listClaimKind.size()];
                    	//遍历赋值
                		for(int i=0;i<listClaimKind.size();i++){
                			if(listClaimKind.get(i) != null){
                				prpLinterClaimKindDtos[i] = listClaimKind.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterClaimKindDto(prpLinterClaimKindDtos);
                	}
                	
                	ArrayList<PrpLinterPrepayFeeDto> listPrepayFee = 
                		(ArrayList<PrpLinterPrepayFeeDto>)blPrpLinterPrepayFeeAction.findByConditions(dbManager,queryConditions);
                	if(listPrepayFee!=null && listPrepayFee.size()>0){
                		PrpLinterPrepayFeeDto prpLinterPrepayFeeDtos[] = new PrpLinterPrepayFeeDto[listPrepayFee.size()];
                    	//遍历赋值
                		for(int i=0;i<listPrepayFee.size();i++){
                			if(listPrepayFee.get(i) != null){
                				prpLinterPrepayFeeDtos[i] = listPrepayFee.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterPrepayFeeDto(prpLinterPrepayFeeDtos);
                	}
                	
                	ArrayList<PrpLinterCertifyDto> listCertify = 
                		(ArrayList<PrpLinterCertifyDto>)blPrpLinterCertifyAction.findByConditions(dbManager,queryConditions);
                	if(listCertify!=null && listCertify.size()>0){
                		PrpLinterCertifyDto prpLinterCertifyDtos[] = new PrpLinterCertifyDto[listCertify.size()];
                    	//遍历赋值
                		for(int i=0;i<listCertify.size();i++){
                			if(listCertify.get(i) != null){
                				prpLinterCertifyDtos[i] = listCertify.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCertifyDto(prpLinterCertifyDtos);
                	}
                	
                	ArrayList<PrpLinterCompeFeeDto> listCompeFee = 
                		(ArrayList<PrpLinterCompeFeeDto>)blPrpLinterCompeFeeAction.findByConditions(dbManager,queryConditions);
                	if(listCompeFee!=null && listCompeFee.size()>0){
                		PrpLinterCompeFeeDto prpLinterCompeFeeDtos[] = new PrpLinterCompeFeeDto[listCompeFee.size()];
                    	//遍历赋值
                		for(int i=0;i<listCompeFee.size();i++){
                			if(listCompeFee.get(i) != null){
                				prpLinterCompeFeeDtos[i] = listCompeFee.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCompeFeeDto(prpLinterCompeFeeDtos);
                	}
                	
                	ArrayList<PrpLinterCompePayFeeDto> listCompePayFee = 
                		(ArrayList<PrpLinterCompePayFeeDto>)blPrpLinterCompePayFeeAction.findByConditions(dbManager,queryConditions);
                	if(listCompePayFee!=null && listCompePayFee.size()>0){
                		PrpLinterCompePayFeeDto prpLinterCompePayFeeDtos[] = new PrpLinterCompePayFeeDto[listCompePayFee.size()];
                    	//遍历赋值
                		for(int i=0;i<listCompePayFee.size();i++){
                			if(listCompePayFee.get(i) != null){
                				prpLinterCompePayFeeDtos[i] = listCompePayFee.get(i);
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCompePayFeeDto(prpLinterCompePayFeeDtos);
                	}
                	
                	ArrayList<PrpLinterCompeInvMainDto> listCompeInvMain = 
                		(ArrayList<PrpLinterCompeInvMainDto>)blPrpLinterCompeInvMainAction.findByConditions(dbManager,queryConditions);
                	if(listCompeInvMain!=null && listCompeInvMain.size()>0){
                		PrpLinterCompeInvMainDto prpLinterCompeInvMainDtos[] = new PrpLinterCompeInvMainDto[listCompeInvMain.size()];
                    	//遍历赋值
                		for(int i=0;i<listCompeInvMain.size();i++){
                			if(listCompeInvMain.get(i) != null){
                				prpLinterCompeInvMainDtos[i] = listCompeInvMain.get(i);
                				ArrayList<PrpLinterCompeInvDetailDto> listCompeInvDetail = 
                            		(ArrayList<PrpLinterCompeInvDetailDto>)blPrpLinterCompeInvDetailAction.findByConditions(dbManager,queryConditions);
                				if(listCompeInvDetail!=null && listCompeInvDetail.size()>0){
                					PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDtos = new PrpLinterCompeInvDetailDto[listCompeInvDetail.size()];
                    				for(int j=0;j<listCompeInvDetail.size();j++){
                    					prpLinterCompeInvDetailDtos[j] = listCompeInvDetail.get(j);
                    				}
                    				prpLinterCompeInvMainDtos[i].setPrpLinterCompeInvDetailDto(prpLinterCompeInvDetailDtos);
                				}
                			}
                		}
                		prpLinterRequestDto.setPrpLinterCompeInvMainDto(prpLinterCompeInvMainDtos);
                	}
                	
                	ArrayList<PrplinterAutoClaimDetailDto> listClaimDetail = 
                		(ArrayList<PrplinterAutoClaimDetailDto>)blPrplinterAutoClaimDetailAction.findByConditions(dbManager,queryConditions);
                	if(listClaimDetail!=null && listClaimDetail.size()>0){
                		PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDtos = new PrplinterAutoClaimDetailDto();
                		if(listClaimDetail.get(0) != null){
                			prplinterAutoClaimDetailDtos = listClaimDetail.get(0);
                		}
                		prpLinterRequestDto.setPrplinterAutoClaimDetailDto(prplinterAutoClaimDetailDtos);
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
