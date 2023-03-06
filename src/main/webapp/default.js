/**
 * @author	P-C Lin (a.k.a 高科技黑手)
 */

/**
 * 
 */
function onLoad() {
	gapi.load('auth2', function () {
		gapi.auth2.init();
	});
}

/**
 * @param {type} googleUser
 */
function signIn(googleUser) {
	$.post('/signIn.json', {idToken: googleUser.getAuthResponse().id_token}, function (data) {
		console.log(JSON.stringify(data));
		location.reload();
	}, 'json');
}

/**
 */
function signOut() {
	if (window.confirm('確定要登出嗎!?')) {
		gapi.auth2.getAuthInstance().signOut().then(function () {
			$.post('/signOut.json', function (data) {
				if (data.reason) {
					alert(data.reason);
				}
			}, 'json');
		});
		location.reload();
	}
}

$(document).ready(function () {
	/**
	 * 日時選擇器
	 */
	if (typeof jQuery.ui !== 'undefined' && /[1-9]\.[1-9]{1,2}.[0-9]{1,2}/.test($.ui.version)) {
		$('INPUT[type="date"]').datepicker({
			changeMonth: true,
			changeYear: true,
			dateFormat: 'yy-mm-dd'
		}).datepicker($.datepicker.regional['zh-TW']);
	}
});