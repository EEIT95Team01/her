$(function() {
	/* admin_navbar toggle nav */
	$('.js_nav_button').click(toggleNav)

	/* admin_main_box */
	$('.js_form_container').hide();
	let hash = window.location.hash;
	$(hash).fadeIn('slow');

<<<<<<< HEAD
	$(window).on('hashchange', function(e){
		$('.js_form_container').hide();
		let hash = window.location.hash;
		$(hash).fadeIn('slow');
	});

	$('#Admin_nav_bar a').on('click', function(event) {
		event.preventDefault();
		$('.js_form_container').hide();
		let tab = $(this).attr('href');
		$(tab).fadeIn('slow');
	});

	/* card/font/gift description */
	$('.js_remove_description').on('click', removeDescription);
	$('.js_add_description').on('click', addDescription);

	/* preview file */
	$('input[type=file]').on('change', function() {
		previewFile(this)
	})

	/* datepicker */
	const dateFormat = "yy-mm-dd"
  const ad_manage_beginDate = $( "#Ad_manage_beginDate" )
        .datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          ad_manage_endDate.datepicker( "option", "minDate", getDate(this));
        })
  const ad_manage_endDate = $( "#Ad_manage_endDate" )
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        ad_manage_beginDate.datepicker( "option", "maxDate", getDate(this));
      })

  const ad_select_beginDate = $('#Ad_select_beginDate')
      	.datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          ad_select_endDate.datepicker( "option", "minDate", getDate(this));
        })
  const ad_select_endDate = $('#Ad_select_endDate')
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        ad_select_beginDate.datepicker( "option", "maxDate", getDate(this));
      })

  const pack_select_beginDateMailed = $('#Pack_select_beginDateMailed')
      	.datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          pack_select_endDateMailed.datepicker( "option", "minDate", getDate(this));
        })
  const pack_select_endDateMailed = $('#Pack_select_endDateMailed')
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        pack_select_beginDateMailed.datepicker( "option", "maxDate", getDate(this));
      })

  const orderform_select_beginDateCreated = $('#Orderform_select_beginDateCreated')
      	.datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          orderform_select_endDateCreated.datepicker( "option", "minDate", getDate(this));
        })
  const orderform_select_endDateCreated = $('#Orderform_select_endDateCreated')
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        orderform_select_beginDateCreated.datepicker( "option", "maxDate", getDate(this));
      })

    function getDate(element) {
      var date;
      try {
        date = $.datepicker.parseDate(dateFormat, element.value);
      } catch(error) {
        date = null;
      }

      return date;
    }
})

function toggleNav() {
	$(this).children('button').toggleClass('bgi_close_nav').toggleClass('bgi_open_nav');
	$(this).parent().next().toggle();
}

function previewFile(input) {
	if (input.files && input.files[0]) {
        let reader = new FileReader();

        reader.onload = function (e) {
            $('#' + input.id + '_preview').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    } else {
    	$('#' + input.id + '_preview').attr('src', '/views/images/_for_views/cover_default.png')
    }
}

function removeDescription() {
	let container = $(this).closest('.js_description_container');
	let box = container.children('.js_description_box');
	box.last().remove();
}

function addDescription() {
	let container = $(this).closest('.js_description_container');
	let length = container.children('.js_description_box').length;

	let box = $("<div class='js_description_box flex_block'></div>");

	let box440 = $("<div class='box440'></div>");
		let box440_box440 = $("<div class='box440'></div>");
			let box440_box440_img = $("<img id='Description_" + (length+1) + "_preview' src='/her/images/_for_views/cover_default.png' width='440' />")
=======
  $('#Admin_nav_bar a').on('click', function(e) {
    $('.js_form_container').hide();
    let hash = window.location.hash;
    $(hash).fadeIn('slow');
  })

	$(window).on('hashchange', function(e) {
		$('.js_form_container').hide();
		let hash = window.location.hash;
		$(hash).fadeIn('slow');
	});

	/* card/font/gift description */
	$('.js_remove_description').on('click', removeDescription);
	$('.js_add_description').on('click', addDescription);

	/* preview file */
	$('input[type=file]').on('change', function() {
		previewFile(this)
	})

	/* datepicker */
	const dateFormat = "yy-mm-dd"
  const ad_manage_beginDate = $( "#Ad_manage_beginDate" )
        .datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          ad_manage_endDate.datepicker( "option", "minDate", getDate(this));
        })
  const ad_manage_endDate = $( "#Ad_manage_endDate" )
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        ad_manage_beginDate.datepicker( "option", "maxDate", getDate(this));
      })

  const ad_select_beginDate = $('#Ad_select_beginDate')
      	.datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          ad_select_endDate.datepicker( "option", "minDate", getDate(this));
        })
  const ad_select_endDate = $('#Ad_select_endDate')
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        ad_select_beginDate.datepicker( "option", "maxDate", getDate(this));
      })

  const pack_select_beginDateMailed = $('#Pack_select_beginDateMailed')
      	.datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          pack_select_endDateMailed.datepicker( "option", "minDate", getDate(this));
        })
  const pack_select_endDateMailed = $('#Pack_select_endDateMailed')
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        pack_select_beginDateMailed.datepicker( "option", "maxDate", getDate(this));
      })

  const orderform_select_beginDateCreated = $('#Orderform_select_beginDateCreated')
      	.datepicker({
          changeMonth: true,
          changeYear: true,
          numberOfMonths: 1,
          dateFormat: dateFormat
        })
        .on( "change", function() {
          orderform_select_endDateCreated.datepicker( "option", "minDate", getDate(this));
        })
  const orderform_select_endDateCreated = $('#Orderform_select_endDateCreated')
	      .datepicker({
	        changeMonth: true,
	        changeYear: true,
	        numberOfMonths: 1,
	        dateFormat: dateFormat
	      })
      .on( "change", function() {
        orderform_select_beginDateCreated.datepicker( "option", "maxDate", getDate(this));
      })

  function getDate(element) {
    var date;
    try {
      date = $.datepicker.parseDate(dateFormat, element.value);
    } catch(error) {
      date = null;
    }

    return date;
  }
})

function toggleNav() {
	$(this).children('button').toggleClass('bgi_close_nav').toggleClass('bgi_open_nav');
	$(this).parent().next().toggle();
}

function previewFile(input) {
	if (input.files && input.files[0]) {
        let reader = new FileReader();

        reader.onload = function (e) {
            $('#' + input.id + '_preview').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    } else {
    	$('#' + input.id + '_preview').attr('src', webapp + '/images/_for_views/cover_default.png')
    }
}

function removeDescription() {
	let container = $(this).closest('.js_description_container');
	let box = container.children('.js_description_box');
	box.last().remove();
}

function addDescription() {
	let container = $(this).closest('.js_description_container');
	let length = container.children('.js_description_box').length;

	let box = $("<div class='js_description_box flex_block'></div>");

	let box440 = $("<div class='box440'></div>");
		let box440_box440 = $("<div class='box440'></div>");
			let box440_box440_img = $("<img id='Description_" + (length+1) + "_preview' src=" + webapp + "'/images/_for_views/cover_default.png' width='440' />")
>>>>>>> branch 'master' of https://github.com/EEIT95Team01/her.git
		let box_440_block40 = $("<div class='block40 flex_left'></div>");
			let box440_block40_input = $("<input id='Description_" + (length+1) + "' name='description_" + (length+1) + "' type=file />")
	box440_box440.append(box440_box440_img)
	box_440_block40.append(box440_block40_input)

	box440.append([box440_box440, box_440_block40])


	let box360 = $("<div class='box360'></div>");
		let box360_textarea = $("<textarea class='rec_textarea360 chi_16_30'></textarea>")
	box360.append(box360_textarea)

	box.append([box440, box360])
	container.append(box).append($("<div class='block20'></div>"))

	$('input[type=file]').on('change', function() {
		previewFile(this)
	})
}
