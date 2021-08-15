var findNthDigit = function (n) {
  if (n < 10) return n;
  let digitNum = 1;
  let maxNumPre = 0;
  let maxNum = 9;
  while (n > maxNum) {
    maxNumPre = maxNum;
    maxNum += 10 ** digitNum * 9 * (digitNum + 1);
    digitNum++;
  }
  let remainNum = n - maxNumPre;
  let skip = Math.floor(remainNum / digitNum);
  let remain = remainNum % digitNum;
  if (remain == 0) {
    let finalNum = 10 ** (digitNum - 1) + skip - 1;
    let arr = String(finalNum).split('');

    return arr[arr.length - 1];
  } else {
    let finalNum = 10 ** (digitNum - 1) + skip;
    return String(finalNum).split('')[remain - 1];
  }
};

console.log(findNthDigit(10000));
