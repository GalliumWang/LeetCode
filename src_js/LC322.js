/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function (coins, amount) {
  // ascending sort the coins array
  coins.sort(function (a, b) {
    return a - b;
  });

  let dpArr = new Array(amount + 1);
  for (let idx = 0; idx < dpArr.length; idx++) {
    dpArr[idx] = Infinity;
  }
  dpArr[0] = 0;

  for (let coin of coins) {
    for (let i = 1; i <= amount; i++) {
      if (i - coin < 0) continue;
      if (dpArr[i - coin] + 1 < dpArr[i]) dpArr[i] = dpArr[i - coin] + 1;
    }
  }

  let result = dpArr.pop();
  if (result == 'Infinity') {
    return -1;
  } else {
    return result;
  }
};

coinChange([1, 2, 5], 11);
