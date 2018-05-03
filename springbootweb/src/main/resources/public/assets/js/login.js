function isLogin(token){
	api_get({
		url : api_map().isLogin,
		headers : {"token":token},
		success : function(data) {  
			if(data.status == 0){
				location.href = 'main.html'
			}
		}
	});
}

function login_login_form_submit(){

	// 账号密码验证码
	var account = $("#j_username").val();
	var password = $("#j_password").val();
	var salt = $("#j_captcha").val();

	var issubmit = true;
	var i_index  = 0;
	$(this).find('.form-control').each(function(i){
		if ($.trim($(this).val()).length == 0) {
			$(this).css('border', '1px #ff0000 solid');
			issubmit = false;
			if (i_index == 0)
			i_index  = i;
		}
	});
	if (!issubmit) {
		$(this).find('.form-control').eq(i_index).focus();
		return false;
	}
	
	$("#login_ok").attr("disabled", true).val('登陆中..');

	/*
	var key = CryptoJS.enc.Base64.parse($("#j_randomKey").val());
	var iv = CryptoJS.enc.Latin1.parse('0102030405060708');
	var password = CryptoJS.AES.encrypt($("#j_password").val(), key, {iv:iv, mode:CryptoJS.mode.CBC, padding:CryptoJS.pad.Pkcs7 });
	
	$("#j_password").val(password)
	*/
	
	//return true;
	
	//location.href = 'index.html'
	var passwordSha512 = CryptoJS.SHA512(password).toString();
	$("#j_password").val(passwordSha512);

	api_post({
		url : api_map().login,
		//headers : options.headers,
		data : JSON.stringify({
			account:account,
			password:passwordSha512,
			salt:salt
		}),
		success : function(data) {  
			if(data.status == 0 && data.entity != null && data.entity != undefined && data.entity != ""){
				localStorage.token = data.entity;
				rememberme(account);
				location.href = 'main.html'
			}else{
				$("#login_msg").text(data.message);
				$("#j_password").val('');
				$("#j_password").focus();
				$("#j_captcha").val('');
    			changeCode();
				$("#login_ok").attr("disabled", false).val('登录');
			}
		}
	});

	return false;
}


function rememberme(account){
    var $remember = $("#j_remember");
    if ($remember.attr('checked')) {
        localStorage.account = account;
    } else {
        localStorage.account = '';
    }
}