/**
 * @param {number} n
 * @return {number}
 */
var numOfWays = function(n) {
    let result=[[BigInt(6),BigInt(6)]];
    while(result.length<n){
        let [tempA,tempB]=[result[result.length-1][0],result[result.length-1][1]];
        result.push([tempA*BigInt(3)+tempB*BigInt(2),tempA*BigInt(2)+tempB*BigInt(2)]);
    }
    // console.log(result);
    return Number((result[result.length-1][0]+result[result.length-1][1]) % BigInt(10**9 + 7));
};

console.log(numOfWays(2));