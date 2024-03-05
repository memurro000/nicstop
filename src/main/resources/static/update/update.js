const textarea = document.getElementById('commentary');
const textarea_charcounter = document.getElementById('commentary_charcounter');

textarea.addEventListener('input', function () {
    const page_scroll = window.scrollY;
    this.style.height = '56px';
    this.style.height = (this.scrollHeight) + 'px';
    
    const val_len = this.value.trim().length;
    
    textarea_charcounter.textContent = `${val_len}/500`;
    textarea_charcounter.style.color = val_len > 500 ? 
                                    '#be4216' : '#5e7a1a';
    
    window.scrollTo(0, page_scroll);
});


