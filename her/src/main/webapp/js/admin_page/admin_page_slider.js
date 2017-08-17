$(function() {
	/* Tag */
	$('#Tag_select_discount_slider').slider({
			range: true,
			min: 0,
			max: 100,
			values: [0, 100],
			slide: function(event, ui) {
				$('#Tag_select_discount_range').val(ui.values[ 0 ] + ' % - ' + ui.values[1] + ' %');
			}
		})
		$('#Tag_select_discount_range').val($('#Tag_select_discount_slider').slider('values', 0)
			+ ' % － ' + $('#Tag_select_discount_slider').slider( 'values', 1) + ' %');

	/* Card */
	$('#Card_select_price_slider').slider({
		range: true,
		min:0,
		max: 500,
		values:[0, 500],
		slide: function(event, ui) {
			$('#Card_select_price_range').val('NT $ ' + ui.values[ 0 ] + ' - NT $ ' + ui.values[1]);
		}
	})
	$('#Card_select_price_range').val('NT $ ' + $('#Card_select_price_slider').slider('values', 0)
		+ ' － NT $ ' + $('#Card_select_price_slider').slider( 'values', 1));

	$('#Card_select_cost_slider').slider({
		range: true,
		min: 0,
		max: 500,
		values: [0, 500],
		slide: function(event, ui) {
			$('#Card_select_cost_range').val('NT $ ' + ui.values[ 0 ] + ' - NT $ ' + ui.values[1]);
		}
	})
	$('#Card_select_cost_range').val('NT $ ' + $('#Card_select_cost_slider').slider('values', 0)
		+ ' － NT $ ' + $('#Card_select_cost_slider').slider( 'values', 1));

	/* Font */
	$('#Font_select_price_slider').slider({
		range: true,
		min:0,
		max: 500,
		values:[0, 500],
		slide: function(event, ui) {
			$('#Font_select_price_range').val('NT $ ' + ui.values[ 0 ] + ' - NT $ ' + ui.values[1]);
		}
	})
	$('#Font_select_price_range').val('NT $ ' + $('#Font_select_price_slider').slider('values', 0)
		+ ' － NT $ ' + $('#Font_select_price_slider').slider( 'values', 1));

	/* Gift */
	$('#Gift_select_price_slider').slider({
		range: true,
		min:0,
		max: 500,
		values:[0, 500],
		slide: function(event, ui) {
			$('#Gift_select_price_range').val('NT $ ' + ui.values[ 0 ] + ' - NT $ ' + ui.values[1]);
		}
	})
	$('#Gift_select_price_range').val('NT $ ' + $('#Gift_select_price_slider').slider('values', 0)
		+ ' － NT $ ' + $('#Gift_select_price_slider').slider( 'values', 1));

	$('#Gift_select_cost_slider').slider({
		range: true,
		min: 0,
		max: 500,
		values: [0, 500],
		slide: function(event, ui) {
			$('#Gift_select_cost_range').val('NT $ ' + ui.values[ 0 ] + ' - NT $ ' + ui.values[1]);
		}
	})
	$('#Gift_select_cost_range').val('NT $ ' + $('#Gift_select_cost_slider').slider('values', 0)
		+ ' － NT $ ' + $('#Gift_select_cost_slider').slider( 'values', 1));

	/* Pack */
	$('#Pack_select_sum_slider').slider({
		range: true,
		min:0,
		max: 3000,
		values:[0, 3000],
		slide: function(event, ui) {
			$('#Pack_select_sum_range').val('NT $ ' + ui.values[ 0 ] + ' - NT $ ' + ui.values[1]);
		}
	})
	$('#Pack_select_sum_range').val('NT $ ' + $('#Pack_select_sum_slider').slider('values', 0)
		+ ' － NT $ ' + $('#Pack_select_sum_slider').slider( 'values', 1));
})
