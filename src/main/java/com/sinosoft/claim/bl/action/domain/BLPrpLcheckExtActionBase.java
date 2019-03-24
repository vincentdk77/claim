package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckExt;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckExt-�鿱/���鿱��չ��(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckExtActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcheckExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //�����¼
        dbPrpLcheckExt.insert(prpLcheckExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param columnName �鿱��Ŀ����
     * @param referSerialNo �������⳵�����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //ɾ����¼
        dbPrpLcheckExt.delete(registNo, serialNo, columnName, referSerialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //������ɾ����¼
        dbPrpLcheckExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //���¼�¼
        dbPrpLcheckExt.update(prpLcheckExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param columnName �鿱��Ŀ����
     * @param referSerialNo �������⳵�����
     * @return prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public PrpLcheckExtDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //����DTO
        PrpLcheckExtDto prpLcheckExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcheckExtDto = dbPrpLcheckExt.findByPrimaryKey(registNo, serialNo, columnName, referSerialNo);
        return prpLcheckExtDto;
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
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcheckExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckExt.findByConditions(conditions);
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
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckExt.getCount(conditions);
        return count;
    }
}
