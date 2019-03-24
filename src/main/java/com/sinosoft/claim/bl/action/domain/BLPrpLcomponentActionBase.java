package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcomponentDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcomponent;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcomponent-������Ŀ�嵥(�޸�)��ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcomponentActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcomponentActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcomponentActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcomponentDto prpLcomponentDto) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //�����¼
        dbPrpLcomponent.insert(prpLcomponentDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ����
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //ɾ����¼
        dbPrpLcomponent.delete(riskCode, serialNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //������ɾ����¼
        dbPrpLcomponent.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcomponentDto prpLcomponentDto) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //���¼�¼
        dbPrpLcomponent.update(prpLcomponentDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ����
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @return prpLcomponentDto prpLcomponentDto
     * @throws Exception
     */
    public PrpLcomponentDto findByPrimaryKey(DBManager dbManager,String riskCode,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        //����DTO
        PrpLcomponentDto prpLcomponentDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcomponentDto = dbPrpLcomponent.findByPrimaryKey(riskCode, serialNo, lossItemCode);
        return prpLcomponentDto;
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
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomponent.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcomponent.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcomponentDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcomponent.findByConditions(conditions);
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
        DBPrpLcomponent dbPrpLcomponent = new DBPrpLcomponent(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcomponent.getCount(conditions);
        return count;
    }
}
