package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangerclaimsd;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERCLAIMSD��ҵ���߼�������<br>
 */
public class BLPrplaccidangerclaimsdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangerclaimsdActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplaccidangerclaimsdActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //�����¼
        dbPrplaccidangerclaimsd.insert(prplaccidangerclaimsdDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String insuredname,int serialno,String companycode,String lossdate)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //ɾ����¼
        dbPrplaccidangerclaimsd.delete(insuredname, serialno, companycode, lossdate);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //������ɾ����¼
        dbPrplaccidangerclaimsd.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //���¼�¼
        dbPrplaccidangerclaimsd.update(prplaccidangerclaimsdDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @return prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public PrplaccidangerclaimsdDto findByPrimaryKey(DBManager dbManager,String insuredname,int serialno,String companycode,String lossdate)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        //����DTO
        PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = null;
        //��ѯ����,��ֵ��DTO
        prplaccidangerclaimsdDto = dbPrplaccidangerclaimsd.findByPrimaryKey(insuredname, serialno, companycode, lossdate);
        return prplaccidangerclaimsdDto;
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
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangerclaimsd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplaccidangerclaimsd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplaccidangerclaimsdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplaccidangerclaimsd.findByConditions(conditions);
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
        DBPrplaccidangerclaimsd dbPrplaccidangerclaimsd = new DBPrplaccidangerclaimsd(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangerclaimsd.getCount(conditions);
        return count;
    }
}
