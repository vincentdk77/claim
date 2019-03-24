package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.MessageReceiveLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBMessageReceiveLog;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����MessageReceiveLog��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLMessageReceiveLogActionBase{
    private static Logger logger = Logger.getLogger(BLMessageReceiveLogActionBase.class);

    /**
     * ���캯��
     */
    public BLMessageReceiveLogActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MessageReceiveLogDto messageReceiveLogDto)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //�����¼
        dbMessageReceiveLog.insert(messageReceiveLogDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param ruleCode RuleCode
     * @param month Month
     * @throws Exception
     */
    public void delete(DBManager dbManager,String ruleCode,String month)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //ɾ����¼
        dbMessageReceiveLog.delete(ruleCode, month);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //������ɾ����¼
        dbMessageReceiveLog.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MessageReceiveLogDto messageReceiveLogDto)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //���¼�¼
        dbMessageReceiveLog.update(messageReceiveLogDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param ruleCode RuleCode
     * @param month Month
     * @return messageReceiveLogDto messageReceiveLogDto
     * @throws Exception
     */
    public MessageReceiveLogDto findByPrimaryKey(DBManager dbManager,String ruleCode,String month)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        //����DTO
        MessageReceiveLogDto messageReceiveLogDto = null;
        //��ѯ����,��ֵ��DTO
        messageReceiveLogDto = dbMessageReceiveLog.findByPrimaryKey(ruleCode, month);
        return messageReceiveLogDto;
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
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMessageReceiveLog.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMessageReceiveLog.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����messageReceiveLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMessageReceiveLog.findByConditions(conditions);
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
        DBMessageReceiveLog dbMessageReceiveLog = new DBMessageReceiveLog(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMessageReceiveLog.getCount(conditions);
        return count;
    }
}
