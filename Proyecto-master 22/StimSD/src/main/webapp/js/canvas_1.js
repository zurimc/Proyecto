	
//inicializacion de las variables globales  del programa para construir la grafica
var img = new Image();

  var myCanvas = document.getElementById('myCanvas');
			        var ctx = myCanvas.getContext('2d');
              var prueba = myCanvas.getContext('2d');
			        var input = document.querySelector('input');    
              var curFile = input.files;
			        var x1 =0;
			        var y1 =0;
			        var x2 =0;
			        var y2 =0;
			        var inter_x1 = 0;
			        var inter_x2 = 0;
			        var inter = false;
			        var tipo_accion = 0;
			        // linea de referecia de la grafica (eje x)
			        var y=[0];
              var s1; //valor_scroll*300/3250;
              var valor_scroll2;
              var s2;
              var imageData;
              var iff = 150;
/* ----------------- Canvas -----------------*/
                  function validFileType(file){
     for(var i = 0; i < fileTypes.length; i++){
        if(file.type == fileTypes[i]) 
            return true;
    }
    ejemplo()
    {
      alert("HOLA");
    }
 input.addEventListener('change', updateImageDisplay); 

    return false;
    }

  function updateImageDisplay()
 {
 var curFile =  document.getElementById('foto').files;
        for(var i = 0; i < curFile.length+5; i++){

            if(validFileType(curFile[i])){
                source = curFile[i].name;
                img.src = window.URL.createObjectURL(curFile[i]);
                 
                   img.onload = function(){
                      imagen_1();
                    imageData = ctx.getImageData(0, 0, myCanvas.width, myCanvas.height);
                    }
                //
            } 

            
        }

 }
    var fileTypes = [
     'image/jpeg',
     'image/pjpeg',
     'image/png'
    ]

function izq()
{
  if(inter_x1>0){
      inter_x1 = inter_x1 - 1;
  }
      s1 =yy[inter_x1];
                  $("#style-6").scrollTop(s1*3250/300, 0);
                  valor_scroll2 =  $("#style-6").scrollTop() + "";
   imagen_1();
         for (var ii = 0; ii < 521; ii++) {
                
                ctx.fillStyle = "#2E9AFE";  
                ctx.fillRect(ii, yy[ii],2,1); 
                 }
            if(inter_x1<inter_x2){
              grayscale(-150, inter_x1,inter_x2)
            }else{
                grayscale(-150, inter_x2,inter_x1)
            }
}
function der()
{
   if(inter_x1<500){
      inter_x1 = inter_x1 + 1;
  }
  imagen_1();
           for (var ii = 0; ii < 521; ii++) {
                
                ctx.fillStyle = "#2E9AFE";  
                ctx.fillRect(ii, yy[ii],2,1); 
                 }
            if(inter_x1<inter_x2){
              grayscale(-150, inter_x1,inter_x2)
            }else{
                grayscale(-150, inter_x2,inter_x1)
            }
}
function izq1()
{
  if(inter_x2>0){
      inter_x2 = inter_x2 - 1;
  }
      s1 =yy[inter_x2];
                  $("#style-6").scrollTop(s1*3250/300, 0);
                  valor_scroll2 =  $("#style-6").scrollTop() + "";
   imagen_1();
            for (var ii = 0; ii < 521; ii++) {
                
                ctx.fillStyle = "#2E9AFE";  
                ctx.fillRect(ii, yy[ii],2,1); 
                 }
            if(inter_x1<inter_x2){
              grayscale(-150, inter_x1,inter_x2)
            }else{
                grayscale(-150, inter_x2,inter_x1)
            }
}
function der1()
{
   if(inter_x2<500){
      inter_x2 = inter_x2 + 1;
  }
  imagen_1();
           for (var ii = 0; ii < 521; ii++) {
                
                ctx.fillStyle = "#2E9AFE";  
                ctx.fillRect(ii, yy[ii],2,1); 
                 }
            if(inter_x1<inter_x2){
              grayscale(-150, inter_x1,inter_x2)
            }else{
                grayscale(-150, inter_x2,inter_x1)
            }
}
 //funcion que verifica el tipo de check que se presiona si es el uno              

function check(c) {
tipo_accion = c;
inter = false;
}


img.src = '1.PNG';



function imagen_1(){
  ctx.drawImage(img, 0, 0,500,300);

  img.style.display = 'none';

};
//dibuja la linea de referencia azul que esta posicionada junto con el scroll a 150
  var yy=[0];
    $(document).ready(function(){
        $("#foto").change(function() {
         
          updateImageDisplay();
    });

       $("#style-6").scrollTop(150*3250/300, 0);
              imagen_1();
              imageData = ctx.getImageData(0, 0, myCanvas.width, myCanvas.height);
      for (var ii = 0; ii < 521; ii++) {
                yy[ii]=150;
                ctx.fillStyle = "#2E9AFE";  
                ctx.fillRect(ii, yy[ii],2,1); 
                 }
                 
                });


//esta funcion da la posicion del scroll y posicion las rectas
function deslizador(){
//Inicializacion de variables   
    var x1a = inter_x1;
    var x2a = inter_x2;
    var inter_x = inter_x2 -inter_x1;
    var vec=[0]; //vector 
    var  angulo = 0;
    var se = 0;
    var m; 

    //LA ACCION UNO ES PARA SELECCIONAR LAS COORDENADAS SI ES DEFERENTE DEL 1 PUEDE EJECUTARSE CUALQUIERA DE LOS CASOS
  if(tipo_accion != 1 ){

   
  if (x2a<=522 && x2a>=0) { // Si x2a es menor o igual a 522 y x2a es mayor o igual a 0
    if (x1a<x2a && x1a>=0) { // si x1 es menor a x2a y x1a es mayor o igual a 0
          valor_scroll2 =  $("#style-6").scrollTop() + "";
          angulo = Math.PI/ (2*inter_x);
          //tipo de accion 4 que es el seno +180
    if(tipo_accion==4){
            s2 = (valor_scroll2)*300/3250;
        }else{
              s2 = (valor_scroll2)*300/3250;
              }

              m = (s1 - s2) / (x2a -x1a); //formula para calcular la pendiente para el tipo de accion 2
              for (var i = 0; i <= inter_x; i++) {
                     if(tipo_accion==4) { // coordenadas
                        vec[i]=s2+(s2-s1)*Math.sin((-i*angulo)+3*Math.PI/2);
                        }else if(tipo_accion==2) {//tipo de accion seno
         			            vec[i]=-m*i+s1;
			                   }else if(tipo_accion==3) {
                          vec[i] = s1+(s1-s2)*Math.sin(-i*angulo);
          
                          }
       		
                        }
                      }          
     // ctx.fillStyle = "#EFF5FB";//color gris para la sombra
    // ctx.fillRect(x1a, 0, x2a-x1a+2, 298);// la sombra va comenzar en el punto donde empiece x1 en 0 hasta la resta del area de x2 -x1 a 298
   ctx.putImageData(imageData, 0, 0);

        for (var vi = 1; vi <=522; vi++) {
          if(tipo_accion==5){
            iff = ($("#style-6").scrollTop() + "")*300/3250;
             yy[vi-1]=iff;
             ctx.fillStyle = "#2E9AFE"; 
            ctx.fillRect(vi-1, yy[vi-1],2,1); 
           }else{

             if(vi>= x1a && vi<=x2a){
                A = Math.abs(yy[vi]-yy[vi+1]);//linea que se dibuja el punto final hacia la linea de 150
                ctx.fillStyle = "#2E9AFE";//dibuja la linea azul de donde se queda el punto final hacia la linea de 150
                yy[vi] = vec[vi-x1a];// el valor de yy[ii] es el resultado de la resta de vi y x1a y es almacenado en un vector
               ctx.fillRect(vi,yy[vi],2, 1);//dibuja una lina azul entre las panters seleccionadas segun el tipo de linea.
              }else{
                  ctx.fillStyle = "#2E9AFE";
                  ctx.fillRect(vi-1, yy[vi],2, 1);
          }
        }

    }
   //     if(tipo_accion==5){
 // offset_1();
// }

 }
}
}

 function offset_1()
 {
         iff = ($("#style-6").scrollTop() + "")*300/3250;
        for (var ii = 0; ii < 521; ii++) {
           yy[ii]=iff;
              ctx.fillStyle = "#2E9AFE"; 
                ctx.fillRect(ii, yy[ii],2,1); 
                 }
                  ctx.putImageData(imageData, 0, 0);
  }
//esta funcion muestra el color al dar click a cualquier parte del lienzo de canvas 
function color(elEvento){
         evento = elEvento || window.event;
         tipo = evento.type;
         if (tipo == "click") {
            
             if(inter == true){
             	inter = false;
             	if(tipo_accion==1) // coordenadas
             	{
             		
                  if(inter_x1<x2){
                    inter_x2 = x2;
                  }else{
                    inter_x2 = inter_x1;
                    inter_x1 = x2;
                  }
                    s1 =yy[inter_x1];
                  $("#style-6").scrollTop(s1*3250/300, 0);
                  valor_scroll2 =  $("#style-6").scrollTop() + "";
                  //console.log(s1);
             	}
 	
             }else 
             {
              inter = true;
              	if(tipo_accion==1) // coordenadas
             	{
                inter_x1 = x2;
             	}
             }
            }

         }
//carga el lienzo del canvas          
window.onload = function() {
document.getElementById("myCanvas").onclick = color;
document.getElementById("myCanvas").ondblclick = color;

}
//mouse position detecta dentro del lienzo del canvas la posicion del mouse
function getMousePos(canvas, evt) {
        var rect = canvas.getBoundingClientRect();
        return {
          x: evt.clientX - rect.left,
          y: evt.clientY - rect.top
        };
      }

var canvas = document.getElementById('myCanvas');
var context = canvas.getContext('2d');
canvas.addEventListener('mousemove', function(evt) {
var mousePos = getMousePos(canvas, evt);

      x1 = mousePos.x;
      y1 = mousePos.y;
      x1 = x1*0.87;
      x2 =  parseInt(x1);
      y2 =  parseInt(y1);
var message = 'Mouse position: ' + x2+ ',' + y2;
//var mouse2 = document.getElementById("hh").innerHTML=message;
var A;
       if(inter==true)
       { 

       	if(tipo_accion==1) // coordenadas
          {
            //ctx.fillStyle = 'white';//pinta el lienzo de blanco al seleccionar la cordenadas 
            //ctx.fillRect(0, 0,522, 300); //desde 0 hasta los 300 del eje x y los 522 del eje y
            imagen_1();
            //ctx.fillStyle = "#EFF5FB";	
            //ctx.fillRect(inter_x1, 0,x2-inter_x1+2, 290);
            if(inter_x1<x2){
              grayscale(-150, inter_x1,x2)
            }else{
                grayscale(-150, x2,inter_x1)
            }
            
          }

        }
              ctx.fillStyle = "#2E9AFE";  
        for (var ii = 0; ii < 521; ii++) {
                A = Math.abs(yy[ii]-yy[ii+1]);
                ctx.fillStyle = "#2E9AFE"; 
            if(yy[ii]<yy[ii+1]){
                ctx.fillRect(ii,yy[ii],2, A+1);  
            }else{
              ctx.fillRect(ii,yy[ii],2, -A-1);  
            }  
            }
          }, true);

   var grayscale = function(contrast, xmi, xmf) {
    imageData = ctx.getImageData(0, 0, myCanvas.width, myCanvas.height);
    var pixels = imageData.data;
    numPixels = imageData.width * imageData.height;
     var factor;
    contrast || ( contrast = 100 ); // Default value
 
    factor = ( 259 * ( contrast + 255 ) ) / ( 255 * ( 259 - contrast ) );
  for ( var ik = 0; ik < imageData.height; ik++ ) {
      for ( var i = xmi; i < xmf; i++ ) {

        var r = pixels[ (ik*imageData.width+i) * 4 ];
        var g = pixels[ (ik*imageData.width+i) * 4 + 1 ];
        var b = pixels[ (ik*imageData.width+i) * 4 + 2 ];
        pixels[ (ik*imageData.width+i) * 4 ] = factor * ( r - 128 ) + 128;
        pixels[ (ik*imageData.width+i) * 4 + 1 ] = factor * ( g - 128 ) + 128;
        pixels[ (ik*imageData.width+i) * 4 + 2 ] = factor * ( b - 128 ) + 128;
    }
   }

    ctx.putImageData(imageData, 0, 0);
  };
/* ----------------- Canvas -----------------*/
/* ----------------- Gràficas -----------------*/
document.getElementById("container").style.width = "1px";
document.getElementById("container").style.height = "1px";
var cambio_click = 0;
var yy_base = [0];
var yy_base_1 = [0];
var amplitud_max = 0;
var amplitud_min = 0;
var yy_base_2 = [0];
var offset_voltaje = 0;
var voltaje_max = 1.5;
var voltaje_min = -1.5;
var vector_voltaje = [0];

//esta funcion cambia de vista de canvas a la grafica de highchart.
function cambio_de_vista()
{
  //el boton esta en un estado 0 cuando hace un cambio a 1.
  if(cambio_click == 0){
    cambio_click = 1;

 
document.getElementById("abajo").style.display = "none";
document.getElementById("izq_1").style.display = "none";
document.getElementById("arriba").style.display = "block";


  document.getElementById("myCanvas").style.width = "0px";
  document.getElementById("myCanvas").style.height = "1px";
  document.getElementById("myCanvas").style.display = "none";
  document.getElementById("style-6").style.width = "1px";
  document.getElementById("style-6").style.height = "1px";
  
  document.getElementById("container").style.width = "500px";
  document.getElementById("container").style.height = "300px";
  document.getElementById("container").style.display = "block";
  graf1ca_Highcharts();


  }else{
    cambio_click = 0;
    document.getElementById("abajo").style.display = "block";
   document.getElementById("izq_1").style.display = "block";
    document.getElementById("arriba").style.display = "none";


  document.getElementById("myCanvas").style.width = "500px";
  document.getElementById("myCanvas").style.height = "300px";
  document.getElementById("myCanvas").style.display = "block";
  document.getElementById("style-6").style.width = "25px";
  document.getElementById("style-6").style.height = "300px";
  
  document.getElementById("container").style.width = "1px";
  document.getElementById("container").style.height = "1px";
  document.getElementById("container").style.display = "none";
  }
}
 var odd_set_volt = 0;
function cambio_variable()
{
var jka=0;
var jka_1=0;
var jka2 = 0; 

//iff = ($("#style-6").scrollTop() + "")*300/3250;


odd_set_volt = 300 - iff;

 for(jka = 0; jka <= 522; jka++) 
 {
   yy_base[jka] = 300 -yy[jka] ;
   yy_base_1[jka] =  yy_base[jka]  - odd_set_volt;

      if(jka%2== 0){
    yy_base_2 [jka_1] = (yy_base_1[jka+1]+ yy_base_1[jka])/2;
    if(jka_1>0 && jka_1 < 260)
    {
       if(amplitud_max<yy_base_2 [jka_1]){ amplitud_max = yy_base_2 [jka_1];}
       else if(amplitud_min>yy_base_2 [jka_1]){ amplitud_min = yy_base_2 [jka_1];}
    }
    jka_1++;
    }
 }
 for(jka2 = 0; jka2 <= 261; jka2++) 
 {
   if(yy_base_2 [jka2] > 0)
   {
      vector_voltaje[jka2] = yy_base_2 [jka2]*voltaje_max/amplitud_max;
    }else if(yy_base_2 [jka2] < 0)
    {
       vector_voltaje[jka2] = yy_base_2 [jka2]*voltaje_min/amplitud_min;
    }else{
      vector_voltaje[jka2] = 0;
    }
 }
}

function graf1ca_Highcharts()
{
     cambio_variable();
    Highcharts.chart('container', {
        chart: {
            type: 'area'
        },
        title: {
            text: 'Grafica Seno'
        },
        xAxis: {
            categories: [
]
        },
        credits: {
            enabled: false
        },
        series: [{

  
            name: 'valores en x',
            data: vector_voltaje
        }]
    });
  
  }
/* ----------------- Gràficas -----------------*/
function minimo_voltaje_1 ()
{
   var retVal = prompt("Ingrese Volatje Minimo: ", "-3");
   if(retVal>-3 && retVal<3){
     voltaje_min = retVal;
     cargar_a();
   }else{
    alert("Valor no valido");
   }
               
}
function maximo_voltaje_2 ()
{
   var retVal = prompt("Ingrese Volatje Minimo: ", "-3");
   if(retVal>-3 && retVal<3){
     voltaje_max = retVal;
     cargar_a();
   }else{
    alert("Valor no valido");
   }
               
}
function rango_1 ()
{
   var res = 0;
   var retVal = prompt("Ingrese Volatje Minimo: ", "-3");
   if(retVal> 0 && retVal<6){
     res = retVal/2;
     voltaje_max =  res;
     voltaje_min = - res;
     cargar_a();
   }else{
    alert("Valor no valido");
   }
               
}
function cargar_a()
{
  graf1ca_Highcharts();
}