const id = document.querySelector('.noi-dung').id.slice(4);
const domain = 'https://localhost/luyenthithptqg';

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");


const chi_tiet_de_thi = document.querySelector('.chi-tiet-de-thi');
const ten_de_thi = chi_tiet_de_thi.querySelector('.ten-de');
const chua_cau_hoi = chi_tiet_de_thi.querySelector('.chua-cau-hoi-dt');
const diem_so = chi_tiet_de_thi.querySelector('.diem_so_kq span');
const thoi_gian = chi_tiet_de_thi.querySelector('.thoi_gian_kq span');

(async()=>{
    const response = await fetch(`${domain}/api/student_exam?exid=${id}`, {
        method: 'GET',
        headers: headers
    })

    const stu_exam = await response.json();
    console.log(stu_exam);

    hienThiBaiLam(stu_exam.exam);

    hienThiKetQua(stu_exam);
})();


function hienThiBaiLam(exam){
    ten_de_thi.textContent = exam.name;
    chua_cau_hoi.innerHTML = '';
    let stt=1;
    exam.questions.forEach(e => {

        let html = `
        <form>
            <div class="cau-hoi" id=${e.questionID}>
                <div class="nut-danh-dau">
                    <i class="uil uil-check an"></i>
                    <i class="uil uil-times"></i>
                </div>
                <p class="noi-dung-cau-hoi">
                    <b>Câu <span class="stt">${stt++}</span></b>:  ${e.description};
                </p>
                <div class="phuong-an-lua-chon an_chon">
                    <div class="phuong-an" id="p1${e.questionID}">
                        <input type="radio" id="${e.questionID}pa1" name="phuong_an" value="1" >
                        <label for="${e.questionID}pa1">A. ${e.selection1}</label><br>
                    </div>
                    <div class="phuong-an an_chon" id="p2${e.questionID}">
                        <input type="radio" id="${e.questionID}pa2" name="phuong_an" value="2">
                        <label for="${e.questionID}pa2">B. ${e.selection2}</label><br>
                    </div>
                    <div class="phuong-an an_chon" id="p3${e.questionID}">
                        <input type="radio" id="${e.questionID}pa3" name="phuong_an" value="3">
                        <label for="${e.questionID}pa3">C. ${e.selection3}</label>
                    </div>
                    <div class="phuong-an an_chon" id="p4${e.questionID}">
                        <input type="radio" id="${e.questionID}pa4" name="phuong_an" value="4">
                        <label for="${e.questionID}pa4">D. ${e.selection4}</label>
                    </div>
                </div>
            </div>
        </form>
        `

        chua_cau_hoi.insertAdjacentHTML('beforeend', html);
    });
    // chi_tiet_de_thi.innerHTML = '';
}

function hienThiKetQua(stu_exam){
    diem_so.textContent = `${stu_exam.score}/10`;
    thoi_gian.textContent = `${stu_exam.exam.time-stu_exam.submitTime}/${stu_exam.exam.time}`;

    stu_exam.exam.questions.forEach(e => {
        let cau_hoi = document.getElementById(`${e.questionID}`);
        let cau_tl_dung = document.getElementById(`p${e.answer}${e.questionID}`);
        cau_tl_dung.classList.add('chu-xanh');
    });

    stu_exam.answerQuestions.forEach(e => {
        let cau_hoi = document.getElementById(`${e.question.questionID}`);
        let nut_dd_dung = cau_hoi.querySelector('.uil-check');
        let nut_dd_sai = cau_hoi.querySelector('.uil-times');
        if(e.choice!=0){
            let cau_tl = document.getElementById(`p${e.choice}${e.question.questionID}`);
            if(!cau_tl.classList.value.includes('chu-xanh')){
                cau_tl.classList.add('chu-do');
            }else{
                nut_dd_dung.classList.remove('an');
                nut_dd_sai.classList.add('an');
            }
        }
    });
}