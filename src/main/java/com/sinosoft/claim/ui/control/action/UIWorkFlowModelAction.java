package com.sinosoft.claim.ui.control.action;
import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.ui.model.SwfConditionFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfConditionInsertCommand;
import com.sinosoft.claim.ui.model.SwfModelMainFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfModelUseFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfModelUseInsertCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelFindByConditionsCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelGetNoCommand;
import com.sinosoft.claim.ui.model.WorkFlowModelInsertCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �����������߼�
 * <p>Title: ��������</p>
 * <p>Description: �������⹤�����ӿڳ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */
public class UIWorkFlowModelAction
{
  public static String NODESTATUSSUBMIT = "04"; //�ڵ�״̬ ���ύ
  public static String CURRENCYCODE = "CurrencyCode"; //�ұ�
  /**
   * ������������ģ��
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public void createModel(WorkFlowModelDto workFlowModelDto) throws Exception {
    WorkFlowModelInsertCommand WorkFlowModelInsertCommand = new WorkFlowModelInsertCommand(workFlowModelDto);
    WorkFlowModelInsertCommand.execute() ;
    return ;
  }

  /**
   * �޸Ĺ�������ģ��
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public String updateModel() throws Exception {
    String ModelNo="";
    return ModelNo;
  }


  /**
   * ɾ����������ģ��
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public String deleteModel() throws Exception {
    String ModelNo="";
    return ModelNo;
  }

  /**
   * �õ�ģ���
   * @throws Exception
   * @return int
   */
  public int getModelNo() throws Exception
   {
     Integer modelNo = new Integer(0) ;//ģ����
     WorkFlowModelGetNoCommand workFlowModelGetNoCommand = new WorkFlowModelGetNoCommand();
     modelNo = (Integer)workFlowModelGetNoCommand.execute() ;
     return modelNo.intValue() ;
   }

   /**
    * ���ģ����Ϣ
    * @param  ģ���
    * @return ģ�����
    * @throws Exception
    */
   public WorkFlowModelDto findByPrimaryKey(int modelNo) throws UserException, Exception
   {
           WorkFlowModelFindByPrimaryKeyCommand workFlowModelFindByPrimaryKeyCommand = new WorkFlowModelFindByPrimaryKeyCommand(modelNo);
           WorkFlowModelDto workFlowModelDto = (WorkFlowModelDto)workFlowModelFindByPrimaryKeyCommand.execute();

     if (workFlowModelDto == null)
     {
       throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+modelNo+")");
     }
     return workFlowModelDto;
   }


   /**
   * ��ȡģ���б�
   * @param  conditions����ѯ����
   * @return ģ�����
   * @throws Exception
   */

   public Collection findByConditions(String conditions) throws SQLException,Exception
   {
      WorkFlowModelFindByConditionsCommand workFlowModelFindByConditionsCommand = new WorkFlowModelFindByConditionsCommand(conditions);

      return (Collection)workFlowModelFindByConditionsCommand.execute();
   }
   /**
    * ��ѯģ���б�
    * @param conditions String
    * @throws SQLException
    * @throws Exception
    * @return Collection
    */
   public Collection findByModelMainConditions(String conditions) throws SQLException,Exception
   {
     SwfModelMainFindByConditionsCommand  swfModelMainFindByConditionsCommand = new SwfModelMainFindByConditionsCommand(conditions);

     return (Collection)swfModelMainFindByConditionsCommand.execute() ;

   }
   /**
    * ��ѯģ���б�
    * @param conditions String
    * @throws SQLException
    * @throws Exception
    * @return Collection
    */
   public Collection findByWfConditionConditions(String conditions) throws SQLException,Exception
   {
     SwfConditionFindByConditionsCommand  WfConditionFindByConditionsCommand = new SwfConditionFindByConditionsCommand(conditions);

     return (Collection)WfConditionFindByConditionsCommand.execute() ;

   }
   /**
    * ����ģ������
    * @param wfConditionDto WfConditionDto
    * @throws SQLException
    * @throws Exception
    */
   public void saveWfCondition(SwfConditionDto swfConditionDto) throws SQLException,Exception
   {
      SwfConditionInsertCommand swfConditionInsertCommand = new SwfConditionInsertCommand(swfConditionDto);
      swfConditionInsertCommand.execute() ;
      return ;
   }

   /**
    * ����ģ��ʹ�������Ϣ
    * @param wfModelUseDto WfModelUseDto
    * @throws SQLException
    * @throws Exception
    */
   public void saveWfModelUse(SwfModelUseDto swfModelUseDto) throws SQLException,Exception
   {
      SwfModelUseInsertCommand swfModelUseInsertCommand = new SwfModelUseInsertCommand(swfModelUseDto);
      swfModelUseInsertCommand.execute() ;
      return ;
   }

   /**
    * ��ѯģ��ʹ������б�
    * @param conditions String
    * @throws SQLException
    * @throws Exception
    * @return Collection
    */
   public Collection findByModelUseConditions(String conditions) throws SQLException,Exception
   {
     SwfModelUseFindByConditionsCommand  swfModelUseFindByConditionsCommand = new SwfModelUseFindByConditionsCommand(conditions);

     return (Collection)swfModelUseFindByConditionsCommand.execute() ;

   }
   


}
