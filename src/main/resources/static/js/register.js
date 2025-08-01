function getCsrfToken() {
    const match = document.cookie.match(/XSRF-TOKEN=([^;]+)/);
    return match ? decodeURIComponent(match[1]) : '';
}

document.querySelector('#registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.querySelector('#username').value;
    const password = document.querySelector('#password').value;

    fetch('/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-XSRF-TOKEN': getCsrfToken()
        },
        body: JSON.stringify({ username, password })
    })
    .then(response => {
        if (!response.ok) return response.text().then(text => { throw new Error(text); });
        return response.text();
    })
    .then(data => {
        alert(data);
        if (data === '註冊成功') {
            window.location.href = '/index';
        }
    })
    .catch(error => {
        alert('註冊失敗：' + error.message);
    });
});
