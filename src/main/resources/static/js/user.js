//"确定"点击事件
$(".confirm").click(function(){
  var tr;
  $.ajax({
    type: "POST",
    url: "/user/userList2/1/3",
    // data: JSON.stringify(param),
    timeout:30000,
    // dataType:'json',
    // contentType: "application/json",
    success:function (info){
      if(info){
        $(".student").html("");
        $.each(info,function(i,item){
          tr+='<tr class="student"><td>'+item.id+'</td>'+'<td>'+item.name+'</td>'+'<td>'+item.age+'</td>'
              +'<td>'+item.address+'</td>'+'<td>'+item.sex+'</td>'+'<td>'+item.telephonenum+'</td>'+'<td>'+item.profession+'</td></tr>';
        });
        $(".title").after(tr);
      }
    },
    error:function (XMLHttpRequest, textStatus, errorThrown){
      console.log(errorThrown);
      alert(2);
    },
    complete:function(event,xhr,options){
      // alert(3);
    }
  });
});