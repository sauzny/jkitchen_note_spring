
function logout(){
	// 清除token
	localStorage.token = '';
	location.href = 'login.html'
}