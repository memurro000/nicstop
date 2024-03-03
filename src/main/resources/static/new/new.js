const textarea = document.getElementById('commentary');
const textarea_charcounter = document.getElementById('commentary_charcounter');

textarea.addEventListener('input', function () {
    const page_scroll = window.scrollY;
    this.style.height = '56px';
    this.style.height = (this.scrollHeight) + 'px';
    textarea_charcounter.textContent = `${this.value.length}/500`;
    textarea_charcounter.style.color = this.value.length > 500 ? 
                                        '#be4216' : '#5e7a1a';
    
    window.scrollTo(0, page_scroll);
});


