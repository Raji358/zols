'use strict';

(function($) {
    var base_url = 'http://localhost:8080/api';

    $.ajaxSetup({
      contentType: 'application/json',
    })

    var template;

    var selectedCategory;

    $('#createCategory').click(function() {
        $.fn.createCategory();
    });

    $.fn.listFirstCategory = function() {
        $.get(base_url + '/link_categories').done(function(data) {
            var template = $.templates("#viewLink");
            var htmlOutput = template.render({category: data});
            $("#categories").prepend(htmlOutput);
        });
    };

    $.fn.saveCategory = function() {
      console.log(selectedCategory);
      $.ajax({
        method: 'POST',
        url: base_url + '/link_categories',
        dataType : 'json',
        data:  JSON.stringify(selectedCategory)
      }).done(function(data) {
        alert("Data Loaded: " + data);
      });
    };
    $.fn.editFirstCategory = function() {
        $.get(base_url + '/link_categories').done(function(data) {
            template = $.templates("#editLink");
            selectedCategory = data[0];
            console.log(selectedCategory);
            template.link('#categories', selectedCategory);
            $(selectedCategory).on("propertyChange", $.fn.changeHandler);
        });
    };

    $.fn.createCategory = function() {
        selectedCategory = {};
        template = $.templates("#editLink");
        template.link('#result', selectedCategory);
    };


    $.fn.listFirstCategory();


}(jQuery));

