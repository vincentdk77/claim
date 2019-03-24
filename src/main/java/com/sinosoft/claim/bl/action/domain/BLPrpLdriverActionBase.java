package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdriver;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLdriver-���ռ�ʻԱ��Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.015<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLdriverActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLdriverActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLdriverActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLdriverDto prpLdriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLdriverDto prpLdriverDto) throws Exception{
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        //�����¼
        dbPrpLdriver.insert(prpLdriverDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        //ɾ����¼
        dbPrpLdriver.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        //������ɾ����¼
        dbPrpLdriver.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLdriverDto prpLdriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLdriverDto prpLdriverDto) throws Exception{
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        //���¼�¼
        dbPrpLdriver.update(prpLdriverDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ���
     * @return prpLdriverDto prpLdriverDto
     * @throws Exception
     */
    public PrpLdriverDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        //����DTO
        PrpLdriverDto prpLdriverDto = null;
        //��ѯ����,��ֵ��DTO
        prpLdriverDto = dbPrpLdriver.findByPrimaryKey(registNo, serialNo);
        return prpLdriverDto;
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
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdriver.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLdriver.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLdriverDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLdriver.findByConditions(conditions);
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
        DBPrpLdriver dbPrpLdriver = new DBPrpLdriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdriver.getCount(conditions);
        return count;
    }
}
