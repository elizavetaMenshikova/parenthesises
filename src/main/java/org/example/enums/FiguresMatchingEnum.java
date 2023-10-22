package org.example.enums;

import java.util.Arrays;

import static org.example.enums.OpenedFiguresEnum.isOpened;
import static org.example.enums.ParenthesisEnum.*;

public enum FiguresMatchingEnum {
    BRACE(OPENED_BRACE, CLOSED_BRACE),
    ROUND_PARENTHESIS(OPENED_ROUND_PARENTHESIS, CLOSED_ROUND_PARENTHESIS),
    SQUARE_BRACKET(OPENED_SQUARE_BRACKET, CLOSED_SQUARE_BRACKET);

    private final ParenthesisEnum openedFigure;
    private final ParenthesisEnum closedFigure;

    FiguresMatchingEnum(ParenthesisEnum openedFigure, ParenthesisEnum closedFigure) {
        this.openedFigure = openedFigure;
        this.closedFigure = closedFigure;
    }

    public ParenthesisEnum getOpenedFigure() {
        return openedFigure;
    }

    public ParenthesisEnum getClosedFigure() {
        return closedFigure;
    }

    public static char getOpenedFigureByClosed(char closedFigure) {
        if (isOpened(closedFigure)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(FiguresMatchingEnum.values())
                .filter(parenthesis -> parenthesis.getClosedFigure().getValue() == closedFigure)
                .findFirst()
                .map(FiguresMatchingEnum::getOpenedFigure)
                .map(ParenthesisEnum::getValue)
                .orElseThrow(NullPointerException::new);
    }
}
