package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdpartyStatusDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdpartyStatus;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdpartyStatus-���������ҵ��Ϣ������Ϣ״̬���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.125<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdpartyStatusActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdpartyStatusActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdpartyStatusActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //�����¼
        dbPrpLthirdpartyStatus.insert(prpLthirdpartyStatusDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo ����ҵ�����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,int serialNo) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //ɾ����¼
        dbPrpLthirdpartyStatus.delete(businessNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //������ɾ����¼
        dbPrpLthirdpartyStatus.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //���¼�¼
        dbPrpLthirdpartyStatus.update(prpLthirdpartyStatusDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo ����ҵ�����
     * @param serialNo ���
     * @return prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public PrpLthirdpartyStatusDto findByPrimaryKey(DBManager dbManager,String businessNo,int serialNo) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        //����DTO
        PrpLthirdpartyStatusDto prpLthirdpartyStatusDto = null;
        //��ѯ����,��ֵ��DTO
        prpLthirdpartyStatusDto = dbPrpLthirdpartyStatus.findByPrimaryKey(businessNo, serialNo);
        return prpLthirdpartyStatusDto;
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
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdpartyStatus.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLthirdpartyStatus.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLthirdpartyStatusDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLthirdpartyStatus.findByConditions(conditions);
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
        DBPrpLthirdpartyStatus dbPrpLthirdpartyStatus = new DBPrpLthirdpartyStatus(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdpartyStatus.getCount(conditions);
        return count;
    }
}
