const domain = 'https://localhost/luyenthithptqg'

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");

const mon_toan = document.querySelector('.mon_toan');
const mon_li = document.querySelector('.mon_li');
const mon_hoa = document.querySelector('.mon_hoa');
const mon_sinh = document.querySelector('.mon_sinh');
const mon_su = document.querySelector('.mon_su');
const mon_dia = document.querySelector('.mon_dia');
const mon_gdcd = document.querySelector('.mon_gdcd');
const mon_anh = document.querySelector('.mon_anh');

const danh_sach_de_thi = document.querySelector('.danh_sach_de_thi');

const o_chon_tinh_tp = document.getElementById('nguon_goc');
const o_chon_nam_bat_dau = document.getElementById('nam_bat_dau');
const o_chon_nam_ket_thuc = document.getElementById('nam_ket_thu');
const nut_loc_tim_kiem = document.querySelector('.nut_loc_bai_viet');

let dl_de_thi = null;

(async()=>{
    themDuLieuChoTimTheoTinh();
    dl_de_thi = getExam('Toán');
    mon_toan.addEventListener('click', ()=>{getExam('Toán'); removeActiveBtn(mon_toan);});
    mon_li.addEventListener('click', ()=>{getExam('Lý'); removeActiveBtn(mon_li);});
    mon_hoa.addEventListener('click', ()=>{getExam('Hóa'); removeActiveBtn(mon_hoa);});
    mon_sinh.addEventListener('click', ()=>{getExam('Sinh'); removeActiveBtn(mon_sinh);});
    mon_su.addEventListener('click', ()=>{getExam('Sử'); removeActiveBtn(mon_su);});
    mon_dia.addEventListener('click', ()=>{getExam('Địa'); removeActiveBtn(mon_dia);});
    mon_gdcd.addEventListener('click', ()=>{getExam('Gdcd'); removeActiveBtn(mon_gdcd);});
    mon_anh.addEventListener('click', () => {getExam('Anh'); removeActiveBtn(mon_anh);});
    
    locDeThi();
})();


// Lọc đề thi
async function locDeThi(){
    let nguon_goc = '';
    let nam_bd = 2017;
    let nam_kt = 2022;

    nut_loc_tim_kiem.addEventListener('click', ()=>{
        console.log(dl_de_thi);
        //  lấy dữ liệu các trường tìm kiếm
        o_chon_tinh_tp.querySelectorAll('option').forEach(e => {
            if(e.selected){
                nguon_goc = e.textContent;
            }
        });
        o_chon_nam_bat_dau.querySelectorAll('option').forEach(e => {
            if(e.selected){
                nam_bd = e.textContent;
            }
        });
        o_chon_nam_ket_thuc.querySelectorAll('option').forEach(e => {
            if(e.selected){
                nam_kt = e.textContent;
            }
        });

        // loc du lieu
        const dl_de_sau_loc = [];
        dl_de_thi.forEach(e => {
            if( ((nguon_goc != "Tỉnh/Thành phố" && e.source==nguon_goc) || nguon_goc=="Tỉnh/Thành phố")
            && e.year>=nam_bd && e.year<=nam_kt){
                dl_de_sau_loc.push(e);
            }
        })

        // hien thi du lieu sau loc
        hienThiDanhSachDeThi(dl_de_sau_loc);
        console.log(dl_de_sau_loc);

    })

}


// Add data for search box
async function themDuLieuChoTimTheoTinh(){

    const res = await  fetch("https://provinces.open-api.vn/api/p", {
     method: 'GET'
    })
  
    const pro = await res.json();
    console.log(pro);

    // o_chon_tinh_tp.textContent = '';
    pro.forEach(e => {
        let html = `<option  >${e.name}</option>`;
        o_chon_tinh_tp.insertAdjacentHTML('beforeend', html);
    });
}


async function getExam(subj){
    // call api
    const response = await fetch(`${domain}/api/exams?sub=${subj}`, {
        method: 'GET',
        headers: headers
    })

    const examArr = await response.json();
    console.log(examArr);

    hienThiDanhSachDeThi(examArr);

    dl_de_thi = examArr;
}

function removeActiveBtn(el){
    document.querySelectorAll('.mon').forEach(e =>{
        e.classList.remove('duoc_chon');
    })
    el.classList.add('duoc_chon');

}

function hienThiDanhSachDeThi(examArr){
    danh_sach_de_thi.innerHTML = '';

    if(examArr!=null){
        let i = 1;
        examArr.forEach(e => {
            let html = `
            <div class="de_thi">
                <div class="so_tt">${i++}</div>
                <div class="thong_tin_de">
                    <div class="ten_de_thi">
                        ${e.name}
                    </div>
                    <div class="thong_tin">
                        <div>
                            <i class="uil uil-location-pin-alt"></i>
                            <p>${e.source}</p>
                        </div>
                        <div>
                            <i class="uil uil-file-question"></i>
                            <p>${e.amount} câu</p>
                        </div>
                        <div>
                            <i class="uil uil-clock-eight"></i>
                            <p>${e.time} phút</p>
                        </div>
                        
                    </div>
                </div>
                <div class="nut_xem_de_chi_tiet" id="${e.examID}">
                    <i class="uil uil-angle-right-b"></i>
                </div>
            </div>
            `
            danh_sach_de_thi.insertAdjacentHTML('beforeend', html);
        });
    }


    // chuyen sang trang xem chi tiet de thi
    const nut_chuyen_sang_trang_chi_tiet = document.querySelectorAll('.nut_xem_de_chi_tiet');
    nut_chuyen_sang_trang_chi_tiet.forEach(e=>{
        e.addEventListener('click', ()=>{
            location.href = `exams?id=${e.id}`;
        })
    })
}
