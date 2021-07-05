package com.xsy.notebook.stack;

import java.util.LinkedList;

/**
 * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。
 * 再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。
 * 这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。鱼的行为符合以下几个条件:
 *
 * 1.所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
 *
 * 2.当方向相对时，大鱼会吃掉小鱼；
 *
 * 3.鱼的大小都不一样。
 *
 * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
 *
 * 输出：3
 * */
public class FishSwallowing {

    public static void main(String[] args) {
        int[] sizes = {4, 2, 5, 3, 1};
        int[] dirs = {1, 1, 1, 1, 1};
        System.out.println(swallowing(sizes, dirs));
    }

    public static int swallowing(int[] sizes, int[] dirs) {
        LinkedList<Integer> stack = new LinkedList();
        for (int i = 0; i < sizes.length; i++) {
            while (!stack.isEmpty()
                    && dirs[stack.peek()] != dirs[i]
                    && dirs[stack.peek()] != 0) {
                if (sizes[stack.peek()] < sizes[i]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return stack.size();
    }

}
