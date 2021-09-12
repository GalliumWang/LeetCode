function gcd_two_numbers(x, y) {
  if (typeof x !== 'number' || typeof y !== 'number') return false;
  x = Math.abs(x);
  y = Math.abs(y);
  while (y) {
    var t = y;
    y = x % y;
    x = t;
  }
  return x;
}

/**
 * @param {number[][]} rectangles
 * @return {number}
 */
var interchangeableRectangles = function (rectangles) {
  let help_set = new Map();
  for (let rectangle of rectangles) {
    let gcd_num = gcd_two_numbers(rectangle[0], rectangle[1]);
    let width = rectangle[0] / gcd_num;
    let height = rectangle[1] / gcd_num;
    let help_num = width * 100000 + height;
    if (!help_set.get(help_num)) {
      help_set.set(help_num, 1);
    } else {
      help_set.set(help_num, help_set.get(help_num) + 1);
    }
  }
  let result = 0;
  help_set.forEach((value) => {
    result += (value * (value - 1)) / 2;
  });
  return result;
};
