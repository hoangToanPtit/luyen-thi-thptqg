const domain = 'https://localhost/luyenthithptqg';


//header
let headers = new Headers();
headers.append("Content-Type", "application/json");

//api
const urlApiStudents = `${domain}/admin/api/students`;

//elementDom
const danh_sach_hs = document.querySelector('.danh-sach-hoc-sinh tbody');
const btn_them_hs = document.querySelector('.them-moi-hs');
const form_them_hs = document.querySelector('.form-them-hoc-sinh');
const btn_luu_hs = form_them_hs.querySelector('.nut-submit');
const btn_dong = document.querySelectorAll('.form-ql-hs .nut-dong');
const form_ql = document.querySelectorAll('.nen-xam');
const form_sua_hs = document.querySelector('.form-sua-hoc-sinh');
const input_form_sua_hs = form_sua_hs.querySelectorAll('input');
const btn_chinh_sua_hs = document.querySelector('.form-sua-hoc-sinh .nut-submit');

let stt = 1;


// ==================================== MAIN============
(() => {
    // ===== xu li su kien chung ==============
    // --------- dong cac modal ----------
    btn_dong.forEach(ele => {
        ele.addEventListener('click', () =>{
            form_ql.forEach(e => {
                e.style.display = 'none';
            })
        })
    })
    // ----------- xu li modal them moi hoc sinh ----------
    btn_them_hs.addEventListener('click', () => {
        form_them_hs.style.display = 'block';
    })



    // ---------- view student table ---------
    viewListStudent();

    //  ---------- add new student ----------
    btn_luu_hs.addEventListener('click', () => {
        addNewStudent();
        form_them_hs.style.display = 'none';
    })

})();


//========== function view student table
async function viewListStudent() {
    const response = await fetch(urlApiStudents, {
        method: 'GET',
        headers: headers
    })
    stt = 1;
    const studentArr = await response.json();
    const sl_hs = document.querySelector('.so-luong-hs span');
    sl_hs.textContent = studentArr.length;
    const html = studentArr.map((item) => {
        return `
        <tr>
            <td>${stt++}</td>
            <td>${item.userID}</td>
            <td>${item.firstName}</td>
            <td>${item.lastName}</td>
            <td>${item.dateOfBirth}</td>
            <td>${item.email}</td>
            <td>${item.userName}</td>
            <td>***********</td>
            <td><i class="uil uil-edit nut-sua"></i></td>
            <td><i class="uil uil-trash-alt nut-xoa" "userID"= "${item.userID}"></i></td>
        </tr>
        `  
    });
    danh_sach_hs.innerHTML = html.join(' ');

    //===== edit student ==== 
    editStudent();


    // ============= delete student =============
    // deleteStudent();
    const btn_xoa_hs = document.querySelectorAll('.danh-sach-hoc-sinh .nut-xoa');
    btn_xoa_hs.forEach(ele => {
        ele.addEventListener('click', (e) => {
            deleteStudent(ele.attributes[1].value);
        })
    })
};

//========== function add new student
async function addNewStudent(){
    // get data from form
    const newStudent = {role: "student"};
    const input = form_them_hs.querySelectorAll('input');
    input.forEach(ele => {
        newStudent[ele.name] = ele.value;
        ele.value = '';
    })
    // call api
    const response = await fetch(urlApiStudents, {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(newStudent)
    })
    const student = await response.json();
    console.log(student);
    viewListStudent()
}

//========== function delete student
async function deleteStudent(id) {
    await fetch(`${urlApiStudents}?id=${id}`, {
        method: 'DELETE',
        headers: headers
    })
    viewListStudent();
}


// =================================== edit student ============================
// function add event for edit btn
function editStudent() {
    var btn_sua_hs = document.querySelectorAll('.danh-sach-hoc-sinh .nut-sua');
    btn_sua_hs.forEach(ele => {
        ele.addEventListener('click', () => {
            const tr = ele.closest('tr');
            const tds = tr.querySelectorAll('td');
            for(let j=1; j<tds.length-2; j++){
                input_form_sua_hs[j-1].value = tds[j].textContent;    
            }
            form_sua_hs.style.display = 'block';
        })
    })


    btn_chinh_sua_hs.addEventListener('click', async () => {
        
        const editedStudent = {role: "student"};
        input_form_sua_hs.forEach(e => {
            editedStudent[e.name] = e.value;
        })
    
        const response = await fetch(urlApiStudents, {
            method: 'PUT',
            headers: headers,
            body: JSON.stringify(editedStudent)
        })
        const editStu = await response.json();
        console.log(editStu);
        await viewListStudent();
        form_sua_hs.style.display = 'none';
    })

}




// {"userID":1,"email":"abcdefgh","userName":"toan","password":"12345","role":"student",
// "firstName":"toan1","lastName":"nguyen123","dateOfBirth":980960400000,"classes":null,"exames":null}










































