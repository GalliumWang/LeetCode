/**
 * @param {string} num
 * @return {string}
 */
var largestOddNumber = function(num) {
    for(let idx = num.length - 1;idx >= 0;idx--){
        if(isOdd(num[idx])){
            return num.substring(0,idx + 1);
        }
    }
    return "";
};

function isOdd(num){
    switch (num) {
        case "1":
            return true;
            break;
        case "3":
            return true;
            break;
        case "5":
            return true;
            break;
        case "7":
            return true;
            break;
        case "9":
            return true;
            break;
        default:
            return false;
            break;
    }
}