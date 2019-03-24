package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcarLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcarLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcarLoss-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcarLossActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcarLossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcarLossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcarLossDto prpLcarLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcarLossDto prpLcarLossDto) throws Exception{
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        //�����¼
        dbPrpLcarLoss.insert(prpLcarLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param lossItemCode ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        //ɾ����¼
        dbPrpLcarLoss.delete(registNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        //������ɾ����¼
        dbPrpLcarLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcarLossDto prpLcarLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcarLossDto prpLcarLossDto) throws Exception{
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        //���¼�¼
        dbPrpLcarLoss.update(prpLcarLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param lossItemCode ������
     * @return prpLcarLossDto prpLcarLossDto
     * @throws Exception
     */
    public PrpLcarLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode) throws Exception{
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        //����DTO
        PrpLcarLossDto prpLcarLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcarLossDto = dbPrpLcarLoss.findByPrimaryKey(registNo, lossItemCode);
        return prpLcarLossDto;
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
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcarLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcarLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcarLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcarLoss.findByConditions(conditions);
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
        DBPrpLcarLoss dbPrpLcarLoss = new DBPrpLcarLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcarLoss.getCount(conditions);
        return count;
    }
}
