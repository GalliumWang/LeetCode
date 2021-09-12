/**
 * @param {number} p
 * @return {number}
 */
var minNonZeroProduct = function (p) {
  if (p == 1) return 1;
  const modNum = 10 ** 9 + 7;
  const subMaxNumSize = (2 ** p - 2) / 2;
  let subMaxNum = 2 ** p - 2;
  subMaxNum %= modNum;
  let maxNum = 2 ** p - 1;
  maxNum %= modNum;

  let count = 0;
  let result = 1;
  while (count < subMaxNumSize) {
    result *= subMaxNum;
    result %= modNum;
    count++;
  }
  result *= maxNum;
  result %= modNum;

  return result;
};
/**
 * failed, js can't provide enough presition when num is greater than 10**18,
 * so this solution can be accepted when language switched to python or c++
 */
