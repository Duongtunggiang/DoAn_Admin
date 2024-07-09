$(document).ready(function() {
  // Add a click event listener to the dropdown toggle
  $('#dropdown_myaccount').click(function(e) {
    // Prevent the default link behavior
    e.preventDefault();

    // Toggle the dropdown menu
    $(this).toggleClass('show');
    $(this).next('.dropdown-menu').toggleClass('show');
  });

  // Add a hover event listener to the dropdown menu
  $('.dropdown-menu').on('mouseenter', function() {
    // Show the dropdown menu
    $('#dropdown_myaccount').addClass('show');
    $(this).addClass('show');
  });

  // Add a hover event listener to the document to close the dropdown menu when mouse leaves the dropdown menu
  $(document).on('mouseleave', '.dropdown-menu', function() {
    // Hide the dropdown menu
    $('#dropdown_myaccount').removeClass('show');
    $('.dropdown-menu').removeClass('show');
  });
});