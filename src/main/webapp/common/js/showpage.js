function showPage(img,spanID){
  if(spanID.style.display=="")
  {
   //关闭
    spanID.style.display="none";
    img.src="/claim/images/butCollapseBlue.gif";
  }
  else
  {
   //展开
    spanID.style.display="";
    img.src="/claim/images/butExpandBlue.gif";
  }
}




//选中计算书触发时间
function setCheckFlag(index)
{
  if(fm.check.length == null)
      {
        if(fm.check.checked)
        {
        fm.CheckFlag.value = "Y";
        }else{
        fm.CheckFlag.value = "N";
        }
      }else{
  if(fm.check[index].checked == true)
  {
    fm.CheckFlag[index].value = "Y";
  }
  else if(fm.check[index].checked == false)
  {
    fm.CheckFlag[index].value = "N" ;
  }
}
}

//删除理算触发时间函数
function deleteLS()
{
  fm.deleteFlag.value = '1';
  doing.style.visibility="visible";
  fm.deleteButton.disabled = true;	
  fm.submit();
}    


