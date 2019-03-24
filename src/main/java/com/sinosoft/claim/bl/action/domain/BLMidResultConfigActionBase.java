package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.MidResultConfigDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBMidResultConfig;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����MidResultConfig���ҳ�����ñ��ҵ���߼�������<br>
 * ������ 2005-03-11 10:51:28.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLMidResultConfigActionBase{
    private static Log logger = LogFactory.getLog(BLMidResultConfigActionBase.class);

    /**
     * ���캯��
     */
    public BLMidResultConfigActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MidResultConfigDto midResultConfigDto) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //�����¼
        dbMidResultConfig.insert(midResultConfigDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param configOwner ���ù�����
     * @param resultType ���ҳ������
     * @param itemNo ��Ŀ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String configOwner,String resultType,int itemNo) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //ɾ����¼
        dbMidResultConfig.delete(configOwner, resultType, itemNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //������ɾ����¼
        dbMidResultConfig.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MidResultConfigDto midResultConfigDto) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //���¼�¼
        dbMidResultConfig.update(midResultConfigDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param configOwner ���ù�����
     * @param resultType ���ҳ������
     * @param itemNo ��Ŀ���
     * @return midResultConfigDto midResultConfigDto
     * @throws Exception
     */
    public MidResultConfigDto findByPrimaryKey(DBManager dbManager,String configOwner,String resultType,int itemNo) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        //����DTO
        MidResultConfigDto midResultConfigDto = null;
        //��ѯ����,��ֵ��DTO
        midResultConfigDto = dbMidResultConfig.findByPrimaryKey(configOwner, resultType, itemNo);
        return midResultConfigDto;
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
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMidResultConfig.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMidResultConfig.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����midResultConfigDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        collection = dbMidResultConfig.findByConditions(conditions);
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
        DBMidResultConfig dbMidResultConfig = new DBMidResultConfig(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMidResultConfig.getCount(conditions);
        return count;
    }
}
