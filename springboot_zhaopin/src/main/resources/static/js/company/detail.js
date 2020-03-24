/**
 * Created by admin on 2020/2/27.
 */
//职位申请
$(".application_btn").click(function () {
    alert("申请成功");
});
var collectionFlag = 0;
$(".col_stat,.job_col_star").click(function () {
    checkCollection();
    // console.log(collectionFlag);
    // console.log(typeof collectionFlag); //number
});
function checkCollection() {
    if (collectionFlag == 0) {
        $(".job_col_star").attr("src","../images/star-real.png");
        collectionFlag = 1;
        alert("职位收藏成功")
    }else {
        $(".job_col_star").attr("src","../images/star-empty.png");
        collectionFlag = 0;
    }

}