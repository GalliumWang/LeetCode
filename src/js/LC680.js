/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    if(checkOrigin(s)){
        return true;
    }
    let left=0,right=s.length-1;
    while(true){
        if(s[left]==s[right]){
            left++;
            right--;
            continue;
        }
        else{
            let arr1=s.split("");
            let arr2=s.split("");
            arr1.splice(left,1);
            arr2.splice(right,1);
            if(checkOrigin(arr1.join(""))||checkOrigin(arr2.join(""))){
                return true;
            }
            else{
                return false;
            }
        }
    }
};


// unused
function checkOrigin(s){
    let len=s.length;
    return len%2 == 1? s.slice(0,Math.floor(len/2)) === s.slice(Math.floor(len/2)+1).split("").reverse().join(""):
                       s.slice(0,Math.floor(len/2)) === s.slice(Math.floor(len/2)).split("").reverse().join("");
}