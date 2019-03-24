package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.claim.dto.domain.PrpLnodutyLossDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLnodutyLoss;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLNODUTYLOSS��ҵ���߼�������<br>
 */
public class BLPrplnodutylossActionBase{
    private static Logger logger = Logger.getLogger(BLPrplnodutylossActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplnodutylossActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplnodutylossDto prplnodutylossDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLnodutyLossDto prplnodutylossDto)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //�����¼
        dbPrplnodutyloss.insert(prplnodutylossDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateno COMPENSATENO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateno,int serialno)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //ɾ����¼
        dbPrplnodutyloss.delete(compensateno, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //������ɾ����¼
        dbPrplnodutyloss.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplnodutylossDto prplnodutylossDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLnodutyLossDto prplnodutylossDto)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //���¼�¼
        dbPrplnodutyloss.update(prplnodutylossDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateno COMPENSATENO
     * @param serialno SERIALNO
     * @return prplnodutylossDto prplnodutylossDto
     * @throws Exception
     */
    public PrpLnodutyLossDto findByPrimaryKey(DBManager dbManager,String compensateno,int serialno)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        //����DTO
    	PrpLnodutyLossDto prplnodutylossDto = null;
        //��ѯ����,��ֵ��DTO
        prplnodutylossDto = dbPrplnodutyloss.findByPrimaryKey(compensateno, serialno);
        return prplnodutylossDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplnodutyloss.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplnodutyloss.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplnodutylossDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplnodutyloss.findByConditions(conditions);
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
    	DBPrpLnodutyLoss dbPrplnodutyloss = new DBPrpLnodutyLoss(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplnodutyloss.getCount(conditions);
        return count;
    }
}
