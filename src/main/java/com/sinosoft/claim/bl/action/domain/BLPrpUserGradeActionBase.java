package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpUserGradeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpUserGrade;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpusergradeԱ��Ȩ�ޱ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeActionBase{
    private static Log log = LogFactory.getLog(BLPrpUserGradeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpUserGradeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //�����¼
        dbPrpUserGrade.insert(prpUserGradeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //ɾ����¼
        dbPrpUserGrade.delete(userCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //������ɾ����¼
        dbPrpUserGrade.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //���¼�¼
        dbPrpUserGrade.update(prpUserGradeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param userCode Ա������
     * @return prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(DBManager dbManager,String userCode) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //����DTO
        PrpUserGradeDto prpUserGradeDto = null;
        //��ѯ����,��ֵ��DTO
        prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(userCode);
        return prpUserGradeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpUserGradeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpUserGrade.getCount(conditions);
        collection = dbPrpUserGrade.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUserGrade.getCount(conditions);
        return count;
    }
}
