package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterPaymentInfoAction;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是传入参数主表的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterPayRequestFacade extends BLPrpLinterPayRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPayRequestFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPayRequestFacade(){
        super();
    }

    /**
     * 插入数据,连同prpLinterPayRequestDto对象的子对象数组一起插入
     * @param prpLinterPayRequestDto
     * @throws Exception
     */
    public void insertAll(PrpLinterPayRequestDto prpLinterPayRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        
        BLPrpLinterPayRequestAction blPrpLinterPayRequestAction = new BLPrpLinterPayRequestAction();
        BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        
        PrpLinterPayExtDto[] prpLinterPayExtDtos = prpLinterPayRequestDto.getPrpLinterPayExtDto();
        PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blPrpLinterPayRequestAction.insert(dbManager,prpLinterPayRequestDto);
            if(prpLinterPayExtDtos!=null && prpLinterPayExtDtos.length>0){
            	blPrpLinterPayExtAction.insert(dbManager, prpLinterPayExtDtos);
            }
            if(prpLinterPaymentInfoDtos!=null && prpLinterPaymentInfoDtos.length>0){
            	blPrpLinterPaymentInfoAction.insert(dbManager, prpLinterPaymentInfoDtos);
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
     * 按条件查询多条数据，关联子表
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterPayRequestDto的集合
     * @throws Exception
     */
    public Collection findByConditionsWithChild(String conditions)
            throws Exception{
    	DBManager dbManager = new DBManager();
        Collection collection = new ArrayList();
        BLPrpLinterPayRequestAction blPrpLinterPayRequestAction = new BLPrpLinterPayRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterPayRequestAction.findByConditions(dbManager,conditions);
            if(collection!=null && collection.size() >0){
            	BLPrpLinterPayExtAction blPrpLinterPayExtAction = new BLPrpLinterPayExtAction();
                BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
                BLPrpLinterPayDetailAction blPrpLinterPayDetailAction = new BLPrpLinterPayDetailAction();
            	
                for (Iterator iter = collection.iterator(); iter.hasNext();) {
                	PrpLinterPayRequestDto prpLinterPayRequestDto = (PrpLinterPayRequestDto) iter.next();
                	String queryConditions = " ID='" + prpLinterPayRequestDto.getId() + "' ";
                	/***********子对象赋值开始**************/
                	ArrayList<PrpLinterPayExtDto> listPayExt = 
                		(ArrayList<PrpLinterPayExtDto>)blPrpLinterPayExtAction.findByConditions(dbManager,queryConditions);
                	if(listPayExt!=null && listPayExt.size()>0){
                		PrpLinterPayExtDto prpLinterPayExtDtos[] = new PrpLinterPayExtDto[listPayExt.size()];
                    	//遍历赋值
                		for(int i=0;i<listPayExt.size();i++){
                			if(listPayExt.get(i) != null){
                				prpLinterPayExtDtos[i] = listPayExt.get(i);
                			}
                		}
                		prpLinterPayRequestDto.setPrpLinterPayExtDto(prpLinterPayExtDtos);
                	}
                	
                	ArrayList<PrpLinterPaymentInfoDto> listPaymentInfo = 
                		(ArrayList<PrpLinterPaymentInfoDto>)blPrpLinterPaymentInfoAction.findByConditions(dbManager,queryConditions);
                	if(listPaymentInfo!=null && listPaymentInfo.size()>0){
                		PrpLinterPaymentInfoDto prpLinterPaymentInfoDtos[] = new PrpLinterPaymentInfoDto[listPaymentInfo.size()];
                    	//遍历赋值
                		for(int i=0;i<listPaymentInfo.size();i++){
                			if(listPaymentInfo.get(i) != null){
                				prpLinterPaymentInfoDtos[i] = listPaymentInfo.get(i);
                			}
                		}
                		prpLinterPayRequestDto.setPrpLinterPaymentInfoDto(prpLinterPaymentInfoDtos);
                	}
                	
                	ArrayList<PrpLinterPayDetailDto> listPayDetail = 
                		(ArrayList<PrpLinterPayDetailDto>)blPrpLinterPayDetailAction.findByConditions(dbManager,queryConditions);
                	if(listPayDetail!=null && listPayDetail.size()>0){
                		PrpLinterPayDetailDto prpLinterPayDetailDto = new PrpLinterPayDetailDto();
                		if(listPayDetail.get(0) != null){
                			prpLinterPayDetailDto = listPayDetail.get(0);
                		}
                		prpLinterPayRequestDto.setPrpLinterPayDetailDto(prpLinterPayDetailDto);
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
