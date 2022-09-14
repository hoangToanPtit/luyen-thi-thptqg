const id = document.querySelector('.noi-dung').id.slice(4);
const domain = 'https://localhost/luyenthithptqg';

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");


const chi_tiet_de_thi = document.querySelector('.chi-tiet-de-thi');
const ten_de_thi = chi_tiet_de_thi.querySelector('.ten-de');
const chua_cau_hoi = chi_tiet_de_thi.querySelector('.chua-cau-hoi-dt');
const bang_danh_dau = document.querySelector('.phan_danh_dau');
const thoi_gian = document.querySelector('.thoi_gian span');
const nut_tam_dung = document.querySelector('.nut_tam_dung');
const nut_nop_bai = document.querySelector('.nut_nop_bai');
const che_noi_dung = document.querySelector('.che_trang');
const ket_qua = document.querySelector('.ket_qua');
const nut_xem_ket_qua_chi_tiet = ket_qua.querySelector('.xem_kq_chi_tiet');
const nut_dong_ket_qua = ket_qua.querySelector('.nut_dong_kq');

(async()=>{
    const response = await fetch(`${domain}/api/exams?id=${id}`, {
        method: 'GET',
        headers: headers
    })

    const dethi = await response.json();
    // console.log(dethi);

    xemChiTietDe(dethi);
    themSuKienChoBangDanhDau(dethi);
    themSuKienChonDapAn();
    dongHo(dethi.time);
    nopBai(dethi);

 
})();


function xemChiTietDe(dethi){
    ten_de_thi.textContent = dethi.name;
    chua_cau_hoi.innerHTML = '';
    let stt=1;
    dethi.questions.forEach(e => {

        let html = `
        <form>
            <div class="cau-hoi" id=${e.questionID}>
                <div class="nut-danh-dau">
                    <i class="uil uil-edit nut-sua"></i>
                </div>
                <p class="noi-dung-cau-hoi">
                    <b>Câu <span class="stt">${stt++}</span></b>:  ${e.description};
                </p>
                <div class="phuong-an-lua-chon">
                    <div class="phuong-an">
                        <input type="radio" id="${e.questionID}pa1" name="phuong_an" value="1" >
                        <label for="${e.questionID}pa1">A. ${e.selection1}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="${e.questionID}pa2" name="phuong_an" value="2">
                        <label for="${e.questionID}pa2">B. ${e.selection2}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="${e.questionID}pa3" name="phuong_an" value="3">
                        <label for="${e.questionID}pa3">C. ${e.selection3}</label>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="${e.questionID}pa4" name="phuong_an" value="4">
                        <label for="${e.questionID}pa4">D. ${e.selection4}</label>
                    </div>
                </div>
            </div>
        </form>
        `

        chua_cau_hoi.insertAdjacentHTML('beforeend', html);
    });

}

function themSuKienChoBangDanhDau(dethi){
    const mang_cau_hoi = document.querySelectorAll('.cau-hoi');
    console.log(mang_cau_hoi);

    for(let i=1; i<=dethi.questions.length; i++){
        let html = `<div class="cau_danh_dau">${i}</div>`;
        bang_danh_dau.insertAdjacentHTML('beforeend', html);
        const nut = bang_danh_dau.querySelector('.cau_danh_dau:last-child');
        nut.addEventListener('click', () => {
            mang_cau_hoi[i-1].scrollIntoView({behavior: "smooth", block: "center", inline: "nearest"});
            mang_cau_hoi[i-1].style.background = '#E9F4F0';
            setTimeout(() => {
                mang_cau_hoi[i-1].style.background = '#fff';
            }, 1500);
        })
    }

    for(let i=dethi.questions.length+1; i<=50; i++){
        let html = `<div class="cau_danh_dau"></div>`;
        bang_danh_dau.insertAdjacentHTML('beforeend', html);
    }

    const mang_nut_danh_dau = document.querySelectorAll('.cau_danh_dau');
    for(let i=0; i<mang_cau_hoi.length; i++){
        const nut_danh_dau = mang_cau_hoi[i].querySelector('.nut-sua');
        nut_danh_dau.addEventListener('click', () => {
            if(nut_danh_dau.classList.value.includes('da-danh-dau')){
                nut_danh_dau.classList.remove('da-danh-dau');
                if(layLuaChonChoCauHoiDaLamChua(mang_cau_hoi[i])!=0){
                    mang_nut_danh_dau[i].style.background = '#4CBC9A';
                    mang_nut_danh_dau[i].style.color = '#fff';
                }else{
                    mang_nut_danh_dau[i].style.background = '#fff';
                    mang_nut_danh_dau[i].style.color = '#A098AE';
                }
            }else {
                nut_danh_dau.classList.add('da-danh-dau');
                mang_nut_danh_dau[i].style.background = '#4e73df';
                mang_nut_danh_dau[i].style.color = '#fff';
            }
        })
    };
}

function layLuaChonChoCauHoiDaLamChua(cau_hoi){
    const lua_chon = cau_hoi.querySelectorAll('input');
    let bl = 0;
    lua_chon.forEach(e => {
        if(e.checked){
            bl = e.value;
        }
    });
    return bl;
}

function themSuKienChonDapAn(){
    const mang_cau_hoi = document.querySelectorAll('.cau-hoi');
    const mang_nut_danh_dau = document.querySelectorAll('.cau_danh_dau');

    for(let i=0; i<mang_cau_hoi.length; i++){
        const lua_chon = mang_cau_hoi[i].querySelectorAll('input');
        lua_chon.forEach(el => {
            el.addEventListener('click', ()=> {
                mang_nut_danh_dau[i].style.background = '#4CBC9A';
                mang_nut_danh_dau[i].style.color = '#fff';
            })
        });        
    };

}

function dongHo(so_phut){
    so_phut-=1
    let so_giay = 59;
    let phut='';
    let giay='';
    var demNguoc = setInterval(() => {
        if(so_giay==0){
            so_giay=59; 
            so_phut-=1;  
        }else so_giay-=1;
        
        if(so_giay<10) giay = `0${so_giay}`;
        else giay = `${so_giay}`;
        if(so_phut<10) phut = `0${so_phut}`;
        else phut = `${so_phut}`;

        thoi_gian.textContent = `${phut}:${giay}`;

        if(so_phut<5) thoi_gian.style.color='red';

        if(so_phut==0 && so_giay==0) clearInterval(demNguoc);
        
    }, 1000);

    nut_tam_dung.addEventListener('click', () => {
        if(nut_tam_dung.classList.value.includes('duoc_chon')){
            che_noi_dung.style.display = 'none';
            thoi_gian.style.color='#3D4A5C';
            nut_tam_dung.classList.remove('duoc_chon');
            nut_tam_dung.textContent = 'Tạm dừng';
            demNguoc = setInterval(() => {
                if(so_giay==0){
                    so_giay=59; 
                    so_phut-=1;  
                }else so_giay-=1;
                
                if(so_giay<10) giay = `0${so_giay}`;
                else giay = `${so_giay}`;
                if(so_phut<10) phut = `0${so_phut}`;
                else phut = `${so_phut}`;
        
                thoi_gian.textContent = `${phut}:${giay}`;
        
                if(so_phut<5) thoi_gian.style.color='red';
        
                if(so_phut==0 && so_giay==0) clearInterval(demNguoc);
                
            }, 1000);
        }else{
            che_noi_dung.style.display = 'block';
            nut_tam_dung.classList.add('duoc_chon');
            nut_tam_dung.textContent = 'Tiếp tục';
            clearInterval(demNguoc);
            thoi_gian.style.color='#A098AE';
        }
    })
}

function nopBai(dethi){
    nut_nop_bai.addEventListener('click', async()=>{

        const baiLam = {};
        baiLam.exam = {}; 
        baiLam.exam.examID = id;
        baiLam.exam.amount = dethi.amount;
        baiLam.exam.time = dethi.time;
        baiLam.submitTime = thoi_gian.textContent.slice(0,2);
        baiLam.answerQuestions = [];

        const mang_cau_hoi = document.querySelectorAll('.cau-hoi');
        for(let i=0; i<dethi.questions.length; i++){
            let x = {};
            x.question = dethi.questions[i];
            x.choice = layLuaChonChoCauHoiDaLamChua(mang_cau_hoi[i]);
            baiLam.answerQuestions.push(x);
        }


        console.log(baiLam);
        const res = await fetch(`${domain}/api/student_exam`, {
            method: 'POST',
            headers: headers,
            body: JSON.stringify(baiLam)
        })

        const bl = await res.json();
        // console.log(bl);

        document.querySelector('.thoi_gian').style.display = 'none';
        nut_nop_bai.style.display = 'none';
        nut_tam_dung.style.display = 'none';

        ket_qua.querySelector('.diem_so').textContent = `${bl.score}/10`;
        ket_qua.querySelector('.thoi_gian_kq').textContent 
        = `${bl.exam.time-bl.submitTime}/${bl.exam.time}`;
        ket_qua.style.display = 'block';

        nut_dong_ket_qua.addEventListener('click', ()=>{
            location.href='exams';
        })

        nut_xem_ket_qua_chi_tiet.addEventListener('click', ()=> {
            location.href = `student_exam?exid=${id}`;
        })
    })
}