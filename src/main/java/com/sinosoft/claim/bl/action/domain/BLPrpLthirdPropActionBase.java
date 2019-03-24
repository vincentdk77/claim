package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLthirdProp;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdProp-�Ʋ���ʧ��λ���ҵ���߼�������<br>
 * ������ 2005-04-12 11:37:51.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLthirdPropActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLthirdPropActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLthirdPropActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        //�����¼
        dbPrpLthirdProp.insert(prpLthirdPropDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ��ʧ��Ŀ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        //ɾ����¼
        dbPrpLthirdProp.delete(registNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        //������ɾ����¼
        dbPrpLthirdProp.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLthirdPropDto prpLthirdPropDto) throws Exception{
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        //���¼�¼
        dbPrpLthirdProp.update(prpLthirdPropDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @param serialNo ��ʧ��Ŀ���
     * @return prpLthirdPropDto prpLthirdPropDto
     * @throws Exception
     */
    public PrpLthirdPropDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        //����DTO
        PrpLthirdPropDto prpLthirdPropDto = null;
        //��ѯ����,��ֵ��DTO
        prpLthirdPropDto = dbPrpLthirdProp.findByPrimaryKey(registNo, serialNo);
        return prpLthirdPropDto;
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
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdProp.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLthirdProp.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLthirdPropDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLthirdProp.findByConditions(conditions);
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
        DBPrpLthirdProp dbPrpLthirdProp = new DBPrpLthirdProp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLthirdProp.getCount(conditions);
        return count;
    }
}
