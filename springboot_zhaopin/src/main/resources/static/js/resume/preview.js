$(".previewBtn").click(function () {
    console.log("resume id:...." +$(".resumeId").val() );
    var id= $(".resumeId").val();
    location.href="/resume/preview/"+id;
});