package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǹ��������������ҵ�������չ��<br>
 * ������ 2005-04-05 10:45:04.515<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionAction extends BLSwfNotionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionAction.class);

    /**
     * ���캯��
     */
    public BLSwfNotionAction(){
        super();
    }
    
    /**
     * ��ѯflowID�����Lineno��ֵ
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return flowID
     * @throws Exception
     */
    public int getMaxLineNo(DBManager dbManager,String flowID,int logNo)
        throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);

        int lineNo = dbSwfNotion.getMaxLineNo(flowID, logNo);
        return lineNo;
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfNotionDto swfNotionDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfNotionDto swfNotionDto,String mode) throws Exception{
    }
}
