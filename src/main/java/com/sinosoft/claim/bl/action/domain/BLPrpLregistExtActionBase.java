package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLregistExt;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregistExt-������Ϣ����˵����ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistExtActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLregistExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLregistExtDto prpLregistExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLregistExtDto prpLregistExtDto) throws Exception{
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        //�����¼
        dbPrpLregistExt.insert(prpLregistExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        //ɾ����¼
        dbPrpLregistExt.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        //������ɾ����¼
        dbPrpLregistExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLregistExtDto prpLregistExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLregistExtDto prpLregistExtDto) throws Exception{
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        //���¼�¼
        dbPrpLregistExt.update(prpLregistExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @return prpLregistExtDto prpLregistExtDto
     * @throws Exception
     */
    public PrpLregistExtDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        //����DTO
        PrpLregistExtDto prpLregistExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpLregistExtDto = dbPrpLregistExt.findByPrimaryKey(registNo, serialNo);
        return prpLregistExtDto;
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
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregistExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLregistExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLregistExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregistExt.findByConditions(conditions);
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
        DBPrpLregistExt dbPrpLregistExt = new DBPrpLregistExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregistExt.getCount(conditions);
        return count;
    }
}
