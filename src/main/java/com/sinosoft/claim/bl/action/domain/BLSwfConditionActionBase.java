package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfCondition;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfCondition-������������������������ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.296<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfConditionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfConditionActionBase.class);

    /**
     * ���캯��
     */
    public BLSwfConditionActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfConditionDto swfConditionDto) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //�����¼
        dbSwfCondition.insert(swfConditionDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //ɾ����¼
        dbSwfCondition.delete(modelNo, pathNo, conditionNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //������ɾ����¼
        dbSwfCondition.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfConditionDto swfConditionDto) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //���¼�¼
        dbSwfCondition.update(swfConditionDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @return swfConditionDto swfConditionDto
     * @throws Exception
     */
    public SwfConditionDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        //����DTO
        SwfConditionDto swfConditionDto = null;
        //��ѯ����,��ֵ��DTO
        swfConditionDto = dbSwfCondition.findByPrimaryKey(modelNo, pathNo, conditionNo, serialNo);
        return swfConditionDto;
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
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfCondition.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfCondition.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����swfConditionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfCondition.findByConditions(conditions);
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
        DBSwfCondition dbSwfCondition = new DBSwfCondition(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfCondition.getCount(conditions);
        return count;
    }
}
