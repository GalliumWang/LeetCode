/**
 * @param {string[]} words
 * @return {boolean}
 */
var makeEqual = function(words) {
    let map = new Map();

    let concatedWord = words.join('');
    for(i of concatedWord){
        mapOperate(map,i);
    }

    let result = true;

    map.forEach(value => {
        if(value%words.length != 0){
            result = false;
        }
    })

    return result;

};

function mapOperate(map,key){
    if(!map.has(key)){
        map.set(key,1);
    }
    else{
        map.set(key,map.get(key)+1);
    }
}


makeEqual(["abbab"]);