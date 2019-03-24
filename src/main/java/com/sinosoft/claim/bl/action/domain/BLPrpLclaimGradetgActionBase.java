package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimGradetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimGrade--����ҵ��Ȩ�ޱ�(����)��ҵ���߼�������<br>
 * ������ 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradetgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimGradetgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //�����¼
        dbPrpLclaimGradetg.insert(prpLclaimGradetgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @param taskCode �������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String taskCode,String configPara) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //ɾ����¼
        dbPrpLclaimGradetg.delete(userCode, taskCode,configPara);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //������ɾ����¼
        dbPrpLclaimGradetg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //���¼�¼
        dbPrpLclaimGradetg.update(prpLclaimGradetgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @param taskCode �������
     * @return prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public PrpLclaimGradetgDto findByPrimaryKey(DBManager dbManager,String userCode,String taskCode,String configPara) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //����DTO
        PrpLclaimGradetgDto prpLclaimGradetgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimGradetgDto = dbPrpLclaimGradetg.findByPrimaryKey(userCode, taskCode,configPara);
        return prpLclaimGradetgDto;
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
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimGradetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimGradetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimGradetgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimGradetg.findByConditions(conditions);
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
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimGradetg.getCount(conditions);
        return count;
    }
}
