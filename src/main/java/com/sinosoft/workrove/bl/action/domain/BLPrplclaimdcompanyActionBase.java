package com.sinosoft.workrove.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.workrove.dto.domain.PrplclaimdcompanyDto;
import com.sinosoft.workrove.resource.dtofactory.domain.DBPrplclaimdcompany;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLCLAIMDCOMPANY��ҵ���߼�������<br>
 */
public class BLPrplclaimdcompanyActionBase{
    private static Logger logger = Logger.getLogger(BLPrplclaimdcompanyActionBase.class);

    /**
     * ���캯��
     */
    public BLPrplclaimdcompanyActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplclaimdcompanyDto prplclaimdcompanyDto)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //�����¼
        dbPrplclaimdcompany.insert(prplclaimdcompanyDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param nodetype NODETYPE
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String nodetype,String comcode)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //ɾ����¼
        dbPrplclaimdcompany.delete(nodetype, comcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //������ɾ����¼
        dbPrplclaimdcompany.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplclaimdcompanyDto prplclaimdcompanyDto)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //���¼�¼
        dbPrplclaimdcompany.update(prplclaimdcompanyDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param nodetype NODETYPE
     * @param comcode COMCODE
     * @return prplclaimdcompanyDto prplclaimdcompanyDto
     * @throws Exception
     */
    public PrplclaimdcompanyDto findByPrimaryKey(DBManager dbManager,String nodetype,String comcode)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        //����DTO
        PrplclaimdcompanyDto prplclaimdcompanyDto = null;
        //��ѯ����,��ֵ��DTO
        prplclaimdcompanyDto = dbPrplclaimdcompany.findByPrimaryKey(nodetype, comcode);
        return prplclaimdcompanyDto;
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
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplclaimdcompany.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplclaimdcompany.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prplclaimdcompanyDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplclaimdcompany.findByConditions(conditions);
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
        DBPrplclaimdcompany dbPrplclaimdcompany = new DBPrplclaimdcompany(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplclaimdcompany.getCount(conditions);
        return count;
    }
}
