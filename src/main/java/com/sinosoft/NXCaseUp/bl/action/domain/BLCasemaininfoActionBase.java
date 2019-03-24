package com.sinosoft.NXCaseUp.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;
import com.sinosoft.NXCaseUp.resource.dtofactory.domain.DBCasemaininfo;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEMAININFO��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasemaininfoActionBase{
    private static Logger logger = Logger.getLogger(BLCasemaininfoActionBase.class);

    /**
     * ���캯��
     */
    public BLCasemaininfoActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,CasemaininfoDto casemaininfoDto)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //�����¼
        dbCasemaininfo.insert(casemaininfoDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comcode)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //ɾ����¼
        dbCasemaininfo.delete(comcode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //������ɾ����¼
        dbCasemaininfo.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,CasemaininfoDto casemaininfoDto)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //���¼�¼
        dbCasemaininfo.update(casemaininfoDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param comcode COMCODE
     * @return casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public CasemaininfoDto findByPrimaryKey(DBManager dbManager,String comcode)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        //����DTO
        CasemaininfoDto casemaininfoDto = null;
        //��ѯ����,��ֵ��DTO
        casemaininfoDto = dbCasemaininfo.findByPrimaryKey(comcode);
        return casemaininfoDto;
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
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasemaininfo.getCount(conditions);
        collection = dbCasemaininfo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����casemaininfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCasemaininfo.findByConditions(conditions);
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
        DBCasemaininfo dbCasemaininfo = new DBCasemaininfo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCasemaininfo.getCount(conditions);
        return count;
    }
}
