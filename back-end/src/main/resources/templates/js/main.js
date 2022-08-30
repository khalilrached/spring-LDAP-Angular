function showMenu(elem){
    const dropMenu = document.querySelector(".bar-menu-container");
    if(dropMenu.classList.contains('active')){
        dropMenu.classList.remove('active');
    }else{
        dropMenu.classList.add('active');
    }
}
