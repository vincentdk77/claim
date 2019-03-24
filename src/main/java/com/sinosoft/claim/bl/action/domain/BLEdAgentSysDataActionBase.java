package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdAgentSysDataDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdAgentSysData;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdAgentSysData��ҵ���߼�������<br>
 * ������ 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdAgentSysDataActionBase{
    private static Log logger = LogFactory.getLog(BLEdAgentSysDataActionBase.class);

    /**
     * ���캯��
     */
    public BLEdAgentSysDataActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //�����¼
        dbEdAgentSysData.insert(edAgentSysDataDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param cALLID ���б�ʶ
     * @throws Exception
     */
    public void delete(DBManager dbManager,String cALLID) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //ɾ����¼
        dbEdAgentSysData.delete(cALLID);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //������ɾ����¼
        dbEdAgentSysData.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdAgentSysDataDto edAgentSysDataDto) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //���¼�¼
        dbEdAgentSysData.update(edAgentSysDataDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param cALLID ���б�ʶ
     * @return edAgentSysDataDto edAgentSysDataDto
     * @throws Exception
     */
    public EdAgentSysDataDto findByPrimaryKey(DBManager dbManager,String cALLID) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        //����DTO
        EdAgentSysDataDto edAgentSysDataDto = null;
        //��ѯ����,��ֵ��DTO
        edAgentSysDataDto = dbEdAgentSysData.findByPrimaryKey(cALLID);
        return edAgentSysDataDto;
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
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdAgentSysData.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdAgentSysData.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����edAgentSysDataDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdAgentSysData.findByConditions(conditions);
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
        DBEdAgentSysData dbEdAgentSysData = new DBEdAgentSysData(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdAgentSysData.getCount(conditions);
        return count;
    }
}
