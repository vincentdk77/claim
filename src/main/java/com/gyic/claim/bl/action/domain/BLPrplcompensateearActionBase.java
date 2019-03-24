package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Prplcompensateear��ҵ���߼�������<br>
 */
public class BLPrplcompensateearActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplcompensateearActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcompensateearDto prplcompensateearDto)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //�����¼
        dbPrplcompensateear.insert(prplcompensateearDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String earno,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //ɾ����¼
        dbPrplcompensateear.delete(earno, registno, nodetype,businessno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //������ɾ����¼
        dbPrplcompensateear.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcompensateearDto prplcompensateearDto)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //���¼�¼
        dbPrplcompensateear.update(prplcompensateearDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @return prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public PrplcompensateearDto findByPrimaryKey(DBManager dbManager,String earno,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //����DTO
        PrplcompensateearDto prplcompensateearDto = null;
        //��ѯ����,��ֵ��DTO
        prplcompensateearDto = dbPrplcompensateear.findByPrimaryKey(earno, registno, nodetype,businessno);
        return prplcompensateearDto;
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
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcompensateear.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcompensateear.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplcompensateearDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplcompensateear.findByConditions(conditions);
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
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcompensateear.getCount(conditions);
        return count;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getInprocessCount(DBManager dbManager,String policyno,String earno) 
        throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);

        int count = dbPrplcompensateear.getInprocessCount(policyno,earno);
        return count;
    }
    /**
     * ��ѯ����ģ����ѯ������Ԥ�Ƹ������
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ������Ԥ�Ƹ������
     * @throws Exception
     */
    public double getSumLoss(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sumLoss = dbPrplcompensateear.getSumLoss(conditions);
        return sumLoss;
    }
}
