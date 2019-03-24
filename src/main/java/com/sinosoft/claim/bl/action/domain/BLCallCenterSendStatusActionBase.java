package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBCallCenterSendStatus;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CallCenterSendStatus��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCallCenterSendStatusActionBase{
    private static Logger logger = Logger.getLogger(BLCallCenterSendStatusActionBase.class);

    /**
     * ���캯��
     */
    public BLCallCenterSendStatusActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CallCenterSendStatusDto callCenterSendStatusDto)
            throws Exception{
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        //�����¼
        dbCallCenterSendStatus.insert(callCenterSendStatusDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param serial serial
     * @throws Exception
     */
    public void delete(DBManager dbManager,double serial)
            throws Exception{
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        //ɾ����¼
        dbCallCenterSendStatus.delete(serial);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        //������ɾ����¼
        dbCallCenterSendStatus.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CallCenterSendStatusDto callCenterSendStatusDto)
            throws Exception{
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        //���¼�¼
        dbCallCenterSendStatus.update(callCenterSendStatusDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param serial serial
     * @return callCenterSendStatusDto callCenterSendStatusDto
     * @throws Exception
     */
    public CallCenterSendStatusDto findByPrimaryKey(DBManager dbManager,double serial)
            throws Exception{
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        //����DTO
        CallCenterSendStatusDto callCenterSendStatusDto = null;
        //��ѯ����,��ֵ��DTO
        callCenterSendStatusDto = dbCallCenterSendStatus.findByPrimaryKey(serial);
        return callCenterSendStatusDto;
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
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCallCenterSendStatus.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCallCenterSendStatus.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����callCenterSendStatusDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCallCenterSendStatus.findByConditions(conditions);
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
        DBCallCenterSendStatus dbCallCenterSendStatus = new DBCallCenterSendStatus(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCallCenterSendStatus.getCount(conditions);
        return count;
    }
}
