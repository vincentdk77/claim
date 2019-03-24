package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLchargeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcharge;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcharge-��������Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLchargeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLchargeActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLchargeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLchargeDto prpLchargeDto) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //�����¼
        dbPrpLcharge.insert(prpLchargeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //ɾ����¼
        dbPrpLcharge.delete(compensateNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //������ɾ����¼
        dbPrpLcharge.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLchargeDto prpLchargeDto) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //���¼�¼
        dbPrpLcharge.update(prpLchargeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param compensateNo ���������
     * @param serialNo ���
     * @return prpLchargeDto prpLchargeDto
     * @throws Exception
     */
    public PrpLchargeDto findByPrimaryKey(DBManager dbManager,String compensateNo,int serialNo) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        //����DTO
        PrpLchargeDto prpLchargeDto = null;
        //��ѯ����,��ֵ��DTO
        prpLchargeDto = dbPrpLcharge.findByPrimaryKey(compensateNo, serialNo);
        return prpLchargeDto;
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
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcharge.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcharge.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLchargeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcharge.findByConditions(conditions);
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
        DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcharge.getCount(conditions);
        return count;
    }
    
    
    public int getMaxSerialNo(DBManager dbManager,String conditions) 
    throws Exception{
    DBPrpLcharge dbPrpLcharge = new DBPrpLcharge(dbManager);

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    int count = dbPrpLcharge.getMaxSerialNo(conditions);
    return count;
}
}
