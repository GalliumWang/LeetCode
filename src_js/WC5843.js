/**
 * @param {string[]} patterns
 * @param {string} word
 * @return {number}
 */
var numOfStrings = function (patterns, word) {
  let count = 0;
  patterns.forEach(function (pattern, index, patterns) {
    if (word.includes(pattern)) count++;
  });
  return count;
};
