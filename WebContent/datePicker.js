$(function() {
    //This array containes all the disabled array

        $("#ssdatepicker").datepicker({
          minDate : 0,
          maxDate : '1Y' ,
          todayHighlight: 1,
          dateFormat: "yy-mm-dd",
          beforeShowDay: function (date) {
              var dateStr = jQuery.datepicker.formatDate('yy-mm-dd', date);
                  return [ssDatearr.indexOf(dateStr) == -1];
          },

        });
        
});
$(function() {
$("#msdatepicker").datepicker({
    minDate : 0,
    maxDate : '1Y' ,
    todayHighlight: 1,
    dateFormat: "yy-mm-dd",
    beforeShowDay: function (date) {
        var dateStr = jQuery.datepicker.formatDate('yy-mm-dd', date);
            return [msDatearr.indexOf(dateStr) == -1];
    },

  });
});
$(function() {
$("#lsdatepicker").datepicker({
    minDate : 0,
    maxDate : '1Y' ,
    todayHighlight: 1,
    dateFormat: "yy-mm-dd",
    beforeShowDay: function (date) {
        var dateStr = jQuery.datepicker.formatDate('yy-mm-dd', date);
            return [lsDatearr.indexOf(dateStr) == -1];
    },

  });
});
$(function() {
$("#tdate").datepicker({
    minDate : 0,
    maxDate : '1Y' ,
    todayHighlight: 1,
    dateFormat: "yy-mm-dd",
    beforeShowDay: function (date) {
        var dateStr = jQuery.datepicker.formatDate('yy-mm-dd', date);
            return [tDatearr.indexOf(dateStr) == -1];
    },

  });
});
/**
 * 
 */