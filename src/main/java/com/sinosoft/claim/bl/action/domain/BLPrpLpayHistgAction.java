package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLpayHisDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpayHistg;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpLpayHis��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpayHistgAction extends BLPrpLpayHistgActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayHistgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLpayHistgAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLpayHisDto prpLpayHisDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLpayHisDto prpLpayHisDto,String mode)
            throws Exception{
    }

	public Collection findByElement(DBManager dbManager, String name,
			String registNo) throws Exception{
		DBPrpLpayHistg dbPrpLpayHis = new DBPrpLpayHistg(dbManager);
		
		 Collection collection = new ArrayList();
		 String conditions = "";
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        //�����¼
	    collection =  dbPrpLpayHis.findByElement(name,registNo);
	    return collection ;
	}
}
