package com.sinosoft.NXCaseUp.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasefarmer;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEFARMER��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasefarmerActionBase{
    private static Logger logger = Logger.getLogger(BLCasefarmerActionBase.class);

    /**
     * ���캯��
     */
    public BLCasefarmerActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CasefarmerDto casefarmerDto)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //�����¼
        dbCasefarmer.insert(casefarmerDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param farmername FARMERNAME
     * @throws Exception
     */
    public void delete(DBManager dbManager,String farmername)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //ɾ����¼
        dbCasefarmer.delete(farmername);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //������ɾ����¼
        dbCasefarmer.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CasefarmerDto casefarmerDto)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //���¼�¼
        dbCasefarmer.update(casefarmerDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param farmername FARMERNAME
     * @return casefarmerDto casefarmerDto
     * @throws Exception
     */
    public CasefarmerDto findByPrimaryKey(DBManager dbManager,String farmername)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        //����DTO
        CasefarmerDto casefarmerDto = null;
        //��ѯ����,��ֵ��DTO
        casefarmerDto = dbCasefarmer.findByPrimaryKey(farmername);
        return casefarmerDto;
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
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasefarmer.getCount(conditions);
        collection = dbCasefarmer.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����casefarmerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCasefarmer.findByConditions(conditions);
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
        DBCasefarmer dbCasefarmer = new DBCasefarmer(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasefarmer.getCount(conditions);
        return count;
    }
}
