package com.sinosoft.ciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.ciplatform.dto.domain.CIInsureValidDto;
import com.sinosoft.ciplatform.resource.dtofactory.domain.DBCIInsureValid;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ��ȷ������-CIInsureValid��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCIInsureValidActionBase{
    private static Logger logger = Logger.getLogger(BLCIInsureValidActionBase.class);

    /**
     * ���캯��
     */
    public BLCIInsureValidActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CIInsureValidDto cIInsureValidDto)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //�����¼
        dbCIInsureValid.insert(cIInsureValidDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param validNo ȷ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String validNo)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //ɾ����¼
        dbCIInsureValid.delete(validNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //������ɾ����¼
        dbCIInsureValid.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CIInsureValidDto cIInsureValidDto)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //���¼�¼
        dbCIInsureValid.update(cIInsureValidDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param validNo ȷ����
     * @return cIInsureValidDto cIInsureValidDto
     * @throws Exception
     */
    public CIInsureValidDto findByPrimaryKey(DBManager dbManager,String validNo)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        //����DTO
        CIInsureValidDto cIInsureValidDto = null;
        //��ѯ����,��ֵ��DTO
        cIInsureValidDto = dbCIInsureValid.findByPrimaryKey(validNo);
        return cIInsureValidDto;
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
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIInsureValid.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIInsureValid.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����cIInsureValidDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIInsureValid.findByConditions(conditions);
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
        DBCIInsureValid dbCIInsureValid = new DBCIInsureValid(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIInsureValid.getCount(conditions);
        return count;
    }
}
