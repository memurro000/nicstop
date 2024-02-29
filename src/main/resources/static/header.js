const path = window.location.pathname;
if (path === '/')
    $(`a[href="/index.html"]`).addClass('active');
else
    $(`a[href="${path}"]`).addClass('active');