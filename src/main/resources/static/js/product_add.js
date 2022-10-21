const fileAddButton = document.querySelector(".add-button");
const fileInput = document.querySelector(".file-input");
const submitButton = document.querySelector(".submit-button");

let productImageFiles = new Array();


fileAddButton.onclick = () => {
    fileInput.click();
}

fileInput.onchange = () => {
    const formData = new FormData(document.querySelector("form"));
    
    let changeFlag = false;
    
    formData.forEach((value) => {
        if(value.size != 0) {  // 파일 사이즈가 0이 아닐 때, 추가( => 취소 버튼 눌러도 추가 안됨)
            productImageFiles.push(value);
            console.log(productImageFiles);
            changeFlag = true;
        }
    });

    if(changeFlag){
        getImagePreview();
        fileInput.value = null;
    }
}

function getImagePreview() {
    const productImages = document.querySelector(".product-images");   
    
    productImages.innerHTML = "";

    
    productImageFiles.forEach((file, i) => {

        const reader = new FileReader();

        reader.onload = (e) => {
            productImages.innerHTML += `
                <div class="img-box">
                    <i class="fa-solid fa-xmark"></i>
                    <img class="product-img" src="${e.target.result}">
                </div>
            `;

            const deleteButton = document.querySelectorAll(".fa-xmark");
            deleteButton.forEach((xbutton, index) => {
                xbutton.onclick = () => {
                    if(confirm("상품 이미지를 지우시겠습니까?")) {
                        productImageFiles.splice(index, 1);
                        console.log(productImageFiles);
                        getImagePreview();
                    }
                };
            });
        }

        setTimeout(() => {reader.readAsDataURL(file)}, (i * 100));

    });
}

// submit버튼 클릭 시 formData로 전송하기 위한 과정
submitButton.onclick = () => {
    const productInputs = document.querySelectorAll(".product-input");

    let formData = new FormData();  // 생성

    // formData에 추가할 항목들 ("key", value)
    formData.append("category", productInputs[0].value);
    formData.append("name", productInputs[1].value);
    formData.append("price", productInputs[2].value);
    formData.append("color", productInputs[3].value);
    formData.append("size", productInputs[4].value);
    formData.append("infoSimple", productInputs[5].value);
    formData.append("infoDetail", productInputs[6].value);
    formData.append("infoOption", productInputs[7].value);
    formData.append("infoManagement", productInputs[8].value);
    formData.append("infoShipping", productInputs[9].value);
    
    productImageFiles.forEach((file) => {
        formData.append("files", file);
    });

    request(formData);
}

function request(formData) {
    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/product",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("상품 등록 완료");
            location.replace("/admin/products");
        },
        error: (error) => {
            alert("상품 등록 실패");
            console.log(error);
        }
    });
}