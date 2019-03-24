package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplaccidangersd;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERSD��ҵ���߼�������<br>
 */
public class BLPrplaccidangersdActionBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangersdActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplaccidangersdActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplaccidangersdDto prplaccidangersdDto)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //�����¼
        dbPrplaccidangersd.insert(prplaccidangersdDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String insuredname,int serialno)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //ɾ����¼
        dbPrplaccidangersd.delete(insuredname, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //������ɾ����¼
        dbPrplaccidangersd.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplaccidangersdDto prplaccidangersdDto)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //���¼�¼
        dbPrplaccidangersd.update(prplaccidangersdDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @return prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public PrplaccidangersdDto findByPrimaryKey(DBManager dbManager,String insuredname,int serialno)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        //����DTO
        PrplaccidangersdDto prplaccidangersdDto = null;
        //��ѯ����,��ֵ��DTO
        prplaccidangersdDto = dbPrplaccidangersd.findByPrimaryKey(insuredname, serialno);
        return prplaccidangersdDto;
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
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangersd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplaccidangersd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplaccidangersdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplaccidangersd.findByConditions(conditions);
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
        DBPrplaccidangersd dbPrplaccidangersd = new DBPrplaccidangersd(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccidangersd.getCount(conditions);
        return count;
    }
}
