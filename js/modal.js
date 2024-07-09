$(document).ready(function() {
    $(".update-Danhmuc").click(function() {
      $("#editModal").modal("show");
    });
    $('#signin-signup').on('click', function() {
        $('#signin-signup-modal').modal('show');
    });
});
$(document).ready(function() {
    $('.view-avatar').click(function() {
      $('#avatarModal').modal('show');
    //   addClass('show').css('display', 'block');
    });
  
    $('.update-avatar').click(function() {
      $('<input type="file">').on('change', function() {
        // Update avatar with selected file
      }).click();
    });
  
    $('.delete-avatar').click(function() {
      // Delete avatar
    });
    const toggleBtn = $('.togg');
    const menuNav = $('#menu-nav');
    menuNav.hide();
    toggleBtn.click(function() {
        if (menuNav.is(':visible')) {
            menuNav.fadeOut();
        } else {
            menuNav.fadeIn();
        }
    });
    $('#navbarSupportedContent').hide(); 

    $('.ipsearch').click(function(){
        if ($('#navbarSupportedContent').is(':visible')) {
            $('#navbarSupportedContent').fadeOut();
        } else {
            $('#navbarSupportedContent').fadeIn();
        }
    });
});
