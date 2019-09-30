(function ($) {
    Drupal.behaviors.apigee_responsive = {
        attach: function (context, settings) {
            $('div.modal ul.openid-links li.user-link').hide();
            $('div.modal a[href="#openid-login"]').click(function() {
                $('div.modal div.apigee-responsive-openidhide').show();
            });

            $('li.dropdown').mouseover(function() {
                $(this).addClass('open');
            });

            $('li.dropdown').mouseout(function() {
                $(this).removeClass('open');
            });

            // Load the app delete form in a modal.
            $('.apigee-modal-link-delete a').click(function() {
                var hrefLocation = $(this).attr('href');
                var identifier = $(this).attr('data-target');

                // Open the empty modal.
                $(identifier).modal();
                if (($(identifier + ' .modal-body #devconnect_developer_application_delete').length == 0)) {
                    $(identifier + ' .modal-body').html('<p class="load-indicator" style="display:none;">' +
                        '<span class="label label-success" style="padding:5px;">Loading...</span></p>');
                    apigeePulsateForever(identifier + ' .modal-body .load-indicator');
                }

                // Load the page fragment (#devconnect_developer_application_delete) via an AJAX call.
                $(identifier + ' .modal-body').load(hrefLocation + ' #devconnect_developer_application_delete', function() {
                    if (!($(identifier + ' .modal-body #devconnect_developer_application_delete').length == 0)) {
                        $(this).remove('.load-indicator');
                    }
                });
                return false;
            });

            // Load the app edit form in a modal.
            $('.apigee-modal-link-edit a').click(function() {
                var hrefLocation = $(this).attr('href');
                var identifier = $(this).attr('data-target');

                // Open the empty modal.
                $(identifier).modal();
                if (($(identifier + ' .modal-body #devconnect-developer-apps-edit-form').length == 0)) {
                    $(identifier + ' .modal-body').html('<p class="load-indicator" style="display:none;">' +
                        '<span class="label label-success" style="padding:5px;">Loading...</span></p>');
                    apigeePulsateForever(identifier + ' .modal-body .load-indicator');

                    // Load the page fragment (#devconnect-developer-apps-edit-form) via an AJAX call.
                    $(identifier + ' .modal-body').load(hrefLocation + ' #devconnect-developer-apps-edit-form', function() {
                        if (!($(identifier + ' .modal-body #devconnect_developer_application_delete').length == 0)) {
                            $(this).remove('.load-indicator');
                        }
                        if (Drupal.settings.devconnect_developer_apps.selectlist == 'true'){
                            var selectItem = identifier + ' .selectlist-item';
                            $(identifier + ' select#api_product').attr('title', 'Select an API Product');

                            var sl = $(identifier + ' select#api_product').selectList({
                                instance: true,
                                clickRemove: false,
                                onAdd: function (select, value, text) {
                                    $(selectItem + ':last').append('<span style="margin-top:5px;" ' +
                                        'class="btn btn-primary pull-right remove-product">Remove</span>');
                                }
                            });

                            $('.selectlist-list').on('click', '.remove-product', function(event) {
                                sl.remove($(this).parent().data('value'));
                            });

                            $(selectItem).append('<span style="margin-top:5px;" ' +
                                'class="btn btn-primary pull-right remove-product">Remove</span>');
                        }
                    });
                }
                return false;
            });

            function apigeePulsateForever(elem) {
                $(elem).fadeTo(500, 1.0);
                $(elem).fadeTo(500, 0.1, function() {
                    apigeePulsateForever(elem);
                });
            }
        }
    };
})(jQuery);
;
/*
  This is the javascript file that will contain all the custom javascript code that you will be writing to customize the interactivity of the Apigee developer portal.
*/
;
(function ($) {
    Drupal.behaviors.syncplicity_left_menu = {
        attach: function (context, settings) {

          //  On JavaScript Load run this function
          collapsableDivsManualClickHandler();

          // check a parent menu was clicked on page load
          var pmenu=readCookie("parent_menu_clicked");

          if ( pmenu == 1) {
            var nid=readCookie("nid");

            // expire cookie
            document.cookie = "parent_menu_clicked=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
            document.cookie = "nid=; expires=Thu, 01 Jan 1970 00:00:00 UTC";

            //$(".sampleCodeCollapse-top[nid='" + nid + "']").each(function() {
            //  if ($(this).closest('#sampleCodeCollapseDiv-top').hasClass('in')) {
            //      $(this).siblings('.view-content').removeClass('hide');
            //    }
            //    else {
            //      $(this).closest('#sampleCodeCollapseDiv-top').addClass('in');
            //      $(this).siblings('.view-content').removeClass('hide');
            //    }
            //});
          }

          /*
           * Make the collapsable div be manually open and closed.
           */
          function collapsableDivsManualClickHandler() {

            // Register click handlers on the collapsable div's
            $('.sampleCodeCollapse-top').bind('click', function () {

              var nid = $(this).attr('nid');
              url = location.protocol + "//" + location.host +  "/" + nid;

              createCookie('parent_menu_clicked', '1');
              createCookie('nid', nid);
              window.location.href = url;
            });

            $('.sampleCodeCollapse').bind('click', function () {
              // expire cookie
              document.cookie = "parent_menu_clicked=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
              document.cookie = "nid=; expires=Thu, 01 Jan 1970 00:00:00 UTC";

              if ($(this).parent().find('#sampleCodeCollapseDiv').hasClass('in')) {
                $(this).parent().find('.sampleCodeCollapse').removeClass('in');
                $(this).parent().find('#sampleCodeCollapseDiv').removeClass('in');
              }
              else {
                $(this).parent().find('#sampleCodeCollapseDiv').addClass('in');
                $(this).parent().find('.sampleCodeCollapse').addClass('in');
              }
            });

            $('.menu-name-menu-docs-left-side-menu ul li > a').bind('click', function () {
              // expire cookie and remove class
              document.cookie = "parent_menu_clicked=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
              document.cookie = "nid=; expires=Thu, 01 Jan 1970 00:00:00 UTC";
              $('.sampleCodeCollapse').removeClass('in');
              $('#sampleCodeCollapseDiv').removeClass('in');
              $('#sampleCodeCollapseDiv-top').removeClass('in');
            });
          }

          // Force parent menu to fully expand
          $('.view-content').removeClass('hide');
          $('.panel-heading .sampleCodeCollapse').addClass('in');
          $('.panel-heading #sampleCodeCollapseDiv').addClass('in');

        }
    };
})(jQuery);

function createCookie(name, value) {
  // set cookie to expire after 30 seconds, this is generally enough time for the page to load
  var date = new Date();
  date.setTime(date.getTime()+(30000));
  var expires = "; expires="+date.toGMTString();
  document.cookie = name+"="+value+expires+"; path=/";
}


function readCookie(name) {
  var nameEQ = name + "=";
  var ca = document.cookie.split(';');
  for (var i = 0; i < ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') c = c.substring(1, c.length);
    if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
  }
  return null;
};
