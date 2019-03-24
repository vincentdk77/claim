package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLsalvationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLsalvation;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLsalvation-��Լ�������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.140<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLsalvationActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLsalvationActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLsalvationActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLsalvationDto prpLsalvationDto) throws Exception{
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        //�����¼
        dbPrpLsalvation.insert(prpLsalvationDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        //ɾ����¼
        dbPrpLsalvation.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        //������ɾ����¼
        dbPrpLsalvation.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLsalvationDto prpLsalvationDto) throws Exception{
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        //���¼�¼
        dbPrpLsalvation.update(prpLsalvationDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param serialNo ���
     * @return prpLsalvationDto prpLsalvationDto
     * @throws Exception
     */
    public PrpLsalvationDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        //����DTO
        PrpLsalvationDto prpLsalvationDto = null;
        //��ѯ����,��ֵ��DTO
        prpLsalvationDto = dbPrpLsalvation.findByPrimaryKey(registNo, serialNo);
        return prpLsalvationDto;
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
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLsalvation.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLsalvation.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLsalvationDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLsalvation.findByConditions(conditions);
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
        DBPrpLsalvation dbPrpLsalvation = new DBPrpLsalvation(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLsalvation.getCount(conditions);
        return count;
    }
}
