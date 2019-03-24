package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdeductCondDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdeductCond;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLdeductCond-�����������������ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLdeductCondActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLdeductCondActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLdeductCondActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //�����¼
        dbPrpLdeductCond.insert(prpLdeductCondDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo �������
     * @param deductCondCode ������������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String deductCondCode)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //ɾ����¼
        dbPrpLdeductCond.delete(compensateNo, deductCondCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //������ɾ����¼
        dbPrpLdeductCond.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLdeductCondDto prpLdeductCondDto)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //���¼�¼
        dbPrpLdeductCond.update(prpLdeductCondDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo �������
     * @param deductCondCode ������������
     * @return prpLdeductCondDto prpLdeductCondDto
     * @throws Exception
     */
    public PrpLdeductCondDto findByPrimaryKey(DBManager dbManager,String compensateNo,String deductCondCode)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        //����DTO
        PrpLdeductCondDto prpLdeductCondDto = null;
        //��ѯ����,��ֵ��DTO
        prpLdeductCondDto = dbPrpLdeductCond.findByPrimaryKey(compensateNo, deductCondCode);
        return prpLdeductCondDto;
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
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdeductCond.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLdeductCond.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLdeductCondDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        String findConditions = " compensateno='"+conditions+"'";
        collection = dbPrpLdeductCond.findByConditions(findConditions);
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
        DBPrpLdeductCond dbPrpLdeductCond = new DBPrpLdeductCond(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdeductCond.getCount(conditions);
        return count;
    }
}
