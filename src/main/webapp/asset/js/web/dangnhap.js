const domain = 'https://localhost/luyenthithptqg';


//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");

const cac_truong_nhap_dl = document.querySelectorAll('input');
const cac_loi = document.querySelectorAll('.error');
const nut_dang_ky = document.querySelector('.nut_dang_nhap button');


(()=>{
    kiemTraGiaTriFormNhap();
    nut_dang_ky.addEventListener('click', async() => {
        if(kiemTraDaNhapDu()){
            const tai_khoan = layDuLieu();

            const response = await fetch(`${domain}/api-log-in`, {
                method: 'POST',
                headers: headers,
                body: JSON.stringify(tai_khoan)
            })

            const tk = await response.json();
            console.log(tk);

            if(tk==null){
                cac_loi[0].textContent = '*Tên đăng nhập hoặc mật khẩu không chính xác';
            }else{
                if(tk.role=='student'){
					let url = document.querySelector('.url').textContent;
					console.log(url);
					if(url != "null"){
						location.href=`https://localhost/luyenthithptqg/${url}`;
						return;
					}else{
	                    location.href="exams";						
					}
				}
                else if(tk.role=='admin')
                    location.href="https://localhost/luyenthithptqg/admin/exams";
            }
        }
    })
 
})();

function kiemTraGiaTriFormNhap(){
    nut_dang_ky.style.backgroundColor = '#E9F4F';
    for(let i=0; i<cac_truong_nhap_dl.length; i++){
        cac_truong_nhap_dl[i].addEventListener('blur', () => {
            if(cac_truong_nhap_dl[i].value==''){
                cac_loi[i+1].textContent = '*Bắt buộc';
            }
        })
        cac_truong_nhap_dl[i].addEventListener('click', () => {
            cac_loi[i+1].textContent = '';
            cac_loi[0].textContent = '';
        })
    }
}

function layDuLieu(){
    const tai_khoan = {};
    cac_truong_nhap_dl.forEach(e => {
        tai_khoan[e.name] = e.value;
    })
    return tai_khoan;
}


function kiemTraDaNhapDu(){
    let bl = true;
    cac_loi.forEach(e => {
        if(e.textContent!='') bl = false;
    })
    return bl;
}