<%@ page contentType="text/html; charset=GBK"%>
   <table   cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8"  class="common">
     <tr ondblclick="showPage(RegistExtImg,top3)">

				<td  colspan="4" class="tabletitle">
					<div style="padding-left: 3px">
						<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif"
							name="RegistExtImg" id="RegistExtImg"
							onclick="showPage(this,top3)">
						<span>投诉处理</span>
					</div>
				</td>
			</tr>
			
			<tbody id="top3">
			
      <tr>
        <td class='title w15 textr' style="width: 20%" >处理意见：</td>
         <td colspan="3"> 
               <textarea rows="4" style="width: 95%"  onchange="textareaValue(this)" <c:if test="${nodeTypes eq 'compl'}">disabled="disabled"</c:if> >${prplcomplaintDto.complaintopinion}</textarea><font color="red">*</font>
               <input type="hidden" name="complaintopinion" class="" cname="处理意见" ccname="处理意见" cmax="1000" style="width: 95%" value="${prplcomplaintDto.complaintopinion}"> 
         </td>
        </tr>
   	<tr>
   	  <td class='title w15 textr' >
					处理人员：
				</td>
				<td class='input'  style="width: 30%">
					${prplcomplaintDto.transactorname}
					<input  type="hidden" name="transactorname" id="transactorname" value="${prplcomplaintDto.transactorname}" class="query">
					<input  type="hidden" name="transactorcode" id="transactorcode" value="${prplcomplaintDto.transactorcode}" class="query">
				</td>
	    <td class='title w15 textr' style="width: 20%">
					完成时间：
				</td>
				<td class='input' >
					${prplcomplaintDto.transactordate}
					<input type="hidden" name="transactordate" id="transactordate" value="${prplcomplaintDto.transactordate}" class="query">
				</td>
   	</tr>
       
       </tbody>
       </table>
       
 

