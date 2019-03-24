package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciCheck--�⽡�յ��������ҵ���߼�������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLacciCheckActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //�����¼
        dbPrpLacciCheck.insert(prpLacciCheckDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param checkNo �����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String checkNo) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //ɾ����¼
        dbPrpLacciCheck.delete(checkNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //������ɾ����¼
        dbPrpLacciCheck.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLacciCheckDto prpLacciCheckDto) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //���¼�¼
        dbPrpLacciCheck.update(prpLacciCheckDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param checkNo �����
     * @return prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public PrpLacciCheckDto findByPrimaryKey(DBManager dbManager,String checkNo) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        //����DTO
        PrpLacciCheckDto prpLacciCheckDto = null;
        //��ѯ����,��ֵ��DTO
        prpLacciCheckDto = dbPrpLacciCheck.findByPrimaryKey(checkNo);
        return prpLacciCheckDto;
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
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheck.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLacciCheck.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLacciCheckDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLacciCheck.findByConditions(conditions);
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
        DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLacciCheck.getCount(conditions);
        return count;
    }
}
