package com.sinosoft.servlet.accisd.services;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.servlet.accisd.bl.action.domain.BLPrpLAcciBaseInfoSDAction;
import com.sinosoft.servlet.accisd.bl.action.domain.BLPrpLAcciClaimInfoSDAction;
import com.sinosoft.servlet.accisd.dto.AcciSDRequestDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.servlet.accisd.utils.XMLHealHelper;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class AcciSDInfoPushServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String strReturn = "";
		DataInputStream input = null;
		BufferedOutputStream output = null;
		try {
			//获取接收对象
			input = new DataInputStream(req.getInputStream());
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			byte[] data = null;
			byte[] b = new byte[1024];
			int read = 0;
			//转换数据流
			while ((read = input.read(b)) !=-1) {
				byteOut.write(b, 0, read);
			}
			data = byteOut.toByteArray();
			//接收完毕
			input.close();
			String strData = new String(data);
			// 解析数据并保存
			this.transData(strData);
			String returnXml = "<?xml version=\"1.0\" encoding=\"GBK\"?>     "+
					"<Packet type=\"RESPONSE\" version=\"1.0\">   "+
					"	<Head>                                "+
					"		<RequestType>T02</RequestType>    "+
					"		<ResponseCode>1</ResponseCode>    "+
					"		<ErrorCode>0000</ErrorCode>       "+
					"		<ErrorMessage>成功</ErrorMessage>  "+
					"	</Head>                               "+
					"</Packet>                                ";
			//输出成功标识
			output = new BufferedOutputStream(resp.getOutputStream());
			output.write(returnXml.getBytes());
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
			output = new BufferedOutputStream(resp.getOutputStream());
			strReturn = "<?xml version=\"1.0\" encoding=\"GBK\"?>     "+
					"<Packet type=\"RESPONSE\" version=\"1.0\">   "+
					"	<Head>                                "+
					"		<RequestType>T02</RequestType>    "+
					"		<ResponseCode>0</ResponseCode>    "+
					"		<ErrorCode>4001</ErrorCode>       "+
					"		<ErrorMessage>失败</ErrorMessage> "+
					"	</Head>                               "+
					"</Packet>                                ";
			output.write(strReturn.getBytes());
			output.close();
		}
	}
	
	private void transData(String strData) throws Exception{
		XMLHealHelper xmlHealHelper = new XMLHealHelper();
		AcciSDRequestDto acciSDRequestDto = xmlHealHelper.getAcciSDXMLToDto(strData);
		if(acciSDRequestDto != null){
			DBManager dbManager = new DBManager();
			try{
				dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				dbManager.beginTransaction();
				PrpLAcciBaseInfoSDDto prpLAcciBaseInfoSDDto = acciSDRequestDto.getPrpLAcciBaseInfoSDDto();
				if(prpLAcciBaseInfoSDDto != null ){
					BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
					blPrplaccibaseinfosdAction.delete(dbManager,prpLAcciBaseInfoSDDto.getName(),prpLAcciBaseInfoSDDto.getCredentialType(),prpLAcciBaseInfoSDDto.getCredentialNo());
					blPrplaccibaseinfosdAction.insert(dbManager, prpLAcciBaseInfoSDDto);
				}
				List<PrpLAcciClaimInfoSDDto> prpLAcciClaimInfoSDDtoList = acciSDRequestDto.getPrpLAcciClaimInfoSDDtoList();
				if(prpLAcciClaimInfoSDDtoList != null && prpLAcciClaimInfoSDDtoList.size()>0){
					BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
					for (PrpLAcciClaimInfoSDDto prpLAcciClaimInfoSDDto : prpLAcciClaimInfoSDDtoList) {
						blPrplacciclaiminfosdAction.delete(dbManager,prpLAcciClaimInfoSDDto.getName(),prpLAcciClaimInfoSDDto.getCredentialType(),prpLAcciClaimInfoSDDto.getCredentialNo(),prpLAcciClaimInfoSDDto.getClaimNo());
						blPrplacciclaiminfosdAction.insert(dbManager,prpLAcciClaimInfoSDDto);
					}
				}
				dbManager.commitTransaction();
			}catch(Exception e){
				dbManager.rollbackTransaction();
				e.printStackTrace();
			}finally{
				dbManager.close();
			}
		}
	}
}
