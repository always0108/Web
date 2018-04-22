var res = document.getElementById("result").value;
var iImg=document.getElementsByTagName("img");

var time = new Array(0,0,0,0,0,0,0,0,0);
var arry = new Array(9);


arry[0] = setInterval("moo(0)",30);
arry[1] = setInterval("moo(1)",30);
arry[2] = setInterval("moo(2)",30);
arry[3] = setInterval("moo(3)",30);
arry[4] = setInterval("moo(4)",30);
arry[5] = setInterval("moo(5)",30);
arry[6] = setInterval("moo(6)",30);
arry[7] = setInterval("moo(7)",30);


function moo(index) {
    time[index] += 1;
    var x = Math.floor(Math.random()*10);
    iImg[index].src="img/"+String(x)+".png";
    if (time[index] == (index+1)*50){
        iImg[index].src="img/"+res[index]+".png";
        clearInterval(arry[index]);
    }
}
