package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFittings;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimFittings-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingsActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingsActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimFittingsActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimFittingsDto prpLclaimFittingsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFittingsDto prpLclaimFittingsDto) throws Exception{
        DBPrpLclaimFittings dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
        //�����¼
        dbPrpLclaimFittings.insert(prpLclaimFittingsDto);
    }
   
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFittings dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
        //������ɾ����¼
        dbPrpLclaimFittings.deleteByConditions(conditions);
    }
}
