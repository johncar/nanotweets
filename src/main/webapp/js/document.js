function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getSelectedText() {
    var text = "";
    if ( typeof window.getSelection == "function" ) {
        text = window.getSelection().toString();
    } else if (document.selection && document.selection.type != "Control") {
        text = document.selection.createRange().text;
    }
    return text;
}

function nanotweet() {

    var data = {
        text: escape( getSelectedText() ),
        uuid: uuid,
        comment: $("#userComment").val()

    }

	$('body').addClass('loading');
	$.getJSON( "//nanotate", data,  function(result) {
		$('body').removeClass('loading');
		// TODO: show result message
	});
	simpleTip.hide();
	feedNanotweets();
}

function getNanotweetLink() {
    // TODO: text comment for social networks

    var html = '<textarea id="userComment"></textarea>'
        + '<a onclick="nanotweet()" class="sb circle no-shadow no-border blue twitter" href="#"></a>'+
          		   '<a onclick="nanotweet()" href="#">Send to Nanotweets</a>';
	return html;
}

function formatAnnotations(str) {
	var myRegexp = /<z:(.*?)<\/z:(.*?)>/g;
	var result = "", i=0, css;
	match = myRegexp.exec(str);
	while (match != null) {
		css = ( i++ % 2 == 0 ) ? "odd" : "even";
		result += ( match[0].length > 0 ) ? '<span class="' + css + '">' + match[0] + "</span> " : "" ;
	    // matched text: match[0]
	    // match start: match.index
	    // capturing group n: match[n]
	    match = myRegexp.exec(str);
	}
	
	return result;
}

function feedNanotweets(){
	
	// Get nanotweets feed 
	$("#Nanotweets").html('');
	$.getJSON( "nanotate?action=list&uuid=" + uuid, function(result) {
		if ( result.code == 0 ) {
			var ul = $("<ul></ul>").appendTo("#Nanotweets");
			if ( result.hasOwnProperty('data') && result.data.length > 0 ) {
				for ( var i in result.data ) {
					
					if ( result.data[i].status == "COMPLETED" ) {
						var li = $("<li></li>").appendTo(ul);
						li.append('<span class="commentnumber">' + 
							(result.data[i].creation.match(/[A-Za-z]+ [0-9]+, 2[0-9][0-9][0-9]/)[0]) + '</span>');
						li.append("<p>" + formatAnnotations(result.data[i].annotatedText) + "</p>");
						li.append('<span class="icons"></span>');
					
					} else if ( result.data[i].status == "WORKING" ) {
						var li = $("<li></li>").appendTo(ul);
						li.append('<span class="commentnumber">'+
							(result.data[i].creation.match(/[A-Za-z]+ [0-9]+, 2[0-9][0-9][0-9]/)[0]) + '</span>');
						li.append("<p>Nanotweeting:</p>");
						li.append('<p class="blockquote" >' + result.data[i].originalText.substring(0,70) + "...</p>");
					}

			    } 	
			} else {
				ul.append("<li>Nanotweets not found.</li>");
			}

		}
	});	
}

var uuid = getParameterByName("uuid");
var docViewer = undefined;
var simpleTip = undefined;

$.getJSON( "document?action=session&uuid=" + uuid, function(result) {
	
	// 
	$('.nanotweets-feed-control').click(function(){ 
		$(this).children('.legend').toggle(); 
		$('.nanotweets-feed').toggle(); 
		
		if ( $('.nanotweets-feed').is(":visible") ) {
			$("#DocViewer").css('right','20%');
		} else {
			$("#DocViewer").css('right','0%');
		}
	});
	
	$.getScript( "//crocodoc.com/webservice/document.js?session=" + result.data, 
		function( data, textStatus, jqxhr ) {
	  	    //creates a document viewer using the "DocViewer" div
	  	    docViewer = new DocViewer({ "id": "DocViewer" });

	  	  	//on docviewer ready
	  	    docViewer.ready(function(e) {
	  	        $('.numpages').text(e.numpages);
	  	    });

	  	    //docviewer events
	  	    docViewer.bind({
				'pagechange': function(e) {
	  	        	$('.num').text(e.page);
	  	    	}
			});
			
	  	    //toolbar events
	  	    $('.zoom-in').click(function() {
	  	        docViewer.zoom('in');
	  	    });
	  	    $('.zoom-out').click(function() {
	  	        docViewer.zoom('out');
	  	    });
	  	    $('.prev').click(function() {
	  	        docViewer.scrollTo('prev');
	  	    });
	  	    $('.next').click(function() {
	  	        docViewer.scrollTo('next');
		  	});
	  	    
	  	    // Text selection 
			
			if ( (/iphone|ipad|ipod/i).test(navigator.userAgent) ){

		  	    simpleTip = new Biojs.Tooltip({
		    		targetSelector: '.page',
		    		position: Biojs.Tooltip.MANUAL_POSITION,
		    		arrowType: Biojs.Tooltip.ARROW_RIGHT_MIDDLE,
		    		cbRender: function( element ) {
		    			return getNanotweetLink();
		    		},
		    		showOnEvent: 'touchend',
		    		hideOnEvent: 'touchstart'
		  	  	});

			    function handleMouseMove(event) {
			       event = event || window.event; // IE-ism
			       // event.clientX and event.clientY contain the mouse position
			    }
		  	  
			  	
				/*
			  	$('document').bind( "touchstart touchend mouseup click", function (event) {	
			  		var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
			  		simpleTip._setPosition(
			  			{ left: touch.pageX - 10, top: touch.pageY - 10 }, 
			  			{ width: 20, height: 20 } 
			  	    );
		        });
				
				*/
		  	    
	      	  	$('.page').bind( "touchend mouseup", function (e) {  			
			  	  	var target = jQuery(e.target);

			        if (simpleTip.timer) { 
			            clearTimeout(simpleTip.timer); 
			        }
			        simpleTip.timer = 0;

			        simpleTip._body.html( getNanotweetLink() );
      
			        // Show up
			        simpleTip._show();
					
				  	// Tooltip in a fixed position
					var pos = $("#Nanotweets").offset();
			  		simpleTip._setPosition(
			  			pos, { width: simpleTip._body.width(), height: 20 } 
			  	    );
			  	

	            }).bind( "touchstart click", function() {
	                simpleTip.timer = setTimeout( 
						'Biojs.getInstance(' + simpleTip.getId()  + ')._hide()' , simpleTip.opt.delay );
	            });
				
				simpleTip._body.bind( "touchstart click", function() {
					nanotweet();
				});
				
		  	    
			} else {
		  	    simpleTip = new Biojs.Tooltip({
		    		targetSelector: '.page',
		    		position: Biojs.Tooltip.MOUSE_POSITION,
		    		arrowType: Biojs.Tooltip.ARROW_TOP_MIDDLE,
		    		cbRender: function( element ) {
		    			return getNanotweetLink();
		    		},
		    		showOnEvent: 'mouseup',
		    		hideOnEvent: 'click'
		  	  	});
			}

		}
	);
	
	feedNanotweets();
});	  


