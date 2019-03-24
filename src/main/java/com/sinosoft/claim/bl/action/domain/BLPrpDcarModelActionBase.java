package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcarModelDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcarModel;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcarmodel���ʹ����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcarModelActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcarModelActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcarModelActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcarModelDto prpDcarModelDto) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //�����¼
        dbPrpDcarModel.insert(prpDcarModelDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelCode ���ʹ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String modelCode) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //ɾ����¼
        dbPrpDcarModel.delete(modelCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //������ɾ����¼
        dbPrpDcarModel.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcarModelDto prpDcarModelDto) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //���¼�¼
        dbPrpDcarModel.update(prpDcarModelDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelCode ���ʹ���
     * @return prpDcarModelDto prpDcarModelDto
     * @throws Exception
     */
    public PrpDcarModelDto findByPrimaryKey(DBManager dbManager,String modelCode) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        //����DTO
        PrpDcarModelDto prpDcarModelDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcarModelDto = dbPrpDcarModel.findByPrimaryKey(modelCode);
        return prpDcarModelDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcarModelDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcarModel.getCount(conditions);
        collection = dbPrpDcarModel.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcarModel.getCount(conditions);
        return count;
    }
}
