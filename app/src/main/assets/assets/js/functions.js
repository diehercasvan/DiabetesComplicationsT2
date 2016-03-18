/*Funciones*/
var arr = ["a","b","p","li","ul","ol","h1","h2","h3","h4","h5","h6","table"];
var arrs = [];
$(document).ready(function()
{
	$("#slide").attr('max','60');

	for(var i=0;i<arr.length;i++)
	{

		arrs.push($(arr[i]).css('font-size'));
	};

	$('#btn_opciones').click(function(event) 
	{
		$('#menu_botones').toggle();
		$('#menu_slide').toggle();
	});
	$('#slide').change(function(event)
	{
		//var opcion = $(this).attr('id');
		var data = $(this).data('inicial');
		var opcion = $(this).val();
		tamanoTextoSlide(opcion,data);
	});

	$('#select_font').change(function(event)
	{
		var opcion = $(this).val();
		fuenteTexto(opcion);
	});

	$('.botones-caja-lector').click(function(event)
	{
		var opcion = $(this).attr('id');
		estiloLectura(opcion);
	});
	$('#contenedor-texto').click(function()
    	{
    	if($('#menu_botones').is(":visible")){
    		$('#menu_botones').toggle();
       		 $('#menu_slide').toggle();
        }
    });


});

function fuenteTexto(opcion)
{
	//var arr = ["a","b","p","li","ul","ol","h1","h2","h3","h4","h5","h6","table"];
	for(var i =0;i<arr.length;i++)
	{
		$(arr[i]).css('font-family',opcion);
	}
}

function tamanoTextoSlide(opcion,data)
{
	//var arr = ["p","h1","h2","h3","h4","h5","h6","li","table"];

	//var arrs = ["16","22","20","19","18","17","16","16","16"];

	//if(data > opcion)
	//{

	for(var i =0;i<arr.length;i++)
	{
		var fontSize = parseInt(arrs[i]) + parseInt(opcion);
		//var tagVf = parseInt(fontSize) + parseInt(opcion) +'px';
		//var tagVi = $(arr[i]).css('font-size');
		//var tagVf = parseInt(tagVi) - parseInt(opcion);
		$(arr[i]).css('font-size',fontSize+'px');
	}
	
	//$('#slide').data('inicial','');
	/*}
	else
	{
		for(var i =0;i<arr.length;i++)
		{
			var tagVi = $(arr[i]).css('font-size');
			var tagVf = parseInt(tagVi) + parseInt(opcion);
			$(arr[i]).css('font-size',tagVf);
		}
	}
	$('#slide').data('inicial',opcion);*/
}
/*
function tamanoTexto(opcion)
{
	var arr = ["p","h1","h2","h3","h4","h5","h6","li","table"];
	var size_general = '14';
	var p = $('p').css('font-size');
	switch(opcion)
	{
	case 'btn_menor':
		if(p > size_general)
		{
			for(var i =0;i<arr.length;i++)
			{
				var tagVi = $(arr[i]).css('font-size');
				var tagVf = parseInt(tagVi) - 1;
				$(arr[i]).css('font-size',tagVf);
			}
		}
		break;

	case 'btn_mayor':
		for(var i =0;i<arr.length;i++)
		{
			var tagVi = $(arr[i]).css('font-size');
			var tagVf = parseInt(tagVi) + 1;
			$(arr[i]).css('font-size',tagVf);
		}
	break;
	} 
}
*/
function estiloLectura(opcion)
{
	switch(opcion)
	{
		case 'btn_normal':
			$('body').css('background', '#ffffff');
			$('#contenedor-texto').css('color','#000000');
			$('a').css('color','#000000');
			$('li').css('color','#000000');
			$('ul').css('color','#000000');
			$('b').css('color','#3D3669');
			$('#subtitulo').css('color','#4A5BA6');
			$('#btn_opciones').css('background','#000000');
			$('.fonts').css('color','#ffffff');
		break;

		case 'btn_sepia':
			$('body').css('background', '#BC8B5A');
			$('#contenedor-texto').css('color','#ffffff');
			$('a').css('color','#ffffff');
			$('ul').css('color','#ffffff');
			$('li').css('color','#ffffff');
			$('ol').css('color','#ffffff');
			$('b').css('color','#3C2D1D');
			$('#subtitulo').css('color','#3C2D1D');
			$('#btn_opciones').css('background','#ffffff');
			$('.fonts').css('color','#000000');
		break;

		case 'btn_noche':
			$('body').css('background', '#414141');
			$('#contenedor-texto').css('color','#ffffff');
			$('a').css('color','#ADB8BF');
			$('li').css('color','#ADB8BF');
			$('ul').css('color','#ADB8BF');
			$('ol').css('color','#ADB8BF');
			$('b').css('color','#ADB8BF');
			$('#subtitulo').css('color','#A1ACB2');
			$('#btn_opciones').css('background','#ffffff');
			$('.fonts').css('color','#000000');
		break;
	}
}