package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcfee-����������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcfeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcfeeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcfeeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcfeeDto prpLcfeeDto) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //�����¼
        dbPrpLcfee.insert(prpLcfeeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param policyNo ������
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,String policyNo,String currency) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //ɾ����¼
        dbPrpLcfee.delete(compensateNo, policyNo, currency);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //������ɾ����¼
        dbPrpLcfee.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcfeeDto prpLcfeeDto) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //���¼�¼
        dbPrpLcfee.update(prpLcfeeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param policyNo ������
     * @param currency �ұ����
     * @return prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public PrpLcfeeDto findByPrimaryKey(DBManager dbManager,String compensateNo,String policyNo,String currency) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        //����DTO
        PrpLcfeeDto prpLcfeeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcfeeDto = dbPrpLcfee.findByPrimaryKey(compensateNo, policyNo, currency);
        return prpLcfeeDto;
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
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcfee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcfeeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcfee.findByConditions(conditions);
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
        DBPrpLcfee dbPrpLcfee = new DBPrpLcfee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfee.getCount(conditions);
        return count;
    }
}
