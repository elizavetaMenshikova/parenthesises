package org.example;

import java.util.*;

import static org.example.enums.ClosedFiguresEnum.isClosed;
import static org.example.enums.FiguresMatchingEnum.getOpenedFigureByClosed;
import static org.example.enums.OpenedFiguresEnum.isOpened;

public class Main {
    private static final String NORMAL_LINE_1 = "({[]})";
    private static final String NORMAL_LINE_2 = "(({}))[{}]";
    private static final String ABNORMAL_LINE_1 = "({}])";
    private static final String ABNORMAL_LINE_2 = "(({})[]";
    private static final String ABNORMAL_LINE_3 = "([)]";
    private static final String ABNORMAL_LINE_4 = "())";
    private static final String ABNORMAL_LINE_5 = ")(){()}";

    public static void main(String[] args) {
        System.out.println("isLineNormal: " + isLineNormal(NORMAL_LINE_1));
        System.out.println("isLineNormal: " + isLineNormal(NORMAL_LINE_2));
        System.out.println("isLineNormal: " + isLineNormal(ABNORMAL_LINE_1));
        System.out.println("isLineNormal: " + isLineNormal(ABNORMAL_LINE_2));
        System.out.println("isLineNormal: " + isLineNormal(ABNORMAL_LINE_3));
        System.out.println("isLineNormal: " + isLineNormal(ABNORMAL_LINE_4));
        System.out.println("isLineNormal: " + isLineNormal(ABNORMAL_LINE_5));
    }

    private static boolean isLineNormal(String line) {
        char[] chars = line.toCharArray();
        List<Character> tempList = new ArrayList<>();
        for (char character : chars) {
            if (isClosed(character) && tempList.isEmpty()) {
                return false;
            }
            if (isOpened(character)) {
                tempList.add(character);
            }
            if (isClosed(character) && !isLastElementMatchesTheClosedFigure(tempList, character)) {
                return false;
            }
            if (isClosed(character) && isLastElementMatchesTheClosedFigure(tempList, character)) {
                tempList.remove(getLastElement(tempList));
            }
        }
        return tempList.size() == 0;
    }

    private static boolean isLastElementMatchesTheClosedFigure(List<Character> tempList, char chars) {
        return getLastElement(tempList) == getOpenedFigureByClosed(chars);
    }

    private static Character getLastElement(List<Character> tempList) {
        return tempList.get(getIndexOfLastElement(tempList));
    }

    private static int getIndexOfLastElement(List<Character> tempList) {
        return tempList.size() - 1;
    }
}