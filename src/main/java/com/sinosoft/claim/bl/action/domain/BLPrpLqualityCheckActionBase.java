package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLqualityCheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLqualityCheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLqualityCheck-�����������ݱ��ҵ���߼�������<br>
 * ������ 2005-04-14 15:56:47.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLqualityCheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLqualityCheckActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLqualityCheckActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //�����¼
        dbPrpLqualityCheck.insert(prpLqualityCheckDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param qualityCheckType ҵ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //ɾ����¼
        dbPrpLqualityCheck.delete(registNo, qualityCheckType, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //������ɾ����¼
        dbPrpLqualityCheck.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLqualityCheckDto prpLqualityCheckDto) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //���¼�¼
        dbPrpLqualityCheck.update(prpLqualityCheckDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param qualityCheckType ҵ������
     * @param serialNo ���
     * @return prpLqualityCheckDto prpLqualityCheckDto
     * @throws Exception
     */
    public PrpLqualityCheckDto findByPrimaryKey(DBManager dbManager,String registNo,String qualityCheckType,int serialNo) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        //����DTO
        PrpLqualityCheckDto prpLqualityCheckDto = null;
        //��ѯ����,��ֵ��DTO
        prpLqualityCheckDto = dbPrpLqualityCheck.findByPrimaryKey(registNo, qualityCheckType, serialNo);
        return prpLqualityCheckDto;
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
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLqualityCheck.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLqualityCheck.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLqualityCheckDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLqualityCheck.findByConditions(conditions);
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
        DBPrpLqualityCheck dbPrpLqualityCheck = new DBPrpLqualityCheck(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLqualityCheck.getCount(conditions);
        return count;
    }
}
