/**
 * 微信js-sdk工具调用方法集合
 */
var Weixin = {
	/**
	 * 微信支付,使用js-sdk 进行支付
	 */
	pay : function(data) {
		 wx.config({
			debug : false,// 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			appId : data.jsapiPayRequest.appId, // 必填，公众号的唯一标识
			timestamp : data.weixinConfigRequest.timestamp, // 必填，生成签名的时间戳
			nonceStr : data.weixinConfigRequest.noncestr, // 必填，生成签名的随机串
			signature : data.weixinConfigRequest.signature,// 必填，签名，见附录1
			jsApiList : [ 'chooseWXPay','onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone' ]
		// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
		// wx.ready(function() {
		wx.chooseWXPay({
			timestamp : data.jsapiPayRequest.timeStamp, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
			nonceStr : data.jsapiPayRequest.nonceStr, // 支付签名随机串，不长于32 位
			'package' : data.jsapiPayRequest._package, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
			signType : 'MD5', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
			paySign : data.jsapiPayRequest.paySign, // 支付签名
			// 通用属性errMsg，其值格式如下：
			// 调用成功时："xxx:ok" ，其中xxx为调用的接口名
			// 用户取消时："xxx:cancel"，其中xxx为调用的接口名
			// 调用失败时：其值为具体错误信息
			success : function(res) {
				// 支付成功后的回调函数
				// alert(res.error_msg);
				//alert('success:' + res.error_msg);
				location.href=data.successRedirectUrl;
			},
			fail : function(res) {
				// 接口调用失败时执行的回调函数。
				//alert('fail:' + res.error_msg);
				location.href=data.failRedirectUrl;
			},
			complete : function(res) {
				// 接口调用完成时执行的回调函数，无论成功或失败都会执行
				//alert('complete:' + res.error_msg);
			},
			cancel : function(res) {
				// 用户点击取消时的回调函数，仅部分有用户取消操作的api才会用到。
				//alert('cancel:' + res.error_msg);
				location.href=data.cancelRedirectUrl;
			}
		});
	},
	/**
	*微信分享
	*/
	share:function(data){
       Weixin.config(data);
       /**
		*分享到朋友圈
		*/
		//alert('Title:'+data.title+",link:"+data.link+",imgUrl:"+data.imgUrl);
		wx.onMenuShareTimeline({
			title:data.title,
			link:data.link,
			imgUrl:data.imgUrl,
			success:function(){
				//alert('share success.');
			},
			cancel:function(){
                //alert('cancel share.');
			}
		});
		
	},
	/**
	*微信js-sdk配置
	*/
	config:function(data){
		if(data.weixinConfigRequestObject){
       wx.config({
			debug : false,// 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
			appId : data.weixinConfigRequestObject.appId, // 必填，公众号的唯一标识
			timestamp : data.weixinConfigRequestObject.timestamp, // 必填，生成签名的时间戳
			nonceStr : data.weixinConfigRequestObject.noncestr, // 必填，生成签名的随机串
			signature : data.weixinConfigRequestObject.signature,// 必填，签名，见附录1
			jsApiList : [ 'chooseWXPay','onMenuShareTimeline','onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone' ]
		// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
		});
       }
	}
};