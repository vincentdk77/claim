package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertainLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertainLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertainLoss���������ҵ���߼�������<br>
 * ������ 2004-07-15 14:09:36.135<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcertainLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertainLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcertainLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertainLossDto prpLcertainLossDto) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //�����¼
        dbPrpLcertainLoss.insert(prpLcertainLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param lossItemCode ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //ɾ����¼
        dbPrpLcertainLoss.delete(registNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //������ɾ����¼
        dbPrpLcertainLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertainLossDto prpLcertainLossDto) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //���¼�¼
        dbPrpLcertainLoss.update(prpLcertainLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param lossItemCode ������
     * @return prpLcertainLossDto prpLcertainLossDto
     * @throws Exception
     */
    public PrpLcertainLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        //����DTO
        PrpLcertainLossDto prpLcertainLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcertainLossDto = dbPrpLcertainLoss.findByPrimaryKey(registNo, lossItemCode);
        return prpLcertainLossDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertainLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertainLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcertainLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0).getResult();
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertainLoss.getCount(conditions);
        return count;
    }
}
