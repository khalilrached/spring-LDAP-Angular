const btn = document.getElementById('menu');
const dropMenu = document.querySelector(".bar-menu-container");
console.log(dropMenu)
btn.addEventListener('click',()=>{
    console.log('here')
    if(dropMenu.classList.contains('active')){
        console.log('true')
        dropMenu.classList.remove('active');
    }else{
        console.log('false')
        dropMenu.classList.add('active');
    }
})

function fetchData(){
    console.log("we are in fetch func !");
    const text = document.getElementById('text');
    const dataList = document.getElementById('data');
    dataList.innerHTML = "";
    const bodydata = {
        "searchToken":text.value
    }
    console.log('data value:' , text.value);
    fetch('http://localhost:8080/form/autoCompleteData/'+text.value)
    .then((response)=>response.json())
    .then((data)=>{
       data.forEach(element => {
            dataList.innerHTML += `<option vlaue="${element}"> ${element} </option>`
       }); 
    })
    .catch((err)=>{
        console.error(err);
    })    
}