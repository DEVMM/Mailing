var ok = false;
function checkByParent(aId) {
if (!ok){
ok = true;
}
else {
ok = false;
}
var collection = document.getElementById(aId).getElementsByTagName('INPUT');
for (var x=0; x<collection.length; x++) {
if (collection[x].type.toUpperCase()=='CHECKBOX')
collection[x].checked = ok;
}
}
