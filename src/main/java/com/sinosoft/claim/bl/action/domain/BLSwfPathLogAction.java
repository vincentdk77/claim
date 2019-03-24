package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����WFPATHLOG������·����־���ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:55.016<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPathLogAction extends BLSwfPathLogActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogAction.class);

    /**
     * ���캯��
     */
    public BLSwfPathLogAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfPathLogDto swfPathLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPathLogDto swfPathLogDto,String mode) throws Exception{
    }
    
     /**
     * ��ѯflowID�����logno��ֵ
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return flowID
     * @throws Exception
     */
    public int getMaxPathNo(DBManager dbManager,String flowID) 
        throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);

        int PathNo = dbSwfPathLog.getMaxPathNo(flowID);
        return PathNo;
    }
}
