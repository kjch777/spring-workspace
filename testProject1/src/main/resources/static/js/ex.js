/**
 * javaScript 코드를 작성하는 공간(바닐라 자바스크립트, jQuery 둘 다 사용이 가능하다.)
 * 
 * jQuery 로 변경하기
 */

/* 바닐라 자바스크립트

document.querySelector("#btn").addEventListener("click", ()=> {
	alert("클릭됨");
})

*/

// jQuery
function btn() {
	alert("클릭되었습니다.");
}

/*
<button onclick="btn()">onclick 은 이벤트 리스너이다.</button>

을 클릭했을 때 나올 기능 ▼

document.querySelector("#btn").addEventListener("click", btn);

을 제이쿼리 형식으로 변경하기 ▼

$(document).ready(function() {
	$("#btn").click(btn);
});
*/