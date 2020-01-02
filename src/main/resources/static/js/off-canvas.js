(function($) {
  'use strict';
  $(function() {
    $('[dao-toggle="offcanvas"]').on("click", function() {
      $('.sidebar-offcanvas').toggleClass('active')
    });
  });
})(jQuery);