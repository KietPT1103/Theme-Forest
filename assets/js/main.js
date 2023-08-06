function changeImage(source) {
  var image = document.getElementById("display-pic");
  image.src = source;
}

function changeStudentImage(source) {
  var image = document.getElementById("student-display-pic");
  image.src = source;
}

function showDiv(divId) {
  // Ẩn tất cả các div bằng cách thêm class "hidden"
  hideAllDivs();

  // Lấy div theo id và xóa class "hidden" để hiển thị nó
  var div = document.getElementById(divId);
  div.classList.remove("hidden");
}

function hideAllDivs() {
  var divs = document.getElementsByTagName("div");
  for (var i = 0; i < divs.length; i++) {
    var div = divs[i];
    if (
      div.id === "teacher-profile" ||
      div.id === "student-profile" ||
      div.id === "side-profile-menu"
    ) {
      divs[i].classList.add("hidden");
    }
  }
}

function showDiv2(divId) {
  // Ẩn tất cả các div bằng cách thêm class "hidden"
  hideAllDivs2();

  // Lấy div theo id và xóa class "hidden" để hiển thị nó
  var div = document.getElementById(divId);
  div.classList.remove("hidden");
  div.classList.add("flex");
}

function hideAllDivs2() {
  var divs = document.getElementsByTagName("div");
  for (var i = 0; i < divs.length; i++) {
    var div = divs[i];
    if (
      div.id === "h5p" ||
      div.id === "course-attachments" ||
      div.id === "course-summary" ||
      div.id === "gradebook"
    ) {
      divs[i].classList.add("hidden");
    }
  }
}

function showDiv3(divId) {
  // Ẩn tất cả các div bằng cách thêm class "hidden"
  hideAllDivs3();

  // Lấy div theo id và xóa class "hidden" để hiển thị nó
  var div = document.getElementById(divId);
  div.classList.remove("hidden");
  div.classList.add("flex");
}

function hideAllDivs3() {
  var divs = document.getElementsByTagName("div");
  for (var i = 0; i < divs.length; i++) {
    var div = divs[i];
    if (
      div.id === "scorm" ||
      div.id === "bb-press" ||
      div.id === "buddy-press" ||
      div.id === "gami-press"
    ) {
      divs[i].classList.add("hidden");
    }
  }
}

function showDiv4(divId) {
  // Ẩn tất cả các div bằng cách thêm class "hidden"
  hideAllDivs4();

  // Lấy div theo id và xóa class "hidden" để hiển thị nó
  var div = document.getElementById(divId);
  div.classList.remove("hidden");
  div.classList.add("flex");
}

function hideAllDivs4() {
  var divs = document.getElementsByTagName("div");
  for (var i = 0; i < divs.length; i++) {
    var div = divs[i];
    if (
      div.id === "assignment" ||
      div.id === "message" ||
      div.id === "announcement" ||
      div.id === "student-forum"
    ) {
      divs[i].classList.add("hidden");
    }
  }
}

function showDiv5(divId) {
  // Ẩn tất cả các div bằng cách thêm class "hidden"
  hideAllDivs5();

  // Lấy div theo id và xóa class "hidden" để hiển thị nó
  var div = document.getElementById(divId);
  div.classList.remove("hidden");
  div.classList.add("flex");
}

function hideAllDivs5() {
  var divs = document.getElementsByTagName("div");
  for (var i = 0; i < divs.length; i++) {
    var div = divs[i];
    if (
      div.id === "point-reward" ||
      div.id === "course-bundles" ||
      div.id === "earning" ||
      div.id === "group-course"
    ) {
      divs[i].classList.add("hidden");
    }
  }
}

function toggleContent(id) {
  var content = document.getElementById("content-" + id);
  var isHidden = content.classList.contains("hidden");
  
  if (isHidden) {
    content.classList.remove("hidden");
    content.style.maxHeight = "0";
    setTimeout(function() {
      content.style.maxHeight = content.scrollHeight + "px";
    }, 0);
  } else {
    content.style.maxHeight = "0";
    setTimeout(function() {
      content.classList.add("hidden");
    }, 500); // Đảm bảo thời gian chờ bằng với duration trong CSS
  }
}
