#include <iostream>
#include <memory>
#include <unordered_map>
using namespace std;

class TreeNode {
public:
  int val;
  shared_ptr<TreeNode> left, right;
  TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

class DiagonalSum {

private:
  void sumHelper(shared_ptr<TreeNode>, int, unordered_map<int, int> &);

public:
  void printDiagonalSum(const shared_ptr<TreeNode>);
};

void DiagonalSum::printDiagonalSum(const shared_ptr<TreeNode> root) {
  unordered_map<int, int> map;
  sumHelper(root, 0, map);
  for (auto s = map.begin(); s != map.end(); s++)
    std::cout << s->second << " ";
}

void DiagonalSum::sumHelper(const shared_ptr<TreeNode> node, int pos,
                            unordered_map<int, int> &map) {
  if (node == nullptr)
    return;

  map[pos] += node->val;

  sumHelper(node->left, pos + 1, map);
  sumHelper(node->right, pos, map);
}

int main(int argc, char const *argv[]) {
  /* code */
  DiagonalSum d;
  shared_ptr<TreeNode> root(new TreeNode(1));
  root->left = shared_ptr<TreeNode>(new TreeNode(2));
  root->right = shared_ptr<TreeNode>(new TreeNode(3));
  root->left->left = shared_ptr<TreeNode>(new TreeNode(4));
  d.printDiagonalSum(root);
  return 0;
}
