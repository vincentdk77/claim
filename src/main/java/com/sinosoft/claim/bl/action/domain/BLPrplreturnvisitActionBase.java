package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLRETURNVISIT��ҵ���߼�������<br>
 */
public class BLPrplreturnvisitActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplreturnvisitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplreturnvisitDto prplreturnvisitDto)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //�����¼
        dbPrplreturnvisit.insert(prplreturnvisitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //ɾ����¼
        dbPrplreturnvisit.delete(registno, serialno);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //������ɾ����¼
        dbPrplreturnvisit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplreturnvisitDto prplreturnvisitDto)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //���¼�¼
        dbPrplreturnvisit.update(prplreturnvisitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registno REGISTNO
     * @param serialno SERIALNO
     * @return prplreturnvisitDto prplreturnvisitDto
     * @throws Exception
     */
    public PrplreturnvisitDto findByPrimaryKey(DBManager dbManager,String registno,String serialno)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        //����DTO
        PrplreturnvisitDto prplreturnvisitDto = null;
        //��ѯ����,��ֵ��DTO
        prplreturnvisitDto = dbPrplreturnvisit.findByPrimaryKey(registno, serialno);
        return prplreturnvisitDto;
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
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplreturnvisit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplreturnvisitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplreturnvisit.findByConditions(conditions);
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
        DBPrplreturnvisit dbPrplreturnvisit = new DBPrplreturnvisit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisit.getCount(conditions);
        return count;
    }
}
