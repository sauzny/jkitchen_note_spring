
function api_map(){
	return {
		login : "api/passport/login?t="+ (new Date().getTime()),
		isLogin : "api/passport/isLogin?t="+ (new Date().getTime()),
		logout : "api/passport/logout?t="+ (new Date().getTime()),
		updatePassword : "api/users/updatePassword?t="+ (new Date().getTime()),
		usersPage : "api/users/page"
	}
}

function api_post(options){
	var options = {
		type : 'POST',
		contentType : "application/json; charset=utf-8", 
		dataType: "json",
		loadingmask: true,
		url : options.url,
		headers : options.headers,
		data : options.data,
		okCallback : options.okCallback,
		errCallback : options.errCallback,
		failCallback : options.failCallback,
		success : options.success,
		error : options.error
	};

	if(options.okCallback){
		BJUI.ajax('doajax', options);
	}else{
		api_ajax(options);
	}
}

function api_put(options){
	var options = {
		type : 'PUT',
		contentType : "application/json; charset=utf-8", 
		dataType: "json",
		loadingmask: true,
		url : options.url,
		headers : options.headers,
		data : options.data,
		okCallback : options.okCallback,
		errCallback : options.errCallback,
		failCallback : options.failCallback,
		success : options.success,
		error : options.error
	};
	
	if(options.okCallback){
		BJUI.ajax('doajax', options);
	}else{
		api_ajax(options);
	}
}

function api_get(options){
	var options = {
		type : 'GET',
		contentType : "application/json; charset=utf-8", 
		dataType: "json",
		loadingmask: true,
		url : options.url,
		headers : options.headers,
		data : options.data,
		okCallback : options.okCallback,
		errCallback : options.errCallback,
		failCallback : options.failCallback,
		success : options.success,
		error : options.error
	};
	
	if(options.okCallback){
		BJUI.ajax('doajax', options);
	}else{
		api_ajax(options);
	}
}

function api_ajax(options){
	$.ajax({
		url: options.url,
		type: options.type,
		contentType : options.contentType,
		dataType: options.dataType,
		headers : options.headers,
		data: options.data,
		success: options.success,
		error : options.error
	});
}