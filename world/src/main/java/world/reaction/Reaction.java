package world.reaction;

import world.elements.IAction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Abstract class Reaction
 *
 * The reactions represents the set of actions generated by behaviors between entities
 * @see IAction
 * */
public abstract class Reaction <From extends IAction, To extends IAction> {

    protected To to;
    protected From from;
    private Class<? extends From> fromClass;
    protected Collection<Sides> sides = new ArrayList<>();

    /**
     * TODO
     * */
    Reaction(To to, Class<? extends From> fromClass, Sides[] sides){
        this.to = to;
        this.fromClass = fromClass;
        for (Sides side: sides){
            this.sides.add(side);
        }
    }
    /**
     * TODO
     * @param from
     * @param side
     * */
    public boolean isReaction(Object from, Sides side){
        return (fromClass.isInstance(from) && this.sides.contains(side));
    }
    /**
     * TODO
     * @param from
     * @param side
     * @param ticks
     * */
    public boolean perform(Object from, Sides side, int ticks){
        if (isReaction(from, side)){
            this.from = (From) from;
            return this.execute(ticks);
        }
        return false;
    }
    /**
     * TODO
     * @return TODO
     * */
    protected abstract boolean execute(int ticks);
}