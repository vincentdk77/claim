package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimStatustgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatustg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimStatus����ڵ�״̬���ҵ�������չ��<br>
 * ������ 2004-05-09 11:07:44.551<br>
 * JToolpad(1.2.9) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimStatustgAction extends BLPrpLclaimStatustgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimStatustgAction.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimStatustgAction(){
        super();
    }

    /**
     * ת��tgDto
     * @param dbManager dbManager
     * @param prpLclaimStatustgDto prpLclaimStatustgDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimStatustgDto prpLclaimStatustgDto,String mode) throws Exception{
    }


    /**
     * ������ͳ������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @throws Exception
     */
    public Collection getStatStatus(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimStatustg dbPrpLclaimStatustg = new DBPrpLclaimStatustg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        return collection = dbPrpLclaimStatustg.getStatStatus(conditions);
    }
}
