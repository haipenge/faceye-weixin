/**
*说明:Account js 脚本
*作者:@haipenge
*/
var Account={
  init:function(){
	  /**
	   * 全选，全不选 
	   */
	  $('input[name="check-all"]').click(function(){
	    Check.onCheck($('input[name="check-all"]'),$('input[name="check-single"]'));
	  });
	  $('.multi-remove').click(function(){
		  Account.multiRemove();
	  });
	  /**
	   * 刷新Token
	   */
	  $('#refresh-token').click(function(){
		  var accountId=$('input[name="accountId"]').val();
		  Account.refreshToken(accountId);
	  });
	  
  },
  /**
   * 批量删除
   */
  multiRemove:function(){
	  var checkedIds=Check.getCheckedIds($('input[name="check-single"]'));
	  if(checkedIds!=''){
		  $.ajax({
			  url:'/weixin/account/multiRemove',
			  type:'post',
			  dataType:'json',
			  data:{
				  ids:checkedIds
			  },
			  success:function(data,textStatux,xhr){
				  var msg=new Msg({msg:'数据删除成功'});
				  var idArray=checkedIds.split(',');
				  for(var i=0;i<idArray.length;i++){
					  $('#'+idArray[i]).remove();
				  }
				  msg.show();
			  }
		  });
	  }else{
		  var msg=new Msg({msg:'请选择要删除的数据',type:'warning'});
		  msg.show();
	  }
  },
  /**
   * 刷新Token
   */
  refreshToken:function(accountId){
	  $.ajax({
		  url:'/weixin/account/refreshAccessToken',
		  data:{
			  id:accountId
		  },
		  type:'post',
		  dataType:'json',
		  success:function(data,textStatus,xhr){
			  if(data.access_token){
				  var msg=new Msg({msg:'刷新成功!'});
				  msg.show();
			  }
		  }
	  });
  }
};

$(document).ready(function(){
	Account.init();
});