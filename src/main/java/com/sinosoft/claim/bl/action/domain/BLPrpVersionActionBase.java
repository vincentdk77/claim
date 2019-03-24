package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpVersionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpVersion;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpversion���ݿ�汾��Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpVersionActionBase{
    private static Log log = LogFactory.getLog(BLPrpVersionActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpVersionActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpVersionDto prpVersionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpVersionDto prpVersionDto) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //�����¼
        dbPrpVersion.insert(prpVersionDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param projectVersion ��Ŀ�汾��
     * @param productID ��Ʒ��ʶ
     * @param times �������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String projectVersion,String productID,int times) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //ɾ����¼
        dbPrpVersion.delete(projectVersion, productID, times);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //������ɾ����¼
        dbPrpVersion.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpVersionDto prpVersionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpVersionDto prpVersionDto) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //���¼�¼
        dbPrpVersion.update(prpVersionDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param projectVersion ��Ŀ�汾��
     * @param productID ��Ʒ��ʶ
     * @param times �������
     * @return prpVersionDto prpVersionDto
     * @throws Exception
     */
    public PrpVersionDto findByPrimaryKey(DBManager dbManager,String projectVersion,String productID,int times) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        //����DTO
        PrpVersionDto prpVersionDto = null;
        //��ѯ����,��ֵ��DTO
        prpVersionDto = dbPrpVersion.findByPrimaryKey(projectVersion, productID, times);
        return prpVersionDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpVersionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpVersion.getCount(conditions);
        collection = dbPrpVersion.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpVersion dbPrpVersion = new DBPrpVersion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpVersion.getCount(conditions);
        return count;
    }
}
