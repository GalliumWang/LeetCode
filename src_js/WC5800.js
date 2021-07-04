/**
 * @param {number[]} nums
 * @return {number[]}
 */
var buildArray = function(nums) {
    return nums.map((num,idx)=>{
        return nums[nums[num]];
    })
};