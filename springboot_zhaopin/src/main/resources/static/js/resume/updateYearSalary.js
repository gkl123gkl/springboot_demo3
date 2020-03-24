/**
 * Created by admin on 2020/3/2.
 */

$(".year-income-title img").click(function () {
    $(".show-income").hide();
    $(".year-income").show();
})

/*   保存年薪   */
$(".income-save-btn").click(function () {
    $(".year-income").hide();
    $(".show-income").show();
    updateYearSalary();
})



//年收入模块
function  updateYearSalary() {
    var resumeId=$(".resumeId").val();
    var salary=$(".income-money").val();
    $.ajax({
        type:"POST",
        url:"/resume/yearsalary",
        datatype:"json",
        data:{
            "_method":"PUT",
            "resumeId":resumeId,
            "salary":salary
        },
        success:function (result) {
            console.log(result);

            $(".income-value").text(result.data.resumeIncome);
        }
    });
}

/*    取消    */
$(".income-undo-btn").click(function () {
    $(".year-income").hide();
    $(".show-income").show();
    if (person.personIncome == "" || person.personIncome == null || person.personIncome == "0") {
        $(".year-income-title i").remove();
    } else {
        $(".income-value").text(person.personIncome);
    }
});
