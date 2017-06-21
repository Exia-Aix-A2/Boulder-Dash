package world.elements.entity;

import world.Permeability;
import world.Position;
import world.behavior.IBehavior;
import world.behavior.KeyboardControl;

import java.awt.*;

public class Character extends Entity implements IBehavior{

    private static String SPRITE = "";
    private static Permeability PERMEABILITY = Permeability.PERMEABLE;
    public Character(Position position, Dimension dimension) {
        super(position, dimension, SPRITE, PERMEABILITY);
        this.setBackground(Color.RED);
    }

    @Override
    public void tick() {
        System.out.println("tick Character");
        //this.state.setStateType(StateType.DOWN);
        //System.out.println(this.getForwardElement());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadBehaviors() {
        this.behaviors.add(new KeyboardControl(this, this.engine));
    }
}