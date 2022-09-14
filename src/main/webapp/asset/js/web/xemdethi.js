const subj = document.querySelector('.noi-dung').id;

const domain = 'https://localhost/luyenthithptqg';

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");


const chi_tiet_de_thi = document.querySelector('.chi-tiet-de-thi');
const ten_de_thi = chi_tiet_de_thi.querySelector('.ten-de');
const chua_cau_hoi = chi_tiet_de_thi.querySelector('.chua-cau-hoi-dt');

(async()=>{
    const response = await fetch(`${domain}/api/exams?id=${subj}`, {
        method: 'GET',
        headers: headers
    })

    const exam = await response.json();
    console.log(exam);

    viewDetailExam(exam);

})();


function viewDetailExam(exam){
    ten_de_thi.textContent = exam.name;
    chua_cau_hoi.innerHTML = '';
    let stt=1;
    exam.questions.forEach(e => {

        let html = `
        <form>
            <div class="cau-hoi">
                
                <p class="noi-dung-cau-hoi">
                    <b>Câu <span class="stt">${stt++}</span></b>:  ${e.description};
                </p>
                <div class="phuong-an-lua-chon an_chon">
                    <div class="phuong-an">
                        <input type="radio" id="html" name="phuong_an" value="">
                        <label for="html">A. ${e.selection1}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="css" name="phuong_an" value="">
                        <label for="css">B. ${e.selection2}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="javascript" name="phuong_an" value="">
                        <label for="javascript">C. ${e.selection3}</label>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="abc" name="phuong_an" value="">
                        <label for="abc">D. ${e.selection4}</label>
                    </div>
                </div>
            </div>
        </form>
        `

        chua_cau_hoi.insertAdjacentHTML('beforeend', html);
    });
    // chi_tiet_de_thi.innerHTML = '';
}