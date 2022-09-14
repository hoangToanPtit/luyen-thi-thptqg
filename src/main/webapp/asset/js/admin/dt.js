//const domain = 'https://localhost:8080/luyenthithptqg'
const domain = 'https://localhost/luyenthithptqg';

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");

//url api
const urlApiExam = `${domain}/admin/api/exams`;
const urlApiQuestion = `${domain}/admin/api/questions`;

const iD = document.getElementById('examId').textContent;
console.log(iD);
let exam = {};
let questions = [];

const form_sua_thong_tin_chung_dt = document.querySelector('.form-sua-thong-tin-chung-de-thi');
const nut_ql_sua_tt_dt = document.querySelector('.noi-dung .sua-tt-dt');
const nut_dong_form_sua = document.querySelector('.form-sua-thong-tin-chung-de-thi .nut-dong');
const inp_form_sua = form_sua_thong_tin_chung_dt.querySelectorAll('input');
const nut_luu_tt_dt = form_sua_thong_tin_chung_dt.querySelector('.nut-submit');

const nut_dong_form_them_cau_hoi = document.querySelector('.form-them-cau-hoi .nut-dong');
const form_them_cau_hoi = document.querySelector('.form-them-cau-hoi');
const inps_form_them_cau_hoi = form_them_cau_hoi.querySelectorAll('input');
const nut_them_cau_hoi = form_them_cau_hoi.querySelector('.nut-submit');
const nut_ql_them_cau_hoi = document.querySelector('.noi-dung .them-cau-hoi-moi');
const ten_de_thi = document.querySelector('.chi-tiet-de-thi .ten-de');
console.log(ten_de_thi);
console.log(nut_ql_sua_tt_dt);

(async () => {
    // get exam
    exam = await getExamById(iD);
    questions = exam.questions;

    // =========== su kien chung --==========
    // add event for form "sua thong tin chung dt"
    nut_ql_sua_tt_dt.addEventListener('click', () => {
        inp_form_sua.forEach(ele => {
            ele.value = exam[ele.name];
        })
        form_sua_thong_tin_chung_dt.style.display = 'block';
    })
    nut_dong_form_sua.addEventListener('click', () => {
        form_sua_thong_tin_chung_dt.style.display = 'none';
    })
    nut_ql_them_cau_hoi.addEventListener('click', () => {
        form_them_cau_hoi.style.display = 'block';
    })
    nut_dong_form_them_cau_hoi.addEventListener('click', () => {
        form_them_cau_hoi.style.display = 'none';
    })


    // ---- view detail exam --------
    viewDetailExam();
    // ----- edit common infomation of exam ------
    editExam();
    // ====== add new question into exam ----------
    addNewQuestionIntoExam(iD);


})();

// function add question into exam 
function addNewQuestionIntoExam(exId){
    nut_them_cau_hoi.addEventListener('click', async () => {
        const newQuestion = {};
        inps_form_them_cau_hoi.forEach(e => {
            newQuestion[e.name] = e.value;
        })
        const slt = form_them_cau_hoi.querySelector('select');
        const da = slt.options[slt.selectedIndex].value;
        newQuestion.answer = da;

        const res = await fetch(`${urlApiQuestion}?exid=${exId}`, {
            method: 'POST',
            headers: headers,
            body: JSON.stringify(newQuestion)
        })
        const newQues = await res.json();
        questions.push(newQues);
        console.log(newQues);
        viewDetailExam();
        form_them_cau_hoi.style.display = 'none';
    }) 
}


//  function get detail exam by id;
async function getExamById(id) {
    const response = await fetch(`${urlApiExam}?id=${id}`, {
        method: 'GET',
        headers: headers
    })
    const ex = await response.json();
    console.log(exam);
    return ex;
}



function editExam() {
    nut_luu_tt_dt.addEventListener('click', async ()=>{
        // const editedExam = {examID: iD,
        //     questionID: };
        inp_form_sua.forEach(e => {
            exam[e.name] = e.value;
        })

        const response = await fetch(urlApiExam, {
            method: 'PUT',
            headers: headers,
            body: JSON.stringify(exam)
        })
        const newexam = await response.json();
        console.log(newexam);
        viewDetailExam();
        form_sua_thong_tin_chung_dt.style.display = 'none';
        // return newexam;
    })
}

// "examID": 5,
// "name": "De 10",
// "subject": "Ly",
// "source": "Tinh HN",
// "year": 2022,
// "time": 60,
// "amount": 40,
// "questions": [

// "questionID": 1,
// "answer": 5,
// "description": "1+1=?",
// "selection1": "1",
// "selection2": "2",
// "selection3": "3",
// "selection4": "4"


// function view detail exam
function viewDetailExam(){
    let stt = 1;
    ten_de_thi.textContent = exam["name"];
    questions = exam['questions'];
    const html = questions.map((ele) => {
        if(ele.answer == 1){
            return `
                <form>
                    <div class="cau-hoi">
                        <div class="nut-ql">
                            <i class="uil uil-edit nut-sua"></i>
                            <i class="uil uil-trash-alt nut-xoa" questionId = ${ele.questionID}></i>
                        </div>
                        <p class="noi-dung-cau-hoi">
                            <b>Câu <span class="stt">${stt++}</span></b>:  ${ele.description}
                        </p>
                        <div class="phuong-an-lua-chon">
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-1-${ele.questionID}" name="selection-${ele.questionID}" value="1" checked="checked">
                                <label for="lua-chon-1-${ele.questionID}">${ele.selection1}</label><br>
                            </div>
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-2-${ele.questionID}" name="selection-${ele.questionID}" value="2">
                                <label for="lua-chon-2-${ele.questionID}">${ele.selection2}</label><br>
                            </div>
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-3-${ele.questionID}" name="selection-${ele.questionID}" value="3">
                                <label for="lua-chon-3-${ele.questionID}">${ele.selection3}</label>
                            </div>
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-4-${ele.questionID}" name="selection-${ele.questionID}" value="4">
                                <label for="lua-chon-4-${ele.questionID}">${ele.selection4}</label>
                            </div>
                        </div>
                    </div>
                </form>
            `
        }
        else if(ele.answer == 2){
            return `
                <form>
                    <div class="cau-hoi">
                        <div class="nut-ql">
                            <i class="uil uil-edit nut-sua"></i>
                            <i class="uil uil-trash-alt nut-xoa" questionId = ${ele.questionID}></i>
                        </div>
                        <p class="noi-dung-cau-hoi">
                        <b>Câu <span class="stt">${stt++}</span></b>:  ${ele.description}
                        </p>
                        <div class="phuong-an-lua-chon">
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-1-${ele.questionID}" name="selection-${ele.questionID}" value="1">
                                <label for="lua-chon-1-${ele.questionID}">${ele.selection1}</label><br>
                            </div>
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-2-${ele.questionID}" name="selection-${ele.questionID}" value="2" checked="checked">
                                <label for="lua-chon-2-${ele.questionID}">${ele.selection2}</label><br>
                            </div>
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-3-${ele.questionID}" name="selection-${ele.questionID}" value="3">
                                <label for="lua-chon-3-${ele.questionID}">${ele.selection3}</label>
                            </div>
                            <div class="phuong-an">
                                <input type="radio" id="lua-chon-4-${ele.questionID}" name="selection-${ele.questionID}" value="4">
                                <label for="lua-chon-4-${ele.questionID}">${ele.selection4}</label>
                            </div>
                        </div>
                    </div>
                </form>
            `
        }
        else if(ele.answer == 3){
            return `
                <form>
                    <div class="cau-hoi">
                        <div class="nut-ql">
                            <i class="uil uil-edit nut-sua"></i>
                            <i class="uil uil-trash-alt nut-xoa" questionId = ${ele.questionID}></i>
                        </div>
                        <p class="noi-dung-cau-hoi">
                            <b>Câu <span class="stt">${stt++}</span></b>:  ${ele.description}
                        </p>
                        <div class="phuong-an-lua-chon">
                        <div class="phuong-an">
                        <input type="radio" id="lua-chon-1-${ele.questionID}" name="selection-${ele.questionID}" value="1">
                        <label for="lua-chon-1-${ele.questionID}">${ele.selection1}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="lua-chon-2-${ele.questionID}" name="selection-${ele.questionID}" value="2">
                        <label for="lua-chon-2-${ele.questionID}">${ele.selection2}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="lua-chon-3-${ele.questionID}" name="selection-${ele.questionID}" value="3" checked="checked">
                        <label for="lua-chon-3-${ele.questionID}">${ele.selection3}</label>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="lua-chon-4-${ele.questionID}" name="selection-${ele.questionID}" value="4">
                        <label for="lua-chon-4-${ele.questionID}">${ele.selection4}</label>
                    </div>
                        </div>
                    </div>
                </form>
            `
        }
        else if(ele.answer == 4){
            return `
                <form>
                    <div class="cau-hoi">
                        <div class="nut-ql">
                            <i class="uil uil-edit nut-sua"></i>
                            <i class="uil uil-trash-alt nut-xoa" questionId = ${ele.questionID}></i>
                        </div>
                        <p class="noi-dung-cau-hoi">
                            <b>Câu <span class="stt">${stt++}</span></b>:  ${ele.description}
                        </p>
                        <div class="phuong-an-lua-chon">
                        <div class="phuong-an">
                        <input type="radio" id="lua-chon-1-${ele.questionID}" name="selection-${ele.questionID}" value="1">
                        <label for="lua-chon-1-${ele.questionID}">${ele.selection1}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="lua-chon-2-${ele.questionID}" name="selection-${ele.questionID}" value="2">
                        <label for="lua-chon-2-${ele.questionID}">${ele.selection2}</label><br>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="lua-chon-3-${ele.questionID}" name="selection-${ele.questionID}" value="3">
                        <label for="lua-chon-3-${ele.questionID}">${ele.selection3}</label>
                    </div>
                    <div class="phuong-an">
                        <input type="radio" id="lua-chon-4-${ele.questionID}" name="selection-${ele.questionID}" value="4" checked="checked">
                        <label for="lua-chon-4-${ele.questionID}">${ele.selection4}</label>
                    </div>
                        </div>
                    </div>
                </form>
            `
        }
    })
    const chua_cau_hoi = document.querySelector('.chua-cau-hoi-dt');
    chua_cau_hoi.innerHTML = html.join('\n');

    // add event for btn edit and delete
    const nut_ql_sua_cau_hoi = document.querySelectorAll('.chi-tiet-de-thi .cau-hoi .nut-sua');
    const form_sua_cau_hoi = document.querySelector('.form-sua-cau-hoi');
    const inp_sua_cau_hoi = document.querySelectorAll('.form-sua-cau-hoi .muc input');
    const dap_an = form_sua_cau_hoi.querySelectorAll('.chon-answer option');
    const nut_luu_cau_hoi_da_sua = form_sua_cau_hoi.querySelector('.nut-submit');
    const nut_dong_form_sua_cau_hoi = form_sua_cau_hoi.querySelector('.nut-dong');
    let st = -1;
    nut_dong_form_sua_cau_hoi.addEventListener('click', () => {
        form_sua_cau_hoi.style.display = 'none';
    })

    nut_ql_sua_cau_hoi.forEach(ele => {
        ele.addEventListener('click', () => {
            const cau_hoi = ele.closest('.cau-hoi');
            st = cau_hoi.querySelector('.stt').textContent-1;
            // console.log(questions[st]);
            inp_sua_cau_hoi.forEach(e => {
                e.value = questions[st][e.name];
                console.log(e);
            })
            dap_an.forEach((e) => {
                e.removeAttribute('selected');
            })
            dap_an[questions[st].answer-1].setAttribute('selected', 'selected');
            form_sua_cau_hoi.style.display = 'block';
        })
    })

    //  save question
    nut_luu_cau_hoi_da_sua.addEventListener('click', async() => {
        inp_sua_cau_hoi.forEach(e => {
            console.log(e.value);
            questions[st][e.name] = e.value;
        })
        const slt = document.querySelector('.form-sua-cau-hoi select');
        const da = slt.options[slt.selectedIndex].value;
        questions[st].answer = da;

        // call api
        const res = await fetch(urlApiQuestion, {
            method: 'PUT',
            headers: headers,
            body: JSON.stringify(questions[st])
        })
        const editedQuestion = await res.json();
        console.log(editedQuestion);
        const radio = document.querySelectorAll('.phuong-an-lua-chon .phuong-an input');
        radio.forEach(e => {
            e.removeAttribute('checked');
        })
        exam.questions = questions;
        viewDetailExam();
        form_sua_cau_hoi.style.display = 'none';

    })


    // delete question
    const nut_ql_xoa_cau_hoi = document.querySelectorAll('.chi-tiet-de-thi .cau-hoi .nut-xoa');
    console.log(nut_ql_xoa_cau_hoi);
    nut_ql_xoa_cau_hoi.forEach(e => {
        e.addEventListener('click', async () => {
            const cau_hoi = e.closest('.cau-hoi');
            st = cau_hoi.querySelector('.stt').textContent-1;
            const quesId = e.attributes[1].value; 
            console.log(quesId);
            await fetch(`${urlApiQuestion}?id=${quesId}`, {
                method: 'DELETE',
                headers: headers
            })
            questions = questions.filter((e, ind) => {
                return ind!=st;
            })
            exam.questions = questions;
            console.log(questions);
            await viewDetailExam();
        })
    })
} 
