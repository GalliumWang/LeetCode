/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let dayNums = prices.length; //number of days
    if(dayNums<2) return 0;

    let dpHelper = new Array(dayNums);  //sotre last day when stock's sold
    let maxProfit = new Array(dayNums); //store max profit

    // init
    dpHelper[0] = -Infinity;
    maxProfit[0] = 0;

    if(prices[1] > prices[0]){
        dpHelper[1] = 1;
        maxProfit[1] = maxProfit[0] + (prices[1] - prices[0]);
    }
    else{
        dpHelper[1] = dpHelper[0];
        maxProfit[1] = maxProfit[0];
    }

    // dp body
    for(let idx = 2;idx < dayNums;idx++){
        if(prices[idx] > prices[idx - 1]){
            if(dpHelper[idx - 1] == idx -1){
                dpHelper[idx] = idx;
                maxProfit[idx] = maxProfit[idx - 1] + (prices[idx] -prices[idx - 1]);
            }
            else if(dpHelper[idx - 1] == idx -2){
                let tempValue = Infinity;
                if(dpHelper[idx -3] !== -Infinity){
                    if(dpHelper[idx -3] == idx -3){
                        tempValue = prices[idx -3];
                    }
                    else{
                        for(let i = dpHelper[idx -3];i<idx - 3;i++){
                            tempValue =Math.min(tempValue,prices[i]);
                        }
                    }

                }
                else{
                    tempValue = prices[idx - 3];
                }
                let updatedLastProfit = maxProfit[idx -3] + Math.max(prices[idx] -tempValue,prices[idx] -prices[idx - 1])
                if(updatedLastProfit >= maxProfit[idx -1]){
                    dpHelper[idx] = idx;
                    maxProfit[idx] = updatedLastProfit;
                }
                else{
                    dpHelper[idx] = dpHelper[idx -1];
                    maxProfit[idx] = maxProfit[idx - 1];
                }
            }
            else{
                dpHelper[idx] = idx;
                maxProfit[idx] = maxProfit[idx - 1] + (prices[idx] -prices[idx - 1]);
            }
        }
        else{
            dpHelper[idx] = dpHelper[idx - 1];
            maxProfit[idx] = maxProfit[idx - 1];
        }
    }

    return maxProfit[dayNums - 1];
};

maxProfit([8,3,6,2,8,8,8,4,2,0,7,2,9,4,9]);