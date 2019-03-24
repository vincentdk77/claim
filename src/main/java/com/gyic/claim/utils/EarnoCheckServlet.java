package com.gyic.claim.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.gyic.claim.utils.Utils;

public class EarnoCheckServlet extends HttpServlet {

	/**
	 * @author 张菊卿
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.setContentType("text/xml;charset=GB2312");
		resp.setContentType("text/xml;charset=UTF-8");
		resp.setHeader("Cache-Control", "no—cache");
		Document dom = DocumentHelper.createDocument();
		Element root = dom.addElement("prpLEarListDto");
		//Element insureMainListEle = root.addElement("insureMainList");
		//Element herdInsuranceListEle = root.addElement("herdInsuranceList");

		// start耳标号真实性判断addby 张菊卿
		String prpLpropPolicyNo = req.getParameter("policyno");
		String prpLCompensateEarno = req.getParameter("earno");
		String kindCode = req.getParameter("kindCode");
		String strDamageDate = req.getParameter("DamageStartDate");
		String strDamageHour = req.getParameter("DamageStartHour");
		PrintWriter out = resp.getWriter();
		try {
			if (prpLpropPolicyNo == null || prpLCompensateEarno == null|| kindCode == null|| strDamageDate == null|| strDamageHour == null)
				throw new UserException(1, 3, "参数不得为空", "");
			if (prpLpropPolicyNo.equals("") || prpLCompensateEarno.equals("") || kindCode.equals("") || strDamageDate.equals("") || strDamageHour.equals(""))
				throw new UserException(1, 3, "参数不得为空", "");
			ArrayList herdpolicylist = (ArrayList) Utils
					.findEndorseHerdpolicylist(prpLpropPolicyNo, prpLCompensateEarno, kindCode, strDamageDate, strDamageHour);
			if (herdpolicylist == null || herdpolicylist.size() != 3) 
				throw new UserException(1,3,"保单号:" + prpLpropPolicyNo + "查询结果异常");
			ArrayList insuremainlistDtoList = (ArrayList) herdpolicylist.get(0);
			ArrayList herdpolicylistDtoList = (ArrayList) herdpolicylist.get(1);
			ArrayList herdEndorsepolicylistDtoList = (ArrayList) herdpolicylist.get(2);
			if (insuremainlistDtoList != null && insuremainlistDtoList.size() == 1) {
				Element insureMainListEle = root.addElement("insureMainList");
				Element temp = insureMainListEle.addElement("Inusrelistcode");
				temp.addText(((InsuremainlistDto)insuremainlistDtoList.get(0)).getInusrelistcode());
			}
			
			if(herdpolicylistDtoList != null && herdpolicylistDtoList.size() == 1){
				HerdpolicylistDto herdPolicyListDto = (HerdpolicylistDto) herdpolicylistDtoList.get(0);
				if(herdPolicyListDto != null && "1".equals(herdPolicyListDto.getValidity()) && herdPolicyListDto.getSumamount() > 0 ){
					if(herdEndorsepolicylistDtoList != null && herdEndorsepolicylistDtoList.size() == 1){
						HerdpolicylistDto herdEndorsePolicyListDto = (HerdpolicylistDto) herdEndorsepolicylistDtoList.get(0);
					if(herdEndorsePolicyListDto != null && "1".equals(herdEndorsePolicyListDto.getValidity())){
						Element herdPolicyListEle = root.addElement("herdPolicyList");
						Element temp;
						
						
						temp = herdPolicyListEle.addElement("Earlabel");
						temp.addText(herdEndorsePolicyListDto.getEarlabel());
						temp = herdPolicyListEle.addElement("Fcode");
						temp.addText(herdEndorsePolicyListDto.getFcode());
						temp = herdPolicyListEle.addElement("Fname");
						temp.addText(herdEndorsePolicyListDto.getFname());
						temp = herdPolicyListEle.addElement("Fidcard");
						temp.addText(herdEndorsePolicyListDto.getFidcard());
						temp = herdPolicyListEle.addElement("BREEDINGNUMBER");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getBreedingnumber()));
						temp = herdPolicyListEle.addElement("Breedingareacode");
						temp.addText(herdEndorsePolicyListDto.getBreedingareacode());
						temp = herdPolicyListEle.addElement("BREEDINGAREANAME");
						temp.addText(herdEndorsePolicyListDto.getBreedingareaname());
						temp = herdPolicyListEle.addElement("Insurenumber");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getInsurenumber()));
						temp = herdPolicyListEle.addElement("Remark");
						temp.addText(herdEndorsePolicyListDto.getRemark());
						temp = herdPolicyListEle.addElement("Validity");
						temp.addText(herdEndorsePolicyListDto.getValidity());
						temp = herdPolicyListEle.addElement("STARTTIME");
						temp.addText(herdEndorsePolicyListDto.getStarttime());
						temp = herdPolicyListEle.addElement("ENDTIME");
						temp.addText(herdEndorsePolicyListDto.getEndtime());
						temp = herdPolicyListEle.addElement("PHONE");
						temp.addText(herdEndorsePolicyListDto.getPhone());
						temp = herdPolicyListEle.addElement("Opcode");
						temp.addText(herdEndorsePolicyListDto.getOpcode());
						temp = herdPolicyListEle.addElement("OPTIME");
						if(herdEndorsePolicyListDto.getOptime() != null)
							temp.addText(String.valueOf(herdEndorsePolicyListDto.getOptime().toString()));
							else temp.addText("");
						temp = herdPolicyListEle.addElement("SETTLENUMBER");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getSettlenumber()));
						temp = herdPolicyListEle.addElement("Species");
						temp.addText(herdEndorsePolicyListDto.getSpecies());
						temp = herdPolicyListEle.addElement("Bank");
						temp.addText(herdEndorsePolicyListDto.getBank());
						temp = herdPolicyListEle.addElement("Bankcard");
						temp.addText(herdEndorsePolicyListDto.getBankcard());
						temp = herdPolicyListEle.addElement("Kindcode");
						temp.addText(herdEndorsePolicyListDto.getKindcode());
						temp = herdPolicyListEle.addElement("Indexcode");
						temp.addText(herdEndorsePolicyListDto.getIndexcode());
						temp = herdPolicyListEle.addElement("Breedingkind");
						temp.addText(herdEndorsePolicyListDto.getBreedingkind());
						temp = herdPolicyListEle.addElement("Amount");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getAmount()));
						temp = herdPolicyListEle.addElement("Rate");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getRate()));
						temp = herdPolicyListEle.addElement("Shortrateflag");
						temp.addText(herdEndorsePolicyListDto.getShortrateflag());
						temp = herdPolicyListEle.addElement("Shortrate");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getShortrate()));
						temp = herdPolicyListEle.addElement("Sumamount");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getSumamount()));
						temp = herdPolicyListEle.addElement("Sumpremium");
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getSumpremium()));
						temp = herdPolicyListEle.addElement("STARTDATE");
						if(herdEndorsePolicyListDto.getStartdate() != null)
						temp.addText(String.valueOf(herdEndorsePolicyListDto.getStartdate().toString()));
						else temp.addText("");
						temp = herdPolicyListEle.addElement("ENDDATE");
						if(herdEndorsePolicyListDto.getEnddate() != null)
							temp.addText(String.valueOf(herdEndorsePolicyListDto.getEnddate().toString()));
							else temp.addText("");
						temp = herdPolicyListEle.addElement("Calculateflag");
						temp.addText(herdEndorsePolicyListDto.getCalculateflag());
						temp = herdPolicyListEle.addElement("Inusrelistcode");
						temp.addText(herdEndorsePolicyListDto.getInusrelistcode());
					}
					}
				}
			}
			
			
		
		} catch (UserException e) {
			Element exception = root.addElement("userException");
			Element temp;
			temp = exception.addElement("CLASSNAME");
			temp.addText(e.getClass().getName());
			temp = exception.addElement("ErrorCatalog");
			temp.addText(String.valueOf(e.getErrorCatalog()));
			temp = exception.addElement("ErrorNo");
			temp.addText(String.valueOf(e.getErrorNo()));
			temp = exception.addElement("ErrorModule");
			temp.addText(e.getErrorModule());
			temp = exception.addElement("ErrorMessage");
			temp.addText(e.getErrorMessage());
			e.printStackTrace();
		}  catch (Exception e) {
			Element exception = root.addElement("exception");
			Element temp;
			temp = exception.addElement("CLASSNAME");
			temp.addText(e.getClass().getName());
			temp = exception.addElement("ErrorMessage");
			temp.addText(String.valueOf(e.getMessage()));
			temp = exception.addElement("Cause");
			temp.addText(String.valueOf(e.getCause()));
			temp = exception.addElement("StackTrace");
			temp.addText(String.valueOf(e.getStackTrace()));
			e.printStackTrace();
		}finally {
			//System.out.print(dom.asXML());
			out.flush();
			out.write(dom.asXML());
			out.close();
		}
	}

}
