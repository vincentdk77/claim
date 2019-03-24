package com.sinosoft.ciplatform.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIPlatformConfig;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIPlatformConfig��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIPlatformConfigActionBase{
    private static Logger logger = Logger.getLogger(BLCIPlatformConfigActionBase.class);

    /**
     * ���캯��
     */
    public BLCIPlatformConfigActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIPlatformConfigDto cIPlatformConfigDto)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //�����¼
        dbCIPlatformConfig.insert(cIPlatformConfigDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String configCode,String comCode,String riskCode)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //ɾ����¼
        dbCIPlatformConfig.delete(configCode, comCode, riskCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //������ɾ����¼
        dbCIPlatformConfig.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIPlatformConfigDto cIPlatformConfigDto)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //���¼�¼
        dbCIPlatformConfig.update(cIPlatformConfigDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param configCode configCode
     * @param comCode comCode
     * @param riskCode riskCode
     * @return cIPlatformConfigDto cIPlatformConfigDto
     * @throws Exception
     */
    public CIPlatformConfigDto findByPrimaryKey(DBManager dbManager,String configCode,String comCode,String riskCode)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        //����DTO
        CIPlatformConfigDto cIPlatformConfigDto = null;
        //��ѯ����,��ֵ��DTO
        cIPlatformConfigDto = dbCIPlatformConfig.findByPrimaryKey(configCode, comCode, riskCode);
        return cIPlatformConfigDto;
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
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIPlatformConfig.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIPlatformConfig.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����cIPlatformConfigDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIPlatformConfig.findByConditions(conditions);
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
        DBCIPlatformConfig dbCIPlatformConfig = new DBCIPlatformConfig(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIPlatformConfig.getCount(conditions);
        return count;
    }
}
