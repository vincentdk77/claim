package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingstgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFittingstg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimFittings-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFittingstgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFittingstgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimFittingstgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimFittingstgDto prpLclaimFittingstgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFittingstgDto prpLclaimFittingstgDto) throws Exception{
        DBPrpLclaimFittingstg dbPrpLclaimFittingstg = new DBPrpLclaimFittingstg(dbManager);
        //�����¼
        dbPrpLclaimFittingstg.insert(prpLclaimFittingstgDto);
    }
   
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFittingstg dbPrpLclaimFittingstg = new DBPrpLclaimFittingstg(dbManager);
        //������ɾ����¼
        dbPrpLclaimFittingstg.deleteByConditions(conditions);
    }
}
