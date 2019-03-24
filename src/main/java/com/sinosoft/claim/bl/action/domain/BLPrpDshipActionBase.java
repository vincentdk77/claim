package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDshipDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDship;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdship���������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDshipActionBase{
    private static Log log = LogFactory.getLog(BLPrpDshipActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDshipActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDshipDto prpDshipDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDshipDto prpDshipDto) throws Exception{
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);
        //�����¼
        dbPrpDship.insert(prpDshipDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param shipCode ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String shipCode) throws Exception{
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);
        //ɾ����¼
        dbPrpDship.delete(shipCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);
        //������ɾ����¼
        dbPrpDship.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDshipDto prpDshipDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDshipDto prpDshipDto) throws Exception{
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);
        //���¼�¼
        dbPrpDship.update(prpDshipDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param shipCode ��������
     * @return prpDshipDto prpDshipDto
     * @throws Exception
     */
    public PrpDshipDto findByPrimaryKey(DBManager dbManager,String shipCode) throws Exception{
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);
        //����DTO
        PrpDshipDto prpDshipDto = null;
        //��ѯ����,��ֵ��DTO
        prpDshipDto = dbPrpDship.findByPrimaryKey(shipCode);
        return prpDshipDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDshipDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDship.getCount(conditions);
        collection = dbPrpDship.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDship dbPrpDship = new DBPrpDship(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDship.getCount(conditions);
        return count;
    }
}
