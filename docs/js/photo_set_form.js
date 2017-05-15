$(document).ready(function() {
    var textareas = $('.materialize-textarea');
    textareas.each(function () {
        $(this).val($(this).attr("value"));
        $(this).trigger('autoresize');
    });
});
