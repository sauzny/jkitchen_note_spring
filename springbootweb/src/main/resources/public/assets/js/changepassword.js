
function cp_init(){
    var payload = JSON.parse(CryptoJS.enc.Base64.parse(localStorage.token.split(".")[1]).toString(CryptoJS.enc.Utf8));
    $('#cp_account').text(payload.account);
    $('#cp_userName').text(payload.userName);
}

function cp_submit(){

    var payload = JSON.parse(CryptoJS.enc.Base64.parse(localStorage.token.split(".")[1]).toString(CryptoJS.enc.Utf8));
    var userId = payload.userId;
    var oldPassword = CryptoJS.SHA512($('#j_userinfo_changepass_oldpass').val()).toString();
    var newPassword = CryptoJS.SHA512($('#j_userinfo_changepass_newpass').val()).toString();

    api_put({
		url : api_map().updatePassword,
        headers:{ticket:localStorage.token},
		data : JSON.stringify({
			userId : userId,
			oldPassword : oldPassword,
			newPassword : newPassword
		}),
        okCallback: function(json, options) {
            console.log('返回内容：\n'+ JSON.stringify(json))
            
            console.log('json.closeCurrent：\n'+ json.closeCurrent)
            if(json.closeCurrent){
                $('#cp_close').click();
            }
            
        },
        errCallback: function(json, options) {
            console.log('errCallback返回内容：\n'+ JSON.stringify(json))
        },
        failCallback: function(json, options) {
            console.log('failCallback返回内容：\n'+ JSON.stringify(json))
        }
	});
	
}