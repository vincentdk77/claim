package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyDirect;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcertifyDirect������ָ����ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcertifyDirectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyDirectActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyDirectActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //�����¼
        dbPrpLcertifyDirect.insert(prpLcertifyDirectDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //ɾ����¼
        dbPrpLcertifyDirect.delete(registNo, serialNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //������ɾ����¼
        dbPrpLcertifyDirect.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //���¼�¼
        dbPrpLcertifyDirect.update(prpLcertifyDirectDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @return prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public PrpLcertifyDirectDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //����DTO
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcertifyDirectDto = dbPrpLcertifyDirect.findByPrimaryKey(registNo, serialNo, lossItemCode);
        return prpLcertifyDirectDto;
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
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyDirect.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertifyDirect.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcertifyDirectDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcertifyDirect.findByConditions(conditions);
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
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyDirect.getCount(conditions);
        return count;
    }
}
