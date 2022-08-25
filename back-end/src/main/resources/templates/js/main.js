function showMenu(elem){
    const dropMenu = document.querySelector(".bar-menu-container");
    if(dropMenu.classList.contains('active')){
        dropMenu.classList.remove('active');
    }else{
        dropMenu.classList.add('active');
    }
}

function isSelected(elem){
    const text = document.getElementById('text');
    text.value = elem.innerHTML.toString();
    init();
}

async function fetchData(){
    const text = document.getElementById('text');
    const dataList = document.getElementById('data');
    dataList.innerHTML = "";
    const bodydata = {
        "searchToken":text.value
    }
    console.log('data value:' , text.value);
    const response = await fetch('http://localhost:8080/form/autoCompleteData/'+text.value);
    var data = await response.json();
    data.forEach((element,index) => {
        dataList.innerHTML += `<div class="px-2 p-1 " onclick="isSelected(this)" >${element}</div>`;
    });  
}

function init(){
    const dataList = document.getElementById('data');
    dataList.innerHTML = "";
}

window.addEventListener('click',(event)=>{
    const dataList = document.getElementById('data');
    if(!event.target.classList.contains('data-value')){
        if(dataList.innerHTML!=""){
            dataList.innerHTML="";
        }
    }
})