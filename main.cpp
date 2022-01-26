#include <iostream>
#include <vector>
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
private:
    static constexpr int directions[4][2] = {{0,  1},
                                             {1,  0},
                                             {0,  -1},
                                             {-1, 0}};
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        if (matrix.size() == 0 || matrix[0].size() == 0) {
            return {};
        }

        int rows = matrix.size(), columns = matrix[0].size();
        vector<vector<bool>> visited(rows, vector<bool>(columns));
        int total = rows * columns;
        vector<int> order(total);

        int row = 0, column = 0;
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns ||
                visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
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
    return 0;
}
