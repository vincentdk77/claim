package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfLogStore��ҵ�������չ��<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLSwfLogStoreAction extends BLSwfLogStoreActionBase{
    private static Log logger = LogFactory.getLog(BLSwfLogStoreAction.class);

    /**
     * ���캯��
     */
    public BLSwfLogStoreAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfLogStoreDto swfLogStoreDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfLogStoreDto swfLogStoreDto,String mode)
            throws Exception{
    }
    
    /**
     * ��ѯflowID�����logno��ֵ
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return flowID
     * @throws Exception
     */
    public int getMaxLogNo(DBManager dbManager, String flowID) throws Exception {
        DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);
        
        int logNo = dbSwfLogStore.getMaxLogNo(flowID);
        return logNo;
    }
    
    /**
     * ��ѯflowID�����logno��ֵ
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return flowID
     * @throws Exception
     */
    public int getMaxNodeLogNo(DBManager dbManager, String flowID,String nodeType,String businessNo) throws Exception {
    	DBSwfLogStore dbSwfLogStore = new DBSwfLogStore(dbManager);

        int logNo = dbSwfLogStore.getMaxNodeLogNo(flowID,nodeType,businessNo);
        return logNo;
    }
}
