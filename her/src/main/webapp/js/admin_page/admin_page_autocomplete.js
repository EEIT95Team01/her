
const baseUrl = serverUrl + '/api/admin/tag'


$(function() {
  function split(val) {
    return val.split(/,\s*/);
  }

  function extractLast(term) {
    return split(term).pop();
  }

  /*
  for loop xxx_manage_tagNames
  */

  const autocompleteSelects = ["#Card_manage_tagNames", "#Font_manage_tagNames", "#Gift_manage_tagNames"]

  autocompleteSelects.map(xxx)

  function xxx(autocompleteSelect) {
    $(autocompleteSelect).after($("<input type='hidden' id='" + autocompleteSelect.replace('#', '') + '_id' + "' />"))

    fetch(baseUrl)
    .then((result) => result.json())
    .then((result) => {
      $(autocompleteSelect).autocomplete({
        minLength: 0,
        source: function(request, response) {

          response(result.data)
        },
        focus: function( event, ui ) {
          return false;
        },
        select: function( event, ui ) {
          var names = split( this.value );
          // remove the current input
          names.pop();
          // add the selected item
          names.push( ui.item.name );
          // add placeholder to get the comma-and-space at the end
          names.push( "" );
          const ids = names.reduce((acc, cur) => {
            result.data.map((item) => {
              if (item.name === cur) {
                acc.push(item.id)
              }
            })
            return acc
          }, [])
          $(this).val( names.join( ", " ) );
          $(autocompleteSelect + '_id').val( ids.join( ", " ) );

          return false;
        }
      })
      .autocomplete( "instance" )._renderItem = function( ul, item ) {
        return $( "<li>" )
          .append( "<div>" + item.name + "</div>" )
          .appendTo( ul );
      };
    })
  }
});
