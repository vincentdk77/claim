package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaUser-��ϯԱ��Ϣ���ҵ�����Facade��<br>
 * ������ 2005-06-22 14:56:52.395<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserFacade extends BLEdaUserFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaUserFacade.class);

    
    /**
     * ����������һ������
     * @param userCode  Ա������
     * @return PrpDuserDto PrpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findPrpDUserByPrimaryKey(String userCode) throws Exception{
        DBManager dbManager = new DBManager();
     
        BLPrpDuserAction bLPrpDuserAction = new BLPrpDuserAction();
        
        //����DTO
        PrpDuserDto prpDuserDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpDuserDto = bLPrpDuserAction.findByPrimaryKey(dbManager,userCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDuserDto;
    }
    /**
     * ���캯��
     */
    public BLEdaUserFacade(){
        super();
    }
}
