/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

let nodeMap = new Map();

/**
 * @param {TreeNode} root
 * @return {number}
 */
var rob = function (root) {
  return recurseIteration(root);
};

function recurseIteration(node) {
  if (node == null) {
    return 0;
  }

  //check in map cache
  if (nodeMap.has(node)) {
    // console.log('cache hit!')
    return nodeMap.get(node);
  }

  //compute max profix in two situation
  //rob this node
  let profit1 =
    node.val +
    getGapchildMaxProfix(node, true) +
    getGapchildMaxProfix(node, false);

  //don't rob this node
  let profit2 = recurseIteration(node.left) + recurseIteration(node.right);

  let result = Math.max(profit1, profit2);
  nodeMap.set(node, result);

  return result;
}

function getGapchildMaxProfix(node, leftSide) {
  if (leftSide == true) {
    if (node.left == null) return 0;
    else {
      return (
        recurseIteration(node.left.left) + recurseIteration(node.left.right)
      );
    }
  } else {
    if (node.right == null) return 0;
    else {
      return (
        recurseIteration(node.right.left) + recurseIteration(node.right.right)
      );
    }
  }
}
