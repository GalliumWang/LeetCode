/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProductDifference = function(nums) {
    let resultArr = nums.sort(function(a, b){
        return a - b;
    });
    return resultArr[resultArr.length - 1] * resultArr[resultArr.length - 2] - resultArr[0] * resultArr[1];
};