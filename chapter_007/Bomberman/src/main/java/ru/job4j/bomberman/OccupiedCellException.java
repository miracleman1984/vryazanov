package ru.job4j.bomberman;

/**
 * Class  OccupiedCellException.
 * <p>
 * Exeption for occupied cell situation.
 *
 * @author vryazanov
 * @version 1.0
 * @since 09.12.2017
 */
public class OccupiedCellException extends RuntimeException {
    public OccupiedCellException(String message) {
        super(message);
    }
}
