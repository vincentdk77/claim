package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPcontractpauseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcontractpause;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpPcontractpause��ֹ���պ�ͬ��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPcontractpauseActionBase{
    private static Log log = LogFactory.getLog(BLPrpPcontractpauseActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpPcontractpauseActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //�����¼
        dbPrpPcontractpause.insert(prpPcontractpauseDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param endorseNo ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //ɾ����¼
        dbPrpPcontractpause.delete(endorseNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //������ɾ����¼
        dbPrpPcontractpause.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPcontractpauseDto prpPcontractpauseDto) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //���¼�¼
        dbPrpPcontractpause.update(prpPcontractpauseDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param endorseNo ������
     * @return prpPcontractpauseDto prpPcontractpauseDto
     * @throws Exception
     */
    public PrpPcontractpauseDto findByPrimaryKey(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        //����DTO
        PrpPcontractpauseDto prpPcontractpauseDto = null;
        //��ѯ����,��ֵ��DTO
        prpPcontractpauseDto = dbPrpPcontractpause.findByPrimaryKey(endorseNo);
        return prpPcontractpauseDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpPcontractpauseDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpPcontractpause.getCount(conditions);
        collection = dbPrpPcontractpause.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpPcontractpause dbPrpPcontractpause = new DBPrpPcontractpause(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcontractpause.getCount(conditions);
        return count;
    }
}
