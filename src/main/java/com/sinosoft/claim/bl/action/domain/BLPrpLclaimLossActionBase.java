package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimLoss-�����ձ��������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimLossDto prpLclaimLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimLossDto prpLclaimLossDto) throws Exception{
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        //�����¼
        dbPrpLclaimLoss.insert(prpLclaimLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        //ɾ����¼
        dbPrpLclaimLoss.delete(claimNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        //������ɾ����¼
        dbPrpLclaimLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimLossDto prpLclaimLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimLossDto prpLclaimLossDto) throws Exception{
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        //���¼�¼
        dbPrpLclaimLoss.update(prpLclaimLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @return prpLclaimLossDto prpLclaimLossDto
     * @throws Exception
     */
    public PrpLclaimLossDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        //����DTO
        PrpLclaimLossDto prpLclaimLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimLossDto = dbPrpLclaimLoss.findByPrimaryKey(claimNo, serialNo);
        return prpLclaimLossDto;
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
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimLoss.findByConditions(conditions);
        return collection;
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
        DBPrpLclaimLoss dbPrpLclaimLoss = new DBPrpLclaimLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimLoss.getCount(conditions);
        return count;
    }
}
