function checkByParent(aId, bId) {
 
var alone = document.getElementById(bId); 
var collection = document.getElementById(aId).getElementsByTagName('INPUT');

if(alone.checked==true){
for (var x=0; x<collection.length; x++) {
collection[x].checked = true;
}
}
else{
 for (var x=0; x<collection.length; x++) {
  
  collection[x].checked = false;
}
}
}