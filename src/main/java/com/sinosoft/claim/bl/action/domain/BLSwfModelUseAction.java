package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelUse;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WfModelUseģ��ʹ�����õ�ҵ�������չ��<br>
 * ������ 2004-08-10 10:49:28.712<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfModelUseAction extends BLSwfModelUseActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelUseAction.class);

    /**
     * ���캯��
     */
    public BLSwfModelUseAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param wfModelUseDto wfModelUseDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfModelUseDto swfModelUseDto,String mode) throws Exception{
    }

    /**
     * �����������
     * @param dbManager DB������
     * @param wfModelUseDto wfModelUseDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection modelUseList) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //�����¼
        dbSwfModelUse.insertAll(modelUseList);
    }

    public void deleteAll(DBManager dbManager,Collection modelUseList) throws Exception
    {
      DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //ɾ����¼
        dbSwfModelUse.deleteAllBatch(modelUseList);

    }

}
