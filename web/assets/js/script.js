$(document).ready(function(){

  var $toggle = $('#nav-toggle');
  var $menu = $('#nav-menu');

  $toggle.click(function() {
    $(this).toggleClass('is-active');
    $menu.toggleClass('is-active');
  });

  $('.modal-button').click(function() {
    var target = $(this).data('target');
    $('html').addClass('is-clipped');
    $(target).addClass('is-active');
  });

  $('.modal-background, .modal-close').click(function() {
    $('html').removeClass('is-clipped');
    $(this).parent().removeClass('is-active');
  });

  $('.modal-card-head .delete, .modal-card-foot .button').click(function() {
    $('html').removeClass('is-clipped');
    $('.modal').removeClass('is-active');
  });

  $('.filter').click(function() {
    $('.filter').removeClass('strong is-disabled');
    $(this).addClass('strong is-disabled');
  });

  $("#tags").select2({
    tags: true
  });

  var citizenId = new Cleave('#citizen-id', {
    blocks: [1,4,5,2,1],
    uppercase: true
  });
  
  var tel = new Cleave('#tel', {
    prefix: '+66',
    delimiter: '-',
    blocks: [3,2,3,4],
    uppercase: true
  });

});
