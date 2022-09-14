const domain = 'https://localhost/luyenthithptqg';

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");

//url api
const urlApiExam = `${domain}/admin/api/exams`;

// element dom
const nut_ql_them_dt = document.querySelector('.noi-dung .them-moi-dt');
const form_them_dt = document.querySelector('.form-them-de-thi');
const form_sua_thong_tin_chung_dt = document.querySelector('.form-sua-thong-tin-chung-de-thi');
const nut_dong_form_sua_tt_chung = form_sua_thong_tin_chung_dt.querySelector('.nut-dong');
const nut_dong_form_them_dt = document.querySelector('.form-them-de-thi .nut-dong');
const nut_them_dt_moi = document.querySelector('.form-them-de-thi .nut-submit');
const danh_sach_de_thi = document.querySelector('.danh-sach-de-thi tbody');
let stt = 1;

//==================================== MAIN ============================
(() => {
    // ------------- event chung ------------------
    // ---- mo form them de thi ------
    nut_ql_them_dt.addEventListener('click', () => {
        form_them_dt.style.display = 'block';
    })
    // ---- dong form them de thi-------
    nut_dong_form_them_dt.addEventListener('click', () => {
        form_them_dt.style.display = 'none';
    })
    // ---- dong form sua tt chung de thi-------
    nut_dong_form_sua_tt_chung.addEventListener('click', () => {
        form_sua_thong_tin_chung_dt.style.display = 'none';
        const inps = form_sua_thong_tin_chung_dt.querySelectorAll('input');
        inps.forEach(ele => {
            ele.value = '';
        })
    })

    // ----- view exam table --------
    viewExamList();

    // ------ add new exam ---------
    nut_them_dt_moi.addEventListener('click', () => {
        addNewExam();
        form_them_dt.style.display = 'none';
    })

})();


//========== function call api render exam list 
async function viewExamList() {
    // call api
    const response = await fetch(urlApiExam, {
        method: 'GET',
        headers: headers
    })
    const examArr = await response.json();
    const sl_dt = document.querySelector('.so-luong-dt span');
    sl_dt.textContent = examArr.length;
    stt = 1;
    const html = examArr.map((item) => {
        return `
        <tr>
        <td>${stt++}</td>
        <td>${item.examID}</td>
        <td>${item.name}</td>
        <td>${item.subject}</td>
        <td>${item.source}</td>
        <td>${item.year}</td>
        <td>${item.time}</td>
        <td>${item.amount}</td>
        <td><a href="?id=${item.examID}"><i class="uil uil-eye nut-xem-chi-tiet" "examID"=${item.examID}></i></a></td>
        <td><i class="uil uil-edit nut-sua"></i></td>
        <td><i class="uil uil-trash-alt nut-xoa "examID"=${item.examID}></i></td>
    </tr>`
    });
    danh_sach_de_thi.innerHTML = html.join('\n');

    // === add event delete exam for delete btn
    const nut_xoa_dt = danh_sach_de_thi.querySelectorAll('.nut-xoa');
    nut_xoa_dt.forEach(ele => {
        ele.addEventListener('click', () => {
            deleteExam(ele.attributes[1].value);
        })
    })


    // === edit exam
    editExam();

}


// ========== function add new exam
async function addNewExam() {
    // get data from form
    const newExam = {};
    const input = form_them_dt.querySelectorAll('input');
    input.forEach(ele => {
        newExam[ele.name] = ele.value;
        ele.value = '';
    })
    // call api
    const response = await fetch(urlApiExam, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(newExam)
    })
    const exam = await response.json();
    console.log(exam);
    viewExamList();
}


// ========== function delete 
async function deleteExam(id) {
    await fetch(`${urlApiExam}?id=${id}`, {
        method: 'DELETE',
        headers: headers
    })
    viewExamList();
}

// ========== edit exam
async function editExam() {

    // === add event edit exam for delete btn
    const nut_ql_chinh_sua = danh_sach_de_thi.querySelectorAll(".nut-sua");
    const nut_luu_tt_dt_da_sua = form_sua_thong_tin_chung_dt.querySelector('.nut-submit');
    let inps;
    // get data form td
    nut_ql_chinh_sua.forEach(ele => {
        ele.addEventListener('click', () => {
            // console.log(ele.closest('tr'));
            const tr = ele.closest('tr');
            form_sua_thong_tin_chung_dt.style.display = 'block';
            inps = form_sua_thong_tin_chung_dt.querySelectorAll('input');
            const tds = tr.querySelectorAll('td');
            let j = 0;
            for(let j=1; j<tds.length-3; j++){
                inps[j-1].value = tds[j].textContent;
            }

        })
    })
    // save exam
    nut_luu_tt_dt_da_sua.addEventListener('click', async() => {
        const exam = {};
        inps.forEach(e => {
            exam[e.name] = e.value;
        })
        console.log(exam);
        // call api save exam
        const response = await fetch(urlApiExam, {
            method: 'PUT',
            headers: headers,
            body: JSON.stringify(exam)
        })
        const editedExam = await response.json();
        console.log(editedExam);
        viewExamList();
        form_sua_thong_tin_chung_dt.style.display = 'none';
    });
}


