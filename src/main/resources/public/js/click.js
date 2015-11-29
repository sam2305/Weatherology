$(document).ready(function(){
		animationClick('.center', 'slideOutRight');
	})
	function animationClick(element, animation){
		  element = $(element)
		  element.click(
		    function() {
		      element.addClass('animated ' + animation);
		      //wait for animation to finish before removing classes
		      window.setTimeout( function(){
		    	  window.location.href = "../index.html" ;
	            }, 500);        
		    }
		  );
		};
