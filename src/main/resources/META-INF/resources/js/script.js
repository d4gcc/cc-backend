$(document).ready(function () {
  // dummy file to be implemented (ajax functions)
  //var our_url =  "https://jsonplaceholder.typicode.com/posts?userId=" + "1";
  globalThis.nb_sub_fam = 0;
  $.ajax({
    url: sub_fam_url, success: function (result) {
      console.log(result);
      nb_sub_fam = result.length;
    },
    error: function (e) {
      $("#div1").html("<strong>Error</strong>");
      console.log("ERROR: ", e);
    }});
 
  //nb_sub_fam = result.length;
  $.ajax({
    url: our_url, success: function (result) {
    // console.log(result);
    
    var ul_up = $('<div> <ul>');
    var ul_down = $('</div> </ul>');
    var list = "";
    for(var j = 0; j<nb_sub_fam; j++) {
    //create the second layer
    list += '<div class="panel"><div class="panel-heading" role="tab" id="' + "heading" + j + '"><h4 class="panel-title"><a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#' + "collapse" + j + '" aria-expanded="true" aria-controls="' + "collapse" + j + '">' + globalThis.res[j].recommendation + '</a></h4></div><div id="' + "collapse" + j + '" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="' + "heading" + j + '"><div class="panel-body"><ul>';
    // this would go in your ajax success handler
    for (var i = 0; i < result.length; i++) {
      if (result[i].subFamilyId == j) {
        var li = '<li><div class="element"><div class="element-left"><input type="checkbox" name="' + result[i].id + '" id="' + result[i].practiceId + '"/></div><div class="element-right"><h2 class="name">' + result[i].precisionOfRecommendations + '</h2><p class="title">' + result[i].criteria + '</p><p class="location">' + result[i].indicators + '</p><div class="interests"><p class="interests_title">Interests: </p><span class="interests_item">A.I.</span><span class="interests_item">Technology</span><span class="interests_item">Coding</span><span class="interests_item">Python</span></div></div></div></li>';
        list += li;
        li = "";
      }

    }
    list += '</ul></div></div></div>';

  }
  $('#wkslist').append(list);
},
  error: function (e) {
    $("#div1").html("<strong>Error</strong>");
    console.log("ERROR: ", e);
  }
  });

/*
  <div class="panel">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Collapsible item #1
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <ul>
          <li>a</li>
        </ul>
      </div>
    </div>
  </div>
*/







$('.collapse.in').prev('.panel-heading').addClass('active');
$('#accordion, #bs-collapse')
  .on('show.bs.collapse', function (a) {
    $(a.target).prev('.panel-heading').addClass('active');
  })
  .on('hide.bs.collapse', function (a) {
    $(a.target).prev('.panel-heading').removeClass('active');
  });

});
var url = 'https://www.orimi.com/pdf-test.pdf';
function addScript() {
  const script = document.createElement('script');
  script.type = 'application/javascript';
  script.src = url;
  document.head.appendChild(script);
  console.log("Downloaded successfully!")
}


