package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGnodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGnode;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgnode�������ڵ�ģ����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGnodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGnodeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpGnodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGnodeDto prpGnodeDto) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //�����¼
        dbPrpGnode.insert(prpGnodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ���
     * @param nodeNo �ڵ��
     * @param sonNodeNo �ӽڵ��
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int nodeNo,int sonNodeNo) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //ɾ����¼
        dbPrpGnode.delete(modelNo, nodeNo, sonNodeNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //������ɾ����¼
        dbPrpGnode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGnodeDto prpGnodeDto) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //���¼�¼
        dbPrpGnode.update(prpGnodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ���
     * @param nodeNo �ڵ��
     * @param sonNodeNo �ӽڵ��
     * @return prpGnodeDto prpGnodeDto
     * @throws Exception
     */
    public PrpGnodeDto findByPrimaryKey(DBManager dbManager,int modelNo,int nodeNo,int sonNodeNo) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        //����DTO
        PrpGnodeDto prpGnodeDto = null;
        //��ѯ����,��ֵ��DTO
        prpGnodeDto = dbPrpGnode.findByPrimaryKey(modelNo, nodeNo, sonNodeNo);
        return prpGnodeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpGnodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGnode.getCount(conditions);
        collection = dbPrpGnode.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGnode dbPrpGnode = new DBPrpGnode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGnode.getCount(conditions);
        return count;
    }
}
