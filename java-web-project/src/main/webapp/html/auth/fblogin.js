if (window.localStorage.getItem('email')) {
  //document.querySelector('#email').value = localStorage.getItem('email')
  document.querySelector('#email').value = localStorage.email
}

function checkLoginState() {
  FB.getLoginStatus(function(response) { 
      if (response.status === 'connected') { // 로그인이 정상적으로 되었을 때,
          autoServerLogin(response.authResponse.accessToken);
      
      } else { // 로그인이 되지 않았을 때,
          console.log("로그인 되지 않았음");
      }
  });
}

document.querySelector('#login-btn').onclick = () => {
  var xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function() {
    if (xhr.readyState != 4 || xhr.status != 200)
      return;
    
    var data = JSON.parse(xhr.responseText);
    
    if (data.status == 'success') {
      location.href = "../index.html"
        
    } else {
      alert('로그인 실패입니다!\n' + data.message);
    }
  };
  xhr.open('POST', '../../app/json/auth/login', true)
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  
  var email = document.querySelector('#email').value;
  var password = document.querySelector('#password').value;
  
  if (document.querySelector('#saveEmail:checked') != null) {
    // 웹브라우저의 로컬 스토리지에 이메일을 저장한다.
    //window.localStorage.setItem("email", email);
    window.localStorage.email = email;
  } else {
    window.localStorage.removeItem("email");
  }
  
  var qs = 'email=' + email + '&password=' + password;
  xhr.send(qs);
};






