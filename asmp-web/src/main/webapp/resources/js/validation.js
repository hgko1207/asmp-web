/**
 * 핸드폰 전화번호 일 경우 자동입력
 * @param str
 * @returns
 */
function autoHypenPhone(str) {
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	if (str.length < 4) {
		return str;
	} else if (str.length < 7) {
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3);
		return tmp;
	} else if (str.length < 11) {
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 3);
		tmp += '-';
		tmp += str.substr(6);
		return tmp;
	} else {
		tmp += str.substr(0, 3);
		tmp += '-';
		tmp += str.substr(3, 4);
		tmp += '-';
		tmp += str.substr(7);
		return tmp;
	}
	return str;
}

/**
 * 집 또는 핸드폰 전화번호 일 경우 자동입력
 * @param str
 * @returns
 */
function autoHypenTel(str) {
	str = str.replace(/[^0-9]/g, '');
	var tmp = '';
	
	if (str.substring(0, 2) == 02) { // 서울전화번호일 경우  10자리까지만 나타나고 그 이상의 자리수는 자동삭제
		if (str.length < 3) {
			return str;
		} else if (str.length < 6) {
			tmp += str.substr(0, 2);
			tmp += '-';
			tmp += str.substr(2);
			return tmp;
		} else if (str.length < 10) {
			tmp += str.substr(0, 2);
			tmp += '-';
			tmp += str.substr(2, 3);
			tmp += '-';
			tmp += str.substr(5);
			return tmp;
		} else {
			tmp += str.substr(0, 2);
			tmp += '-';
			tmp += str.substr(2, 4);
			tmp += '-';
			tmp += str.substr(6, 4);
			return tmp;
		}
	} else {
		if (str.length < 4) {
			return str;
		} else if (str.length < 7) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3);
			return tmp;
		} else if (str.length < 11) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 3);
			tmp += '-';
			tmp += str.substr(6);
			return tmp;
		} else {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 4);
			tmp += '-';
			tmp += str.substr(7);
			return tmp;
		}
	}
	
	return str;
}