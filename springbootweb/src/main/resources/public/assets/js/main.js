function menu1(){
	alert("menu1");
	return JSON.stringify(
		[
		    {"name":"表单相关", "children":[
		        {"id":"base-button", "name":"按钮", "target":"navtab", "url":"html/form/button.html"},
		        {"id":"base-input", "name":"文本框", "target":"navtab", "url":"html/form/input.html"},
		        {"id":"base-select", "name":"下拉选择框", "target":"navtab", "url":"html/form/select.html"},
		        {"id":"base-checkbox", "name":"单选、复选框", "target":"navtab", "url":"html/form/checkbox.html"},
		        {"id":"base-datepicker", "name":"日期选择器", "target":"navtab", "url":"html/form/datepicker.html"},
		        {"id":"base-tags", "name":"Tags、自动完成", "target":"navtab", "url":"html/form/tags.html"},
		        {"id":"base-suggest", "name":"Suggest", "target":"navtab", "url":"html/form/suggest.html"},
		        {"id":"base-findgrid", "name":"FindGrid", "target":"navtab", "url":"html/form/findgrid.html"},
		        {"id":"base-spinner", "name":"Spinner", "target":"navtab", "url":"html/form/spinner.html"}
		    ]},
		    {"name":"综合应用", "children":[
		        {"id":"base-demo-form", "name":"表单示例", "target":"navtab", "url":"html/form/form.html"}
		    ]}
		]
	);
}

function logout(){
	
}