/**
*说明:WeixinMenu js 脚本
*作者:@haipenge
*/
var WeixinMenu={
  init:function(){
	  /**
	   * 全选，全不选 
	   */
	  $('input[name="check-all"]').click(function(){
	    Check.onCheck($('input[name="check-all"]'),$('input[name="check-single"]'));
	  });
	  $('.multi-remove').click(function(){
		  WeixinMenu.multiRemove();
	  });
	  $('#generate-weixin-menu').click(function(){
		  WeixinMenu.generateWeixinMenu();
	  });
	  $('#delete-weixin-menu').click(function(){
		  WeixinMenu.deleteWeixinMenu();
	  });
	  $('.order-index-box').click(function(){
		  if ($(this).find('input').length == 0) {
		  WeixinMenu.onWeixinMenuOrderIndexClick(this);
		  }
	  });
	  $('input[name="orderIndex"]').blur(function(){
		  WeixinMenu.resetWeixinMenuOrderIndex(this);
	  });
	  
  },
  /**
   * 批量删除
   */
  multiRemove:function(){
	  var checkedIds=Check.getCheckedIds($('input[name="check-single"]'));
	  if(checkedIds!=''){
		  $.ajax({
			  url:'/weixin/weixinMenu/multiRemove',
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
   * 生成微信菜单
   */
   generateWeixinMenu:function(){
	   var accountId=$('input[name="accountId"]').val();
	   $.ajax({
		   url:'/weixin/weixinMenu/generate',
		   type:'post',
		   dataType:'json',
		   data:{
			   accountId:accountId
		   },
		   success:function(data,textStatus,xhr){
			   if(data.errcode=='0'){
				   var msg=new Msg({msg:'微信菜单创建成功,重新关注微信公众号,可刷新菜单.'});
				   msg.show();
			   }
		   }
	   });
   },
   /**
    * 删除微信菜单
    */
   deleteWeixinMenu:function(){
	   var accountId=$('input[name="accountId"]').val();
	   $.ajax({
		   url:'/weixin/weixinMenu/deleteWeixinMenu',
		   type:'post',
		   dataType:'json',
		   data:{
			   accountId:accountId
		   },
		   success:function(data,textStatus,xhr){
			   if(data.errcode=='0'){
				   var msg=new Msg({msg:'微信菜单删除成功,重新关注微信公众号,可刷新菜单.'});
				   msg.show();
			   }
		   }
	   });
   },
   /**
    * 重置菜单排序值
    */
   resetWeixinMenuOrderIndex:function(e){
	   var id=$(e).parent().parent().attr('id');
	   var orderIndex=$(e).val();
	   $.ajax({
		   url:'/weixin/weixinMenu/resetWeixinMenuOrderIndex',
		   type:'post',
		   dataType:'json',
		   data:{
			   id:id,
			   orderIndex:orderIndex
		   },
		   success:function(data,textStatus,xhr){
			   $(e).parent().empty().append(orderIndex);
		   }
	   });
   },
   onWeixinMenuOrderIndexClick:function(e){
	   var orderIndex=$(e).text();
	   var html='<input type="text" name="orderIndex"  class="form-control" value="'+orderIndex+'">';
	   $(e).empty().append(html);
	   WeixinMenu.init();
   }
};

$(document).ready(function(){
	WeixinMenu.init();
});