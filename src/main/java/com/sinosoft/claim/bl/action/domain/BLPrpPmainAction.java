package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPmainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPmain;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppmain���ı�����Ϣ���ҵ�������չ��<br>
 * ������ 2004-11-22 15:24:30.906<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPmainAction extends BLPrpPmainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPmainAction.class);

    /**
     * ���캯��
     */
    public BLPrpPmainAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpPmainDto prpPmainDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpPmainDto prpPmainDto,String mode) throws Exception{
    }

//modify by liuyanmei add 20051111 start
    public int checkStatus(DBManager dbManager,String policyNo)
    throws Exception{
    DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);

  
    int checkFlag = dbPrpPmain.checkStatus(policyNo);
    return checkFlag;
}   
//  modify by liuyanmei add 20051111 start    
 
}
