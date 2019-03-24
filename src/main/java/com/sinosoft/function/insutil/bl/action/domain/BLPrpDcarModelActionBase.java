package com.sinosoft.function.insutil.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDcarModelDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpDcarModel;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcarmodel��ҵ���߼�������<br>
 * ������ 2004-4-6 16:08:20<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcarModelActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcarModelActionBase.class.getName());
    protected int count; //findByConditions��ѯ���ļ�¼��

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
     * @param modelCode modelcode
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
     * @param modelCode modelcode
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

        count = dbPrpDcarModel.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDcarModel.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpDcarModelDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        return findByConditions(dbManager,conditions,0,0);
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getCount(){
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpDcarModel dbPrpDcarModel = new DBPrpDcarModel(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcarModel.getCount(conditions);
        return count;
    }
}
