//将日期 转换成 yyyy-MM-dd 格式
function getFormatDate(d){
    var year = d.getFullYear();
    var month = d.getMonth()+1;
    var day = d.getDate();
    return year+"-" + month + "-" + day;
}
//将日期 转换成 yyyy-MM格式
function getFormatDateYM(d){

    var year = d.getFullYear();
    var month = d.getMonth()+1;

    return year+"-" + month ;
}


function getFullDate(ms){
     var d = new Date(ms);
     var year = d.getFullYear();
     var month = d.getMonth()+1;
     var day = d.getDate();
     return year+"-" + month + "-" + day;

 }
