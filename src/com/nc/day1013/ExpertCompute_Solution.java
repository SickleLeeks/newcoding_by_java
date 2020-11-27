package com.nc.day1013;

import java.util.*;
import java.util.regex.*;

public class ExpertCompute_Solution {
    private static Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+");

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public static int solve(String s) {
        if (s == null || s.length() == 0 || !ifValid(s)) {
            return 0;
        }
        // 将所有负号前面增加0
        String newStr = insertZero(s);
        Stack stack = new Stack();
        Queue queue = new ArrayDeque();
        StringBuffer sbNum = new StringBuffer();
        // 从左到右进行遍历
        for (int i = 0; i < newStr.length(); i++) {
            char chr = newStr.charAt(i);
            // 遇到左括号，直接压入栈
            if (chr == '(') {
                stack.push(chr);
                if (!"".equals(sbNum.toString())) {
                    queue.add(sbNum.toString());
                    sbNum = new StringBuffer();
                }
            } else if (chr == ')') {
                if (!"".equals(sbNum.toString())) {
                    queue.add(sbNum.toString());
                    sbNum = new StringBuffer();
                }
                // 遇到右括号，不断弹出栈顶运算符并输出，直到遇到左括号（弹出但不输出）
                while (!stack.peek().equals('(')) {
                    queue.add(stack.pop());
                }
                stack.pop();
            } else if (chr == '+' || chr == '-' || chr == '*' || chr == '/') {
                if (!"".equals(sbNum.toString())) {
                    queue.add(sbNum.toString());
                    sbNum = new StringBuffer();
                }
                // 遇到运算符
                if (!stack.isEmpty()) {
                    char topChr = (char) stack.peek();
                    // 如果优先级高于栈顶元素，则压入栈
                    if (topChr == '(' || ((topChr == '+' || topChr == '-') && (chr == '*' || chr == '/'))) {
                        stack.push(chr);
                    } else { // 如果优先级低于等于栈顶元素，则将栈顶运算符弹出并输出，然后比较新的栈顶运算符
                        while (((topChr == '+' || topChr == '-') && (chr == '+' || chr == '-'))
                                || ((topChr == '*' || topChr == '/') && (chr == '*' || chr == '/'))
                                || ((topChr == '*' || topChr == '/') && (chr == '+' || chr == '-'))) {
                            queue.add(stack.pop());
//                            if (stack.isEmpty() || stack.peek().equals('(')) {
//                                stack.push(chr);
//                                break;
//                            } else {
                            if (!stack.isEmpty()) {
                                topChr = (char) stack.peek();
                            } else {
                                break;
                            }
//                            }
                        }
                        stack.push(chr);
                    }
                } else {
                    stack.push(chr);
                }
            } else {
                if (chr >= 48 && chr <= 57) {
                    sbNum.append(chr);
                }
            }
        }
        if (!"".equals(sbNum.toString())) {
            stack.push(sbNum.toString());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            if (queue.peek().equals('+') || queue.peek().equals('-') || queue.peek().equals('*') || queue.peek().equals('/')) {
                int num2 = (int) stack.pop();
                int num1 = (int) stack.pop();
                char operator = (char) queue.poll();
                switch (operator) {
                    case '+':
                        //System.out.print('+');
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        //System.out.print('-');
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        //System.out.print('*');
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        //System.out.print('/');
                        stack.push(num1 / num2);
                        break;
                    default:
                        break;
                }
            } else {
                String num = (String) queue.poll();
                //System.out.print(num);
                stack.push(Integer.parseInt(num));
            }
        }
        return (int) stack.pop();
    }

    private static String insertZero(String expression) {
        char[] arr = expression.toCharArray();
        int len = arr.length;
        StringBuffer stringBuffer = new StringBuffer();
        int index = 0;
        while (index < len) {
            // 开始位置
            if (arr[index] == '-' && (index == 0 || arr[index - 1] == '(')) {
                stringBuffer.append(0);
                stringBuffer.append(arr[index]);
                index += 1;
            } else if (arr[index] == '-' && (arr[index - 1] == '+' || arr[index - 1] == '-')) {
                stringBuffer.append(0);
                stringBuffer.append(arr[index]);
                index += 1;
            } else if (arr[index] == '-' && (arr[index - 1] == '*' || arr[index - 1] == '/')) {
                stringBuffer.append('(').append(0).append(arr[index]);
                index += 1;
                while (index < len && Character.isDigit(arr[index])) {
                    stringBuffer.append(arr[index]);
                    index += 1;
                }
                stringBuffer.append(')');
            } else {
                stringBuffer.append(arr[index]);
                index += 1;
            }
        }
        //System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    private static boolean ifValid(String expression) {
        //去除空格
        expression = expression.replaceAll(" ", "");
        Set<Character> operate_set = new HashSet<>();
        operate_set.add('-');
        operate_set.add('+');
        operate_set.add('*');
        operate_set.add('/');
        //拆分字符串
        char[] arr = expression.toCharArray();
        int len = arr.length;
        //前后括号计数，用来判断括号是否合法
        int checkNum = 0;
        //数字集合
        StringBuffer stringBuffer = new StringBuffer();
        //循环判断
        for (int i = 0; i < len; i++) {
            //数字判断
            if (Character.isDigit(arr[i])) {
                stringBuffer.append(arr[i]);
            } else {
                //如果集合中有值，取出来判断这个数字整体是否合法
                if (!"".equals(stringBuffer.toString())) {
                    //判断字符串是否合法
                    boolean result = NUMBER_PATTERN.matcher(stringBuffer.toString()).matches();
                    if (result) {
                        //如果合法，清空集合，为了判断下一个
                        stringBuffer = new StringBuffer();
                    } else {
                        //不合法，返回false
                        return false;
                    }
                }
                if (arr[i] == '+' || arr[i] == '*' || arr[i] == '/') {
                    //判断规则(1.不能位于首位 2.不能位于末尾 3.后面不能有其他运算符 4.后面不能有后括号)
                    if (i == 0 || i == (len - 1) || operate_set.contains(arr[i + 1]) || arr[i + 1] == ')') {
                        //System.out.println("error type : '+' or '*' or '/' ->" + arr[i]);
                        return false;
                    }
                } else if (arr[i] == '-') {
                    //减号判断规则(1.不能位于末尾 2.后面不能有其他运算符 3.后面不能有后括号)
                    if (i == (len - 1) || operate_set.contains(arr[i + 1]) || arr[i + 1] == ')') {
                        //System.out.println("error type : '-' ->" + arr[i]);
                        return false;
                    }

                } else if (arr[i] == '(') {
                    checkNum++;
                    //判断规则(1.不能位于末尾 2.后面不能有+，*，/运算符和后括号 3.前面不能为数字)
                    if (i == (len - 1) || arr[i + 1] == '+' || arr[i + 1] == '*' || arr[i + 1] == '/' || arr[i + 1] == ')' || (i != 0 && Character.isDigit(arr[i - 1]))) {
                        //System.out.println("error type : '(' ->" + arr[i]);
                        return false;
                    }
                } else if (arr[i] == ')') {
                    checkNum--;
                    //判定规则(1.不能位于首位 2.后面不能是前括号 3.括号计数不能小于0，小于0说明前面少了前括号)
                    if (i == 0 || (i < (len - 1) && arr[i + 1] == '(') || checkNum < 0) {
                        //System.out.println("error type : ')' ->" + arr[i]);
                        return false;
                    }
                } else {
                    //非数字和运算符
                    //System.out.println("error type : not number and operator ->" + arr[i]);
                    return false;
                }
            }
        }
        if (!"".equals(stringBuffer.toString())) {
            //判断字符串是否合法
            boolean result = NUMBER_PATTERN.matcher(stringBuffer.toString()).matches();
            if (result) {
                //如果合法，清空集合，为了判断下一个
                stringBuffer = new StringBuffer();
            } else {
                //不合法，返回false
                return false;
            }
        }
        //不为0,说明括号不对等，可能多前括号
        if (checkNum != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str0 = "-(20*(-3-17))+5/5";
        String str1 = "-(20*(-3+13))+5/5";
        String str2 = "-(-20*(-3-17)/(-5))+5/5";
        int res = solve(str1);
        System.out.println(res);
    }
}
