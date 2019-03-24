package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.claim.resource.dtofactory.domain.DBED_AGENT_INFO;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϯԱ����Ϣ���ҵ���߼�������<br>
 * ������ 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOActionBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOActionBase.class);

    /**
     * ���캯��
     */
    public BLED_AGENT_INFOActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void insert(DBManager dbManager,ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //�����¼
        dbED_AGENT_INFO.insert(eD_AGENT_INFODto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param aGENTID ��ϯ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String aGENTID) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //ɾ����¼
        dbED_AGENT_INFO.delete(aGENTID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //������ɾ����¼
        dbED_AGENT_INFO.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public void update(DBManager dbManager,ED_AGENT_INFODto eD_AGENT_INFODto) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //���¼�¼
        dbED_AGENT_INFO.update(eD_AGENT_INFODto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param aGENTID ��ϯ����
     * @return eD_AGENT_INFODto eD_AGENT_INFODto
     * @throws Exception
     */
    public ED_AGENT_INFODto findByPrimaryKey(DBManager dbManager,String aGENTID) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        //����DTO
        ED_AGENT_INFODto eD_AGENT_INFODto = null;
        //��ѯ����,��ֵ��DTO
        eD_AGENT_INFODto = dbED_AGENT_INFO.findByPrimaryKey(aGENTID);
        return eD_AGENT_INFODto;
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
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbED_AGENT_INFO.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbED_AGENT_INFO.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����eD_AGENT_INFODto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbED_AGENT_INFO.findByConditions(conditions);
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
        DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbED_AGENT_INFO.getCount(conditions);
        return count;
    }
}
