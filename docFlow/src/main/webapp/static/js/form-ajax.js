/**
 * 表单ajax提交绑定
 * by denglei
 */

//为jquery添加serializeObject方法
(function($){
	$.fn.serializeObject = function () {
		"use strict";

		var result = {};
		var extend = function (i, element) {
			var node = result[element.name];

	// If node with same name exists already, need to convert it to an array as it
	// is a multi-value field (i.e., checkboxes)

			if ('undefined' !== typeof node && node !== null) {
				if ($.isArray(node)) {
					node.push(element.value);
				} else {
					result[element.name] = [node, element.value];
				}
			} else {
				result[element.name] = element.value;
			}
		};

		$.each(this.serializeArray(), extend);
		return result;
	};
})(jQuery);

$(function(){
	$('form[form-ajax]').submit(function(){
		try{
			var $form = $(this),
			url = $form.attr('action'),
			method = $form.attr('method') || 'POST',
			success=$form.attr('success') || '操作成功',
			fail=$form.attr('fail') || '操作失败',
			data = $form.serializeObject(),
			forwardUrl = $form.attr('forward')
			;
			if(!$form.valid()) return false;
			$.ajax({
				url:url,
				data:data,
				type:method,
				dataType:'json'
			}).done(function(data){
				if(data){
					alert(success);
					location.href=forwardUrl;
				}
				else{
					alert(fail);
				}
				if(forwardUrl){
				}
			});
		}
		catch(e){
			console.log(e)
			e.printStackTrace();
			return false;
		}
		return false;
	});
	
	/*if($().validate)$('form[form-ajax]').validate({
		submitHandler:function(form){
			
		}
	});*/
});
