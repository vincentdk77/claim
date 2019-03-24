package com.sinosoft.claim.ui.control.action;

import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpLreinsTrialDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.bl.action.custom.BLReinsLTrialAction;

/**
 * ���ɷ�̯��Ϣ��
 * <p>Title:���ɷ�̯��Ϣ��</p>
 * <p>Copyright:Sinosoft (c) 2005.8.15</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIReinsTrialAction {
       
        public UIReinsTrialAction (){//Ĭ�Ϲ��캯��
        
    }
        /**  
         * ���ɷ�̯��Ϣ
         * @param certiNo
         * @param claimNo
         * @throws Exception
         */
        public void simulateRepayByDangerNo(String certiNo, String claimNo) throws Exception{
                BLReinsLTrialAction blReinsLTrialAction = new BLReinsLTrialAction();
                DBManager dbManager = new DBManager();
                //����try��catch��finally�����,��֤���ݿ����������ر�
                try{
                	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
                    blReinsLTrialAction.simulateRepayByDangerNo(certiNo, dbManager);
                }catch(Exception e){
                	e.printStackTrace();
                }finally{
                	dbManager.close(); 
                }              
        }
        /**
         * ��÷�̯������
         * @param certiNo
         * @return Collection
         * @throws Exception
         */
        public Collection getDangerUnit(String certiNo,int dangerno)throws Exception{
                String condition = "certiNo = '"+certiNo+"' and dangerno="+dangerno;
                Collection dangerTrial = null;
                PrpLreinsTrialDto prpLreinsTrialDto = new PrpLreinsTrialDto();
                BLPrpLreinsTrialFacade blPrpLreinsTrialFacade = new BLPrpLreinsTrialFacade();
                dangerTrial = blPrpLreinsTrialFacade.findByConditions(condition);
                //�Ӻ�Լ����õ���Լ���
                Iterator dangerList = dangerTrial.iterator();
                double sumShare = 0;//�ܱ���
                double sumAmount = 0;//�ܽ��
                double tolSumPaid = 0;
                double tolAcceptSumPaid=0;//�ر��걨�����
                while(dangerList.hasNext()){
                        prpLreinsTrialDto =(PrpLreinsTrialDto) dangerList.next();
                        sumShare = sumShare+ prpLreinsTrialDto.getShareRate();
                        //�����sumPaid��Ϊ�գ�˵�������㻷��
                        if(prpLreinsTrialDto.getCertiType().equals("3")){
                        	prpLreinsTrialDto.setSumClaim(prpLreinsTrialDto.getSumPaid());
                        }
                        sumAmount = sumAmount + prpLreinsTrialDto.getSumClaim();
                        tolSumPaid = tolSumPaid + prpLreinsTrialDto.getSumPaid();
                        tolAcceptSumPaid=tolAcceptSumPaid+prpLreinsTrialDto.getAcceptanceSumPaid();
                        String treatyNo = prpLreinsTrialDto.getTreatyNo();
                        String treatyRef = this.findByPrimaryKey(treatyNo);
                        prpLreinsTrialDto.setDangerDesc(treatyRef);
                }
                PrpLreinsTrialDto sum = new PrpLreinsTrialDto();
                sum.setDangerDesc("�ϼ�");
                sum.setShareRate(sumShare);
                sum.setSumClaim(sumAmount);
                sum.setSumPaid(tolSumPaid);
                sum.setAcceptanceSumPaid(tolAcceptSumPaid);
                dangerTrial.add(sum);
                return dangerTrial; 
        }
        /**
         * �Ӻ�Լ�����еõ���Լ���
         * @param treatyNo
         * @return ��Լ���ļ��
         * @throws Exception
         */
        public String findByPrimaryKey(String treatyNo)throws Exception{
                BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
                FhTreatyDto fhTreatyDto = new FhTreatyDto();
                fhTreatyDto = blFhTreatyFacade.findByPrimaryKey(treatyNo);
                return fhTreatyDto.getRefNo();
        }       
}
