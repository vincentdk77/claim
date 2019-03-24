package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterAccdentPersonAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimRequestAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterCertifyAction;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��������ע��������������ҵ�����Facade��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCancelClaimRequestFacade extends BLPrpLinterCancelClaimRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimRequestFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimRequestFacade(){
        super();
    }
    
    /**
     * ��������,��ͬprpLinterCancelClaimRequestDto������Ӷ�������һ�����
     * @param prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void insertAll(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto) 
    	throws Exception{
    	DBManager dbManager = new DBManager();
    	
    	BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
    	BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
    	BLPrpLinterCertifyAction blPrpLinterCertifyAction = new BLPrpLinterCertifyAction();
    	
    	PrpLinterAccdentPersonDto[] prpLinterAccdentPersonDtos = prpLinterCancelClaimRequestDto.getPrpLinterAccdentPersonDto();
    	PrpLinterCertifyDto[] prpLinterCertifyDtos = prpLinterCancelClaimRequestDto.getPrpLinterCertifyDto();
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterCancelClaimRequestAction.insert(dbManager, prpLinterCancelClaimRequestDto);
            if(prpLinterAccdentPersonDtos != null && prpLinterAccdentPersonDtos.length>0){
            	blPrpLinterAccdentPersonAction.insert(dbManager, prpLinterAccdentPersonDtos);
            }
            if(prpLinterCertifyDtos != null && prpLinterCertifyDtos.length>0){
            	blPrpLinterCertifyAction.insert(dbManager, prpLinterCertifyDtos); 
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
     * ��������ѯ�������ݣ������ӱ�
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLinterCancelClaimRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditionsWithChild(String conditions)
            throws Exception{
    	DBManager dbManager = new DBManager();
        Collection collection = new ArrayList();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCancelClaimRequestAction.findByConditions(dbManager,conditions);
            if(collection.size() >0){
            	BLPrpLinterAccdentPersonAction blPrpLinterAccdentPersonAction = new BLPrpLinterAccdentPersonAction();
            	BLPrpLinterCancelClaimDetailAction blPrpLinterCancelClaimDetailAction = new BLPrpLinterCancelClaimDetailAction();
            	
                for (Iterator iter = collection.iterator(); iter.hasNext();) {
                	PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = (PrpLinterCancelClaimRequestDto) iter.next();
                	String queryConditions = " ID='" + prpLinterCancelClaimRequestDto.getId() + "' ";
                	/***********�Ӷ���ֵ��ʼ**************/
                	ArrayList<PrpLinterAccdentPersonDto> listAccident = 
                		(ArrayList<PrpLinterAccdentPersonDto>)blPrpLinterAccdentPersonAction.findByConditions(dbManager,queryConditions);
                	if(listAccident!=null && listAccident.size()>0){
                		PrpLinterAccdentPersonDto prpLinterAccdentPersonDtos[] = new PrpLinterAccdentPersonDto[listAccident.size()];
                    	//������ֵ
                		for(int i=0;i<listAccident.size();i++){
                			if(listAccident.get(i) != null){
                				prpLinterAccdentPersonDtos[i] = listAccident.get(i);
                			}
                		}
                		prpLinterCancelClaimRequestDto.setPrpLinterAccdentPersonDto(prpLinterAccdentPersonDtos);
                	}
                	
                	ArrayList<PrpLinterCancelClaimDetailDto> listPayDetail = 
                		(ArrayList<PrpLinterCancelClaimDetailDto>)blPrpLinterCancelClaimDetailAction.findByConditions(dbManager,queryConditions);
                	if(listPayDetail!=null && listPayDetail.size()>0){
                		PrpLinterCancelClaimDetailDto prpLinterCancelClaimDetailDto = new PrpLinterCancelClaimDetailDto();
                		if(listPayDetail.get(0) != null){
                			prpLinterCancelClaimDetailDto = listPayDetail.get(0);
                		}
                		prpLinterCancelClaimRequestDto.setPrpLinterCancelClaimDetailDto(prpLinterCancelClaimDetailDto);
                	}
    				
                	/***********�Ӷ���ֵ����**************/
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
