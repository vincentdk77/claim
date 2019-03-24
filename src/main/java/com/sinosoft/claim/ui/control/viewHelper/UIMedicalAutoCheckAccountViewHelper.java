package com.sinosoft.claim.ui.control.viewHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterPayBackDetailFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.newreport.util.tool.FTPTools;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * �Զ�������
 * ��ȡ�������ݣ�������д���Ե�ǰ����������.txt�ļ��У��ٽ�����д�õ��ļ��ϴ���FTP�ϵ��Ե�ǰ�·��������ļ�����
 * */
public class UIMedicalAutoCheckAccountViewHelper {
	
	public void autoCheckAccount(String startDate,String endDate) throws Exception{
		String endTime = "";
		String startTime = "";
		String fileName = "";
		String pathName = "";
		String regex = "([1][7-9][0-9][0-9]|[2][0][0-9][0-9])-([0][1-9]|[1][0-2])-([0-2][1-9]|[3][0-1])";
		
		if(startDate!=null && !"".equals(startDate)){
			if(startDate.matches(regex)){
				startTime = startDate + " 00:00:00";
				fileName = startDate;
				String year = startDate.substring(0, 4);
				String month = startDate.substring(5, 7);
				int day = Integer.parseInt(startDate.substring(8)) + 1;
				pathName = year + month;
				if(endDate!=null && !"".equals(endDate)){
					if(endDate.matches(regex)){
						endTime = endDate + " 00:00:00";
					}else{
						endTime = year+"-"+month+"-"+day+" 00:00:00";
					}
				}else{
					endTime = year+"-"+month+"-"+day+" 00:00:00";
				}
			}
		}else{
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			endTime = sdf.format(c.getTime());
			c.add(Calendar.DAY_OF_YEAR, -1);
			startTime = sdf.format(c.getTime());
			SimpleDateFormat filesdf = new SimpleDateFormat("yyyy-MM-dd");
			fileName = filesdf.format(c.getTime());
			SimpleDateFormat pathsdf = new SimpleDateFormat("yyyyMM");
			pathName = pathsdf.format(c.getTime());
		}

		try {
			
			/**-------------------------------------��ȡ�������ݿ�ʼ--------------------------------------------*/
			String condition = " inputdate >= to_date('" +startTime+"','yyyy-MM-dd HH24:MI:SS')" +
			" and inputdate < to_date('" +endTime+"', 'yyyy-MM-dd HH24:MI:SS')";
			//��ȡ����ӿڽ�������
			BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
			int countClaim = 0;
			Collection collectionClaim = blPrpLinterRequestFacade.findByConditions(condition);
			if(collectionClaim!=null && collectionClaim.size()>0){
				countClaim = collectionClaim.size();
			}
			String[] claimArray = null;
			if(countClaim > 0){
				claimArray = new String[collectionClaim.size()];
				Iterator it = collectionClaim.iterator();
				int i = 0;
				PrpLinterRequestDto prpLinterRequestDto = null;
				while(it.hasNext()){
					prpLinterRequestDto = (PrpLinterRequestDto)it.next();
					claimArray[i++] = "CLAIM|"+prpLinterRequestDto.getOutId()+"|"+prpLinterRequestDto.getInputDate()+"|"+prpLinterRequestDto.getMutualFlag();
				}
			}
			
			//��ȡ����ע����������
			BLPrpLinterCancelClaimRequestFacade blPrplinterCancelClaimRequestFacade = new BLPrpLinterCancelClaimRequestFacade();
			int countCancelClaim = 0;
			Collection collectionCancelClaim = blPrplinterCancelClaimRequestFacade.findByConditions(condition);
			if(collectionCancelClaim!=null && collectionCancelClaim.size()>0){
				countCancelClaim = collectionCancelClaim.size();
			}
			String[] cancelClaimArray = null;
			if(countCancelClaim > 0){
				cancelClaimArray = new String[collectionCancelClaim.size()];
				Iterator it = collectionCancelClaim.iterator();
				int i = 0;
				PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
				while(it.hasNext()){
					prpLinterCancelClaimRequestDto = (PrpLinterCancelClaimRequestDto)it.next();
					cancelClaimArray[i++] = "CANCEL|"+prpLinterCancelClaimRequestDto.getOutId()+"|"+prpLinterCancelClaimRequestDto.getInputDate()+"|"+"1";
				}
			}
			
			//��ȡ�ؿ��ⰸ��������
			BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
			int countRecase = 0;
			Collection collectionRecase = blPrpLinterRecaseRequestFacade.findByConditions(condition);
			if(collectionRecase!=null && collectionRecase.size()>0){
				countRecase = collectionRecase.size();
			}
			String[] recaseArray = null;
			if(countRecase > 0){
				recaseArray = new String[countRecase];
				Iterator it = collectionRecase.iterator();
				int i = 0;
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
				while(it.hasNext()){
					prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)it.next();
					recaseArray[i++] = "RECASE|"+prpLinterRecaseRequestDto.getOutId()+"|"+prpLinterRecaseRequestDto.getInputDate()+"|"+"1";
				}
			}
			
			//��ȡ����֧����������
			double payAmount = 0.0;
			BLPrpLinterPayRequestFacade blPrpLinterPayRequestFacade = new BLPrpLinterPayRequestFacade();
			int countPay = 0;
			Collection collectionPay = blPrpLinterPayRequestFacade.findByConditionsWithChild(condition);
			if(collectionPay!=null && collectionPay.size()>0){
				countPay = collectionPay.size();
			}
			String[] payArray = null;
			if(countPay > 0){
				payArray = new String[collectionPay.size()];
				Iterator it = collectionPay.iterator();
				int i = 0;
				PrpLinterPayRequestDto prpLinterPayRequestDto = null;
				while(it.hasNext()){
					double thisPayAmount = 0.0;
					prpLinterPayRequestDto = (PrpLinterPayRequestDto)it.next();
					PrpLinterPaymentInfoDto[] prpLinterPaymentInfoDtos = prpLinterPayRequestDto.getPrpLinterPaymentInfoDto();
					if(prpLinterPaymentInfoDtos!=null && prpLinterPaymentInfoDtos.length>0){
						for(int k=0;k<prpLinterPaymentInfoDtos.length;k++){
							thisPayAmount += prpLinterPaymentInfoDtos[k].getPaidPay();
						}
					}
					payArray[i++] = "PAY|"+prpLinterPayRequestDto.getOutId()+"|"+prpLinterPayRequestDto.getOperateType()+"|"
							+prpLinterPayRequestDto.getInputDate()+"|"+"1"+"|"+thisPayAmount;
					payAmount += thisPayAmount;
				}
			}
			
			//��ȡ֧���˻ؽ�����Ϣ
			BLPrplinterPayBackDetailFacade blPrplinterPayBackDetailFacade = new BLPrplinterPayBackDetailFacade();
			int countPayBack = 0;
			Collection collectionPayBackDetail = blPrplinterPayBackDetailFacade.findByConditions(condition);
			if(collectionPayBackDetail!=null && collectionPayBackDetail.size()>0){
				countPayBack = collectionPayBackDetail.size();
			}
			String[] payBackArray = null;
			if(countPayBack > 0){
				payBackArray = new String[countPayBack];
				Iterator it = collectionPayBackDetail.iterator();
				int i = 0;
				PrplinterPayBackDetailDto prplinterPayBackDetailDto = null;
				while(it.hasNext()){
					prplinterPayBackDetailDto = (PrplinterPayBackDetailDto)it.next();
					payBackArray[i++] = "PAYBACK|"+prplinterPayBackDetailDto.getOutId()+"|"+prplinterPayBackDetailDto.getInputDate()
							+"|"+prplinterPayBackDetailDto.getSaveSuccFlag();
				}
			}
			
			String checkAccount = countClaim+"|"+countCancelClaim+"|"+countRecase+"|"+countPay+"|"+payAmount+"|"+countPayBack;
			/**----------------------------------------��ȡ�������ݽ���-------------------------------------------*/
			
			//ƴ��
			String[] uploadArray = new String[countClaim+countCancelClaim+countRecase+countPay+countPayBack+1];
			uploadArray[0] = checkAccount;
			for(int i=1;i<countClaim+1;i++){
				uploadArray[i] = claimArray[i-1];
			}
			for(int i=countClaim+1;i<countClaim+1+countCancelClaim;i++){
				uploadArray[i] = cancelClaimArray[i-countClaim-1];
			}
			for(int i=countClaim+1+countCancelClaim;i<countClaim+1+countCancelClaim+countRecase;i++){
				uploadArray[i] = recaseArray[i-countClaim-1-countCancelClaim];
			}
			for(int i=countClaim+1+countCancelClaim+countRecase;i<countClaim+1+countCancelClaim+countRecase+countPay;i++){
				uploadArray[i] = payArray[i-countClaim-1-countCancelClaim-countRecase];
			}
			for(int i=countClaim+1+countCancelClaim+countRecase+countPay;i<countClaim+1+countCancelClaim+countRecase+countPay+countPayBack;i++){
				uploadArray[i] = payBackArray[i-countClaim-1-countCancelClaim-countRecase-countPay];
			}
			
			//�����ϴ�����
			this.uploadFile(fileName, pathName, uploadArray);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	/**
	 * ����ȡ���Ķ�������д�뵽�Ե�ǰ����������.txt�ļ���
	 * */
	public void uploadFile(String fileName,String pathName,String[] uploadArray) throws Exception{
		try {
			/**����ȡ���Ķ�������д�뵽�Ե�ǰ����������.txt�ļ���*/
			String uploadPath = UIMedicalAutoCheckAccountViewHelper.class.getClassLoader().getResource("/").getPath()+File.separator+"temp";//�ϴ�·��
			File file = new File(uploadPath+File.separator+fileName+".txt"); //���ϴ�·���ϴ���һ���ı��ļ�����ΪfileName������
			//��FileOutputSteam��װ�ļ����������ļ���׷��
			OutputStream out = new FileOutputStream(file,true);
			//���ļ���д������
			if(uploadArray !=null){
				for(int i=0;i<uploadArray.length;i++){
					out.write(uploadArray[i].getBytes()); //���ļ���д������
					out.write('\r'); // \r\n��ʾ����
					out.write('\n'); 
				}
			}
			out.close();//�ر������
			
			/**������д�õ��ļ��ϴ���FTP�ϵ��Ե�ǰ�·��������ļ�����*/
			String ftpFilePath = "";
			try {
				String url = AppConfig.get("sysconst.CHECKACCOUNT_UPLOAD_URL");
				int port = Integer.parseInt(AppConfig.get("sysconst.CHECKACCOUNT_UPLOAD_PORT"));
				String userName = AppConfig.get("sysconst.CHECKACCOUNT_UPLOAD_USERNAME");
				String password = AppConfig.get("sysconst.CHECKACCOUNT_UPLOAD_PASSWORD");
				String address = AppConfig.get("sysconst.CHECKACCOUNT_UPLOAD_ADDRESS");
				String path = address+pathName;
				InputStream input = new FileInputStream(new File(uploadPath+"/"+fileName+".txt"));
				ftpFilePath = path+File.separator+fileName+".txt";
				if(!FTPTools.uploadFile(url, port, userName, password, path, fileName+".txt", input)){
					throw new Exception();
				}
			} catch (Exception e){
				e.printStackTrace();
				throw new Exception("�ϴ�FTPʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}

}
