#include <iostream>
#include <vector>

// https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/shun-shi-zhen-da-yin-ju-zhen-by-leetcode-solution/

//示例 1：
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[1,2,3,6,9,8,7,4,5]
//示例 2：
//    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//    输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
// 1 2  3  4
// 5 6  7  8
// 9 10 11 12

using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if (matrix.size() == 0 || matrix[0].size() == 0) {
            return {};
        }

        int rows = matrix.size(), columns = matrix[0].size();
        vector<int> order;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.push_back(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.push_back(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.push_back(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.push_back(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    //matrix = [[1,2,3],[4,5,6],[7,8,9]]
    vector<vector<int>> matrix = {{1, 2, 3},
                                  {4, 5, 6},
                                  {7, 8, 9}};
    Solution solution;
    vector<int> vs = solution.spiralOrder(matrix);
    for (int i = 0; i < vs.size(); i++) {
        cout << vs[i] << " , ";
    }
    // 1 , 2 , 3 , 6 , 9 , 8 , 7 , 4 , 5 ,
    //[1 , 2 , 3 , 6 , 9 , 8 , 7 , 4 , 5 ]
    cout << "" << endl;
    cout << "1 , 2 , 3 , 6 , 9 , 8 , 7 , 4 , 5" << endl;
    return 0;
}
