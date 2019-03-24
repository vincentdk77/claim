package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheck-�鿱/���鿱��չ��(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckDto prpLcheckDto) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //�����¼
        dbPrpLcheck.insert(prpLcheckDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param referSerialNo �������⳵�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int referSerialNo) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //ɾ����¼
        dbPrpLcheck.delete(registNo, referSerialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //������ɾ����¼
        dbPrpLcheck.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckDto prpLcheckDto) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //���¼�¼
        dbPrpLcheck.update(prpLcheckDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param referSerialNo �������⳵�����
     * @return prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public PrpLcheckDto findByPrimaryKey(DBManager dbManager,String registNo,int referSerialNo) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //����DTO
        PrpLcheckDto prpLcheckDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcheckDto = dbPrpLcheck.findByPrimaryKey(registNo, referSerialNo);
        return prpLcheckDto;
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
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheck.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheck.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcheckDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheck.findByConditions(conditions);
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
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheck.getCount(conditions);
        return count;
    }
}
