package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLtrackDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLtrack;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpltrack��ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLtrackActionBase{
    private static Log log = LogFactory.getLog(BLPrpLtrackActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpLtrackActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLtrackDto prpLtrackDto) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //�����¼
        dbPrpLtrack.insert(prpLtrackDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param docCode ��֤����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String docCode) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //ɾ����¼
        dbPrpLtrack.delete(registNo, docCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //������ɾ����¼
        dbPrpLtrack.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLtrackDto prpLtrackDto) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //���¼�¼
        dbPrpLtrack.update(prpLtrackDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ������
     * @param docCode ��֤����
     * @return prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public PrpLtrackDto findByPrimaryKey(DBManager dbManager,String registNo,String docCode) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //����DTO
        PrpLtrackDto prpLtrackDto = null;
        //��ѯ����,��ֵ��DTO
        prpLtrackDto = dbPrpLtrack.findByPrimaryKey(registNo, docCode);
        return prpLtrackDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpLtrackDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLtrack.getCount(conditions);
        collection = dbPrpLtrack.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLtrack.getCount(conditions);
        return count;
    }
}
