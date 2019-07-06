//layui table 单击行选中checkbox
$(document).on("click",".layui-table-body table.layui-table tbody tr",function(){
    var obj = event ? event.target : event.srcElement;
    var tag = obj.tagName;
    var checkbox = $(this).find("td div.laytable-cell-checkbox div.layui-form-checkbox I");
    if(checkbox.length!=0){
        if(tag == 'DIV') {
            checkbox.click();
        }
    }

});

$(document).on("click","td div.laytable-cell-checkbox div.layui-form-checkbox",function(e){
    e.stopPropagation();
});