package util;


/**
 * Write a description of interface Command here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Command<E>
{
    public void execute(E element);
}
