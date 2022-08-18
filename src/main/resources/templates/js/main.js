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