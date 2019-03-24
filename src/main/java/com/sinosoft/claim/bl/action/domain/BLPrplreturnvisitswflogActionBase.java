package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitswflog;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLRETURNVISITSWFLOG��ҵ���߼�������<br>
 */
public class BLPrplreturnvisitswflogActionBase{
    private static Logger logger = Logger.getLogger(BLPrplreturnvisitswflogActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplreturnvisitswflogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplreturnvisitswflogDto prplreturnvisitswflogDto)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //�����¼
        dbPrplreturnvisitswflog.insert(prplreturnvisitswflogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessno,String nodetype)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //ɾ����¼
        dbPrplreturnvisitswflog.delete(businessno, nodetype);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //������ɾ����¼
        dbPrplreturnvisitswflog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplreturnvisitswflogDto prplreturnvisitswflogDto)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //���¼�¼
        dbPrplreturnvisitswflog.update(prplreturnvisitswflogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessno BUSINESSNO
     * @param nodetype NODETYPE
     * @return prplreturnvisitswflogDto prplreturnvisitswflogDto
     * @throws Exception
     */
    public PrplreturnvisitswflogDto findByPrimaryKey(DBManager dbManager,String businessno,String nodetype)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        //����DTO
        PrplreturnvisitswflogDto prplreturnvisitswflogDto = null;
        //��ѯ����,��ֵ��DTO
        prplreturnvisitswflogDto = dbPrplreturnvisitswflog.findByPrimaryKey(businessno, nodetype);
        return prplreturnvisitswflogDto;
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
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisitswflog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplreturnvisitswflog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplreturnvisitswflogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplreturnvisitswflog.findByConditions(conditions);
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
        DBPrplreturnvisitswflog dbPrplreturnvisitswflog = new DBPrplreturnvisitswflog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplreturnvisitswflog.getCount(conditions);
        return count;
    }
}
