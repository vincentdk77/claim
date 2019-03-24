package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpersonLossFG;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpersonLoss-��Ա�⸶��Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonLossActionBaseFG{
    private static Log logger = LogFactory.getLog(BLPrpLpersonLossActionBaseFG.class);

    /**
     * ���캯��
     */
    public BLPrpLpersonLossActionBaseFG(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonLossDto prpLpersonLossDto) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //�����¼
        dbPrpLpersonLoss.insert(prpLpersonLossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //ɾ����¼
        dbPrpLpersonLoss.delete(compensateNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //������ɾ����¼
        dbPrpLpersonLoss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonLossDto prpLpersonLossDto) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //���¼�¼
        dbPrpLpersonLoss.update(prpLpersonLossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @return prpLpersonLossDto prpLpersonLossDto
     * @throws Exception
     */
    public PrpLpersonLossDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        //����DTO
        PrpLpersonLossDto prpLpersonLossDto = null;
        //��ѯ����,��ֵ��DTO
        prpLpersonLossDto = dbPrpLpersonLoss.findByPrimaryKey(compensateNo, serialNo);
        return prpLpersonLossDto;
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
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonLoss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLpersonLoss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLpersonLossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpersonLossFG dbPrpLpersonLoss = new DBPrpLpersonLossFG(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpersonLoss.findByConditions(conditions);
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
        DBPrpLpersonLoss dbPrpLpersonLoss = new DBPrpLpersonLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpersonLoss.getCount(conditions);
        return count;
    }
}
