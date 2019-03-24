package com.sinosoft.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayHisAction;
import com.sinosoft.claim.dto.domain.PrpLpayHisDto;

/**
 * ����prpLpayHis��ҵ�����tgFacade��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHistgFacade extends BLPrpLpayHistgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHistgFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLpayHistgFacade(){
        super();
    }
    
    /**
     * ����������һ������
     * @param serialNo serialNo
     * @param serialNo2 serialNo2
     * @return prpLpayHisDto prpLpayHisDto
     * @throws Exception
     */
    public Collection findByElement(String name,String registNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayHisAction blPrpLpayHisAction = new BLPrpLpayHisAction();
        //����DTO
        Collection collection = new ArrayList();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            collection = blPrpLpayHisAction.findByElement(dbManager,name, registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}
