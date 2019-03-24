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
 * 生成分摊信息；
 * <p>Title:生成分摊信息；</p>
 * <p>Copyright:Sinosoft (c) 2005.8.15</p>
 * @author qinyongli
 * @version 1.0
 */
public class UIReinsTrialAction {
       
        public UIReinsTrialAction (){//默认构造函数
        
    }
        /**  
         * 生成分摊信息
         * @param certiNo
         * @param claimNo
         * @throws Exception
         */
        public void simulateRepayByDangerNo(String certiNo, String claimNo) throws Exception{
                BLReinsLTrialAction blReinsLTrialAction = new BLReinsLTrialAction();
                DBManager dbManager = new DBManager();
                //增加try、catch、finally代码段,保证数据库连接正常关闭
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
         * 获得分摊试算结果
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
                //从合约主表得到合约简称
                Iterator dangerList = dangerTrial.iterator();
                double sumShare = 0;//总比例
                double sumAmount = 0;//总金额
                double tolSumPaid = 0;
                double tolAcceptSumPaid=0;//特别申报总赔款
                while(dangerList.hasNext()){
                        prpLreinsTrialDto =(PrpLreinsTrialDto) dangerList.next();
                        sumShare = sumShare+ prpLreinsTrialDto.getShareRate();
                        //如果，sumPaid不为空，说明是理算环节
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
                sum.setDangerDesc("合计");
                sum.setShareRate(sumShare);
                sum.setSumClaim(sumAmount);
                sum.setSumPaid(tolSumPaid);
                sum.setAcceptanceSumPaid(tolAcceptSumPaid);
                dangerTrial.add(sum);
                return dangerTrial; 
        }
        /**
         * 从合约主表中得到合约简称
         * @param treatyNo
         * @return 合约中文简称
         * @throws Exception
         */
        public String findByPrimaryKey(String treatyNo)throws Exception{
                BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
                FhTreatyDto fhTreatyDto = new FhTreatyDto();
                fhTreatyDto = blFhTreatyFacade.findByPrimaryKey(treatyNo);
                return fhTreatyDto.getRefNo();
        }       
}
