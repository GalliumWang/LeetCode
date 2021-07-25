function charToNum(chr){
    return chr.charCodeAt(0) - 96;
}

function compressString(str,layer){
    let result = 0;
    for(let i of str){
        result += parseInt(i);
    }
    if(layer == 1){
        return result;
    }
    else{
        return compressString(result.toString(),layer - 1);
    }
}

/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLucky = function(s, k) {
    let originalNumString = '';
    for(chr of s){
        originalNumString += charToNum(chr);
    }
    return compressString(originalNumString,k);
};

getLucky('leetcode',2);

