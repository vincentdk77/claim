package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshipClassDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDshipClass;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdshipclass������������յ�ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshipClassActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshipClassActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDshipClassActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDshipClassDto prpDshipClassDto) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //�����¼
        dbPrpDshipClass.insert(prpDshipClassDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param shipCode ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String shipCode,int serialNo) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //ɾ����¼
        dbPrpDshipClass.delete(shipCode, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //������ɾ����¼
        dbPrpDshipClass.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDshipClassDto prpDshipClassDto) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //���¼�¼
        dbPrpDshipClass.update(prpDshipClassDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param shipCode ��������
     * @param serialNo ���
     * @return prpDshipClassDto prpDshipClassDto
     * @throws Exception
     */
    public PrpDshipClassDto findByPrimaryKey(DBManager dbManager,String shipCode,int serialNo) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        //����DTO
        PrpDshipClassDto prpDshipClassDto = null;
        //��ѯ����,��ֵ��DTO
        prpDshipClassDto = dbPrpDshipClass.findByPrimaryKey(shipCode, serialNo);
        return prpDshipClassDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDshipClassDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDshipClass.getCount(conditions);
        collection = dbPrpDshipClass.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDshipClass dbPrpDshipClass = new DBPrpDshipClass(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDshipClass.getCount(conditions);
        return count;
    }
}
